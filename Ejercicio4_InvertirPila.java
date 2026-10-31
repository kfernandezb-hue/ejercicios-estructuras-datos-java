//package ejercicios;

import java.util.Stack;

public class Ejercicio4_InvertirPila {

    // Función para invertir una pila usando recursión / pila auxiliar
    public static void invertirPila(Stack<Integer> pila) {
        if (pila.isEmpty()) {
            return;
        }
        int temp = pila.pop();
        invertirPila(pila);
        insertarEnElFondo(pila, temp);
    }

    private static void insertarEnElFondo(Stack<Integer> pila, int elemento) {
        if (pila.isEmpty()) {
            pila.push(elemento);
            return;
        }
        int temp = pila.pop();
        insertarEnElFondo(pila, elemento);
        pila.push(temp);
    }

    public static void main(String[] args) {
        System.out.println("--- Ejercicio 4: Invertir una Pila ---");
        Stack<Integer> pila = new Stack<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);

        System.out.println("Pila original (Tope a la derecha): " + pila);
        invertirPila(pila);
        System.out.println("Pila invertida (Tope a la derecha): " + pila);
    }
}
