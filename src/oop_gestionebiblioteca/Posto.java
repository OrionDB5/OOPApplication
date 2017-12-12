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

/**
 *
 * @author Davide
 */
public class Posto implements Comparable {
    private boolean [] fasce;
    private final int numeroPosto;
    
    public Posto(int numeroPosto) {
        fasce = new boolean[FasciaOraria.getFasce()];
        this.numeroPosto = numeroPosto;
        for (int i = 0; i < fasce.length; i++){
            fasce[i] = true;
        }
    }
    
    public void liberaPosto(int fasciaOraria) {
        fasce[fasciaOraria] = true;
    }
    
    public void occupaPosto(int fasciaOraria) {
        fasce[fasciaOraria] = false;
    }
    
    public boolean getDisponibilità(int fasciaOraria){
        return fasce[fasciaOraria];
    }

    public int getNumeroPosto() {
        return numeroPosto;
    }
    @Override
    public int compareTo(Object t) {
        
        if(t == null)
            throw new NullPointerException();
        if(! (t instanceof Posto))
            throw new ClassCastException();
        
        Posto p = (Posto) t;
        Integer i = new Integer(numeroPosto);
        return i.compareTo(p.getNumeroPosto());
    }
}
