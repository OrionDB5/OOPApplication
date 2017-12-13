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
    private final String filename = "backup_postazioni.txt";

    public SalvataggioAutomaticoPostazioni(DatabasePostazioni dbPostazioni) {
        this.dbPostazioni = dbPostazioni;
    }
    
    @Override
    public void run(){
        int numeroFasce = FasciaOraria.getFasce();
        while(true) 
        {
            synchronized(dbPostazioni) {
            try {
                dbPostazioni.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SalvataggioAutomaticoPostazioni.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            boolean[] disponibilità;
            for(int i = 0 ; i < numeroFasce ; i++)
            {
                try
                {
                    disponibilità = dbPostazioni.visualizzaPostiDisponibili(i);
                } catch (FasciaNonValidaException ex) 
                 {
                       Logger.getLogger(SalvataggioAutomaticoPostazioni.class.getName()).log(Level.SEVERE, null, ex);
                       break;
                 }
                
                    for(int j = 0 ; j < disponibilità.length ; j++)
                    {
                        out.write(disponibilità[j] ? "0;" : "1;");
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
