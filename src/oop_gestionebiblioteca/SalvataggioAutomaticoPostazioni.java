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

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
/**
 *
 * @author Davide
 */
public class SalvataggioAutomaticoPostazioni implements Runnable {
    private final DatabasePostazioni dbPostazioni;

    public SalvataggioAutomaticoPostazioni(DatabasePostazioni dbPostazioni) {
        this.dbPostazioni = dbPostazioni;
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
            try {
            BufferedWriter out = new BufferedWriter(new FileWriter("backup_postazioni.txt"));
            
                Iterator<Posto> iter_p = dbPostazioni.iterator();
                while(iter_p.hasNext())
                {
                    
                    Posto p = iter_p.next();
                    out.write(p.getNumeroPosto() + ";");
                    for(int i = 0 ; i < FasciaOraria.getFasce() ; i++) {
                        out.write(p.getDisponibilità(i) ? "1" : "0");
                        out.write(";");
                    }
                    out.newLine();
                    
                }
                out.close();
                
            }
             catch (IOException ex) {
            Logger.getLogger(SalvataggioAutomaticoPostazioni.class.getName()).log(Level.SEVERE, null, ex);
             }
            dbPostazioni.notifyAll();
            }
        }
        
        
    }
}
