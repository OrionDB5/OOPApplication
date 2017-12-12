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

import oop_gestionebiblioteca.database.DatabaseUtenti;
import oop_gestionebiblioteca.database.DatabasePrenotazioni;
import oop_gestionebiblioteca.database.DatabasePostazioni;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davide
 */
public class SalvataggioAutomaticoPrenotazioni implements Runnable {
    private DatabasePostazioni dbPostazioni;
    private final DatabasePrenotazioni dbPrenotazioni;
    private DatabaseUtenti dbUtenti;

    public SalvataggioAutomaticoPrenotazioni( DatabasePrenotazioni dbPrenotazioni) {
        this.dbPrenotazioni = dbPrenotazioni;
    }
    
    @Override
    public void run(){
        
        while(true) 
        {
            synchronized(dbPrenotazioni) {
            try {
                dbPrenotazioni.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SalvataggioAutomaticoPrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
            BufferedWriter out = new BufferedWriter(new FileWriter("backup_prenotazioni.txt"));
            
                Iterator<Prenotazione> iter_p = dbPrenotazioni.iterator();
                while(iter_p.hasNext())
                {
                    
                    Prenotazione p = iter_p.next();
                    System.out.println("Prenotazione: " + p);
                    Utente u = p.getUtente();
                    out.write(p.getCodicePrenotazione() + ";" + u.getNome() + ";" + u.getCognome() + ";" + u.getMatricola() + ";" + p.getDataPrenotazione());
                }
                
                out.close();
                
            }
             catch (IOException ex) {
            Logger.getLogger(SalvataggioAutomaticoPrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
             }
            dbPrenotazioni.notifyAll();
            }
        }
        
        
    }
}
