/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poker.model;


public class ComparadorSoluciones {

    public ComparadorSoluciones() {
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
    public Solucion compara(Solucion sol1, Solucion sol2){
        if(sol1.getJugada() > sol2.getJugada())
            return sol1;
        else if(sol1.getJugada() == sol2.getJugada()){
            switch(sol1.getJugada()){
                case 1:
                {
                    if(compara1(sol1, sol2))
                        return sol1;
                    else
                        return sol2;                   
                }
                
                case 2:
                {
                    if(compara2(sol1, sol2))
                        return sol1;
                    else
                        return sol2;
                }

                case 3:
                {
                    if(compara3(sol1, sol2))
                        return sol1;
                    else
                        return sol2;
                }

                case 4:
                {
                    if(compara4(sol1, sol2))
                        return sol1;
                    else
                        return sol2;
                }

                case 5:
                {
                    if(compara5(sol1, sol2))
                        return sol1;
                    else
                        return sol2;
                }

                case 6:
                {
                    if(compara6(sol1, sol2))
                        return sol1;
                    else
                        return sol2;
                }

                case 7:
                {
                    if(compara7(sol1, sol2))
                        return sol1;
                    else
                        return sol2;
                }

                case 8:
                {
                    if(compara8(sol1, sol2))
                        return sol1;
                    else
                        return sol2;
                }

                case 9:
                {
                    if(compara9(sol1, sol2))
                        return sol1;
                    else
                        return sol2;
                }

                case 10:
                {
                    if(compara10(sol1, sol2))
                        return sol1;
                    else
                        return sol2;
                }

            }
            return sol1;
        }
        else
            return sol2;
    }
    
    private boolean compara1(Solucion sol1, Solucion sol2){
        return true;
    }
    private boolean compara2(Solucion sol1, Solucion sol2){
        return true;
    }
    private boolean compara3(Solucion sol1, Solucion sol2){
        return true;
    }
    private boolean compara4(Solucion sol1, Solucion sol2){
        return true;
    }
    private boolean compara5(Solucion sol1, Solucion sol2){
        return true;
    }
    private boolean compara6(Solucion sol1, Solucion sol2){
        return true;
    }
    private boolean compara7(Solucion sol1, Solucion sol2){
        return true;
    }
    private boolean compara8(Solucion sol1, Solucion sol2){
        return true;
    }
    private boolean compara9(Solucion sol1, Solucion sol2){
        return true;
    }
    private boolean compara10(Solucion sol1, Solucion sol2){
        return true;
    }
}
