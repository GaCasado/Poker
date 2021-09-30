/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poker.model;

/**
 *
 * @author seiya
 */
public class Solucion {
    private int jugada;
    private int tipo;
    private int tipo2;
    private String mano;
    private String drawSg, drawSo, drawF;
    
    public Solucion(int jugada, String mano) {
        this.jugada = jugada;
        this.tipo = -1;
        this.mano = mano;
        tipo2 = -1;
        drawSg = null;
        drawSo = null;
        drawF = null;
    }
    public Solucion(int jugada, int tipo, String mano) {
        this.jugada = jugada;
        this.tipo = tipo;
        this.mano = mano;
        tipo2 = -1;
        drawSg = null;
        drawSo = null;
        drawF = null;
    }
    public Solucion(int jugada, int tipo,int tipo2, String mano) {
        this.jugada = jugada;
        this.tipo = tipo;
        this.mano = mano;
        this.tipo2 = tipo2;
        drawSg = null;
        drawSo = null;
        drawF = null;
    }
    public int getJugada() {
        return jugada;
    }

    public int getTipo() {
        return tipo;
    }

    public String getMano() {
        return mano;
    }
    public void setDrawSg(String drawSg){
        this.drawSg = drawSg;
    }
    public void setDrawSo(String drawSo){
        this.drawSo = drawSo;
    }
    public void setDrawF(String drawF){
        this.drawF = drawF;
    }
}
