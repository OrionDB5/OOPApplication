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
    
    public Database() {
        utenti = new DatabaseUtenti();
        postazioni = new DatabasePostazioni(50);
        prenotazioni = new DatabasePrenotazioni();
    }
    
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
    
    /*public synchronized boolean controllaDisponibilitàPosto(int numeroPosto, int fasciaOraria) {
        
        if(numeroPosto <= 0 || posti.size() < numeroPosto)
            return false;
        
        return mappaDisponibilità[fasciaOraria][numeroPosto];
    }*/
    
    public synchronized  Prenotazione prenotaPosto(int numeroPosto, int fasciaOraria, Utente u)
        throws PostoNonPresenteException, FasciaNonValidaException, PostoOccupatoException {
        
        try {
            postazioni.prenotaPosto(numeroPosto, fasciaOraria, u);
        } catch (PostoNonPresenteException ex) {
            throw ex;
        } catch (FasciaNonValidaException ex) {
            throw ex;
        } catch (PostoOccupatoException ex) {
            throw ex;
        }
        
        return prenotazioni.inserisciPrenotazione(numeroPosto, fasciaOraria, u);
    }
    
    
    public synchronized void azzeraDisponibilitàPosti(int fasciaOraria) {
        
        postazioni.azzeraDisponibilità(fasciaOraria);
        notifyAll();
    }
    
    public synchronized void ripristinaDisponibilitàPosti() {
        
        postazioni.ripristinaDisponibilità();
        notifyAll();
    }
    
    public synchronized boolean rimuoviPrenotazione (int codicePrenotazione) {
        
       boolean ret = prenotazioni.rimuoviPrenotazione(codicePrenotazione);
       notifyAll();
       return ret;
    }
    
    public synchronized Set<Prenotazione> ricercaPrenotazione(Utente u) {
        
        Set<Prenotazione> search_results = prenotazioni.ricercaPrenotazione(u);
        notifyAll();
        return search_results;
    }
    
    public synchronized Set<Prenotazione> ricercaPrenotazione(int codicePrenotazione) {
        
        Set<Prenotazione> search_results = prenotazioni.ricercaPrenotazione(codicePrenotazione);
        notifyAll();
        return search_results;
    }
    
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
    
     public synchronized Utente aggiungiUtente(String nome, String cognome, String email, String password) 
             throws UtentePresenteException {
        
        try {
            Utente u = utenti.aggiungiUtente(nome, cognome, email, password);
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
