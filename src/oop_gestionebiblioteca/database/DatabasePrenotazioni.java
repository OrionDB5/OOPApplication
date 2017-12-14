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

import java.io.Serializable;
import java.util.*;
import oop_gestionebiblioteca.Prenotazione;
import oop_gestionebiblioteca.Utente;

/**
 *
 * @author Davide
 */
public class DatabasePrenotazioni implements Serializable {
    private Map<Integer,Prenotazione> m;
    private int contatorePrenotazione;

    protected DatabasePrenotazioni() {
        m = new HashMap<>();
        contatorePrenotazione = 0;
    }
    
    public synchronized Prenotazione inserisciPrenotazione (int numeroPosto, int fasciaOraria, Utente u) {
        
        Prenotazione p = new Prenotazione(numeroPosto, fasciaOraria, u, contatorePrenotazione);
        m.put(contatorePrenotazione, p);
        contatorePrenotazione++;
        notifyAll();
        return p;
    }
    
    public synchronized Prenotazione rimuoviPrenotazione (int codicePrenotazione) {
        
       if(m.containsKey(codicePrenotazione)) {
           Prenotazione p = m.get(codicePrenotazione);
           p.setValidità(false);
           System.out.println("databasePrenotazioni.rimuoviPrenotazione(" + codicePrenotazione + ")");
           notifyAll();
           return p;
       }
       else {
           notifyAll();
           return null;
       }
    }
    
    public synchronized Set<Prenotazione> ricercaPrenotazione(Utente u) {
        Set<Integer> keys = m.keySet();
        Set<Prenotazione> prenotazioni = new TreeSet<>();
        for (Integer i : keys) {
            if (m.get(i).getUtente().equals(u))
                prenotazioni.add(m.get(i));
         }
        notifyAll();
        return prenotazioni;
    }
    
    public synchronized Prenotazione ricercaPrenotazione(int codicePrenotazione) {
        Set<Integer> keys = m.keySet();
        for (Integer i : keys) {
            if (i.equals(codicePrenotazione))
                return m.get(i);
        }
        notifyAll();
        return null;
    }
    
    public synchronized Set<Prenotazione> ricercaPrenotazione(String infoUtente) {
        Set<Integer> keys = m.keySet();
        Set<Prenotazione> prenotazioni = new TreeSet<>();
        for (Integer i : keys) {
            Utente u = m.get(i).getUtente();
            if (u.getCognome().equalsIgnoreCase(infoUtente) || u.getNome().equalsIgnoreCase(infoUtente) || u.getMatricola() == Integer.parseInt(infoUtente))
                prenotazioni.add(m.get(i));
        }
        notifyAll();
        return prenotazioni;
    }
    
    public synchronized Iterator<Prenotazione> iterator() {
        Iterator<Prenotazione> tmp = m.values().iterator();
        notifyAll();
        return tmp;
    }
    
    public synchronized void reset() {
        m = new HashMap<>();
        contatorePrenotazione = 0;
    }
    
}
