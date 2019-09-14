package dijsktra;

import java.util.Scanner;

/**
 *
 * @author gustavo
 */
public class Main {

    private static Grafo g;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        leituraVertices();
        int sair;
        do {
            System.out.println(g.toStringVertices());
            System.out.print("Origem: ");
            String nome = scanner.next();
            while (g.getVerticeNome(nome) == null) {
                System.err.println("(Vertice nao encotrado)");
                System.out.print("Origem: ");
                nome = scanner.next();
            }
            Vertice origem = g.getVerticeNome(nome);
            System.out.print("Destino: ");
            nome = scanner.next();
            while (g.getVerticeNome(nome) == null) {
                System.err.println("(Vertice nao encotrado)");
                System.out.print("Destino: ");
                nome = scanner.next();
            }
            Vertice dest = g.getVerticeNome(nome);
            Dijsktra d = new Dijsktra(g, origem);
            System.out.println(d.toString() + "\n");

            System.out.println(d.caminho(dest)+"\n");

            System.out.print("Digite 1 para sair ou outro numero para testar outro caminho:");
            sair = scanner.nextInt();
        } while (sair != 1);
        //System.out.println(g.toString());
    }

    private static void leituraVertices() {
        g = new Grafo();
        System.out.println("Digite o numero de Vertices(-1 para grafo padrão):");
        int num = scanner.nextInt();

        if (num < 0) {
            g.grafoPadrao();
            System.err.println("Grafo Padrão Escolhido!");
        } else {
            System.out.print("Digite 1 para Grafo não direcional (A<--->B) ou 2 para Grafo Direcional (A--->B): ");
            int dir = scanner.nextInt();

            for (int i = 0; i < num; i++) {
                System.out.println("Vertice " + (i + 1) + " de " + num + ":");
                System.out.print("Nome: ");
                String nome = scanner.next();
                g.addVertice(new Vertice(nome));
            }
            for (int i = 0; i < num; i++) {
                System.out.print("Numero de Arestas do Vertice " + (i + 1) + ":");
                int nAresta = scanner.nextInt();

                for (int j = 0; j < nAresta; j++) {
                    System.out.println("Aresta " + (j + 1) + ":");
                    System.out.print("Destino: ");
                    String nome = scanner.next();
                    while (g.getVerticeNome(nome) == null) {
                        System.err.println("(Vertice nao encotrado)");
                        System.out.print("Destino: ");
                        nome = scanner.next();
                    }
                    System.out.print("Peso: ");
                    int peso = scanner.nextInt();
                    if (dir == 2) {
                        g.getVertices().get(i).addArestaDir(g.getVerticeNome(nome), peso);
                    } else {
                        g.getVertices().get(i).addAresta(g.getVerticeNome(nome), peso);
                    }

                }
            }

            System.out.println("Leitura Concluida!\n");
        }
    }
}
