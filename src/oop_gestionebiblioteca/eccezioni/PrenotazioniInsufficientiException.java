/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca.eccezioni;

/**
 *
 * @author Davide
 */
public class PrenotazioniInsufficientiException extends Exception {

    /**
     * Creates a new instance of <code>PrenotazioniInsufficientiException</code>
     * without detail message.
     */
    public PrenotazioniInsufficientiException() {
    }

    /**
     * Constructs an instance of <code>PrenotazioniInsufficientiException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public PrenotazioniInsufficientiException(String msg) {
        super(msg);
    }
}
