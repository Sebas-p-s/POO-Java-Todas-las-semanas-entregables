package co.edu.sena.Semanas.Semana09.modelo;

public class Apartamento extends Propiedad {
    private int piso;

    public Apartamento(String direccion, double precio, int piso) {
        super(direccion, precio);
        this.piso = piso;
    }

    public int getPiso() { return piso; }

    @Override
    public void mostrarInformacion() {
        System.out.println("Apartamento\nDireccion: " + direccion +
                "\nPrecio: " + precio +
                "\nPiso: " + piso);
    }
}
