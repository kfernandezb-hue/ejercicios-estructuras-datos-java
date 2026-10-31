//package ejercicios;

public class Ejercicio1_ContarListaEnlazada {
    
    // Clase Nodo
    static class Nodo {
        int valor;
        Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    // Clase ListaEnlazada
    static class ListaEnlazada {
        Nodo cabeza;

        public ListaEnlazada() {
            this.cabeza = null;
        }

        public void agregar(int valor) {
            Nodo nuevoNodo = new Nodo(valor);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
            }
        }

        // Método que recorre la lista y cuenta los elementos
        public int contarElementos() {
            int contador = 0;
            Nodo actual = cabeza;
            while (actual != null) {
                contador++;
                actual = actual.siguiente;
            }
            return contador;
        }
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);
        lista.agregar(50);

        System.out.println("--- Ejercicio 1: Contar elementos en una lista enlazada ---");
        System.out.println("Cantidad de elementos en la lista: " + lista.contarElementos());
    }
}
