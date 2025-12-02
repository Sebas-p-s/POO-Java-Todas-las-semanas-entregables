package co.edu.sena.Semanas.Semana06.implementaciones;

import co.edu.sena.Semanas.Semana06.abstractas.PropiedadInmobiliaria;
import co.edu.sena.Semanas.Semana06.interfaces.Vendible;

public class Casa extends PropiedadInmobiliaria implements Vendible {

    private double areaTerreno;

    public Casa(String direccion, double precioBase, double areaTerreno) {
        super(direccion, precioBase);
        this.areaTerreno = areaTerreno;
    }

    @Override
    public double calcularImpuesto() {
        return precioBase * 0.015; // 1.5%
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
    public void mostrarInformacion() {
        System.out.println("\n=== CASA ===");
        super.mostrarInformacion();
        System.out.println("Área del terreno: " + areaTerreno + " m2");
    }
}
