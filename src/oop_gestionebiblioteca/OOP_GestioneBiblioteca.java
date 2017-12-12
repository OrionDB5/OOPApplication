/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca;

import oop_gestionebiblioteca.database.DatabaseUtenti;
import oop_gestionebiblioteca.database.DatabasePrenotazioni;
import oop_gestionebiblioteca.database.DatabasePostazioni;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop_gestionebiblioteca.eccezioni.FasciaNonValidaException;
import oop_gestionebiblioteca.eccezioni.PostoNonPresenteException;
import oop_gestionebiblioteca.eccezioni.PostoOccupatoException;
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
            Prenotazione p;
            try {
                dbpost.prenotaPosto(1, 1, u);
                System.out.println(p);
            } catch (PostoNonPresenteException ex) {
                System.out.println(ex.getMessage());
            } catch (FasciaNonValidaException ex) {
                System.out.println(ex.getMessage());
            } catch (PostoOccupatoException ex) {
                System.out.println(ex.getMessage());
            }
            u2 = dbu.aggiungiUtente("Bernadette", "Wallowiz", "amolawii@gmail.com", "987654321");
            
        } catch (UtentePresenteException ex) {
            Logger.getLogger(OOP_GestioneBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
