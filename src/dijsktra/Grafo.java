package dijsktra;

import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Grafo {

    private ArrayList<Vertice> vertices;

    public Grafo(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public void addVertice(Vertice v) {
        vertices.add(v);
    }

    public boolean removeVertice(Vertice v) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertice atual = vertices.get(i);
            for (int j = 0; j < atual.getArestas().size(); j++) {
                if (atual.getArestas().get(j).getDest() == v) {
                    atual.removeAresta(atual.getArestas().get(j));
                }
            }
        }
        return vertices.remove(v);
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public Vertice getVerticeNome(String nome) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getNome().equals(nome)) {
                return vertices.get(i);
            }
        }
        return null;
    }

    public void grafoPadrao() {
        /**
         * Vertice s = new Vertice("s"); Vertice u = new Vertice("u"); Vertice v
         * = new Vertice("v"); Vertice x = new Vertice("x"); Vertice y = new
         * Vertice("y");
         *
         * s.addArestaDir(u, 10); s.addArestaDir(x, 5);
         *
         * u.addArestaDir(v, 1); u.addArestaDir(x, 2);
         *
         * v.addArestaDir(y, 6);
         *
         * x.addArestaDir(u, 3); x.addArestaDir(y, 2); x.addArestaDir(v, 9);
         *
         * y.addArestaDir(s, 7); y.addArestaDir(v, 4);
         *
         * addVertice(s); addVertice(u); addVertice(v); addVertice(x);
         * addVertice(y);*
         */

        Vertice a = new Vertice("A");
        Vertice b = new Vertice("B");
        Vertice c = new Vertice("C");
        Vertice d = new Vertice("D");
        Vertice e = new Vertice("E");
        Vertice f = new Vertice("F");

        a.addAresta(b, 2);
        a.addAresta(d, 1);
        a.addAresta(c, 5);
        b.addAresta(d, 2);
        b.addAresta(c, 3);
        c.addAresta(d, 3);
        c.addAresta(e, 1);
        c.addAresta(f, 5);
        d.addAresta(e, 1);
        e.addAresta(f, 2);

        addVertice(a);
        addVertice(b);
        addVertice(c);
        addVertice(d);
        addVertice(e);
        addVertice(f);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < vertices.size(); i++) {
            Vertice atual = vertices.get(i);
            s += atual.getNome() + " {\n";
            ArrayList<Aresta> arestas = atual.getArestas();
            for (int j = 0; j < arestas.size(); j++) {
                s += "\t(" + j + "): " + atual.getNome() + " -> "
                        + arestas.get(j).getDest().getNome()
                        + " Peso: " + arestas.get(j).getPeso() + "\n";
            }
            s += "}\n";
        }
        return s;
    }

    public String toStringVertices() {
        String ver = "Vertices:\t";
        for (int i = 0; i < vertices.size(); i++) {
            ver += vertices.get(i).getNome() + "  ";
        }
        return ver;
    }

}
