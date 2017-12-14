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
import oop_gestionebiblioteca.*;
import oop_gestionebiblioteca.eccezioni.*;

/**
 *
 * @author Davide
 */
public class DatabasePostazioni implements Serializable{
   
    private boolean[][] mappaDisponibilità;
    private int numeroPosti;
    
    protected DatabasePostazioni(int numeroPosti) {
        this.numeroPosti = numeroPosti;
        int numeroFasce = FasciaOraria.getFasce();
        mappaDisponibilità = new boolean[numeroFasce][numeroPosti];
        for (int i = 0; i < numeroFasce; i++){
            for(int j = 0 ; j < numeroPosti ; j++)
            {
                mappaDisponibilità[i][j] = true;
            }
        }
    }

    public synchronized boolean [] visualizzaPostiDisponibili(int fasciaOraria)
        throws FasciaNonValidaException {
        
        if(fasciaOraria < 0  || fasciaOraria > FasciaOraria.getFasce())
            throw new FasciaNonValidaException();
        
        boolean[] disponibilità = mappaDisponibilità[fasciaOraria]; 
        notifyAll();
        return disponibilità;
    }
    
    /*public synchronized boolean controllaDisponibilitàPosto(int numeroPosto, int fasciaOraria) {
        
        if(numeroPosto <= 0 || posti.size() < numeroPosto)
            return false;
        
        return mappaDisponibilità[fasciaOraria][numeroPosto];
    }*/
    
    public synchronized void liberaPosto(int numeroPosto, int fasciaOraria)
        throws PostoNonPresenteException, FasciaNonValidaException {
         
        System.out.println("Rimozione prenotazione... fascia oraria... " + fasciaOraria + "... posto... " + numeroPosto);

         if(numeroPosto <= 0 || numeroPosti < numeroPosto)
            throw new PostoNonPresenteException();
         
         mappaDisponibilità[fasciaOraria][numeroPosto] = true;
        
        
    }
    
    public synchronized  void prenotaPosto(int numeroPosto, int fasciaOraria)
        throws PostoNonPresenteException, FasciaNonValidaException, PostoOccupatoException {
        
        if(numeroPosto < 0 || numeroPosto > this.numeroPosti)
            throw new PostoNonPresenteException("Posto " + numeroPosto + " non esistente.");
        if(fasciaOraria < 0 || fasciaOraria > FasciaOraria.getFasce())
            throw new FasciaNonValidaException ("Fascia " + fasciaOraria + " non valida");
        
        if(! mappaDisponibilità[fasciaOraria][numeroPosto])
           throw new PostoOccupatoException("Posto " + numeroPosto + " occupato nella seguente fascia : " + FasciaOraria.getFasciaOraria(fasciaOraria));
        
        mappaDisponibilità[fasciaOraria][numeroPosto] = false;
    }
    
    
    public synchronized void azzeraDisponibilità(int fasciaOraria) {
        
        for(int i = 0 ; i < this.numeroPosti ; i++)
            mappaDisponibilità[fasciaOraria][i] = false;
        notifyAll();
    }
    
    public synchronized void ripristinaDisponibilità() {
        
        int fasceOrarie = FasciaOraria.getFasce();
        for(int i = 0 ; i < fasceOrarie ; i++)
            for(int j = 0 ; j < this.numeroPosti ; j++)
                mappaDisponibilità[i][j] = true;
        notifyAll();
    }
    
}
