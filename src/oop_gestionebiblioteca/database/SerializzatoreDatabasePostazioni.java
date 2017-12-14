/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca.database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop_gestionebiblioteca.FasciaOraria;
import oop_gestionebiblioteca.eccezioni.FasciaNonValidaException;

/**
 *
 * @author Benedetto
 */
public class SerializzatoreDatabasePostazioni {

    private DatabasePostazioni db;
    private int numeroFasce;

    public SerializzatoreDatabasePostazioni(DatabasePostazioni db) {
        this.db = db;
        numeroFasce = FasciaOraria.getFasce();
    }
    
    public void salva(String filename) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            boolean[] disponibilità;
            for(int i = 0 ; i < numeroFasce ; i++)
            {
                try
                {
                    disponibilità = db.visualizzaPostiDisponibili(i);
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
    }
    
}
