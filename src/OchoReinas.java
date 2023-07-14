public class OchoReinas {

	private Casilla[][] tablero;
	private boolean resuelto;
	private final int N = 8;
	private int nroSol = 1;

	public OchoReinas() {
		resuelto = false;
		tablero = new Casilla[8][8];
		generarTablero();
	}

	private void generarTablero() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tablero[i][j] = new Casilla(i, j);
			}
		}
	}

	public void imprimirTablero() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(tablero[i][j].toString() + " ");
			}
			System.out.println();
		}
	}

	public void resolver(int x, int nroReina) {
		
		if (nroReina == 8) { // Si pudo colocar las 8 reinas
			System.out.println("Solucion " + nroSol++);
			imprimirTablero();
			System.out.println();
		}
		
		int j = -1; // Columnas a probar
		
		do {
			
			j++; // Aumentamos una columna
			
			if (j != 8) {
				if (!va_a_morir(x, j)) { // Vemos si es una posicion valida
					if (nroReina < N) {
						tablero[x][j].setHayReina(true);
						resolver(x + 1, nroReina + 1);
						if (!resuelto) // Volvemos atras 
							tablero[x][j].setHayReina(false);
					}
					else {
						resuelto = true;
					}
				}
			}
			

		} while ((j < 8) && !resuelto);
		
	}

	private boolean va_a_morir(int x, int y) {
		boolean muere = false;

		int diag1 = x + y;
		int diag2 = x - y;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((j == y) && tablero[i][j].getHayReina())
					return true; // Si esta en la misma columna
				else if ((i == x) && tablero[i][j].getHayReina())
					return true; // Si esta en la mism fila
				else if (((i + j) == diag1) && tablero[i][j].getHayReina())
					return true; // Si estan en la misma diagonal
				else if (((i - j) == diag2) && tablero[i][j].getHayReina())
					return true; // Si estan en la misma diagonal
			}
		}

		return muere;
	}

	public static void main(String[] args) {
		OchoReinas reina = new OchoReinas();

		reina.resolver(0, 0);
	}

}

class Casilla {
	private int x;
	private int y;
	private boolean hayReina;

	public Casilla(int x, int y) {
		this.x = x;
		this.y = y;
		hayReina = false;
	}

	public boolean getHayReina() {
		return hayReina;
	}

	public void setHayReina(boolean hayReina) {
		this.hayReina = hayReina;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return hayReina ? "*" : "o";
	}
}