package dijsktra;

import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Vertice {

    private String nome;
    private ArrayList<Aresta> arestas;

    public Vertice(String nome, ArrayList<Aresta> arestas) {
        this.nome = nome;
        this.arestas = arestas;
    }

    public Vertice(String nome) {
        this.nome = nome;
        this.arestas = new ArrayList<>();
    }

    public void addAresta(Vertice dest, int peso) {
        arestas.add(new Aresta(dest, peso));
        dest.arestas.add(new Aresta(this, peso));
    }

    public void addArestaDir(Vertice dest, int peso) {
        arestas.add(new Aresta(dest, peso));
    }

    public boolean removeAresta(Aresta a) {
        return arestas.remove(a);
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public String getNome() {
        return nome;
    }

}
