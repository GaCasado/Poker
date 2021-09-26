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
	private char num;
	
	public Carta(char p, char n){
		this.palo = p;
		this.num = n;
	}
	
	public char getPalo() {
		return palo;
	}
	
	public char getNum() {
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
