//package ejercicios;

public class Ejercicio2_PilaArreglo {

    static class PilaFija {
        private int[] arreglo;
        private int tope;
        private int capacidad;

        public PilaFija(int capacidad) {
            this.capacidad = capacidad;
            this.arreglo = new int[capacidad];
            this.tope = -1; // Pila vacía
        }

        public void push(int elemento) {
            if (estaLlena()) {
                System.out.println("Error: La pila está llena. No se puede apilar " + elemento);
                return;
            }
            arreglo[++tope] = elemento;
            System.out.println("Apilado: " + elemento);
        }

        public int pop() {
            if (estaVacia()) {
                System.out.println("Error: La pila está vacía.");
                return -1;
            }
            return arreglo[tope--];
        }

        public boolean estaVacia() {
            return tope == -1;
        }

        public boolean estaLlena() {
            return tope == capacidad - 1;
        }

        public int peek() {
            if (estaVacia()) {
                System.out.println("La pila está vacía.");
                return -1;
            }
            return arreglo[tope];
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Ejercicio 2: Pila con Arreglo de Tamaño Fijo ---");
        PilaFija pila = new PilaFija(4);
        
        pila.push(5);
        pila.push(15);
        pila.push(25);
        pila.push(35);
        pila.push(45); // Intento en pila llena

        System.out.println("Elemento desapilado: " + pila.pop());
        System.out.println("Elemento desapilado: " + pila.pop());
    }
}
