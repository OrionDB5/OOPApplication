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
public class OrologioDiSistema implements Runnable {
    Database db;
    public OrologioDiSistema(Database db) {
       this.db = db;
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
            db.azzeraDisponibilitàPosti(0);
            try {
                System.out.println("Ore 10:30");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.azzeraDisponibilitàPosti(1);

            try {
                System.out.println("Ore 12:30");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.azzeraDisponibilitàPosti(2);
            try {
                System.out.println("Ore 14:30");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.azzeraDisponibilitàPosti(3);
            try {
                System.out.println("Ore 16:30");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.azzeraDisponibilitàPosti(4);
            
            try {
                System.out.println("Ore 18:30");
                
                Thread.sleep(15000);    // aspetta le 19 per ripristinare la disponibilità
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            db.ripristinaDisponibilitàPosti();
            db.cancellaPrenotazioni();
            System.out.println("Ore 19:00");

            
            try {
                Thread.sleep(15000);   // aspetta fino a mezzanotte
            } catch (InterruptedException ex) {
                Logger.getLogger(OrologioDiSistema.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    } 
    
}
