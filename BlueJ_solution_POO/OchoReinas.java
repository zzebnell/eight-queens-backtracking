public class OchoReinas {

    private Tablero tablero;
    private int sol = 1;

    public OchoReinas() {
        tablero = new Tablero();
    }

    public void resolver(int fila, int nroReina) {
        int columna = 0; // Iniciamos con la columna 0
        boolean resuelto = false;
        
        do {
            if (!tablero.enPeligro(fila, columna)) { // Si no esta en peligro colocamos una reina
                tablero.ocuparCasilla(fila, columna);
                if (nroReina < 8) { // Seguimos resolviendo para cada fila hasta que sea la ultima reina
                    resolver(fila + 1, nroReina + 1);
                    if (!resuelto) { // Si no pudo resolver entonces libera la casilla (Vuelta atras)
                        tablero.liberarCasilla(fila, columna);
                    }
                }
                else {
                    System.out.println("Solucion " + sol++);
                    mostrarTablero();
                    
                    tablero.liberarCasilla(fila, columna); // Liberamos la casilla para empezar a encontrar otras soluciones
                    resuelto = true;
                }
            }
            columna++; // Avanzamos a la siguiente columna
        } while(columna < 8 && !resuelto);
    }

    private void mostrarTablero() {
        tablero.mostrarTablero();
        System.out.println();
    }
}