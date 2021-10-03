/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poker.model;


public class Solucion {
    private int jugada;
    private int tipo; // pareja 1 de full house o doble pareja
    private int tipo2; // segunda pareja para la doble pareja o trio para el full house
    private String mano; // las 5 cartas que has cogido
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

    public int getTipo2() {
        return tipo2;
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
    public String getDraws(){
        String texto = "";
        if(drawSg == null){
            texto += "Draw: Gutshot";
        }
        if(drawSo == null){
            texto += "Draw: Open Ended";
        }
        if(drawF == null){
            texto += "Draw: Flush";
        }
        return texto;
    }
    public String toString(){
        switch(jugada){
                case 1:
                {
                    return "";
                }
                
                case 2:
                {
                    
                    return "";
                }

                case 3:
                {
                    return "";
                }

                case 4:
                {
                    return "";
                }

                case 5:
                {
                    return "";
                }

                case 6:
                {
                    return "";
                }

                case 7:
                {
                    return "";
                }

                case 8:
                {
                    return "";
                }

                case 9:
                {
                    
                    return "Pair of " + parseaTipo() + " " + mano;
                }

                case 10:
                {
                    return "";
                }

            }
        return "Error";
    }
    
    private String parseaTipo(){
        Integer n;Character aux = 'o';String aux1;
        switch(tipo){
                    case 14:{
                        aux = 'A';
                        aux1 = aux.toString();
                    }
                        
                    break;
                    case 10:{
                        aux = 'T';
                        aux1 = aux.toString();
                    }
                    break;
                    case 11:{
                        aux = 'J';
                        aux1 = aux.toString();
                    }
                    break;
                    case 12:{
                        aux = 'Q';
                        aux1 = aux.toString();
                    }
                    break;
                    case 13:{
                        aux = 'K';
                        aux1 = aux.toString();
                    }
                    break;
                    default:{
                        n = tipo;
                        aux1 = n.toString();
                    }
                        
                }

        return aux1.toString();
    }
    
}
