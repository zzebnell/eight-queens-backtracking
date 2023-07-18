public class Casilla {

    private boolean ocupada;
    
    public Casilla() {
        ocupada = false;
    }

    public boolean getOcupada() {
        return ocupada;
    }
    
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    @Override
    public String toString() {
        return ocupada ? "[" + "*" + "]" : " 0 ";
    }
}