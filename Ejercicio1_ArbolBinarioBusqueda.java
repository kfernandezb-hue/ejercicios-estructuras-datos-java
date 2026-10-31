public class Ejercicio1_ArbolBinarioBusqueda {

    static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    static class ArbolBinarioBusqueda {
        Nodo raiz;

        public ArbolBinarioBusqueda() {
            this.raiz = null;
        }

        // Insertar elemento
        public void insertar(int valor) {
            raiz = insertarRec(raiz, valor);
        }

        private Nodo insertarRec(Nodo actual, int valor) {
            if (actual == null) {
                return new Nodo(valor);
            }
            if (valor < actual.valor) {
                actual.izquierdo = insertarRec(actual.izquierdo, valor);
            } else if (valor > actual.valor) {
                actual.derecho = insertarRec(actual.derecho, valor);
            }
            return actual;
        }

        // Buscar elemento
        public boolean buscar(int valor) {
            return buscarRec(raiz, valor);
        }

        private boolean buscarRec(Nodo actual, int valor) {
            if (actual == null) return false;
            if (actual.valor == valor) return true;
            return valor < actual.valor ? buscarRec(actual.izquierdo, valor) : buscarRec(actual.derecho, valor);
        }

        // Recorrido Inorden (Izquierda, Raíz, Derecha)
        public void inorden() {
            inordenRec(raiz);
            System.out.println();
        }

        private void inordenRec(Nodo nodo) {
            if (nodo != null) {
                inordenRec(nodo.izquierdo);
                System.out.print(nodo.valor + " ");
                inordenRec(nodo.derecho);
            }
        }

        // Recorrido Preorden (Raíz, Izquierda, Derecha)
        public void preorden() {
            preordenRec(raiz);
            System.out.println();
        }

        private void preordenRec(Nodo nodo) {
            if (nodo != null) {
                System.out.print(nodo.valor + " ");
                preordenRec(nodo.izquierdo);
                preordenRec(nodo.derecho);
            }
        }

        // Recorrido Postorden (Izquierda, Derecha, Raíz)
        public void postorden() {
            postordenRec(raiz);
            System.out.println();
        }

        private void postordenRec(Nodo nodo) {
            if (nodo != null) {
                postordenRec(nodo.izquierdo);
                postordenRec(nodo.derecho);
                System.out.print(nodo.valor + " ");
            }
        }
    }

    public static void main(String[] args) {
        ArbolBinarioBusqueda bst = new ArbolBinarioBusqueda();
        bst.insertar(50);
        bst.insertar(30);
        bst.insertar(70);
        bst.insertar(20);
        bst.insertar(40);
        bst.insertar(60);
        bst.insertar(80);

        System.out.println("--- Ejercicio 1: Árbol Binario de Búsqueda ---");
        System.out.print("Recorrido Inorden: ");
        bst.inorden();
        System.out.print("Recorrido Preorden: ");
        bst.preorden();
        System.out.print("Recorrido Postorden: ");
        bst.postorden();

        System.out.println("¿Existe el 40?: " + bst.buscar(40));
        System.out.println("¿Existe el 90?: " + bst.buscar(90));
    }
}
