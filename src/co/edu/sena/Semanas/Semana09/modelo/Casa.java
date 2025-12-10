package co.edu.sena.Semanas.Semana09.modelo;

public class Casa extends Propiedad {
    private int pisos;

    public Casa(String direccion, double precio, int pisos) {
        super(direccion, precio);
        this.pisos = pisos;
    }

    public int getPisos() { return pisos; }

    @Override
    public void mostrarInformacion() {
        System.out.println("Casa\nDireccion: " + direccion +
                "\nPrecio: " + precio +
                "\nPisos: " + pisos);
    }
}
