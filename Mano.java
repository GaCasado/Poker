
import Carta.java;
import java.util.ArrayList;
import java.util.String;

public class Mano {
    private List<Carta> cartas;
    private List<String> jugadas;
    private int nC;
    public Mano(String s, int nC){//nC de entrada es el número de cartas que hay en la mesa
        this.nC = nC + 2;
        cartas = new ArrayList<Carta>();
        parseador(s);
        
        jugadas = new ArrayList<String>();
        buscaJugadas();

    }
    private ArrayList parseador(String entrada, int nC){
        for(int i = 0; i < nC; i++){
            cartas.add(new Carta(entrada[i*2], entrada[i*2 + 1]));
        }
    }

    public void buscaJugadas(){

    }
    public String jugadaToString(){

    }
}