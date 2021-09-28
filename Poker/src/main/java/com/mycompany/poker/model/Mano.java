/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poker.model;

//import com.mycompany.poker.model.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
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
        Map<Integer,Integer> repeticiones = new HashMap<Integer,Integer>();
        //prueba
        if(cartas.get(nC - 1).getNum() - cartas.get(0).getNum() == 5){
            //hay escalera o si solo hay una pareja hay proyecto
        }
        else if(cartas.get(nC - 1).getNum() - cartas.get(0).getNum() == 4 ){
            
        }
        for(int i = 0; i < nC - 1; i++){
            if(cartas.get(i+1).getNum() - cartas.get(i).getNum() == 0){               
                if(repeticiones.putIfAbsent(cartas.get(i).getNum(), 1) != null)
                    repeticiones.put(cartas.get(i).getNum(), repeticiones.get(cartas.get(i).getNum()));   
            }
            else if(cartas.get(i+1).getNum() - cartas.get(i).getNum() == 1){
                if(cartas.get(i).getPalo() == cartas.get(i+1).getPalo()){
                    //escalera real
                }
                //contar escalera
            }
            else{
                //ver si se queda de proyecto de escalera por la mitad
            }
            if(cartas.get(i+1).getPalo() == cartas.get(i).getPalo()){
                //sumar al contador de color de ese palo
            }
        }
        
        //tratar las repeticiones y gurdar las jugadas
    }
    public String jugadaToString(){
        return "hola";
    }
}
