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
    private Solucion solucion = null;
    
    private String manoOrd = "";
    public Mano(String jugador, String mesa, int nC){//nC de entrada es el número de cartas que hay en la mesa
        //this.nC = nC + 2;
        
        solucion(jugador , mesa , nC);
        
        //jugadas = new ArrayList<String>();
        

    }
    private void solucion(String jugador, String mesa, int nC){
        //Hacer que esta función llame a busca jugadas con todas las combinaciones
        //No se si lo he hecho bien
        ArrayList<Carta> cartasJ = new ArrayList<>(); Solucion solActual = null;
        ComparadorSoluciones comp = new ComparadorSoluciones();
        for(int i = 0; i < 2; i++){
            cartasJ.add(new Carta(jugador.charAt(i*2), jugador.charAt(i*2 + 1), true));
        }
        
        for(int i = 0; i < nC - 2; i++){
            ArrayList<Carta> cartas = new ArrayList<>();
            cartas = cartasJ;
            for(int j = 0; j < nC; j++){// esto esta mal hay que cambiarlo
                if(i != j){
                    cartas.add(new Carta(mesa.charAt(j*2), mesa.charAt(j*2 + 1), false));
                } 
            }
            solActual = buscaJugadas(cartas);
            solucion = comp.compara(solActual, solucion);
        }
    }
    private Solucion ayuda(String mesa, ArrayList<Carta> cartasJ, int k, int nC, boolean co[], ArrayList<Carta> cartas){
        ComparadorSoluciones comp = new ComparadorSoluciones();
        for(int i = 0; i < nC - 2; i++){
            if(!co[i]){
                co[i] = true;
                cartas.add(new Carta(mesa.charAt(k*2), mesa.charAt(k*2 + 1), false));
                if(k == 3){
                    cartas.addAll(cartasJ);
                    Solucion solActual = buscaJugadas(cartas);
                    solucion = comp.compara(solActual, solucion);
                }
                else{
                    ayuda(mesa, cartasJ, k + 1, nC, co, cartas);
                }
            }
        }
        return solucion;//esto tendria que estar en parametros porreferencia y no va a funcionar
    }

    private Solucion buscaJugadas(ArrayList<Carta> cartas){
        Solucion solActual = null;
        Map<Integer,ArrayList<Carta>> repeticiones = new TreeMap<>();//estoy cambiando el mapa
        List<Carta> lista = new ArrayList<>();
        int colH = 0, colD = 0, colC = 0, colS = 0;
        int pareja1 = -1, pareja2 = -1, trio = -1, poker = -1;
        String escalera = null, escaleraReal = null, escaleraColor = null, drawSg = null,drawSo = null, drawF = null;
        
       //ArrayList<Carta> aux1 = new ArrayList<>();
       
        for(int i = 0; i < 5; i++){
            ArrayList<Carta> aux1 = new ArrayList<>();
            aux1.add(cartas.get(i));
            aux1 = repeticiones.putIfAbsent(cartas.get(i).getNum(), aux1);
            if(aux1 != null){
                aux1.add(cartas.get(i));
                repeticiones.put(cartas.get(i).getNum(), aux1);
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
        }
        
        for( Map.Entry<Integer, ArrayList<Carta>>  r: repeticiones.entrySet()){
            Integer ke = r.getKey();//hacer que la clave sea el número y el valor una lista de cartas
            ArrayList<Carta> va = r.getValue();
            
            for(int i = 0; i < va.size();i++){
                lista.add(va.get(i));
                manoOrd += va.get(i).toString();
            }
                                               
            if(va.size() == 2){
                if(ke > pareja1){
                    pareja2 = pareja1;
                    pareja1 = ke;
                }    
            }
            else if(va.size() == 3){
                if(ke > trio)
                    trio = ke;
            }
            else if(va.size() == 4){
                if(ke > poker)
                    poker = ke;
            }
        }
        
        
        if(lista.size() == 5){
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
            
            else if(lista.get(0).getNum() - lista.get(4).getNum() == 6){
                drawSg = "gutshot " + manoOrd;
            } 
            else if(lista.get(0).getNum() - lista.get(3).getNum() == 4 || lista.get(1).getNum() - lista.get(4).getNum() == 4){//esto lo tengo que terminar               
                drawSo = "open-ended " + manoOrd;               
            }
        }
        else if (lista.size() == 4){
            // si la primera y la ultima no tienen repes en el map es que hay hueco en medio
            // si una de esas tiene es proyecto del normal
            //hay proyecto
            if(repeticiones.get(lista.get(0).getNum()).size() == 1 && repeticiones.get(lista.get(3).getNum()).size() == 1){
                    drawSg = "gutshot " + manoOrd;
            }
            else{
                //open-ended
                drawSo = "open-ended " + manoOrd;
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
            solActual = new Solucion(1,escaleraReal);
        }
        else if(escaleraColor != null){
            solActual = new Solucion(2,escaleraColor);
        }
        else if(poker != -1){//poker
            solActual = new Solucion(3, poker, manoOrd);
            
        }
        else if(pareja1 != -1 && trio != -1){        
            //fullhouse 
            solActual = new Solucion(4, pareja1, trio,manoOrd);
        }
        else if(colH == 5){
            //Color de hearts
            solActual = new Solucion(5, 1, manoOrd);
        }
        else if(colD == 5){
            //Color de diamonds
            solActual = new Solucion(5, 2, manoOrd);
        }
        else if(colC == 5){
            //Color de tréboles
            solActual = new Solucion(5, 3, manoOrd);
        }
        else if(colS == 5){
            //Color de picas
            solActual = new Solucion(5, 4, manoOrd);
        }
        else if(escalera != null){
            //escalera
            solActual = new Solucion(6, escalera);
        }
        else if(trio != -1){
            //Trio
            solActual = new Solucion(7, trio, manoOrd);
        }
        else if(pareja1 != -1 && pareja2 != -1){
            //Dobles parejas
            solActual = new Solucion(8, pareja1, pareja2,manoOrd);
        }
        else if(pareja1 != -1){
            //Pareja
            solActual = new Solucion(9, pareja1, manoOrd);
        }
        else{
            //Carta alta
            solActual = new Solucion(10, lista.get(4).getNum(), manoOrd);
        }
        //Proyectos
        if(drawSg != null)
            solActual.setDrawSg(drawSg);
        else if(drawSo != null)
            solActual.setDrawSo(drawSo);
        if(colH == 4 || colD  == 4 || colC == 4 || colS == 4)//si hay que decir que color es se cambia
            solActual.setDrawF(manoOrd);
        return solActual;
    }
    
    public Solucion getSolucion(){
        return solucion;
    }
    /*
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
    }*/
    /*
    public String getJugada(){
        return solucion;
    }*/
    /*
    public List getProyectos(){
        ArrayList<String> proye = new ArrayList<>();
        if(drawS != null)
            proye.add(drawS);
        else if(drawF != null)
            proye.add(drawF);
        else
            return null;
        return proye;
    }*/
    
}