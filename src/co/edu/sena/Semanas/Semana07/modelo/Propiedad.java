package co.edu.sena.Semanas.Semana07.modelo;

public abstract class Propiedad {
    private String direccion;
    private double precio;

    public Propiedad(String direccion, double precio) {
        this.direccion = direccion;
        this.precio = precio;
    }

    public String getDireccion() { return direccion; }
    public double getPrecio() { return precio; }

    public abstract void mostrarInformacion();
}
