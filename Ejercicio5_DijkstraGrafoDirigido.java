import java.util.*;

public class Ejercicio5_DijkstraGrafoDirigido {

    static class Arista {
        int destino, peso;

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    static class NodoDistancia implements Comparable<NodoDistancia> {
        int nodo, distancia;

        public NodoDistancia(int nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(NodoDistancia o) {
            return Integer.compare(this.distancia, o.distancia);
        }
    }

    static class GrafoDirigidoPonderado {
        private Map<Integer, List<Arista>> adj = new HashMap<>();

        public void agregarArista(int origen, int destino, int peso) {
            adj.computeIfAbsent(origen, k -> new ArrayList<>()).add(new Arista(destino, peso));
        }

        public void dijkstra(int origen, int destino) {
            PriorityQueue<NodoDistancia> pq = new PriorityQueue<>();
            Map<Integer, Integer> distancias = new HashMap<>();
            Map<Integer, Integer> predecesores = new HashMap<>();

            distancias.put(origen, 0);
            pq.add(new NodoDistancia(origen, 0));

            while (!pq.isEmpty()) {
                NodoDistancia actual = pq.poll();
                int u = actual.nodo;

                if (actual.distancia > distancias.getOrDefault(u, Integer.MAX_VALUE)) continue;
                if (u == destino) break;

                for (Arista arista : adj.getOrDefault(u, new ArrayList<>())) {
                    int v = arista.destino;
                    int nuevoPeso = distancias.get(u) + arista.peso;

                    if (nuevoPeso < distancias.getOrDefault(v, Integer.MAX_VALUE)) {
                        distancias.put(v, nuevoPeso);
                        predecesores.put(v, u);
                        pq.add(new NodoDistancia(v, nuevoPeso));
                    }
                }
            }

            if (!distancias.containsKey(destino)) {
                System.out.println("No existe camino de " + origen + " a " + destino);
                return;
            }

            // Reconstruir el camino
            List<Integer> camino = new ArrayList<>();
            Integer curr = destino;
            while (curr != null) {
                camino.add(curr);
                curr = predecesores.get(curr);
            }
            Collections.reverse(camino);

            System.out.println("Distancia mínima de " + origen + " a " + destino + ": " + distancias.get(destino));
            System.out.println("Camino: " + camino);
        }
    }

    public static void main(String[] args) {
        GrafoDirigidoPonderado grafo = new GrafoDirigidoPonderado();
        grafo.agregarArista(0, 1, 4);
        grafo.agregarArista(0, 2, 2);
        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(1, 3, 10);
        grafo.agregarArista(2, 4, 3);
        grafo.agregarArista(4, 3, 4);
        grafo.agregarArista(3, 5, 11);
        grafo.agregarArista(4, 5, 2);

        System.out.println("--- Ejercicio 5: Algoritmo de Dijkstra ---");
        grafo.dijkstra(0, 5);
    }
}
