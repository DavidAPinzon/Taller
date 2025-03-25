public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private double precioDia;
    private boolean disponible;

    public Vehiculo(String marca, String modelo, int anio, double precioDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioDia = precioDia;
        this.disponible = true;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getTipo() {
        return "Vehiculo";
    }
}