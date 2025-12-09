package co.edu.sena.Semanas.Semana08.modelo;

public class Apartamento extends Propiedad {

    private int piso;

    public Apartamento(String direccion, double precio, int piso) {
        super(direccion, precio);
        this.piso = piso;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Apartamento en: " + getDireccion());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Piso: " + piso);
    }
}
