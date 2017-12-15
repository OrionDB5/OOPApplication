/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca.database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import oop_gestionebiblioteca.eccezioni.*;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop_gestionebiblioteca.Utente;

/**
 *
 * @author Davide
 */
public class DatabaseUtenti implements Serializable {
    private int genMatricola;
    private HashMap<Utente, String> utenti;
    private HashMap<Utente, Integer> prenotazioniEffettuate;
    
    /**
     * Crea un database utenti, che contiene tutte le informazioni relative a ciascun utente
     * (nome, cognome, email, matricola assegnata dal sistema, password).
     */
    protected DatabaseUtenti() {
        utenti = new HashMap<>();
        genMatricola = 612700000;
        prenotazioniEffettuate = new HashMap<>();
    }
    
    /**
     * Il metodo permette la creazione di un nuovo account utente.
     * @param nome Nome del nuovo utente.
     * @param cognome Cognome del nuovo utente.
     * @param email Indirizo e-mail del nuovo utente.
     * @param password Password per accedere all'account utente.
     * @return L'utente creato (con matricola generata in automatico dal database).
     * @throws UtentePresenteException L'eccezione viene lanciata se l'e-mail risulta
     * essere associata già ad un altro account utente.
     */
    public synchronized Utente registraUtente(String nome, String cognome, String email, String password) throws UtentePresenteException {
        
        Set<Utente> keys = utenti.keySet();
        for(Utente u : keys) {
            if(u.getEmail().equals(email))
                throw new UtentePresenteException();
        }
        
        Utente u = new Utente(nome, cognome, genMatricola++, email);
        utenti.put(u, password);
        prenotazioniEffettuate.put(u, 0);
        notifyAll();
        return u;
                
    }
    
    /**
     * Il metodo prevede la rimozione di un utente dal database.
     * @param matricola La matricola dell'utente che si vuole eliminare.
     * @throws UtenteNonPresenteException L'eccezione viene lanciata se la matricola non risulta
     * essere associata ad alcun account utente.
     */
    public synchronized void rimuoviUtente(int matricola) throws UtenteNonPresenteException {
        Set<Utente> keys = utenti.keySet();
        
        for (Utente u : keys){
            if (u.getMatricola() == matricola) {
                utenti.remove(u);
                prenotazioniEffettuate.remove(u);
                notifyAll();
                return;
            }
        }
        throw new UtenteNonPresenteException();
    }
    
    /**
     * Il metodo indica se l'utente può o meno effettuare nuove prenotazioni,
     * ossia se ha superato o meno il limite del numero massimo di prenotazioni giornaliere ammesse.
     * @param matricola
     * @return
     * @throws UtenteNonPresenteException 
     */
    public synchronized boolean possibilePrenotare(int matricola)
        throws UtenteNonPresenteException {
        
        Set<Utente> keys = utenti.keySet();
        
        for(Utente u: keys)
        {
            if(u.getMatricola() == matricola)
            {
                return prenotazioniEffettuate.get(u) < Utente.MAX_POSTI_PRENOTABILI;
            }
        }
        
        throw new UtenteNonPresenteException();
    }
    
    /**
     * Il metodo cancella le prenotazioni associate a tutti gli utenti presenti nel database.
     */
    public void cancellaPrenotazioni() {
        
        Set<Utente> keys = prenotazioniEffettuate.keySet();
        
        for(Utente u : keys)
        {
            prenotazioniEffettuate.put(u, 0);
        }
    }
    
    /**
     * Il metodo permette di inserire una prenotazione per l'utente identificato dalla matricola
     * @param matricola La matricola di identificazione dell'utente.
     * @throws PrenotazioniInsufficientiException L'eccezione viene lanciata se l'utente ha esaurito
     * le proprie prenotazioni giornaliere.
     * @throws UtenteNonPresenteException L'eccezione viene lanciata se la matricola non è associata
     * ad alcun account utente.
     */
    public void inserisciPrenotazione(int matricola)
        throws PrenotazioniInsufficientiException, UtenteNonPresenteException {
        
        Set<Utente> keys = utenti.keySet();
        
        for(Utente u : keys) 
        {
            if(u.getMatricola() == matricola) 
            {
                int prenotazioni = prenotazioniEffettuate.get(u);
                if(prenotazioni > Utente.MAX_POSTI_PRENOTABILI)
                    throw new PrenotazioniInsufficientiException();
                prenotazioniEffettuate.put(u, prenotazioni + 1);
                return;
            }
        }
        
        throw new UtenteNonPresenteException();
    }
    
    /**
     * Il metodo rimuove una prenotazione dall'account associato alla matricola
     * @param matricola La matricola di identificazione di un utente.
     * @return Un booleano che indica se l'operazione è andata a buon fine.
     * @throws UtenteNonPresenteException L'eccezione viene lanciata se la matricola 
     * non risulta essere associata ad alcun account utente.
     */
    public boolean rimuoviPrenotazione(int matricola)
        throws UtenteNonPresenteException {
        
        Set<Utente> keys = utenti.keySet();
        
        for(Utente u : keys) 
        {
            if(u.getMatricola() == matricola) 
            {
                int prenotazioni = prenotazioniEffettuate.get(u);
                if(prenotazioni <= 0)
                    return false;
                
                prenotazioniEffettuate.put(u, prenotazioni - 1);
                return true;
            }
        }
        
        throw new UtenteNonPresenteException();
    }
    
    /*public static void main(String[] args) {
        DatabaseUtenti db = new DatabaseUtenti();
        try {
            db.aggiungiUtente("b", "g", "jhbpifduhb", "jbfouyb");
            db.aggiungiUtente("òhbf", "ahfb", "hedgbuey", "lwhdbiytg");
            try {
                try {
                    db.inserisciPrenotazione(612700000);
                    db.inserisciPrenotazione(612700000);
                    System.out.println(db.rimuoviPrenotazione(612700000));
                    System.out.println(db.rimuoviPrenotazione(612700000));
                    System.out.println(db.rimuoviPrenotazione(612700000));
                    db.inserisciPrenotazione(612700000);
                    db.inserisciPrenotazione(612700000);
                    db.inserisciPrenotazione(612700000);
                    db.inserisciPrenotazione(612700000);
                } catch (PrenotazioniInsufficientiException ex) {
                    System.out.println("Prenotazioni insufficienti.");

                }
            } catch (UtenteNonPresenteException ex) {
                Logger.getLogger(DatabaseUtenti.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UtentePresenteException ex) {
            Logger.getLogger(DatabaseUtenti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    /**
     * Il metodo offre la funzionalità di login, ossia permette di accedere ad un account utente con
     * le sue informazioni.
     * @param email Indirizzo e-mail dell'account a cui si vuole accedere.
     * @param password Password 
     * @return L'utente associato all'indirizzo e-mail, se il login è andato a buon fine.
     * @throws UtenteNonPresenteException L'eccezione viene lanciata se l'e-mail non è associata
     * ad alcun account utente.
     * @throws PasswordErrataException L'eccezione viene lanciata se la password è errata.
     */
    public synchronized Utente login(String email, String password) 
        throws UtenteNonPresenteException, PasswordErrataException {
        
        Utente u = new Utente("", "", 0, email);
        Collection<Utente> users = utenti.keySet();
        Iterator<Utente> iter_users = users.iterator();
        
        while(iter_users.hasNext()) 
        {
            Utente u2 = iter_users.next();
            if(u2.getEmail().equals(email))
            {
                if(utenti.get(u2).equals(password)) 
                {
                    notifyAll();
                    return u2;
                }
                else
                    throw new PasswordErrataException("Password errata.");
            }
        }
        
        throw new UtenteNonPresenteException("L'indirizzo e-mail specificato non è associato ad alcun account.");
    }
    
    /**
     * Il metodo permette di visualizzare tutti gli utenti presenti nel database.
     * @return Una stringa con le informazioni di tutti gli utenti, stampati secondo il formato del metodo toString() della classe Utente.
     */
    @Override
    public synchronized String toString(){
        String ret = "";
        int i = 1;
        Set<Utente> keys = utenti.keySet();

        for (Utente u : keys) {
            ret += i + ") " + u + "\n";
            i++;
        }
        notifyAll();
        return ret;
    }
    
    /**
     * Il metodo fornisce un iteratore su tutti gli utenti presenti nel database,
     * permettendo una visita di tutti gli utenti.
     * @return Un iterator di utenti.
     */
    public synchronized Iterator<Utente> iterator() {
        Iterator<Utente> iter = utenti.keySet().iterator();
        notifyAll();
        return iter;
    }
    
}
