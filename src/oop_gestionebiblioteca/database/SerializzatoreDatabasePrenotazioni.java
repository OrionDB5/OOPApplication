/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca.database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop_gestionebiblioteca.Prenotazione;
import oop_gestionebiblioteca.Utente;

/**
 *
 * @author Benedetto
 */
public class SerializzatoreDatabasePrenotazioni {
    
    private DatabasePrenotazioni db;
    protected SerializzatoreDatabasePrenotazioni(DatabasePrenotazioni db) {
        this.db = db;
    }
    
    public void salva(String filename) { 
            try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            
                Iterator<Prenotazione> iter_p = db.iterator();
                while(iter_p.hasNext())
                {
                    
                    Prenotazione p = iter_p.next();
                    Utente u = p.getUtente();
                    out.write(p.getCodicePrenotazione() + ";"
                            + u.getNome() + ";"
                            + u.getCognome() + ";"
                            + u.getMatricola() + ";" 
                            + p.getDataPrenotazione() 
                            + ";" + p.getValidità() + ";");
                    out.newLine();
                }
                
                out.close();
            }
             catch (IOException ex) {
            Logger.getLogger(SalvataggioAutomaticoPrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
             }
            
    }
}

