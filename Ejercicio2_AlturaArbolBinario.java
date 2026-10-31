
public class Ejercicio2_AlturaArbolBinario {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public static int calcularAltura(Nodo nodo) {
        if (nodo == null) {
            return 0; // Altura en términos de cantidad de niveles de nodos
        }
        int alturaIzquierda = calcularAltura(nodo.izquierdo);
        int alturaDerecha = calcularAltura(nodo.derecho);

        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    public static void main(String[] args) {
        // Construcción de árbol binario de prueba
        Nodo raiz = new Nodo(1);
        raiz.izquierdo = new Nodo(2);
        raiz.derecho = new Nodo(3);
        raiz.izquierdo.izquierdo = new Nodo(4);
        raiz.izquierdo.derecho = new Nodo(5);
        raiz.izquierdo.izquierdo.izquierdo = new Nodo(6);

        System.out.println("--- Ejercicio 2: Altura de un Árbol Binario ---");
        System.out.println("La altura del árbol es: " + calcularAltura(raiz));
    }
}
