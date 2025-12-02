package co.edu.sena.Semanas.Semana06.implementaciones;

import co.edu.sena.Semanas.Semana06.abstractas.PropiedadInmobiliaria;
import co.edu.sena.Semanas.Semana06.interfaces.Alquilable;
import co.edu.sena.Semanas.Semana06.interfaces.Vendible;

public class Apartamento extends PropiedadInmobiliaria implements Vendible, Alquilable {

    private int piso;

    public Apartamento(String direccion, double precioBase, int piso) {
        super(direccion, precioBase);
        this.piso = piso;
    }

    @Override
    public double calcularImpuesto() {
        return precioBase * 0.012; // 1.2%
    }

    @Override
    public double calcularPrecioVenta() {
        return precioBase + calcularImpuesto();
    }

    @Override
    public boolean disponibleParaVenta() {
        return true;
    }

    @Override
    public double calcularPrecioAlquiler() {
        return precioBase * 0.005; // 0.5% mensual
    }

    @Override
    public void registrarAlquiler(String cliente) {
        System.out.println("Alquiler registrado para: " + cliente);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("\n=== APARTAMENTO ===");
        super.mostrarInformacion();
        System.out.println("Piso: " + piso);
    }
}
