
package com.mycompany.poker.main;

/**

 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

	private int ej;
	private int numCartas;
	private static OutputStream outFile = null;
	private static InputStream inFile = null;
	
	public Main(String[] args) {
		try {			
			start(args);
		} catch (Exception e) {
			System.err.println("Something went wrong ...");
			System.err.println();
			e.printStackTrace();
		}
	}
	
	private void start(String[] args) throws Exception {
		parseArgs(args);
		switch (ej) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
	
			break;
		case 4:
	
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
