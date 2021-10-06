/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.poker.view;

import com.mycompany.poker.model.Solucion;
import static com.mycompany.poker.view.Opcion1.mostrarImagen;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class Opcion3 extends javax.swing.JFrame {

 
    public Opcion3(ArrayList<String> cartasJugadores,String mesa, String soluciones) {
        initComponents();
        String auxiliar = "";Character uno = null, dos = null;
        for(int i = 0;i< cartasJugadores.size();i++){
            
            auxiliar += " Jugador "+ (i+1) + " " + cartasJugadores.get(i) + "\n";
        }
        cartasj.setText(auxiliar);
            for(int i = 0; i < mesa.length()/2;i++){
                uno = mesa.charAt(i*2);dos =mesa.charAt(i*2+1);
                //System.out.println(uno.toString()+dos.toString()+".png");
                muestra(i+1,"Images/" + uno.toString()+dos.toString()+".png");
            }
            jugadas.setText(soluciones);
        
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartasj = new javax.swing.JLabel();
        jugadas = new javax.swing.JLabel();
        carta1m = new javax.swing.JLabel();
        carta2m = new javax.swing.JLabel();
        carta3m = new javax.swing.JLabel();
        carta4m = new javax.swing.JLabel();
        carta5m = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cartasj.setText("cartasj");

        jugadas.setText("soluciones");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(carta1m, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(carta2m, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(carta3m, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(carta4m, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(carta5m, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(cartasj, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 97, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jugadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(carta1m, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(carta2m, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(carta3m, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(carta4m, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(carta5m, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(cartasj, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carta1m;
    private javax.swing.JLabel carta2m;
    private javax.swing.JLabel carta3m;
    private javax.swing.JLabel carta4m;
    private javax.swing.JLabel carta5m;
    private javax.swing.JLabel cartasj;
    private javax.swing.JLabel jugadas;
    // End of variables declaration//GEN-END:variables
}
