//package ejercicios;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio5_MinMaxCola {

    public static void encontrarMinMax(Queue<Integer> cola) {
        if (cola == null || cola.isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        int tamano = cola.size();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Recorrer desencolando y volviendo a encolar para mantener el estado original
        for (int i = 0; i < tamano; i++) {
            int actual = cola.poll();
            
            if (actual < min) {
                min = actual;
            }
            if (actual > max) {
                max = actual;
            }
            
            cola.add(actual); // Volver a colocar en la cola
        }

        System.out.println("Valor Mínimo en la cola: " + min);
        System.out.println("Valor Máximo en la cola: " + max);
    }

    public static void main(String[] args) {
        System.out.println("--- Ejercicio 5: Mínimo y Máximo en una Cola ---");
        Queue<Integer> cola = new LinkedList<>();
        cola.add(45);
        cola.add(12);
        cola.add(89);
        cola.add(3);
        cola.add(67);

        System.out.println("Cola original: " + cola);
        encontrarMinMax(cola);
        System.out.println("Cola preservada después de la operación: " + cola);
    }
}
