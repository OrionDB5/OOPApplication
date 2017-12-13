/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca;

import oop_gestionebiblioteca.database.DatabaseUtenti;
import oop_gestionebiblioteca.database.DatabasePrenotazioni;
import oop_gestionebiblioteca.database.DatabasePostazioni;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop_gestionebiblioteca.database.Database;
import oop_gestionebiblioteca.eccezioni.FasciaNonValidaException;
import oop_gestionebiblioteca.eccezioni.PasswordErrataException;
import oop_gestionebiblioteca.eccezioni.PostoNonPresenteException;
import oop_gestionebiblioteca.eccezioni.PostoOccupatoException;
import oop_gestionebiblioteca.eccezioni.UtenteNonPresenteException;
import oop_gestionebiblioteca.eccezioni.UtentePresenteException;
import java.util.*;
import oop_gestionebiblioteca.eccezioni.PrenotazioniInsufficientiException;
/**
 *
 * @author Benedetto
 */
public class OOP_GestioneBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Database db = new Database();
        try {
            Utente u = db.registraUtente("Benedetto", "Ginestra", "benedettoginestra@gmail.com", "FUCK");
            System.out.println("======== UTENTE AGGIUNTO ======\n" + u);
            Utente u2 = db.registraUtente("Giovanni", "Cerchia", "giocer2412@gmail.com", "YOU");
            System.out.println("======== UTENTE AGGIUNTO ======\n" + u2);
            Utente u3 = db.registraUtente("Amici", "Di Maria", "amici5@gmail.com", "<3");
            System.out.println("======== UTENTE AGGIUNTO ======\n" + u3);
            
            boolean signup = false;
            while(!signup)
            {
                System.out.println("\n====== PROCEDURA DI REGISTRAZIONE ======");
                Scanner sc = new Scanner(System.in);
                System.out.print("Nome: ");
                String nome = sc.next();
                System.out.print("Cognome: ");
                String cognome = sc.next();
                System.out.println("E-mail: ");
                String email = sc.next();
                System.out.println("Password");
                String password = sc.next();
                try {
                    Utente u4 = db.registraUtente(nome, cognome, email, password);
                    signup = true;
                    System.out.println("Utente registrato\n" + u4);
                } catch(UtentePresenteException ex)
                {
                   
                }
            }
        } catch(UtentePresenteException ex) {
            
        }
        boolean accesso = false;
        boolean error = true;
        Utente logged = null;
        while(!accesso)
        {   try {
                System.out.println("\n====== LOGIN ======");
                Scanner sc = new Scanner(System.in);
                System.out.println("E-mail: ");
                String email = sc.next();
                System.out.println("Password");
                String password = sc.next();
                logged = db.login(email, password);
                        System.out.println("\nUtente loggato\n" + logged);
                accesso = true;
                } catch(UtenteNonPresenteException ex) {
                    System.out.println("Utente non esistente.");
                    error = true;
                    continue;
                } catch(PasswordErrataException ex)
                {
                    System.out.println(ex.getMessage());
                    error = true;
                    continue;
                }            
        }
        
        try {
            Prenotazione p = db.prenotaPosto(5, 2, logged);
            System.out.println(p);
            p = db.prenotaPosto(17, 2, logged);
            System.out.println(p);
            boolean b = db.rimuoviPrenotazione(p.getCodicePrenotazione());
                if(b)
                    System.out.println("Prenotazione rimossa: " + p);
            p = db.prenotaPosto(17, 2, logged);
            System.out.println(p);
        } catch (PostoNonPresenteException ex) {
            Logger.getLogger(OOP_GestioneBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FasciaNonValidaException ex) {
            Logger.getLogger(OOP_GestioneBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PostoOccupatoException ex) {
            Logger.getLogger(OOP_GestioneBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UtenteNonPresenteException ex) {
            Logger.getLogger(OOP_GestioneBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PrenotazioniInsufficientiException ex) {
            Logger.getLogger(OOP_GestioneBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
}}
