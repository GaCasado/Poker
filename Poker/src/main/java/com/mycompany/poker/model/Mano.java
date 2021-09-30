/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poker.model;

//import com.mycompany.poker.model.Carta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
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
        //Collections.sort(cartas, (Carta c1, Carta c2) -> c1.compareTo(c2));
    }

    private void buscaJugadas(){//PENSADO PARA 5 CARTAS CAMBIAR PARA 7
        Map<Carta,Integer> repeticiones = new TreeMap<>();
        List<Carta> lista = new ArrayList<>();
        int colH = 0, colD = 0, colC = 0, colS = 0;//, escalera = 0,
               // escaleraC = 0, escaleraH = 0, escaleraD = 0, escaleraS = 0;
        boolean hueco = false;//, color = false;
        //char po = 'z';
        int pareja1 = -1, pareja2 = -1, trio = -1, poker = -1;
        //String fullhouse = "-1";
       
        for(int i = 0; i < nC - 1; i++){
            
            if(cartas.get(i+1).getNum() - cartas.get(i).getNum() == 0){ 
                Integer aux1 = repeticiones.putIfAbsent(cartas.get(i), 2);
                if(aux1 != null)
                    repeticiones.put(cartas.get(i), aux1++);   
            }
           
            if(cartas.get(i+1).getPalo() == cartas.get(i).getPalo()){
                switch(cartas.get(i).getPalo()) {
                    case 'h':
                        colH++;
                    break;
                    case 'd':
                        colD++;
                    break;
                    case 'c':
                        colC++;
                    break;
                    case 's':
                        colS++;
                    break;
                }
            }
            
            //GUARDAR LAS ESCALERAS QUE VAYAS TENIENDO y sus proyectos
        }
        
        for( Map.Entry<Carta, Integer>  r: repeticiones.entrySet()){
            Carta auxC = r.getKey();
            int auxR = r.getValue();
            
            lista.add(auxC);
            
            if(auxR == 2){
                if(auxC.getNum() > pareja1){
                    pareja2 = pareja1;
                    pareja1 = auxC.getNum();
                }
                    
                    
            }
            if(auxR == 3){
                if(auxC.getNum() > trio)
                    trio = auxC.getNum();
            }
            if(auxR == 4){
                if(auxC.getNum() > poker)
                    poker = auxC.getNum();
            }
        }
        /*
        1. Escalera real de color (cartas 10, J, Q, K y A del mismo palo)
        2. Escalera de color
        3. Poker
        4. Full house
        5. Color
        6. Escalera
        7. Trio
        8. Dobles parejas
        9. Parejas
        10. Carta alta
        */
        for(int i = 4; i < lista.size() ; i++){
            if(lista.get(i).getNum() - lista.get(i - 4).getNum() == 5){
                //hay escalera
            }
            else if(lista.get(i).getNum() - lista.get(i - 4).getNum() == 4){
                // si la primera y la ultima no tienen repes en el map es que hay hueco en medio
                // si una de esas tiene es proyecto del normal
                //hay proyecto
            }
        }
        if(poker != -1){
            //poker
        }
        else if(pareja1 != -1 && trio != -1){            
            //fullhouse           
        }
        else if(colH == 5){
            //Color de hearts
        }
        for(Carta c : lista){
            
        }
        
        
        
        //tratar las repeticiones si no hay escalera de color y gurdar la mejor jugada y los proectos de colr
    }
    
    public String jugadaToString(){
        return "hola";
    }
}
/*

 
            else if(cartas.get(i+1).getNum() - cartas.get(i).getNum() == 1){
                if(i > 4){
                    
                }
                else{
                    if(cartas.get(i).getPalo() == cartas.get(i+1).getPalo()){
                    if(po == 'z'){
                        po = cartas.get(i).getPalo();
                    }
                    else{
                        if(po != cartas.get(i).getPalo())
                            ;
                    }
                
                }
                escalera++;
                //contar escalera
                }   
                
            }
            
            else{
                if(cartas.get(i+1).getNum() - cartas.get(i).getNum() == 2 && !hueco){
                    hueco = true;
                    if(cartas.get(i).getPalo() == cartas.get(i+1).getPalo()){
                        //escalera real
                        //escaleraReal++;
                    }
                    escalera++;
                }
                else {
                    escalera = 0;
                    //escaleraReal = 0;
                    hueco = false;
                }
                //ver si se queda de proyecto de escalera por la mitad
            }
            
*/
