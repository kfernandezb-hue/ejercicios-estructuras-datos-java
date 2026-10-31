import java.util.*;

public class Ejercicio3_RutaCortaGrafoNoDirigido {

    static class GrafoNoDirigido {
        private Map<Integer, List<Integer>> adj = new HashMap<>();

        public void agregarArista(int u, int v) {
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        public List<Integer> rutaMasCortaBFS(int inicio, int destino) {
            if (inicio == destino) return Collections.singletonList(inicio);

            Queue<Integer> cola = new LinkedList<>();
            Map<Integer, Integer> padre = new HashMap<>();
            Set<Integer> visitados = new HashSet<>();

            cola.add(inicio);
            visitados.add(inicio);
            padre.put(inicio, null);

            boolean encontrado = false;

            while (!cola.isEmpty()) {
                int actual = cola.poll();
                if (actual == destino) {
                    encontrado = true;
                    break;
                }

                for (int vecino : adj.getOrDefault(actual, new ArrayList<>())) {
                    if (!visitados.contains(vecino)) {
                        visitados.add(vecino);
                        padre.put(vecino, actual);
                        cola.add(vecino);
                    }
                }
            }

            if (!encontrado) return Collections.emptyList();

            // Reconstruir camino
            List<Integer> camino = new ArrayList<>();
            Integer curr = destino;
            while (curr != null) {
                camino.add(curr);
                curr = padre.get(curr);
            }
            Collections.reverse(camino);
            return camino;
        }
    }

    public static void main(String[] args) {
        GrafoNoDirigido grafo = new GrafoNoDirigido();
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);
        grafo.agregarArista(4, 5);

        System.out.println("--- Ejercicio 3: Ruta Más Corta en Grafo No Dirigido (BFS) ---");
        int inicio = 0, destino = 5;
        List<Integer> camino = grafo.rutaMasCortaBFS(inicio, destino);
        System.out.println("Ruta más corta de " + inicio + " a " + destino + ": " + camino);
    }
}
