/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.poker.view;

import com.mycompany.poker.model.ComparadorSoluciones;
import com.mycompany.poker.model.Mano;
import com.mycompany.poker.model.Solucion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alberto
 */
public class pantalla2 extends javax.swing.JPanel {
    String fichero;
    /**
     * Creates new form pantalla2
     */
    public pantalla2(String fichero) {
        initComponents();
        this.fichero = fichero;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonop1 = new javax.swing.JButton();
        botonop2 = new javax.swing.JButton();
        botonop3 = new javax.swing.JButton();
        botonop4 = new javax.swing.JButton();

        jLabel1.setText("Seleccione el apartado que quiere probar");

        botonop1.setText("Apartado1");
        botonop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonop1ActionPerformed(evt);
            }
        });

        botonop2.setText("Apartado2");
        botonop2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonop2ActionPerformed(evt);
            }
        });

        botonop3.setText("Apartado3");
        botonop3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonop3ActionPerformed(evt);
            }
        });

        botonop4.setText("Apartado4");
        botonop4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonop4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonop4)
                    .addComponent(botonop3)
                    .addComponent(botonop2)
                    .addComponent(botonop1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(botonop1)
                .addGap(18, 18, 18)
                .addComponent(botonop2)
                .addGap(18, 18, 18)
                .addComponent(botonop3)
                .addGap(18, 18, 18)
                .addComponent(botonop4)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonop1ActionPerformed

            String jugador = "", mesa = "";int num = 0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fichero))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pantalla2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(reader.ready()){
                String linea = reader.readLine();
                jugador = linea.substring(0, 4);
                mesa = linea.substring(4, 10);
                Mano mano = new Mano(jugador, mesa,3, false);
                opcion1 a = new opcion1(jugador, mesa, mano.getSolucion());
                a.setVisible(true);
                this.setVisible(false);
                jugador = "";mesa = "";
            }
        } catch (IOException ex) {
            Logger.getLogger(pantalla2.class.getName()).log(Level.SEVERE, null, ex);
        }
             // TODO add your handling code here:
    }//GEN-LAST:event_botonop1ActionPerformed

    private void botonop2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonop2ActionPerformed
        // TODO add your handling code here:
        String jugador = "", mesa = "";int num = 0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fichero))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pantalla2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(reader.ready()){
                String linea = reader.readLine();
                jugador = linea.substring(0, 4);
                char ch = linea.charAt(5);
                num = Character.getNumericValue(ch); // Lee el numero de cartas del river
                mesa = linea.substring(7, ((num*2) + 7));
                Mano mano = new Mano(jugador, mesa,num, false);
                opcion2 a = new opcion2(jugador, mesa, mano.getSolucion());
                a.setVisible(true);
                this.setVisible(false);
                jugador = "";mesa = "";
            }
        } catch (IOException ex) {
            Logger.getLogger(pantalla2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonop2ActionPerformed

    private void botonop3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonop3ActionPerformed
        String solu = "";
        String manJug = "", mesa = "";int numJugadores = 0; ArrayList<String> cartasJugador = new ArrayList<>();
        BufferedReader reader = null;TreeMap<Solucion, Integer> soluciones = new TreeMap<>();
        ComparadorSoluciones comp = new ComparadorSoluciones();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fichero))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pantalla2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(reader.ready()){
                String linea = reader.readLine();
                numJugadores = Character.getNumericValue(linea.charAt(0));
                            int ini = 4, fin = 9;
                            for(int i =0; i< numJugadores;i++){
                                manJug = "";//4 11 18
                                manJug = linea.substring(ini +(i * 7), fin + (i * 7) -1);
                                cartasJugador.add(manJug);
                                System.out.println(manJug);
                            }
                            
                            mesa = linea.substring(2+(numJugadores * 7), 12 + (numJugadores * 7));
                            
                            System.out.println(mesa);
                            for(int i = 0; i< numJugadores; i++){
                                
                                Mano mano = new Mano(cartasJugador.get(i), mesa, 5, false);
                                Solucion aux = mano.getSolucion();
                                Integer numJ = i;
                                soluciones.put(aux, numJ + 1);
                            }      
                            //comparar y ordenar a los jugadores para escribirlos despues
                            
                            for( Map.Entry<Solucion, Integer>  r: soluciones.entrySet()){
                                Solucion aux = r.getKey();
                                Integer numJ = r.getValue();
                                solu += " J" + numJ + " "+ aux.toString() + "\n";
                            }
                            
                opcion3 a = new opcion3(cartasJugador, mesa, solu);
                a.setVisible(true);
                this.setVisible(false);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(pantalla2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonop3ActionPerformed

    private void botonop4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonop4ActionPerformed

            String jugador = "", mesa = "", cJ = "";int num = 0;Mano mano; Solucion aux;
            ComparadorSoluciones cmp = new ComparadorSoluciones();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fichero))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pantalla2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(reader.ready()){
                String linea = reader.readLine();
                            jugador = linea.substring(0, 8);
                            char ch = linea.charAt(9);
                            num = Character.getNumericValue(ch); // Lee el numero de cartas del river                           
                            mesa = linea.substring(11, ((num*2) + 11));
                            
                            
                            cJ += jugador.charAt(0);cJ += jugador.charAt(1);
                            cJ += jugador.charAt(2);cJ += jugador.charAt(3);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = mano.getSolucion();                         
                            cJ = "";
                            
                            cJ += jugador.charAt(2);cJ += jugador.charAt(3);
                            cJ += jugador.charAt(4);cJ += jugador.charAt(5);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                          
                            cJ = "";
                            
                            cJ += jugador.charAt(4);cJ += jugador.charAt(5);
                            cJ += jugador.charAt(6);cJ += jugador.charAt(7);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                          
                            cJ = "";
                            
                            cJ += jugador.charAt(0);cJ += jugador.charAt(1);
                            cJ += jugador.charAt(4);cJ += jugador.charAt(5);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                          
                            cJ = "";
                            
                            cJ += jugador.charAt(0);cJ += jugador.charAt(1);
                            cJ += jugador.charAt(6);cJ += jugador.charAt(7);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                          
                            cJ = "";
                            
                            cJ += jugador.charAt(2);cJ += jugador.charAt(3);
                            cJ += jugador.charAt(6);cJ += jugador.charAt(7);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                       
                            cJ = "";
                                                                                 
                        opcion4 a = new opcion4(jugador, mesa, aux);
                    a.setVisible(true);
                this.setVisible(false);
            }
        } catch (IOException ex) {
            Logger.getLogger(pantalla2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonop4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonop1;
    private javax.swing.JButton botonop2;
    private javax.swing.JButton botonop3;
    private javax.swing.JButton botonop4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
