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
import oop_gestionebiblioteca.Utente;

/**
 *
 * @author Davide
 */
public class DatabaseUtenti implements Serializable {
    private int genmatricola;
    private HashMap<Utente, String> utenti;
    
    public DatabaseUtenti() {
        utenti = new HashMap<>();
        genmatricola = 612700000;
    }
    
    public synchronized Utente aggiungiUtente(String nome, String cognome, String email, String password) throws UtentePresenteException {
        Utente u = new Utente(nome, cognome, genmatricola++, email);
        if (utenti.containsKey(u))
            throw new UtentePresenteException();
        
        utenti.put(u, password);
        notifyAll();
        return u;
                
    }
    
    public synchronized void rimuoviUtente(int matricola) throws UtenteNonPresenteException {
        Set<Utente> keys = utenti.keySet();
        
        for (Utente u : keys){
            if (u.getMatricola() == matricola) {
                utenti.remove(u);
                notifyAll();
                return;
            }
        }
        throw new UtenteNonPresenteException();
        
    }
    
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
