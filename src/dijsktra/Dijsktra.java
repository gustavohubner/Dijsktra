/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijsktra;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author gusta
 */
public class Dijsktra {

    private Grafo g;
    private ArrayList<Vertice> vertices;
    private int estimativas[];
    private Vertice precedentes[];
    private boolean aberto[];
    private boolean erro;
    int origem;

    public Dijsktra() {
        g = new Grafo();
    }

    public Dijsktra(Grafo grafo, Vertice origem) {
        this.g = grafo;

        vertices = g.getVertices();

        estimativas = new int[vertices.size()];
        precedentes = new Vertice[vertices.size()];
        aberto = new boolean[vertices.size()];

        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == origem) {
                estimativas[i] = 0;
                precedentes[i] = origem;
                this.origem = i;
            } else {
                estimativas[i] = Integer.MAX_VALUE;
            }
            aberto[i] = true;
        }

        while (existeAberto()) {
            int escolhido = menorEstimativa();
            if (menorEstimativa() != -1) {
                Vertice v = vertices.get(escolhido);
                aberto[escolhido] = false;

                for (int i = 0; i < v.getArestas().size(); i++) {
                    Aresta a = v.getArestas().get(i);
                    int index = vertices.indexOf(a.getDest());
                    int novaestimativa = estimativas[escolhido] + a.getPeso();
                    if (novaestimativa < estimativas[index]) {
                        estimativas[index] = novaestimativa;
                        precedentes[index] = v;
                    }
                }
            } else {
                erro = true;
                break;
            }
        }

    }

    public String caminho(Vertice destino) {
        String str;
        if (!erro) {
            str = "Caminho de " + vertices.get(origem).getNome()
                    + " até " + destino.getNome() + ":\n";
            Stack<Vertice> pilha = new Stack();
            pilha.push(destino);
            int index = vertices.indexOf(destino);
            int pesoTotal = estimativas[index];
            do {
                pilha.push(precedentes[index]);
                index = vertices.indexOf(precedentes[index]);
            } while (index != origem);

            while (!pilha.empty()) {
                Vertice v = pilha.pop();
                str += v.getNome();
                if (!pilha.empty()) {
                    str += "  ->  ";
                }
            }
            str += "\t Peso: "+ pesoTotal;
        } else {
            str = "Caminho não Encontrado!";
        }
        return str;
    }

    @Override
    public String toString() {
        String ver = "Vertices:\t";
        String est = "Estimativas:\t";
        String pre = "Precedentes:\t";
        for (int i = 0; i < vertices.size(); i++) {
            ver += vertices.get(i).getNome() + "\t";
            if (estimativas[i] == Integer.MAX_VALUE) {
                est += "inf.\t";
            } else {
                est += estimativas[i] + "\t";
            }
            if (precedentes[i] != null) {
                pre += precedentes[i].getNome();
            } else {
                pre += "-";
            }
            pre += "\t";
        }
        return ver + "\n" + est + "\n" + pre;
    }

    private boolean existeAberto() {
        for (int i = 0; i < aberto.length; i++) {
            if (aberto[i]) {
                return true;
            }
        }
        return false;
    }

    private int menorEstimativa() {
        int minimo = Integer.MAX_VALUE;
        int v = -1;
        for (int i = 0; i < estimativas.length; i++) {
            if (aberto[i]) {
                if (estimativas[i] < minimo) {
                    minimo = estimativas[i];
                    v = i;
                }
            }
        }
        return v;
    }
}
