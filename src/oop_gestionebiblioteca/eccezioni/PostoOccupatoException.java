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
public class PostoOccupatoException extends Exception {

    /**
     * Creates a new instance of <code>PostoOccupatoException</code> without
     * detail message.
     */
    public PostoOccupatoException() {
    }

    /**
     * Constructs an instance of <code>PostoOccupatoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PostoOccupatoException(String msg) {
        super(msg);
    }
}
