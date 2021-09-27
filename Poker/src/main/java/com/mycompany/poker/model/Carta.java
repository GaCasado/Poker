/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poker.model;

/**
 *
 * @author seiya
 */
public class Carta {
	private char palo;
	private int num;
	
	public Carta(char p, char n){
		this.palo = p;
		this.num = parseaCarta(n);
	}
        private int parseaCarta(char c){
            int ca = 0;
            if(c != 'A' && c != 'T' && c != 'J' && c != 'Q' && c != 'K' ){
                ca = Character.getNumericValue(c);
            }
            else{
                switch(c){
                    case 'A':
                        ca = 1;
                    break;
                    case 'T':
                        ca = 10;
                    break;
                    case 'J':
                        ca = 11;
                    break;
                    case 'Q':
                        ca = 12;
                    break;
                    case 'K':
                        ca = 13;
                    break;
                }
            }
            return ca;
        }
	
	public char getPalo() {
		return palo;
	}
	
	public int getNum() {
		return num;
	}
        
        public int compareTo(Carta otra) {
         if (this.num < otra.getNum())
            return -1;
         else if(this.num > otra.getNum())
             return 1;
         else{
            if(this.palo < otra.getPalo())
                return 1;
            else
                return -1;
        }
    }
}
