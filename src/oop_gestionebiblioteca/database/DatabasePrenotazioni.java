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
import oop_gestionebiblioteca.FasciaOraria;
import oop_gestionebiblioteca.Prenotazione;
import oop_gestionebiblioteca.Utente;
import oop_gestionebiblioteca.eccezioni.FasciaNonValidaException;

/**
 * @author Belgenio Davide
 * @author Cerchia Giovanni
 * @author Gabriele Dario
 * @author Ginestra Benedetto Salvatore
 */
public class DatabasePrenotazioni implements Serializable {
    private Map<Integer,Prenotazione> m;
    private int contatorePrenotazione;

    /**
     * Crea un database per le prenotazioni.
     */
    protected DatabasePrenotazioni() {
        m = new HashMap<>();
        contatorePrenotazione = 0;
    }
    
    /**
     * Il metodo permette di inserire una prenotazione nel database.
     * @param numeroPosto Il numero dle posto prenotato.
     * @param fasciaOraria La fascia oraria relativa alla prenotazione.
     * @param u L'utente che ha effettuato la prenotazione.
     * @return La prenotazione effettuata.
     */
    public synchronized Prenotazione inserisciPrenotazione (int numeroPosto, int fasciaOraria, Utente u) {
        
        Prenotazione p = new Prenotazione(numeroPosto, fasciaOraria, u, contatorePrenotazione);
        m.put(contatorePrenotazione, p);
        contatorePrenotazione++;
        notifyAll();
        return p;
    }
    
    /**
     * Il metodo permette di rimuovere una prenotazione sulla base del codice della stessa.
     * @param codicePrenotazione Il codice della prenotazione che si intende rimuovere.
     * @return  La prenotazione rimossa; se il codice non corrisponde a nessuna prenotazione,
     * il metodo ritorna null.
     */
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
    
    /**
     * Il metodo permette la ricerca della prenotazioni effettuate da un utente, che siano valide o meno.
     * @param u  L'utente di cui si vogliono conoscere le prenotazioni.
     * @return Un set delle prenotazioni associate a un account utente.
     */
    public synchronized Set<Prenotazione> ricercaPrenotazione(Utente u) {
        Set<Integer> keys = m.keySet();
        Set<Prenotazione> prenotazioni = new HashSet<>();
        for (Integer i : keys) {
            if (m.get(i).getUtente().equals(u))
                prenotazioni.add(m.get(i));
         }
        notifyAll();
        return prenotazioni;
    }
    
    /**
     * Il metodo permette la ricerca di una prenotazione sulla base del codice.
     * @param codicePrenotazione Codice della prenotazione che si vuole ottenere.
     * @return La prenotazione associata al codice; se il codice non è associato ad alcuna prenotazione,
     * ritorna null.
     */
    public synchronized Prenotazione ricercaPrenotazione(int codicePrenotazione) {
        Set<Integer> keys = m.keySet();
        for (Integer i : keys) {
            if (i.equals(codicePrenotazione))
                return m.get(i);
        }
        notifyAll();
        return null;
    }
    
    /**
     * Il metodo permette la ricerca delle prenotazioni associate all'informazione passata come parametro.
     * @param infoUtente Parametro di ricerca - può essere il nome, il cognome o la matricola dell'utente.
     * @return Un set di prenotazioni associate agli utenti che rispettano i parametri di ricerca.
     */
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
    
    /**
     * Il metodo setta a non modificabili tutte le prenotazioni per una data fascia oraria.
     * @param fasciaOraria Fascia oraria per cui le prenotazioni non possono essere più modificate.
     * @throws FasciaNonValidaException Viene lanciata se la fascia oraria non è contemplata.
     */
    public synchronized void setNonModificabile(int fasciaOraria)
        throws FasciaNonValidaException {
        
        if(fasciaOraria < 0 || fasciaOraria >= FasciaOraria.getFasce())
            throw new FasciaNonValidaException();
        
        Set<Integer> keys = m.keySet();
        for(Integer i : keys)
        {
            Prenotazione p = m.get(i);
            if(p.getFasciaOraria() == fasciaOraria)
                p.setNonModificabile();
        }
    }
    
    /**
     * Il metodo restituisce un iteratore sulle prenotazioni presenti nel database.
     * @return  Iterator di prenotazioni.
     */
    public synchronized Iterator<Prenotazione> iterator() {
        Iterator<Prenotazione> tmp = m.values().iterator();
        notifyAll();
        return tmp;
    }
    
    /**
     * Il metodo permette il reset del database delle prenotazioni; l'operazione consiste nella cancellazione di tutte 
     * le prenotazioni presenti.
     */
    protected synchronized void reset() {
        m = new HashMap<>();
        contatorePrenotazione = 0;
    }
    
}
