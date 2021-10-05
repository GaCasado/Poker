/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.poker.view;

import com.mycompany.poker.model.Solucion;
import static com.mycompany.poker.view.opcion1.mostrarImagen;

public class opcion4 extends javax.swing.JFrame {
    public opcion4(String jugador, String mesa, Solucion sol) {
        initComponents();
        Character uno = null, dos = null;
        uno = jugador.charAt(0);dos =jugador.charAt(1);
         mostrarImagen(this.carta1j,uno+dos+ ".png");
         uno = jugador.charAt(2);dos =jugador.charAt(3);
         mostrarImagen(this.carta2j,uno+dos+ ".png");
         uno = jugador.charAt(4);dos =jugador.charAt(5);
         mostrarImagen(this.carta3j,uno+dos+ ".png");
         uno = jugador.charAt(6);dos =jugador.charAt(7);
         mostrarImagen(this.carta4j,uno+dos+ ".png");
         uno = mesa.charAt(0);dos =mesa.charAt(1);
         mostrarImagen(this.carta1m,uno+dos+ ".png");
         uno = mesa.charAt(2);dos =mesa.charAt(3);
         mostrarImagen(this.carta2m,uno+dos+ ".png");
         uno = mesa.charAt(4);dos =mesa.charAt(5);
         mostrarImagen(this.carta3m,uno+dos+ ".png");
         uno = mesa.charAt(6);dos =mesa.charAt(7);
         mostrarImagen(this.carta4m,uno+dos+ ".png");
         uno = mesa.charAt(8);dos =mesa.charAt(9);
         mostrarImagen(this.carta5m,uno+dos+ ".png");
         String aux = "";
         aux = sol.toString() + " " + sol.getDraws();
         jugadas.setText(aux);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carta1m = new javax.swing.JLabel();
        carta2m = new javax.swing.JLabel();
        carta3m = new javax.swing.JLabel();
        carta4m = new javax.swing.JLabel();
        carta5m = new javax.swing.JLabel();
        carta1j = new javax.swing.JLabel();
        carta2j = new javax.swing.JLabel();
        carta3j = new javax.swing.JLabel();
        carta4j = new javax.swing.JLabel();
        jugadas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        carta1m.setText("jLabel1");

        carta2m.setText("jLabel2");

        carta3m.setText("jLabel3");

        carta4m.setText("jLabel4");

        carta5m.setText("jLabel5");

        carta1j.setText("jLabel6");

        carta2j.setText("jLabel7");

        carta3j.setText("jLabel8");

        carta4j.setText("jLabel9");

        jugadas.setText("soluciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(carta1m)
                        .addGap(18, 18, 18)
                        .addComponent(carta2m)
                        .addGap(18, 18, 18)
                        .addComponent(carta3m)
                        .addGap(18, 18, 18)
                        .addComponent(carta4m)
                        .addGap(18, 18, 18)
                        .addComponent(carta5m))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(carta1j)
                        .addGap(18, 18, 18)
                        .addComponent(carta2j)
                        .addGap(18, 18, 18)
                        .addComponent(carta3j)
                        .addGap(18, 18, 18)
                        .addComponent(carta4j))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carta1m, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta2m)
                    .addComponent(carta3m)
                    .addComponent(carta4m)
                    .addComponent(carta5m))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carta1j, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta2j)
                    .addComponent(carta3j)
                    .addComponent(carta4j, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carta1j;
    private javax.swing.JLabel carta1m;
    private javax.swing.JLabel carta2j;
    private javax.swing.JLabel carta2m;
    private javax.swing.JLabel carta3j;
    private javax.swing.JLabel carta3m;
    private javax.swing.JLabel carta4j;
    private javax.swing.JLabel carta4m;
    private javax.swing.JLabel carta5m;
    private javax.swing.JLabel jugadas;
    // End of variables declaration//GEN-END:variables
}
