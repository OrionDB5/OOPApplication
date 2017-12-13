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

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop_gestionebiblioteca.Prenotazione;
import oop_gestionebiblioteca.Utente;

/**
 *
 * @author Davide
 */
public class SalvataggioAutomaticoPrenotazioni implements Runnable {
    private final DatabasePrenotazioni dbPrenotazioni;
    private final String filename = "backup_prenotazioni.txt";

    public SalvataggioAutomaticoPrenotazioni(DatabasePrenotazioni dbPrenotazioni) {
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
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            
                Iterator<Prenotazione> iter_p = dbPrenotazioni.iterator();
                while(iter_p.hasNext())
                {
                    
                    Prenotazione p = iter_p.next();
                    Utente u = p.getUtente();
                    out.write(p.getCodicePrenotazione() + ";" + u.getNome() + ";" + u.getCognome() + ";" + u.getMatricola() + ";" + p.getDataPrenotazione() + ";" + p.getValidità());
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
