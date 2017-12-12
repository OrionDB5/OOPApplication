/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca;

import java.util.logging.Level;
import java.util.logging.Logger;
import oop_gestionebiblioteca.eccezioni.UtentePresenteException;

/**
 *
 * @author Benedetto
 */
public class OOP_GestioneBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DatabasePrenotazioni dbp = new DatabasePrenotazioni();
        DatabaseUtenti dbu = new DatabaseUtenti();
        DatabasePostazioni dbpost = new DatabasePostazioni(50);
        Thread t_clock = new Thread(new OrologioDiSistema(dbpost));
        t_clock.start();
        SalvataggioAutomaticoPrenotazioni salvataggio_dbp = new SalvataggioAutomaticoPrenotazioni(dbp);
        Thread t_s_dbp = new Thread(salvataggio_dbp);
        Thread t_s_dbpost = new Thread(new SalvataggioAutomaticoPostazioni(dbpost));
        t_s_dbpost.start();
        t_s_dbp.start();
        Utente u, u2;
        try {
            u = dbu.aggiungiUtente("Benedetto", "Ginestra", "benedettoginestra@gmail.com", "123456789");
            Prenotazione p = new Prenotazione(30, 2, u);
            dbp.inserisciPrenotazione(p);
            u2 = dbu.aggiungiUtente("Bernadette", "Wallowiz", "amolawii@gmail.com", "987654321");
            p = new Prenotazione(10, 2, u2);
            dbp.inserisciPrenotazione(p);
        } catch (UtentePresenteException ex) {
            Logger.getLogger(OOP_GestioneBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
