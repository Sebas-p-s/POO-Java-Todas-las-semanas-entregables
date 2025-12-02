package co.edu.sena.Semanas.Semana06.abstractas;

public abstract class PropiedadInmobiliaria {

    protected String direccion;
    protected double precioBase;

    public PropiedadInmobiliaria(String direccion, double precioBase) {
        this.direccion = direccion;
        this.precioBase = precioBase;
    }

    // Método abstracto
    public abstract double calcularImpuesto();

    // Método concreto
    public void mostrarInformacion() {
        System.out.println("Dirección: " + direccion);
        System.out.println("Precio base: $" + precioBase);
    }
}
