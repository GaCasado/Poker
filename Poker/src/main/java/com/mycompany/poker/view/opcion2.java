/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.poker.view;

import com.mycompany.poker.model.Solucion;
import static com.mycompany.poker.view.opcion1.mostrarImagen;

/**
 *
 * @author alberto
 */
public class opcion2 extends javax.swing.JFrame {

    //  if(mano.getSolucion().nC == 3){
          
   // };
    /**
     * Creates new form opcion2
     */
    public opcion2(String jugador, String mesa, Solucion sol) {
       
        initComponents();
        Character uno = null, dos = null;
        uno = jugador.charAt(0);dos =jugador.charAt(1);
            mostrarImagen(this.carta1j,uno+dos+ ".png");
            uno = jugador.charAt(2);dos =jugador.charAt(3);
            mostrarImagen(this.carta2j,uno+dos+ ".png");
            for(int i = 0; i < mesa.length()/2;i++){
                uno = jugador.charAt(i*2);dos =jugador.charAt(i*2+1);
                muestra(i,uno+dos+ ".png");
            }
            String aux = "";
            aux = sol.toString() + " " + sol.getDraws();
            jugadas.setText(aux);
        
    }
    private void muestra(int i,String ruta){
        
        switch(i){
            case 1:
                mostrarImagen(carta1m,ruta);
                break;
            case 2:
                mostrarImagen(carta2m,ruta);
                break;
            case 3:
                mostrarImagen(carta3m,ruta);
                break;    
            case 4:
                mostrarImagen(carta4m,ruta);
                break;
            case 5:
                mostrarImagen(carta5m,ruta);
                break;    
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jugadas = new javax.swing.JLabel();
        carta1j = new javax.swing.JLabel();
        carta2j = new javax.swing.JLabel();
        carta1m = new javax.swing.JLabel();
        carta2m = new javax.swing.JLabel();
        carta3m = new javax.swing.JLabel();
        carta4m = new javax.swing.JLabel();
        carta5m = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jugadas.setText("solucion");

        carta1j.setText("carta1j");

        carta2j.setText("carta2j");

        carta1m.setText("carta1m");

        carta2m.setText("carta2m");

        carta3m.setText("carta3m");

        carta4m.setText("carta4m");

        carta5m.setText("carta5m");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(carta1j, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(carta2j, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(carta1m)
                        .addGap(18, 18, 18)
                        .addComponent(carta2m)
                        .addGap(18, 18, 18)
                        .addComponent(carta3m)
                        .addGap(18, 18, 18)
                        .addComponent(carta4m)
                        .addGap(18, 18, 18)
                        .addComponent(carta5m)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(137, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carta1m, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta2m, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(carta3m, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta4m, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carta5m, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(carta2j, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(carta1j, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carta1j;
    private javax.swing.JLabel carta1m;
    private javax.swing.JLabel carta2j;
    private javax.swing.JLabel carta2m;
    private javax.swing.JLabel carta3m;
    private javax.swing.JLabel carta4m;
    private javax.swing.JLabel carta5m;
    private javax.swing.JLabel jugadas;
    // End of variables declaration//GEN-END:variables
}
