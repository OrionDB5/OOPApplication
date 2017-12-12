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
public class DatabasePostazioni implements Serializable{
   
    private SortedSet<Posto> posti;
    
    public DatabasePostazioni(int numPosti) {
        posti = new TreeSet<>();
        for (int i = 0; i < numPosti; i++){
            posti.add(new Posto(i + 1));
        }
    }
    
    public synchronized boolean [] visualizzaPostiDisponibili(int fasciaOraria) {
        boolean [] disponibilità = new boolean[posti.size()];
        for(int i = 0; i < disponibilità.length; i++){
            disponibilità[i] = false;
        }
        int i = 0;
        
        for (Posto p : posti){
            if (p.getDisponibilità(fasciaOraria)){
                disponibilità[i++] = true;
            }
        }
        notifyAll();
        return disponibilità;
    }
    
    public synchronized boolean aggiungiPosto(Posto p) {
        boolean b = posti.add(p);
        notifyAll();
        return b;
    }
    
    public synchronized boolean rimuoviPosto(Posto p) {
        boolean b = posti.remove(p);
        notifyAll();
        return b;
    }
    
    public synchronized void azzeraDisponibilità(int fascia) {
        for(Posto p : posti){
            p.occupaPosto(fascia);
        }
        notifyAll();
    }
    
    public synchronized void ripristinaDisponibilità() {
        for(Posto p : posti){
          for(int i = 0; i < 5; i++){
              p.liberaPosto(i);
          }  
        }
        
        notifyAll();
    }
    
    public synchronized Iterator<Posto> iterator() {
        Iterator<Posto> tmp = posti.iterator();
        notifyAll();
        return tmp;
    }
}
