package co.edu.sena.Semanas.Semana04;

public class Propiedad {
    protected String direccion;
    protected String ciudad;
    protected double valor;

    // Constructor
    public Propiedad(String direccion, String ciudad, double valor) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.valor = valor;
    }

    // Metodo para ver esa informacion :p
    public void mostrarInformacion() {
        System.out.println("===PROPIEDAD===");
        System.out.println("Dirección: " + direccion);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Valor base: " + String.format("$%.2f",valor));
    }
    // Metodo para calcular impuesto
    public double calcularImpuesto() {
        return valor * 0.01; // 1% impuesto base
    }
}
