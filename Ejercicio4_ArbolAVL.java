
public class Ejercicio4_ArbolAVL {

    static class Nodo {
        int valor, altura;
        Nodo izquierdo, derecho;

        public Nodo(int valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }

    static class ArbolAVL {
        Nodo raiz;

        private int altura(Nodo n) {
            return n == null ? 0 : n.altura;
        }

        private int obtenerBalance(Nodo n) {
            return n == null ? 0 : altura(n.izquierdo) - altura(n.derecho);
        }

        private Nodo rotacionDerecha(Nodo y) {
            Nodo x = y.izquierdo;
            Nodo T2 = x.derecho;

            x.derecho = y;
            y.izquierdo = T2;

            y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
            x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

            return x;
        }

        private Nodo rotacionIzquierda(Nodo x) {
            Nodo y = x.derecho;
            Nodo T2 = y.izquierdo;

            y.izquierdo = x;
            x.derecho = T2;

            x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
            y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

            return y;
        }

        public void insertar(int valor) {
            raiz = insertarRec(raiz, valor);
        }

        private Nodo insertarRec(Nodo nodo, int valor) {
            if (nodo == null) return new Nodo(valor);

            if (valor < nodo.valor) {
                nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
            } else if (valor > nodo.valor) {
                nodo.derecho = insertarRec(nodo.derecho, valor);
            } else {
                return nodo; // No se permiten duplicados
            }

            nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
            int balance = obtenerBalance(nodo);

            // Casos de rotación
            if (balance > 1 && valor < nodo.izquierdo.valor) return rotacionDerecha(nodo);
            if (balance < -1 && valor > nodo.derecho.valor) return rotacionIzquierda(nodo);
            if (balance > 1 && valor > nodo.izquierdo.valor) {
                nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
                return rotacionDerecha(nodo);
            }
            if (balance < -1 && valor < nodo.derecho.valor) {
                nodo.derecho = rotacionDerecha(nodo.derecho);
                return rotacionIzquierda(nodo);
            }

            return nodo;
        }

        public void eliminar(int valor) {
            raiz = eliminarRec(raiz, valor);
        }

        private Nodo eliminarRec(Nodo root, int valor) {
            if (root == null) return root;

            if (valor < root.valor) {
                root.izquierdo = eliminarRec(root.izquierdo, valor);
            } else if (valor > root.valor) {
                root.derecho = eliminarRec(root.derecho, valor);
            } else {
                if ((root.izquierdo == null) || (root.derecho == null)) {
                    Nodo temp = (root.izquierdo != null) ? root.izquierdo : root.derecho;
                    if (temp == null) {
                        root = null;
                    } else {
                        root = temp;
                    }
                } else {
                    Nodo temp = nodoMinimoValor(root.derecho);
                    root.valor = temp.valor;
                    root.derecho = eliminarRec(root.derecho, temp.valor);
                }
            }

            if (root == null) return root;

            root.altura = Math.max(altura(root.izquierdo), altura(root.derecho)) + 1;
            int balance = obtenerBalance(root);

            if (balance > 1 && obtenerBalance(root.izquierdo) >= 0) return rotacionDerecha(root);
            if (balance > 1 && obtenerBalance(root.izquierdo) < 0) {
                root.izquierdo = rotacionIzquierda(root.izquierdo);
                return rotacionDerecha(root);
            }
            if (balance < -1 && obtenerBalance(root.derecho) <= 0) return rotacionIzquierda(root);
            if (balance < -1 && obtenerBalance(root.derecho) > 0) {
                root.derecho = rotacionDerecha(root.derecho);
                return rotacionIzquierda(root);
            }

            return root;
        }

        private Nodo nodoMinimoValor(Nodo nodo) {
            Nodo actual = nodo;
            while (actual.izquierdo != null) actual = actual.izquierdo;
            return actual;
        }

        public boolean buscar(int valor) {
            return buscarRec(raiz, valor);
        }

        private boolean buscarRec(Nodo actual, int valor) {
            if (actual == null) return false;
            if (actual.valor == valor) return true;
            return valor < actual.valor ? buscarRec(actual.izquierdo, valor) : buscarRec(actual.derecho, valor);
        }

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
    }

    public static void main(String[] args) {
        ArbolAVL avl = new ArbolAVL();
        System.out.println("--- Ejercicio 4: Árbol AVL ---");
        avl.insertar(10);
        avl.insertar(20);
        avl.insertar(30);
        avl.insertar(40);
        avl.insertar(50);
        avl.insertar(25);

        System.out.print("Recorrido Inorden tras inserciones: ");
        avl.inorden();

        System.out.println("¿Buscar 30?: " + avl.buscar(30));

        avl.eliminar(30);
        System.out.print("Recorrido Inorden tras eliminar 30: ");
        avl.inorden();
    }
}
