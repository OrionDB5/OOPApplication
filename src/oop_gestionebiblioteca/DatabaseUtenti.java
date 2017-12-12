/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import oop_gestionebiblioteca.eccezioni.UtenteNonPresenteException;
import oop_gestionebiblioteca.eccezioni.UtentePresenteException;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Davide
 */
public class DatabaseUtenti implements Serializable {
    private static int genmatricola = 612700000;
    private HashMap<Utente, String> utenti;
    
    public DatabaseUtenti() {
        utenti = new HashMap<>();
    }
    
    public synchronized Utente aggiungiUtente(String nome, String cognome, String email, String password) throws UtentePresenteException {
        Utente u = new Utente(nome, cognome, genmatricola++, email);
        if (utenti.containsKey(u))
            throw new UtentePresenteException();
        else
            utenti.put(u, password);
            return u;
                
    }
    
    public synchronized void rimuoviUtente(int matricola) throws UtenteNonPresenteException {
        Set<Utente> keys = utenti.keySet();
        
        for (Utente u : keys){
            if (u.getMatricola() == matricola) {
                utenti.remove(u);
                return;
            }
        }
        throw new UtenteNonPresenteException();
        
    }
    
    @Override
    public String toString(){
        String ret = "";
        int i = 1;
        Set<Utente> keys = utenti.keySet();

        for (Utente u : keys) {
            ret += i+") " + u + "\n";
            i++;
        }
        return ret;
    }
    
}
