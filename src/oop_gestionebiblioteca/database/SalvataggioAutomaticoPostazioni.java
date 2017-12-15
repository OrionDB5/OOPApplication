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

import oop_gestionebiblioteca.database.DatabasePostazioni;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop_gestionebiblioteca.FasciaOraria;

import oop_gestionebiblioteca.eccezioni.FasciaNonValidaException;
/**
 *
 * @author Davide
 */
public class SalvataggioAutomaticoPostazioni implements Runnable {
    private final DatabasePostazioni dbPostazioni;
    private final String filename;
    private SerializzatoreDatabasePostazioni sdp;
    
    /**
     * Crea un thread per il salvataggio automatico del database delle postazioni.
     * @param dbPostazioni Database delle postazioni che si vuole salvare.
     * @param filename File su cui si vuole salvare il database.
     */
    public SalvataggioAutomaticoPostazioni(DatabasePostazioni dbPostazioni, String filename) {
        this.dbPostazioni = dbPostazioni;
        this.filename = filename;
        sdp = new SerializzatoreDatabasePostazioni(dbPostazioni);
    }
    
    @Override
    public void run(){
        while(true) 
        {
            synchronized(dbPostazioni) {
            try {
                dbPostazioni.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SalvataggioAutomaticoPostazioni.class.getName()).log(Level.SEVERE, null, ex);
            }
            sdp.salva(filename);
            dbPostazioni.notifyAll();
            }
        }
        
        
    }
}
