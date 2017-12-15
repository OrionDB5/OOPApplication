/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_gestionebiblioteca.GUI;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oop_gestionebiblioteca.Prenotazione;
import oop_gestionebiblioteca.Utente;
import oop_gestionebiblioteca.database.Database;
import oop_gestionebiblioteca.eccezioni.FasciaNonValidaException;
import oop_gestionebiblioteca.eccezioni.PasswordErrataException;
import oop_gestionebiblioteca.eccezioni.PostoNonPresenteException;
import oop_gestionebiblioteca.eccezioni.PostoOccupatoException;
import oop_gestionebiblioteca.eccezioni.PrenotazioniInsufficientiException;
import oop_gestionebiblioteca.eccezioni.UtenteNonPresenteException;
import oop_gestionebiblioteca.eccezioni.UtentePresenteException;

/**
 *
 * @author Benedetto
 */
public class GUI_Admin_GestioneUtenti extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Admin
     */
    
    private Database db;
    public GUI_Admin_GestioneUtenti() {
        db = new Database();
        try {
           Utente u;
            try {
                u = db.registraUtente("Benedetto", "Ginestra", "benedettoginestra@gmail.com", "FUCK");
                            db.prenotaPosto(5, 3, u);
            } catch (UtentePresenteException ex) {
                Logger.getLogger(GUI_Admin_GestionePrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (PostoNonPresenteException ex) {
            Logger.getLogger(GUI_Admin_GestionePrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FasciaNonValidaException ex) {
            Logger.getLogger(GUI_Admin_GestionePrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PostoOccupatoException ex) {
            Logger.getLogger(GUI_Admin_GestionePrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UtenteNonPresenteException ex) {
            Logger.getLogger(GUI_Admin_GestionePrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PrenotazioniInsufficientiException ex) {
            Logger.getLogger(GUI_Admin_GestionePrenotazioni.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();


        Iterator<Utente> utenti = db.iteratorUtenti();
        int i = 0;
        while(utenti.hasNext())
        {
            Utente u = utenti.next();
            jTableUtenti.setValueAt(u.getMatricola(), i, 0);
            jTableUtenti.setValueAt(u.getCognome(), i, 1);
            jTableUtenti.setValueAt(u.getNome(), i, 2);
            jTableUtenti.setValueAt(u.getEmail(), i++, 3);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGestionePrenotazioni2 = new javax.swing.JPanel();
        jLabelGestionePrenotazioniIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelGestionePrenotazioni = new javax.swing.JLabel();
        jPanelGestioneUtenti = new javax.swing.JPanel();
        jLabelUserListIcon1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelAmministrazione = new javax.swing.JLabel();
        jPanelLogout = new javax.swing.JPanel();
        jLabelLogout = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUtenti = new javax.swing.JTable();
        jRadioButtonCodicePrenotazione = new javax.swing.JRadioButton();
        jRadioButtonCredenzialiUtente = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonRicerca = new javax.swing.JButton();
        jTextFieldCriterioRicerca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCodiceRimuoviUtente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonRimuoviUtente = new javax.swing.JButton();
        jButtonAggiorna = new javax.swing.JButton();

        jPanelGestionePrenotazioni2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGestionePrenotazioni2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 67, 63)));
        jPanelGestionePrenotazioni2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelGestionePrenotazioniIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/checkList.png"))); // NOI18N

        jLabel1.setFont(jLabelGestionePrenotazioni.getFont());
        jLabel1.setText("prenotazioni");

        jLabelGestionePrenotazioni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelGestionePrenotazioni.setText("Gestione");

        javax.swing.GroupLayout jPanelGestionePrenotazioni2Layout = new javax.swing.GroupLayout(jPanelGestionePrenotazioni2);
        jPanelGestionePrenotazioni2.setLayout(jPanelGestionePrenotazioni2Layout);
        jPanelGestionePrenotazioni2Layout.setHorizontalGroup(
            jPanelGestionePrenotazioni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionePrenotazioni2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelGestionePrenotazioni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionePrenotazioni2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelGestionePrenotazioni))
                    .addGroup(jPanelGestionePrenotazioni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelGestionePrenotazioniIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelGestionePrenotazioni2Layout.setVerticalGroup(
            jPanelGestionePrenotazioni2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionePrenotazioni2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGestionePrenotazioniIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelGestionePrenotazioni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanelGestioneUtenti.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGestioneUtenti.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 67, 63)));
        jPanelGestioneUtenti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelUserListIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userListUltimate.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Gestione utenti");

        javax.swing.GroupLayout jPanelGestioneUtentiLayout = new javax.swing.GroupLayout(jPanelGestioneUtenti);
        jPanelGestioneUtenti.setLayout(jPanelGestioneUtentiLayout);
        jPanelGestioneUtentiLayout.setHorizontalGroup(
            jPanelGestioneUtentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestioneUtentiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelGestioneUtentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestioneUtentiLayout.createSequentialGroup()
                        .addComponent(jLabelUserListIcon1)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestioneUtentiLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );
        jPanelGestioneUtentiLayout.setVerticalGroup(
            jPanelGestioneUtentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestioneUtentiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUserListIcon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanelHeader.setBackground(new java.awt.Color(255, 255, 255));

        jLabelLogo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelLogo.setText("Centro Bibliotecario UniSa");

        jLabelAmministrazione.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAmministrazione.setText("AMMINISTRAZIONE/gestione-utenti");

        jPanelLogout.setBackground(new java.awt.Color(0, 51, 51));
        jPanelLogout.setForeground(new java.awt.Color(0, 51, 51));

        jLabelLogout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoutAdminIcon.png"))); // NOI18N
        jLabelLogout.setText(" Logout");
        jLabelLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelBack.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBack.setText("Torna indietro");
        jLabelBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelLogoutLayout = new javax.swing.GroupLayout(jPanelLogout);
        jPanelLogout.setLayout(jPanelLogoutLayout);
        jPanelLogoutLayout.setHorizontalGroup(
            jPanelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogoutLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabelLogout)
                .addGap(44, 44, 44)
                .addComponent(jLabelBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLogoutLayout.setVerticalGroup(
            jPanelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogout)
                    .addComponent(jLabelBack))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAmministrazione)
                    .addComponent(jLabelLogo))
                .addContainerGap(695, Short.MAX_VALUE))
            .addComponent(jPanelLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAmministrazione)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTableUtenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matricola utente", "Cognome", "Nome", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUtenti.setRowHeight(25);
        jTableUtenti.getTableHeader().setResizingAllowed(false);
        jTableUtenti.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableUtenti);

        jRadioButtonCodicePrenotazione.setBackground(new java.awt.Color(0, 102, 102));
        buttonGroup1.add(jRadioButtonCodicePrenotazione);
        jRadioButtonCodicePrenotazione.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonCodicePrenotazione.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCodicePrenotazione.setSelected(true);
        jRadioButtonCodicePrenotazione.setText("Indirizzo e-mail");
        jRadioButtonCodicePrenotazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCodicePrenotazioneActionPerformed(evt);
            }
        });

        jRadioButtonCredenzialiUtente.setBackground(new java.awt.Color(0, 102, 102));
        buttonGroup1.add(jRadioButtonCredenzialiUtente);
        jRadioButtonCredenzialiUtente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonCredenzialiUtente.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonCredenzialiUtente.setText("Cognome");
        jRadioButtonCredenzialiUtente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCredenzialiUtenteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Criterio di ricerca : ");

        jButtonRicerca.setText("Ricerca utente");
        jButtonRicerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRicercaActionPerformed(evt);
            }
        });

        jTextFieldCriterioRicerca.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ricerca utente");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Risultato dell'operazione : ");

        jRadioButton1.setBackground(new java.awt.Color(0, 102, 102));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Matricola");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rimozione utente");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Codice utente : ");

        jButtonRimuoviUtente.setText("Rimuovi utente");
        jButtonRimuoviUtente.setToolTipText("");
        jButtonRimuoviUtente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRimuoviUtenteActionPerformed(evt);
            }
        });

        jButtonAggiorna.setText("Aggiorna");
        jButtonAggiorna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAggiornaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodiceRimuoviUtente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTextFieldCriterioRicerca, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonCredenzialiUtente)
                                    .addComponent(jRadioButtonCodicePrenotazione)
                                    .addComponent(jRadioButton1)))
                            .addComponent(jLabel3)
                            .addComponent(jButtonRicerca, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jButtonRimuoviUtente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(111, 111, 111)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAggiorna, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCriterioRicerca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonCodicePrenotazione)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonCredenzialiUtente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRicerca)))
                .addGap(18, 18, 18)
                .addComponent(jButtonAggiorna)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodiceRimuoviUtente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRimuoviUtente)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRicercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRicercaActionPerformed
       
        
        String criterio = jTextFieldCriterioRicerca.getText().trim();
        if(criterio.equals(""))
            return;
        
        if(jRadioButtonCodicePrenotazione.isSelected())
        {
            if(! criterio.matches("[0-9]+"))
            {
                jTextArea1.setText("Inserisci un numero di prenotazione valido.\n"
                        + "Sono ammessi solo caratteri numerici per il numero di prenotazione.");
                return;
            }
            
            int codicePrenotazione = getCodicePrenotazione(criterio);
            
            Prenotazione p = db.ricercaPrenotazione(codicePrenotazione);
            if(p == null)
                jTextArea1.setText("Nessuna prenotazione trovata col codice "+ codicePrenotazione + ".");
            else
                jTextArea1.setText(p.toString());
            return;
        }
        
        if(jRadioButtonCredenzialiUtente.isSelected())
        {
            Set<Prenotazione> search_results = db.ricercaPrenotazione(criterio);
            
            if(! search_results.isEmpty())
            {
                jTextArea1.setText("Trovati " + search_results.size() + " risultati\n");
                for(Prenotazione p : search_results)
                {
                    jTextArea1.append(p.toString() + "\n");
                }
            }
            
            else
                jTextArea1.setText("La ricerca non ha ottenuto alcun effetto");
        }
    }//GEN-LAST:event_jButtonRicercaActionPerformed

    private void jRadioButtonCredenzialiUtenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCredenzialiUtenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCredenzialiUtenteActionPerformed

    private void jRadioButtonCodicePrenotazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCodicePrenotazioneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCodicePrenotazioneActionPerformed

    private void jButtonRimuoviUtenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRimuoviUtenteActionPerformed
 
        String stringaCodice = jTextFieldCodiceRimuoviUtente.getText();
        if(! stringaCodice.matches("[0-9]+"))
        {
            jTextArea1.setText("Inserisci una matricola valida.\nSono ammesse esclusivamente matricole numeriche");
            return;
        }
        
        int matricolaUtente = Integer.parseInt(stringaCodice);
        
        String psw = JOptionPane.showInputDialog(this, "Inserire il codice di riconoscimento: ");
        
        try {
            db.accessoAdmin(psw);
        } catch (PasswordErrataException ex) {
            jTextArea1.setText("Non ti sei autenticato correttamente in qualità di amministratore");
            return;
        }
        try {
            db.rimuoviUtente(matricolaUtente);
            jTextArea1.setText("Utente rimosso correttamente.");
        } catch (UtenteNonPresenteException ex) {
            jTextArea1.setText("Utente non presente: la matricola inserita non risulta associata ad alcun account utente.");
        }
    }//GEN-LAST:event_jButtonRimuoviUtenteActionPerformed

    private void jButtonAggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAggiornaActionPerformed
        
        for(int i = 0 ; i < jTableUtenti.getRowCount() ; i++) 
        {
            for(int j = 0 ; j < jTableUtenti.getColumnCount() ; j++)
                jTableUtenti.setValueAt(null, i, j);
        }
        
       Iterator<Utente> utenti = db.iteratorUtenti();
        int i = 0;
        while(utenti.hasNext())
        {
            Utente u = utenti.next();
            jTableUtenti.setValueAt(u.getMatricola(), i, 0);
            jTableUtenti.setValueAt(u.getCognome(), i, 1);
            jTableUtenti.setValueAt(u.getNome(), i, 2);
            jTableUtenti.setValueAt(u.getEmail(), i++, 3);
        }
    }//GEN-LAST:event_jButtonAggiornaActionPerformed

    private int getCodicePrenotazione(String criterio) {
        int lunghezza_criterio = criterio.length();
            int codicePrenotazione = 0;
            for(int i = lunghezza_criterio - 1; i >= 0 ; i--)
            {
                codicePrenotazione += (criterio.charAt(i) - 48) * Math.pow(10, lunghezza_criterio - 1 - i);
            }
            
            return codicePrenotazione;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Admin_GestioneUtenti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAggiorna;
    private javax.swing.JButton jButtonRicerca;
    private javax.swing.JButton jButtonRimuoviUtente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAmministrazione;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelGestionePrenotazioni;
    private javax.swing.JLabel jLabelGestionePrenotazioniIcon;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelUserListIcon1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGestionePrenotazioni2;
    private javax.swing.JPanel jPanelGestioneUtenti;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelLogout;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButtonCodicePrenotazione;
    private javax.swing.JRadioButton jRadioButtonCredenzialiUtente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableUtenti;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldCodiceRimuoviUtente;
    private javax.swing.JTextField jTextFieldCriterioRicerca;
    // End of variables declaration//GEN-END:variables
}
