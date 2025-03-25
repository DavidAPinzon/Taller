public class Auto extends Vehiculo {
    private int numPuertas;

    public Auto(String marca, String modelo, int anio, double precioDia, int numPuertas) {
        super(marca, modelo, anio, precioDia);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public String getTipo() {
        return "Auto";
    }
}
