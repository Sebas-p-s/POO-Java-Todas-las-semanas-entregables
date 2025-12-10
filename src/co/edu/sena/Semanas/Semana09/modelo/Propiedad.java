package co.edu.sena.Semanas.Semana09.modelo;

public abstract class Propiedad {
    protected String direccion;
    protected double precio;

    public Propiedad(String direccion, double precio) {
        this.direccion = direccion;
        this.precio = precio;
    }

    public String getDireccion() { return direccion; }
    public double getPrecio() { return precio; }

    public abstract void mostrarInformacion();
}
