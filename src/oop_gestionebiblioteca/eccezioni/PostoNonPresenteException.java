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
public class PostoNonPresenteException extends Exception {

    /**
     * Creates a new instance of <code>PostoNonPresenteException</code> without
     * detail message.
     */
    public PostoNonPresenteException() {
    }

    /**
     * Constructs an instance of <code>PostoNonPresenteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PostoNonPresenteException(String msg) {
        super(msg);
    }
}
