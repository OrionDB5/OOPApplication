/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca.database;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop_gestionebiblioteca.FasciaOraria;
import oop_gestionebiblioteca.Prenotazione;
import oop_gestionebiblioteca.Utente;
import oop_gestionebiblioteca.eccezioni.FasciaNonValidaException;
import oop_gestionebiblioteca.eccezioni.PasswordErrataException;
import oop_gestionebiblioteca.eccezioni.PostoNonPresenteException;
import oop_gestionebiblioteca.eccezioni.PostoOccupatoException;
import oop_gestionebiblioteca.eccezioni.PrenotazioniInsufficientiException;
import oop_gestionebiblioteca.eccezioni.UtenteNonPresenteException;
import oop_gestionebiblioteca.eccezioni.UtentePresenteException;

/**
 *
 * @author Benedetto
 */
public class Database {
    
    private DatabaseUtenti utenti;
    private DatabasePostazioni postazioni;
    private DatabasePrenotazioni prenotazioni;
    private Thread tSalvaPostazioni;
    private Thread tSalvaPrenotazioni;
    private final String filenameBackupPrenotazioni = "backup_prenotazioni.txt";
    private final String filenameBackupPostazioni = "backup_postazioni.txt";
    
    /**
     * Crea un database che permette la gestione di utenti, prenotazioni e postazioni.
     * Prevede funzionalità interne di backup tramite thread (riferite alle prenotazioni e alle postazioni).
     * E' una struttura thread-safe.
     */
    
    public Database() {
        utenti = new DatabaseUtenti();
        postazioni = new DatabasePostazioni(25);
        prenotazioni = new DatabasePrenotazioni();
        tSalvaPostazioni = new Thread(new SalvataggioAutomaticoPostazioni(postazioni, filenameBackupPostazioni));
        tSalvaPrenotazioni = new Thread(new SalvataggioAutomaticoPrenotazioni(prenotazioni, filenameBackupPrenotazioni));
        tSalvaPostazioni.start();
        tSalvaPrenotazioni.start();
        Thread clock = new Thread(new OrologioDiSistema(this));
        clock.start();
    }
    
    /**
     * Fornisce una panoramica dei posti disponibili per una data fascia oraria,
     * se questa risulta esssere valida.
     * @param fasciaOraria Fascia oraria in cui si vuole controllare la disponibilità dei posti.
     * @return Un vettore di booleani che all'i-esima posizione contiene la disponibilità del posto i-esimo.
     * @throws FasciaNonValidaException L'eccezione viene lanciata se la fascia oraria passata come parametro
     * non è prevista tra quelle messe a disposizione dal sistema.
     */
    public synchronized boolean [] visualizzaPostiDisponibili(int fasciaOraria)
        throws FasciaNonValidaException {
        
        boolean[] disponibilità;
        try {
            disponibilità = postazioni.visualizzaPostiDisponibili(fasciaOraria);
        } catch (FasciaNonValidaException ex) {
            throw ex;
        }
        
        notifyAll();
        return disponibilità;
    }
    
    /**
     * Consente di prenotare una postazione in biblioteca.
     * @param numeroPosto posto che si vuole prenotare.
     * @param fasciaOraria fascia oraria in cui si vuole effettuare la prenotazione.
     * @param u utente che intende effettuare la prenotazione.
     * @return la prenotazione relativa alla postazione indicata.
     * @throws PostoNonPresenteException L'eccezione viene lanciata se il posto passato come parametro non è presente.
     * @throws FasciaNonValidaException L'eccezione viene lanciata se la fascia oraria indicata non è contemplata.
     * @throws PostoOccupatoException L'eccezione viene lanciata se il posto indicato risulta occupato in quella fascia oraria.
     * @throws UtenteNonPresenteException L'eccezione viene lanciata se l'utente non è presente nel database.
     * @throws PrenotazioniInsufficientiException  L'eccezione viene lanciata se l'utente ha esaurito le proprie prenotazioni giornaliere.
     */
    public synchronized  Prenotazione prenotaPosto(int numeroPosto, int fasciaOraria, Utente u)
        throws PostoNonPresenteException, FasciaNonValidaException, PostoOccupatoException, UtenteNonPresenteException, PrenotazioniInsufficientiException {
        
        try {
            if(utenti.possibilePrenotare(u.getMatricola()))
            {
                postazioni.prenotaPosto(numeroPosto, fasciaOraria);
                utenti.inserisciPrenotazione(u.getMatricola());
            }
            
            else
                throw new PrenotazioniInsufficientiException();
        } catch (PostoNonPresenteException ex) {
            throw ex;
        } catch (FasciaNonValidaException ex) {
            throw ex;
        } catch (PostoOccupatoException ex) {
            throw ex;
        } catch (UtenteNonPresenteException ex) {
            throw ex;
        }
        
        return prenotazioni.inserisciPrenotazione(numeroPosto, fasciaOraria, u);
    }
    
    /**
     * Il metodo rende non prenotabili i posti per una data fascia oraria.
     * @param fasciaOraria 
     * @throws FasciaNonValidaException L'eccezione viene lanciata se la fascia oraria non è prevista.
     */
    protected synchronized void azzeraDisponibilitàPosti(int fasciaOraria)
        throws FasciaNonValidaException {
        
        if(! FasciaOraria.isValida(fasciaOraria))
            throw new FasciaNonValidaException();
        postazioni.azzeraDisponibilità(fasciaOraria);
        notifyAll();
    }
    
    /**
     * Il metodo ripristina la disponibilità di tutte le postazioni per tutte le fasce orarie,
     * rendendo di fatto nuovamente disponibili le funzionalità di prenotazione e gestione delle prenotazioni.
     */
    public synchronized void ripristinaDisponibilitàPosti() {
        
        postazioni.ripristinaDisponibilità();
        notifyAll();
    }
    
    /**
     * Il metodo cancella tutte le prenotazioni presenti ne database; permette anche di creare un file di salvataggio.
     * @param filename Nome del file su cui verranno salvate le prenotazioni, se backup == true;
     * @param backup Parametro che abilita, se settato a true, il salvataggio su file.
     */
    protected synchronized void cancellaPrenotazioni(String filename, boolean backup) {
        utenti.cancellaPrenotazioni();
        if(backup)
        {
            SerializzatoreDatabasePrenotazioni sdp = new SerializzatoreDatabasePrenotazioni(prenotazioni);
            synchronized(prenotazioni)
            {
                sdp.salva(filename);
            }
        }
            prenotazioni.reset();
        notifyAll();
    }
    
    /**
     * Il metodo permette di rimuovere una prenotazione dal database.
     * @param codicePrenotazione Codice della prenotazione che si intende rimuovere.
     * @return Un booleano se l'operazione è andata a buon fine.
     * @throws PostoNonPresenteException L'eccezione viene lanciata se il posto indicato dalla prenotazione non è presente.
     * @throws FasciaNonValidaException L'eccezione viene lanciata se la prenotazione è relativa a una fascia oraria non prevista.
     */
    public synchronized boolean rimuoviPrenotazione (int codicePrenotazione) 
        throws PostoNonPresenteException, FasciaNonValidaException{
        
        try {
            Prenotazione p = prenotazioni.rimuoviPrenotazione(codicePrenotazione);
            if(p == null)
            {
                notifyAll();
                return false;
            }
            
            try {
                postazioni.liberaPosto(p.getNumPosto(), p.getFasciaOraria() );
            } catch (PostoNonPresenteException ex) {
                System.out.println("database.rimuoviPrenotazione(" + codicePrenotazione + ") sta lanciando PostoNonPresenteException");
                throw ex;
            } catch (FasciaNonValidaException ex) {
                throw ex;
            }
            utenti.rimuoviPrenotazione(p.getUtente().getMatricola());
            notifyAll();
            return true;
        } catch (UtenteNonPresenteException ex) {
        }
        
        return true;
    }
    
    /**
     * Il metodo permette la ricerca delle prenotazioni effettuate da un certo utente.
     * @param u Utente di cui si vogliono ricercare le prenotazioni.
     * @return Un set delle prenotazioni effettuate dall'utente e correntemente valide (non cancellate);
     * il set sarà vuoto se l'utente non ha effettuato alcuna prenotazione.
     */
    public synchronized Set<Prenotazione> ricercaPrenotazione(Utente u) {
        
        Set<Prenotazione> search_results = prenotazioni.ricercaPrenotazione(u);
        
        for(Prenotazione p : search_results)
        {
            if(! p.isValida())
                search_results.remove(p);
        }
        
        notifyAll();
        return search_results;
    }
    
    /**
     * Il metodo permette la ricerca di una prenotazione sulla base del codice della prenotazione.
     * @param codicePrenotazione Codice di cui si vuole ottenere la prenotazione.
     * @return La prenotazione associata al codice passato come parametro; ritorna null se il codice non è associato
     * ad alcuna prenotazione.
     */
    public synchronized Prenotazione ricercaPrenotazione(int codicePrenotazione) {  
        Prenotazione search_results = prenotazioni.ricercaPrenotazione(codicePrenotazione);
        notifyAll();
        return search_results;
    }
    
    /**
     * Il metodo permette la ricerca delle prenotazioni associate all'informazione passata come parametro.
     * @param infoUtente Parametro di ricerca - può essere il nome, il cognome o la matricola dell'utente.
     * @return Un set di prenotazioni associate agli utenti che rispettano i parametri di ricerca.
     */
    public synchronized Set<Prenotazione> RicercaPrenotazione(String infoUtente) {
        
        Set<Prenotazione> search_results = prenotazioni.ricercaPrenotazione(infoUtente);
        notifyAll();
        return search_results;
    }
    
    public synchronized Iterator<Prenotazione> iteratorPrenotazioni() {
        Iterator<Prenotazione> tmp = prenotazioni.iterator();
        notifyAll();
        return tmp;
    }
    
     public synchronized Utente registraUtente(String nome, String cognome, String email, String password) 
             throws UtentePresenteException {
        
        try {
            Utente u = utenti.registraUtente(nome, cognome, email, password);
            notifyAll();
            return u;    
        } catch(UtentePresenteException ex){
            throw ex;
        }
       
    }
    
    public synchronized void rimuoviUtente(int matricola)
            throws UtenteNonPresenteException {
        
        try {
            utenti.rimuoviUtente(matricola);
        } catch(UtenteNonPresenteException ex) {
            throw ex;
        }
        
    }
    
    public synchronized Utente login(String email, String password) 
        throws UtenteNonPresenteException, PasswordErrataException {
        
        try {
            return utenti.login(email, password);
        } catch(UtenteNonPresenteException ex) {
            throw ex;
        } catch(PasswordErrataException ex) {
            throw ex;
        } finally {
            // TO DO...
        }
        
        
    }
    
    /**
     *
     * @return
     */
    public synchronized String stampaPrenotazioni(){
       
        String ret = prenotazioni.toString();
        notifyAll();
        return ret;
    }
    
    public synchronized String stampaUtenti(){
        
        String ret = utenti.toString();
        notifyAll();
        return ret;
    }
    
}
