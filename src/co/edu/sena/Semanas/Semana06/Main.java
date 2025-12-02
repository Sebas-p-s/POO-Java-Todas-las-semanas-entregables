package co.edu.sena.Semanas.Semana06;

import co.edu.sena.Semanas.Semana06.abstractas.PropiedadInmobiliaria;
import co.edu.sena.Semanas.Semana06.implementaciones.Apartamento;
import co.edu.sena.Semanas.Semana06.implementaciones.Casa;
import co.edu.sena.Semanas.Semana06.interfaces.Alquilable;
import co.edu.sena.Semanas.Semana06.interfaces.Vendible;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA INMOBILIARIO - SEMANA 06 ===\n");

        // POLIMORFISMO -----------------------------------------------------
        PropiedadInmobiliaria[] propiedades = new PropiedadInmobiliaria[2];

        propiedades[0] = new Casa("Calle 123 #45-67", 250_000_000, 120);
        propiedades[1] = new Apartamento("Cra 10 #20-30", 180_000_000, 5);

        System.out.println("--- Información de propiedades ---");
        for (PropiedadInmobiliaria p : propiedades) {
            p.mostrarInformacion();
            System.out.println("Impuesto: $" + p.calcularImpuesto());
            System.out.println("----------------------------------");
        }

        // INTERFACE Vendible -----------------------------------------------
        System.out.println("\n--- Uso de interfaz Vendible ---");
        Vendible v = new Casa("Av 50 #15-20", 300_000_000, 150);
        System.out.println("Precio de venta: $" + v.calcularPrecioVenta());

        // MÚLTIPLE IMPLEMENTACIÓN ------------------------------------------
        System.out.println("\n--- Múltiple implementación (Apartamento) ---");
        Apartamento ap = new Apartamento("Calle 88 #30-15", 200_000_000, 9);

        Alquilable a = ap;
        Vendible v2 = ap;

        System.out.println("Alquiler mensual: $" + a.calcularPrecioAlquiler());
        a.registrarAlquiler("Juan Pérez");

        System.out.println("Precio de venta: $" + v2.calcularPrecioVenta());

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}
