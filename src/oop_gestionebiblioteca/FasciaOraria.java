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

/**
 *
 * @author Davide
 */
public abstract class FasciaOraria {

    private static final int NUM_FASCE = 5;
    
    public static String getFasciaOraria(int fascia) throws FasciaNonValidaException {
        switch(fascia) {
            case 1 : return "8:30 - 10:30";
            case 2 : return "10:30 - 12:30";
            case 3 : return "12:30 - 14:30";
            case 4 : return "14:30 - 16:30";
            case 5 : return "16:30 - 18:30";
            default : throw new FasciaNonValidaException();
        }
    }
    
    public static final int getFasce() {
        return NUM_FASCE;
    }
}
