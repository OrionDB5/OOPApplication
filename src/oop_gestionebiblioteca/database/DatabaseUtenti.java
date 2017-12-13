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
    
    protected DatabaseUtenti() {
        utenti = new HashMap<>();
        genMatricola = 612700000;
        prenotazioniEffettuate = new HashMap<>();
    }
    
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
    
    public void cancellaPrenotazioni() {
        
        Set<Utente> keys = prenotazioniEffettuate.keySet();
        
        for(Utente u : keys)
        {
            prenotazioniEffettuate.put(u, 0);
        }
    }
    
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
     *
     * @return
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
    
    
}
