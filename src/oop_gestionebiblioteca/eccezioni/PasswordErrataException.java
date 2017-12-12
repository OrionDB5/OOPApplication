/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca.eccezioni;

/**
 *
 * @author Benedetto
 */
public class PasswordErrataException extends Exception {

    /**
     * Creates a new instance of <code>PasswordErrataException</code> without
     * detail message.
     */
    public PasswordErrataException() {
    }

    /**
     * Constructs an instance of <code>PasswordErrataException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PasswordErrataException(String msg) {
        super(msg);
    }
}
