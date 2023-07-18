public class Tablero {

    private Casilla[][] tablero;
    private final int FILAS = 8;
    private final int COLUMNAS = 8;
    
    public Tablero() {
        tablero = generarTablero();
    }
    
    private Casilla[][] generarTablero() {
        Casilla[][] tablero = new Casilla[FILAS][COLUMNAS];
        
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = new Casilla();
            }
        }
        
        return tablero;
    }
    
    public void mostrarTablero() {     
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j].toString() + " ");
            }
            System.out.println();
        }
    }
    
    public void ocuparCasilla(int i, int j) {
        tablero[i][j].setOcupada(true);
    }
    
    public void liberarCasilla(int i, int j) {
        tablero[i][j].setOcupada(false);
    }
    
    public boolean enPeligro(int x, int y) {
        boolean muere = false;
        
        for (int i = 0; i < FILAS && !muere; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[i][j].getOcupada()) {
                    muere = (i == x) ||
                            (j == y) ||
                            ((i + j) == (x + y)) ||
                            ((i - j) == (x - y));
                }
            }
        }
        
        return muere;
    }
}