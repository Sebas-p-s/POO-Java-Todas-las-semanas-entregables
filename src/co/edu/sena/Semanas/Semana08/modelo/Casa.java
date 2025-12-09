package co.edu.sena.Semanas.Semana08.modelo;

public class Casa extends Propiedad {

    private int pisos;

    public Casa(String direccion, double precio, int pisos) {
        super(direccion, precio);
        this.pisos = pisos;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Casa en: " + getDireccion());
        System.out.println("Precio: $" + getPrecio());
        System.out.println("Número de pisos: " + pisos);
    }
}
