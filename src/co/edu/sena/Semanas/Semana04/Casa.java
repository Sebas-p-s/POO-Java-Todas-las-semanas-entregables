package co.edu.sena.Semanas.Semana04;

public class Casa extends Propiedad {
    private int numeroPisos;

    public Casa(String direccion, String ciudad, double valor, int numeroPisos) {
        super(direccion, ciudad, valor);
        this.numeroPisos = numeroPisos;
    }
    // Usamos override para sobre escribir algunos metodos
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Número de pisos: " + numeroPisos);
    }

    @Override
    public double calcularImpuesto() {
        return valor * 0.015; // 1.5% impuesto para casas
    }
}
