/*
 * UN SORTED SET
 */
package fr.pb.securiteincendie;

import fr.pb.global.Globale;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import redis.clients.jedis.Jedis;

/**
 *
 * @author pascal
 */
public class CategorieCRUD extends javax.swing.JFrame {

    private final Jedis jedis;
    private DefaultTableModel idtm;
//    Map<old, new>;
    private Map<String, String> mapNewCategorie;
    //private String[][] t2DCategorie;
    private long llTaille;

    /**
     * Creates new form CategorieCRUD
     */
    public CategorieCRUD() {
        initComponents();

        jedis = Globale.getConnexionRedis();
        remplirTable();

        setTitle("CRUD Catégorie");
        setLocationRelativeTo(null);
        setVisible(true);

    } /// Constructeur

    /**
     *
     */
    private void remplirTable() {
        try {

            //Trier dans l'ordre
            mapNewCategorie = new TreeMap();

            Object[] tLigne;

            idtm = (DefaultTableModel) jTableCategories.getModel();

            /*
             LIST
             */
            // Nombre d'éléments
            llTaille = jedis.zcard("Categories");
            //t2DCategorie = new String[(int) llTaille][2];
            // Récupération des éléments
            Set<String> set = jedis.zrange("Categories", 0, llTaille);
            String[] tCategories = set.toArray(new String[(int) llTaille]);

            for (int i = 0; i < llTaille; i++) {
                tLigne = new Object[2];
                tLigne[0] = "";
                tLigne[1] = tCategories[i];
                mapNewCategorie.put(tCategories[i], "");
                idtm.addRow(tLigne);
//            int i = 0;
//            for (String lsCategorie : set) {
//                tLigne = new Object[2];
//                tLigne[0] = "";
//                tLigne[1] = lsCategorie;
//                idtm.addRow(tLigne);
//                t2DCategorie[i][0] = lsCategorie;
//                t2DCategorie[i][1] = "";
//                mapNewCategorie.put(lsCategorie[i], "");
//                i++;
            }

            jLabelMessage.setText("Jusque là tout va bien !!!");

        } catch (Exception e) {
            jLabelMessage.setText(e.getMessage());
        }

    } /// remplirTable

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButtonAjouter = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jTextFieldCategorie = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategories = new javax.swing.JTable();
        jButtonCLS = new javax.swing.JButton();
        jButtonCommit = new javax.swing.JButton();
        jButtonRollback = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setText("Catégorie");

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jLabelMessage.setText("Message");

        jTextFieldCategorie.setText("Assistant opérateur");

        jTableCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flag", "Catégorie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCategoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCategories);
        if (jTableCategories.getColumnModel().getColumnCount() > 0) {
            jTableCategories.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonCLS.setText("CLS");
        jButtonCLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCLSActionPerformed(evt);
            }
        });

        jButtonCommit.setText("Commit");
        jButtonCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCommitActionPerformed(evt);
            }
        });

        jButtonRollback.setText("Rollback");
        jButtonRollback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRollbackActionPerformed(evt);
            }
        });

        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMessage)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButtonCLS)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(58, 58, 58)
                            .addComponent(jButtonModifier)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSupprimer))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCommit)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRollback)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCLS)
                        .addComponent(jButtonAjouter))
                    .addComponent(jButtonModifier)
                    .addComponent(jButtonSupprimer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCommit)
                    .addComponent(jButtonRollback))
                .addGap(18, 18, 18)
                .addComponent(jLabelMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        String lsCategorie = jTextFieldCategorie.getText();

        jLabelMessage.setText("");

        if (lsCategorie.trim().isEmpty()) {
            jLabelMessage.setText("Saisies obligatoires");
        } else {
            String[] tLigne = new String[2];
            tLigne[0] = "+";
            tLigne[1] = lsCategorie;
            idtm.addRow(tLigne);
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCLSActionPerformed
        //
        jLabelMessage.setText("");
        jTextFieldCategorie.setText("");
    }//GEN-LAST:event_jButtonCLSActionPerformed

    private void jButtonCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCommitActionPerformed
        jLabelMessage.setText("");
        try {
            int liRows = jTableCategories.getRowCount();
            String lsFlag;
            String lsCategorie;

            for (int i = liRows - 1; i >= 0; i--) {
                lsFlag = jTableCategories.getValueAt(i, 0).toString();
                lsCategorie = jTableCategories.getValueAt(i, 1).toString();

                if (lsFlag.equals("+")) {
                    // Ajout à droite 
                    jedis.zadd("Categories", llTaille, lsCategorie);
                    System.out.println(llTaille);
                    idtm.setValueAt("", i, 0);
                }
                if (lsFlag.equals("-")) {
                    // Remove 
                    jedis.zrem("Categories", lsCategorie);
                    idtm.removeRow(i);
                }
                /* 
                 TODO 
                 */
                if (lsFlag.equals("v")) {
                    // Ancienne valeur (a revoir) 
                    jedis.zrem("Categories", lsCategorie);
                    System.out.println(jedis);
                    System.out.println(Globale.getConnexionRedis());
                    // Nouvelle valeur 
                    jedis.zadd("Categories", llTaille, lsCategorie);
                    idtm.setValueAt("", i, 0);
                }
            }
            jLabelMessage.setText("Validation définitive OK");
        } catch (Exception e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonCommitActionPerformed

    private void jButtonRollbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRollbackActionPerformed

        jLabelMessage.setText("");
        int liRows = jTableCategories.getRowCount();
        String lsFlag;
        String lsNouvelleValeur;
        String lsAncienneValeur;

        for (int i = liRows - 1; i >= 0; i--) {
            lsFlag = jTableCategories.getValueAt(i, 0).toString();
            if (lsFlag.equals("+")) {
                idtm.removeRow(i);
            }
            if (lsFlag.equals("-")) {
                idtm.setValueAt("", i, 0);
            }
            if (lsFlag.equals("v")) {
                lsNouvelleValeur = jTableCategories.getValueAt(i, 1).toString();
                String cle = null;
                String valeur;
                for (Map.Entry<String, String> entry : mapNewCategorie.entrySet()) {
                    cle = entry.getKey();
                    valeur = entry.getValue();
                    if (valeur.equals(lsNouvelleValeur)) {
                        lsAncienneValeur = cle;
                    }
                }
                lsAncienneValeur = cle;
                idtm.setValueAt(lsAncienneValeur, i, 1);
                idtm.setValueAt("", i, 0);
            }
        }
    }//GEN-LAST:event_jButtonRollbackActionPerformed

    private void jTableCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCategoriesMouseClicked
        //
        jTextFieldCategorie.setText(jTableCategories.getValueAt(jTableCategories.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_jTableCategoriesMouseClicked

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed

        jLabelMessage.setText("");
        int liRow = jTableCategories.getSelectedRow();
        if (liRow >= 0) {
            if (jTableCategories.getValueAt(liRow, 0).toString().equals("") || jTableCategories.getValueAt(liRow, 0).toString().equals("-")) {
                jTableCategories.setValueAt("v", liRow, 0);
                mapNewCategorie.replace(jTableCategories.getValueAt(liRow, 1).toString(), jTextFieldCategorie.getText());
                //t2DCategorie[liRow][1] = jTextFieldCategorie.getText();
                jTableCategories.setValueAt(jTextFieldCategorie.getText(), liRow, 1);

            }
        } else {
            jLabelMessage.setText("Vous devez sélectionner une ligne !");
        }

    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        //
        jLabelMessage.setText("");
        int liRow = jTableCategories.getSelectedRow();
        if (liRow >= 0) {
            if (jTableCategories.getValueAt(liRow, 0).toString().equals("+")) {
                idtm.removeRow(liRow);
            } else {
                idtm.setValueAt("-", liRow, 0);
            }
        } else {
            jLabelMessage.setText("Vous devez sélectionner une ligne !");
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //
        JFrame f = Globale.getFenetre();
        f.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(CategorieCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategorieCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategorieCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategorieCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategorieCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonCLS;
    private javax.swing.JButton jButtonCommit;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonRollback;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCategories;
    private javax.swing.JTextField jTextFieldCategorie;
    // End of variables declaration//GEN-END:variables
}
