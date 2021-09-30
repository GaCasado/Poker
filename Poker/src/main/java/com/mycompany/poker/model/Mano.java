/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poker.model;

//import com.mycompany.poker.model.Carta;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
//import java.lang.String;
import java.util.List;

public class Mano {
    //private final List<String> jugadas;
    //private final int nC;
    private String solucion = null, drawS = null, drawF = null;
    private String manoOrd = "";
    public Mano(String jugador, String mesa, int nC){//nC de entrada es el número de cartas que hay en la mesa
        //this.nC = nC + 2;
        
        parseador(jugador , mesa , nC);
        
        //jugadas = new ArrayList<String>();
        

    }
    private void parseador(String jugador, String mesa, int nC){
        ArrayList<Carta> cartas = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            cartas.add(new Carta(jugador.charAt(i*2), jugador.charAt(i*2 + 1), true));
        }
        for(int i = 0; i < nC; i++){
            for(int j = 0; j < nC; j++){
                
            }
            buscaJugadas(cartas);
        }
        
        
        //Hacer que esta función llame a busca jugadas con todas las combinaciones
    }

    private void buscaJugadas(ArrayList<Carta> cartas){
        Map<Carta,Integer> repeticiones = new TreeMap<>();
        List<Carta> lista = new ArrayList<>();
        int colH = 0, colD = 0, colC = 0, colS = 0;
        int pareja1 = -1, pareja2 = -1, trio = -1, poker = -1;
        String escalera = null, escaleraReal = null, escaleraColor = null;
       
        for(int i = 0; i < 5; i++){
            Integer aux1 = repeticiones.putIfAbsent(cartas.get(i), 1);
            if(aux1 != null)
                repeticiones.put(cartas.get(i), aux1++);
           
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
        }
        
        for( Map.Entry<Carta, Integer>  r: repeticiones.entrySet()){
            Carta auxC = r.getKey();
            int auxR = r.getValue();
            
            lista.add(auxC);
            manoOrd += auxC.toString();
            
            if(auxR == 2){
                if(auxC.getNum() > pareja1){
                    pareja2 = pareja1;
                    pareja1 = auxC.getNum();
                }    
            }
            else if(auxR == 3){
                if(auxC.getNum() > trio)
                    trio = auxC.getNum();
            }
            else if(auxR == 4){
                if(auxC.getNum() > poker)
                    poker = auxC.getNum();
            }
        }
        
        if(lista.get(0).getNum() - lista.get(4).getNum() == 5){//hay escalera
                
                if(lista.get(4).getPalo() == lista.get(3).getPalo()// Escalera de color o Real
                        && lista.get(4).getPalo() == lista.get(2).getPalo()
                        && lista.get(4).getPalo() == lista.get(1).getPalo()
                        && lista.get(4).getPalo() == lista.get(0).getPalo()){
                    
                    if(lista.get(4).getNum() == 10 && lista.get(0).getNum() == 14){//Escalera Real
                        escaleraReal = "RoyalFlush " + manoOrd;
                    }
                    else{//Escalera de color
                        escaleraColor = "Straight Flush " + manoOrd;
                    }
                }
            else{//escalera normal
                    escalera = "Straight " + manoOrd;
            }
         }
        else if(lista.get(0).getNum() - lista.get(4).getNum() == 4){
                // si la primera y la ultima no tienen repes en el map es que hay hueco en medio
                // si una de esas tiene es proyecto del normal
                //hay proyecto
                if(repeticiones.get(lista.get(0)) == 1 && repeticiones.get(lista.get(0)) == 1){
                    drawS = "gutshot " + manoOrd;
                }
                else{
                    //open-ended
                    drawS = "open-ended " + manoOrd;
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
        if(escaleraReal != null){
            solucion = escaleraReal;
        }
        else if(escaleraColor != null){
            solucion = escaleraColor;
        }
        else if(poker != -1){//poker
            solucion = "Four of a kind of " + parseaNumero(poker) + " " + manoOrd;
            
        }
        else if(pareja1 != -1 && trio != -1){            
            //fullhouse 
            solucion = "Fullhouse with " + parseaNumero(trio) + " and " + parseaNumero(pareja1) + manoOrd;
        }
        else if(colH == 5){
            //Color de hearts
        }
        else if(colD == 5){
            //Color de diamonds
        }
        else if(colC == 5){
            //Color de tréboles
        }
        else if(colS == 5){
            //Color de picas
        }
        else if(escalera != null){
            //escalera
            solucion = escalera;
        }
        else if(trio != -1){
            //Trio
        }
        else if(pareja1 != -1 && pareja2 != -1){
            //Dobles parejas
        }
        else if(pareja1 != -1){
            //Pareja
        }
        else{
            //Carta alta
        }
        //Poner proyectos de color aquí
        
    }
    
    private String parseaNumero(int entrada){
        String salida;Integer aux = entrada;
        switch(entrada){
            case 14:
                salida = "A";
            break;
            case 13:
                salida = "K";
            break;
            case 12:
                salida = "Q";
            break;
            case 11:
                salida = "J";
            break;
            case 10:
                salida = "T";
            break;
            default:
                salida = aux.toString();
            break;
        }
        return salida;
    }
    
    public String jugadaToString(){
        return solucion;
    }
    
    public List getProyectos(){
        return new ArrayList<String>();
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
