
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
//import java.util.Map;
import java.util.TreeMap;


public class Main {

	private static int ej;
	private int numCartas;
        private static String _outFile = null;
        private static String _inFile = null;
	private static OutputStream outFile = null;
	private static InputStream inFile = null;
        private static boolean gui;
	
        private static void parseArgs(String[] args) throws FileNotFoundException {
		ej = Integer.parseInt(args[0]);
                _inFile = args[1];
                _outFile = args[2];		
	}
        
        private static void run() throws Exception {
		TreeMap<Solucion, Integer> soluciones = new TreeMap<>();
                inFile = new FileInputStream(new File(_inFile));
                outFile = new FileOutputStream(new File(_outFile));
                PrintStream p = new PrintStream(outFile);
		BufferedReader reader;
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
                            Mano mano = new Mano(jugador, mesa,3, false);
                            
                            System.out.println( "Best Hand: " + mano.getSolucion().toString());
                            System.out.println( mano.getSolucion().getDraws());
                            p.println( "Best Hand: " + mano.getSolucion().toString());
                            p.println( mano.getSolucion().getDraws());
                        }
                        
                        jugador = "";mesa = "";
			break;
		case 2:
                        reader = new BufferedReader(new InputStreamReader(inFile));
                        while(reader.ready()){
                            String linea = reader.readLine();
                            jugador = linea.substring(0, 4);
                            char ch = linea.charAt(5);
                            num = Character.getNumericValue(ch); // Lee el numero de cartas del river                           
                            mesa = linea.substring(7, ((num*2) + 7));
                            Mano mano = new Mano(jugador, mesa,num, false);                                                      
                        System.out.println(linea);
                        System.out.println( " - Best Hand: " + mano.getSolucion().toString());
                        System.out.println( mano.getSolucion().getDraws());
                        p.println( "Best Hand: " + mano.getSolucion().toString());
                        p.println( mano.getSolucion().getDraws());
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
                                
                                Mano mano = new Mano(cartasJugador.get(i), mesa, num, true);
                                Solucion aux = mano.getSolucion();
                                Integer numJ = i;
                                soluciones.put(aux, numJ + 1);
                            }      
                            //comparar y ordenar a los jugadores para escribirlos despues
                            soluciones.entrySet().forEach(r -> {
                                Solucion aux = r.getKey();
                                Integer numJ = r.getValue();
                                System.out.println(" J" + numJ + " "+ aux.toString());
                                p.println( " J" + numJ + " "+ aux.toString());
                            });
                            
                        jugador = "";mesa = "";cartasJugador.clear();                            
                        }
                        
			break;
		case 4:
                        reader = new BufferedReader(new InputStreamReader(inFile));String cJ = "";Mano mano;  Solucion aux = null;
                        ComparadorSoluciones cmp = new ComparadorSoluciones();
                        while(reader.ready()){
                            String linea = reader.readLine();
                            jugador = linea.substring(0, 8);
                            char ch = linea.charAt(9);
                            num = Character.getNumericValue(ch); // Lee el numero de cartas del river                           
                            mesa = linea.substring(11, ((num*2) + 11));
                            
                            
                            cJ += jugador.charAt(0);cJ += jugador.charAt(1);
                            cJ += jugador.charAt(2);cJ += jugador.charAt(3);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = mano.getSolucion();                         
                            cJ = "";
                            
                            cJ += jugador.charAt(2);cJ += jugador.charAt(3);
                            cJ += jugador.charAt(4);cJ += jugador.charAt(5);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                          
                            cJ = "";
                            
                            cJ += jugador.charAt(4);cJ += jugador.charAt(5);
                            cJ += jugador.charAt(6);cJ += jugador.charAt(7);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                          
                            cJ = "";
                            
                            cJ += jugador.charAt(0);cJ += jugador.charAt(1);
                            cJ += jugador.charAt(4);cJ += jugador.charAt(5);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                          
                            cJ = "";
                            
                            cJ += jugador.charAt(0);cJ += jugador.charAt(1);
                            cJ += jugador.charAt(6);cJ += jugador.charAt(7);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                          
                            cJ = "";
                            
                            cJ += jugador.charAt(2);cJ += jugador.charAt(3);
                            cJ += jugador.charAt(6);cJ += jugador.charAt(7);
                            mano = new Mano(cJ, mesa,num, true);
                            aux = cmp.compara(mano.getSolucion(),aux);                       
                            cJ = "";
                                                                                 
                        System.out.println(linea);
                        System.out.println( " - Best Hand: " + aux.toString());
                        System.out.println( aux.getDraws());
                        p.println( "Best Hand: " + aux.toString());
                        p.println( aux.getDraws());
                        jugador = "";mesa = "";
                        }
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
