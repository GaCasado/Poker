
package com.mycompany.poker.main;

/**

 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.util.ArrayList;
import com.mycompany.poker.model.Mano;
import com.mycompany.poker.model.ComparadorSoluciones;
import com.mycompany.poker.model.Solucion;
import java.util.Map;
import java.util.TreeMap;


public class Main {

	private static int ej;
	private int numCartas;
	private static OutputStream outFile = null;
	private static InputStream inFile = null;

	
        private static void parseArgs(String[] args) throws FileNotFoundException {
		ej = Integer.parseInt(args[0]);
                String aux = args[1];
                inFile = new FileInputStream(new File("D:\\GitHub\\Poker\\Poker\\resources\\entrada.txt"));
		outFile = new FileOutputStream(new File(args[2])); 
		
	}
        
        private static void run() throws Exception {
		TreeMap<Solucion, Integer> soluciones = new TreeMap<>();
                String mesa = "", jugador = "";
                int num, numJugadores;
		switch (ej) {
		case 1:
                        while(inFile.available() > 0){
                            for(int i = 0; i < 10; i++){
                                if(i < 4)
                                    jugador += (char) inFile.read();
                                else
                                    mesa += (char) inFile.read();
                            }
                            Mano mano = new Mano(jugador, mesa,3);
                            
                            System.out.println( "Best Hand: " + mano.getSolucion().toString());
                            System.out.println( mano.getSolucion().getDraws());
                        }
                        
                        jugador = "";mesa = "";
			break;
		case 2:
                        while(inFile.available() > 0){
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
                            
                            
                        System.out.println(jugador + ';' + num + ';' + mesa);
                        System.out.println( " - Best Hand: " + mano.getSolucion().toString());
                        System.out.println( mano.getSolucion().getDraws());
                        jugador = "";mesa = "";
                        }
                       
			break;
		case 3:
                        ArrayList<String> cartasJugador = new ArrayList<>();
                        String manJug;
                        num = 5;
                        ComparadorSoluciones comp = new ComparadorSoluciones();
                    	while(inFile.available() != 0){
                            char ch = (char) inFile.read();
                            numJugadores = Character.getNumericValue(ch); //lee numero de jugadores
                            
                            inFile.skip(1); // Salta el punto y coma
                            for(int i =0; i< numJugadores;i++){//lee todas las manos de los jugadores
                                manJug = "";
                                inFile.skip(2); // Salta el nombre del jugador
                                manJug += (char) inFile.read();
                                manJug += (char) inFile.read();
                                manJug += (char) inFile.read();
                                manJug += (char) inFile.read();
                                cartasJugador.add(manJug);
                                inFile.skip(1); // Salta el punto y coma
                            }
                            for(int i = 0; i < 10; i++){//Leo la mesa
                                 mesa += (char) inFile.read();
                            }
                            
                            for(int i = 0; i< numJugadores; i++){
                                
                                Mano mano = new Mano(cartasJugador.get(i), mesa, num);
                                Solucion aux = mano.getSolucion();
                                Integer numJ = i;
                                soluciones.put(aux, numJ + 1);
                            }      
                            //comparar y ordenar a los jugadores para escribirlos despues
                            soluciones.entrySet().forEach(r -> {
                                Solucion aux = r.getKey();
                                Integer numJ = r.getValue();
                                System.out.println(" J" + numJ + " "+ aux.toString());
                            });
                            
                        jugador = "";mesa = "";cartasJugador.clear();                            
                        }
                        
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
        
	public static void main(String args[]) {
		try {			
			parseArgs(args);
                        run();
		} catch (Exception e) {
			System.err.println("Something went wrong ...");
			System.err.println();
			e.printStackTrace();
		}
	}
	
	
	
	
}
