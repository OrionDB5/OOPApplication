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

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Davide
 */
public class DatabasePrenotazioni implements Serializable {
    private Map<Integer,Prenotazione> m;
    private static int contatorePrenotazione = 0;

    public DatabasePrenotazioni() {
        m = new HashMap<>();
    }
    
    public synchronized Prenotazione inserisciPrenotazione () {
        m.put(p.hashCode(), p);
        notifyAll();
    }
    
    public synchronized boolean rimuoviPrenotazione (int p) {
       if(m.containsKey(p)) {
           m.get(p).setValidità(false);
           notifyAll();
           return true;
       }
       else {
           notifyAll();
           return false;
       }
    }
    
    public synchronized Set<Prenotazione> RicercaPrenotazione(Utente u) {
        Set<Integer> keys = m.keySet();
        Set<Prenotazione> prenotazioni = new TreeSet<>();
        for (Integer i : keys) {
            if (m.get(i).getUtente().equals(u))
                prenotazioni.add(m.get(i));
         }
        notifyAll();
        return prenotazioni;
    }
    
    public synchronized Set<Prenotazione> RicercaPrenotazione(int codicePrenotazione) {
        Set<Integer> keys = m.keySet();
        Set<Prenotazione> prenotazioni = new TreeSet<>();
        for (Integer i : keys) {
            if (i.equals(codicePrenotazione))
                prenotazioni.add(m.get(i));
        }
        notifyAll();
        return prenotazioni;
    }
    
    public synchronized Set<Prenotazione> RicercaPrenotazione(String infoUtente) {
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
    
}
