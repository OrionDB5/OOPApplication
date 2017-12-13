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

import oop_gestionebiblioteca.eccezioni.FasciaNonValidaException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Davide
 */
public class Prenotazione {
    private int numPosto;
    private int fasciaOraria;
    private final int codicePrenotazione;
    private boolean validità;
    private LocalDate dataPrenotazione;
    private Utente utente;

    public int getCodicePrenotazione() {
        return codicePrenotazione;
    }

    public Prenotazione(int numPosto, int fasciaOraria, Utente utente, int codicePrenotazione) {
        this.numPosto = numPosto;
        this.fasciaOraria = fasciaOraria;
        this.utente = utente;
        this.validità = true;
        this.dataPrenotazione = LocalDate.now();
        this.codicePrenotazione = codicePrenotazione;
    }

    public int getNumPosto() {
        return numPosto;
    }

    public int getFasciaOraria() {
        return fasciaOraria;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public Utente getUtente() {
        return utente;
    }
    
    @Override
    public String toString() {
        String ret = "";
        try {
            ret = "Prenotazione numero: " + codicePrenotazione + " - Data prenotazione: " + dataPrenotazione.toString() + "\n" +
                    "Utente: " + utente.toString() + "\n"
                    + "Numero posto: " + numPosto
                    + "Fascia oraria: " + FasciaOraria.getFasciaOraria(fasciaOraria);
        } catch (FasciaNonValidaException ex) {
            Logger.getLogger(Prenotazione.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean getValidità() {
        return validità;
    }

    public void setValidità(boolean validità) {
        this.validità = validità;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codicePrenotazione;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prenotazione other = (Prenotazione) obj;
        return true;
    }
    
    
    
    
}
