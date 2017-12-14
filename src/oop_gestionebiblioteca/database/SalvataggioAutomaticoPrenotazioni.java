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


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davide
 */
public class SalvataggioAutomaticoPrenotazioni implements Runnable {
    private final DatabasePrenotazioni dbPrenotazioni;
    private final String filename;
    private final SerializzatoreDatabasePrenotazioni sdp;
    private boolean running = true;
    
    public SalvataggioAutomaticoPrenotazioni(DatabasePrenotazioni dbPrenotazioni, String filename) {
        this.dbPrenotazioni = dbPrenotazioni;
        this.filename = filename;
        sdp = new SerializzatoreDatabasePrenotazioni(dbPrenotazioni);
    }
    
    @Override
    public void run(){   
        while(running) 
        {
            synchronized(dbPrenotazioni) {
                try {
                    dbPrenotazioni.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SalvataggioAutomaticoPrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
                }
            sdp.salva(filename);
            dbPrenotazioni.notifyAll();
            }
        }
    }
}
