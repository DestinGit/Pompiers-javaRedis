/*
 LieuModifier.java
 Les lieux sont stockés dans un Hash
 La clé est le CP
 La valeur est le nom du lieu (Paris, Lyon, Marseille, ...)
 {75000:Paris, 69000:Lyon, 13000:Marseille, ...}
 */
package fr.pb.securiteincendie;

import fr.pb.global.Globale;
import java.util.*;
import javax.swing.JFrame;
import redis.clients.jedis.Jedis;

/**
 *
 * @author pascal
 */
public class LieuModifier extends javax.swing.JFrame {

    private final Jedis jedis;
    private Map<String, String> mapInversee;

    /**
     * Creates new form
     */
    public LieuModifier() {
        initComponents();

        // Connexion
        jedis = Globale.getConnexionRedis();
        remplirListe();

        setTitle("Modifier un lieu");
        setLocationRelativeTo(null);
        setVisible(true);
    } /// Constructeur

    /**
     *
     */
    private void remplirListe() {

        try {
            //Recuperation de l'id et du nom des lieux
            Map<String, String> mapLieux = jedis.hgetAll("Lieux");

            String cle;
            String valeur;

            //Inversion de id/lieu par lieu/id
            mapInversee = new TreeMap<>();

            for (Map.Entry<String, String> entry : mapLieux.entrySet()) {
                cle = entry.getKey();
                valeur = entry.getValue();
                mapInversee.put(valeur, cle);
                jComboBoxLieux.addItem(valeur);
            }

        } catch (Exception e) {
            jLabelMessage.setText(e.getMessage());
        }

    } /// remplirListe

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonModifier = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();
        jComboBoxLieux = new javax.swing.JComboBox();
        jButtonSelectionner = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldIdLieu = new javax.swing.JTextField();
        jTextFieldNomLieu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Lieu");

        jButtonModifier.setText("Modification");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jLabelMessage.setText("Message");

        jButtonSelectionner.setText("Sélectionner");
        jButtonSelectionner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectionnerActionPerformed(evt);
            }
        });

        jLabel2.setText("Nom du lieu");

        jLabel3.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonModifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addComponent(jComboBoxLieux, 0, 298, Short.MAX_VALUE))
                    .addComponent(jButtonSelectionner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabelMessage)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldIdLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldNomLieu))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxLieux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSelectionner)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldIdLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonModifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMessage)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        try {
            //Verif si le champs est vide
            if (jTextFieldNomLieu.getText().equals("")) {
                jLabelMessage.setText("Vous devez sélectionner un lieu !");
            } else {
                Map<String, String> map = new HashMap<>();
                map.put(jTextFieldIdLieu.getText(), jTextFieldNomLieu.getText());
                jedis.hmset("Lieux", map);
                jLabelMessage.setText("Modification reussie !!");
            }
        } catch (Exception e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonSelectionnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectionnerActionPerformed

        //Recuperation du nom du lieu à partir de la combo
        String nomLieu = jComboBoxLieux.getSelectedItem().toString();
        jTextFieldNomLieu.setText(nomLieu);
        //Recupere l'id à partir du nom du lieu
        jTextFieldIdLieu.setText(mapInversee.get(nomLieu));
    }//GEN-LAST:event_jButtonSelectionnerActionPerformed

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
            java.util.logging.Logger.getLogger(LieuModifier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LieuModifier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LieuModifier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LieuModifier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LieuModifier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSelectionner;
    private javax.swing.JComboBox jComboBoxLieux;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JTextField jTextFieldIdLieu;
    private javax.swing.JTextField jTextFieldNomLieu;
    // End of variables declaration//GEN-END:variables
}
