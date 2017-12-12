/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca.eccezioni;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davide
 */
public class UtenteNonPresenteException extends Exception {

    /**
     * Creates a new instance of <code>UtentePresenteEception</code> without
     * detail message.
     */
    public UtenteNonPresenteException() {
    }

    /**
     * Constructs an instance of <code>UtentePresenteEception</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UtenteNonPresenteException(String msg) {
        super(msg);
    }
}
