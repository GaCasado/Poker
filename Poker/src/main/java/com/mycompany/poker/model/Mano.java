/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poker.model;

//import com.mycompany.poker.model.Carta;
import java.util.ArrayList;
import java.util.Collections;
//import java.lang.String;
import java.util.List;
import java.util.Comparator;

public class Mano {
    private List<Carta> cartas;
    private List<String> jugadas;
    private int nC;
    public Mano(String s, int nC){//nC de entrada es el número de cartas que hay en la mesa
        this.nC = nC + 2;
        cartas = new ArrayList<Carta>();
        parseador(s,this.nC);
        
        jugadas = new ArrayList<String>();
        buscaJugadas();

    }
    private void parseador(String entrada, int nC){
        for(int i = 0; i < nC; i++){
            char aux1 = entrada.charAt(i*2)
                    , aux2 = entrada.charAt(i*2 + 1);
            cartas.add(new Carta(aux1, aux2));
        }
        Collections.sort(cartas, (Carta c1, Carta c2) -> c1.compareTo(c2));
    }

    private void buscaJugadas(){
        //prueba
    }
    public String jugadaToString(){
        return "hola";
    }
}
