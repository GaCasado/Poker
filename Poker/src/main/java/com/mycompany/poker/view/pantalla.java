/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.poker.view;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author alberto
 */

    

public class pantalla extends javax.swing.JFrame {
    public static void mostrarImagen(JLabel lbl, String ruta){
        lbl.setIcon(new ImageIcon(ruta));
    }

    /**
     * Creates new form pantalla
     */
    public pantalla() {
        initComponents();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fichero = new javax.swing.JTextField();
        Botonfichero = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jPartida = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ingresa el fichero de entrada y pulsa enter");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 390, -1));

        fichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ficheroActionPerformed(evt);
            }
        });
        getContentPane().add(fichero, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 220, -1));

        Botonfichero.setText("Enter");
        Botonfichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonficheroActionPerformed(evt);
            }
        });
        getContentPane().add(Botonfichero, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jPartida.setText("Partida");
        jMenuBar2.add(jPartida);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ficheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ficheroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ficheroActionPerformed

    private void BotonficheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonficheroActionPerformed
        // TODO add your handling code here:
        
        if(fichero.getText().isEmpty() != false){
            
            pantalla2 a = new pantalla2(fichero.getText());
            a.setVisible(true);
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Introduce el nombre del fichero");
        }
    }//GEN-LAST:event_BotonficheroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Botonfichero;
    private javax.swing.JTextField fichero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jPartida;
    // End of variables declaration//GEN-END:variables
}
