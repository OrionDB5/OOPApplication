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

import oop_gestionebiblioteca.database.DatabasePostazioni;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davide
 */
public class OrologioDiSistema implements Runnable {
    DatabasePostazioni dbp;
    private int ora;

    public OrologioDiSistema(DatabasePostazioni dbp) {
       this.dbp = dbp;
       this.ora = 0;
       
    }
    
    @Override
    public void run(){
        
        while(true){
            try {
                System.out.println("Ore 00:00");
                Thread.sleep(50000);   // aspetta fino alle 10:30 e poi occupa tutti i posti della prima fascia
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbp.azzeraDisponibilità(0);
            try {
                System.out.println("Ore 10:30");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbp.azzeraDisponibilità(1);
            try {
                System.out.println("Ore 12:30");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbp.azzeraDisponibilità(2);
            try {
                System.out.println("Ore 14:30");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbp.azzeraDisponibilità(3);
            try {
                System.out.println("Ore 16:30");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbp.azzeraDisponibilità(4);
            
            try {
                System.out.println("Ore 18:30");
                Thread.sleep(15000);    // aspetta le 19 per ripristinare la disnobilità
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbp.ripristinaDisponibilità();
            System.out.println("Ore 19:00");

            
            try {
                Thread.sleep(15000);   // aspetta fino a mezzanotte
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    } 
    
}
