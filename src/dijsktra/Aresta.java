package dijsktra;

/**
 *
 * @author gustavo
 */
public class Aresta {

    private int peso;
    private Vertice dest;

    public Aresta(Vertice dest, int peso) {
        if (peso < 0) {
            this.peso = peso * (-1);
        } else {
            this.peso = peso;
        }
        this.dest = dest;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if (peso < 0) {
            this.peso = peso * (-1);
        } else {
            this.peso = peso;
        }
    }

    public Vertice getDest() {
        return dest;
    }

    public void setDest(Vertice dest) {
        this.dest = dest;
    }
}
