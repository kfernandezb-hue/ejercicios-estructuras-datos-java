//package ejercicios;

public class Ejercicio3_ColaListaEnlazada {

    static class Nodo {
        int valor;
        Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    static class ColaLista {
        private Nodo frente;
        private Nodo fin;

        public ColaLista() {
            this.frente = null;
            this.fin = null;
        }

        // Método Encolar (enqueue)
        public void enqueue(int elemento) {
            Nodo nuevoNodo = new Nodo(elemento);
            if (fin == null) {
                frente = fin = nuevoNodo;
            } else {
                fin.siguiente = nuevoNodo;
                fin = nuevoNodo;
            }
            System.out.println("Encolado: " + elemento);
        }

        // Método Desencolar (dequeue)
        public int dequeue() {
            if (estaVacia()) {
                System.out.println("Error: La cola está vacía.");
                return -1;
            }
            int valor = frente.valor;
            frente = frente.siguiente;
            if (frente == null) {
                fin = null;
            }
            return valor;
        }

        public boolean estaVacia() {
            return frente == null;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Ejercicio 3: Cola con Lista Enlazada ---");
        ColaLista cola = new ColaLista();
        
        cola.enqueue(100);
        cola.enqueue(200);
        cola.enqueue(300);

        System.out.println("Desencolado: " + cola.dequeue());
        System.out.println("Desencolado: " + cola.dequeue());
    }
}
