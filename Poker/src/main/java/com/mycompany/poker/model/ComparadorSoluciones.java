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
                    return sol1;
                }
                
                case 2:
                {
                    //Mirar que escalera es más alta
                    return sol1;
                }

                case 3:
                {
                    return sol1;
                }

                case 4:
                {
                    return sol1;
                }

                case 5:
                {
                    return sol1;
                }

                case 6:
                {
                    return sol1;
                }

                case 7:
                {
                    return sol1;
                }

                case 8:
                {
                    return sol1;
                }

                case 9:
                {
                    return sol1;
                }

                case 10:
                {
                    return sol1;
                }

            }
            return sol1;
        }
        else
            return sol2;
    }
}
