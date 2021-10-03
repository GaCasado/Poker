
package com.mycompany.poker.main;

/**

 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import com.mycompany.poker.model.Mano;

public class Main {

	private int ej;
	private int numCartas;
	private static OutputStream outFile = null;
	private static InputStream inFile = null;
        private ArrayList<Mano> manos;
	
	public Main(String[] args) {
		try {			
			parseArgs(args);
                        run();
		} catch (Exception e) {
			System.err.println("Something went wrong ...");
			System.err.println();
			e.printStackTrace();
		}
	}
	
	private void run() throws Exception {
		
                String mesa = "", jugador = "";
                int num;
		switch (ej) {
		case 1:
                        while(inFile.available() != 0){
                            for(int i = 0; i < 10; i++){
                                if(i < 5)
                                    jugador += (char) inFile.read();
                                else
                                    mesa += (char) inFile.read();
                            }
                            Mano mano = new Mano(jugador, mesa,3);
                            System.out.println(mano.getSolucion().toString());
                        }
                        
                        jugador = "";mesa = "";
			break;
		case 2:
                        while(inFile.available() != 0){
                            for(int i = 0; i < 4; i++){
                              jugador += (char) inFile.read();
                            }
                            inFile.skip(1); // Salta el punto y coma
                            num = (int) inFile.read(); // Lee el numero de cartas del river
                            inFile.skip(1); // Salta el punto y coma
                            for(int i = 0; i < num*2; i++){
                                mesa += (char) inFile.read();
                            }
                            Mano mano = new Mano(jugador, mesa,num);
                        }
                        jugador = "";mesa = "";
			break;
		case 3:
                    	while(inFile.available() != 0){
                            
                        }
                        jugador = "";mesa = "";
			break;
		case 4:
                        while(inFile.available() != 0){
                            
                        }
                        jugador = "";mesa = "";
			break;

		default:
			System.err.println("Something went wrong ...");
			throw new Exception();
		}
                
                
	}
	
	private void parseArgs(String[] args) throws FileNotFoundException {
		ej = Integer.parseInt(args[5]);
		outFile = new FileOutputStream(args[7]);
		inFile = new FileInputStream(args[6]);
	}
}
