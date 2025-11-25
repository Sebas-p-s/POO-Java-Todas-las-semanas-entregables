package co.edu.sena.Semanas.Semana04;

public class Apartamento extends Propiedad {
    private int nivel;

    public Apartamento(String direccion, String ciudad, double valor, int nivel) {
        super(direccion, ciudad, valor);
        this.nivel = nivel;
    }
// @Override sirve para cuando sobre escribimos metodos
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Nivel del apartamento: " + nivel);
    }

    @Override
    public double calcularImpuesto() {
        return valor * 0.012; // 1.2% impuesto para apartamentos
    }
}
