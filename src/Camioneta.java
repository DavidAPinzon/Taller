class Camioneta extends Vehiculo {
    private double capacidadCarga;

    public Camioneta(String marca, String modelo, int anio, double precioDia, double capacidadCarga) {
        super(marca, modelo, anio, precioDia);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String getTipo() {
        return "Camioneta";
    }
}