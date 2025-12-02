package co.edu.sena.Semanas.Semana07;

import co.edu.sena.Semanas.Semana07.modelo.*;
import co.edu.sena.Semanas.Semana07.servicio.*;
import co.edu.sena.Semanas.Semana07.util.Validaciones;
import co.edu.sena.Semanas.Semana07.excepciones.*;

public class Main {
    public static void main(String[] args) {

        SistemaInmobiliaria sistema = new SistemaInmobiliaria();

        // Manejo de excepciones en empleados
        try {
            sistema.agregarEmpleado(new Empleado("Carlos Pérez", "Asesor", "Casas", 5_000_000, 8));
            sistema.agregarEmpleado(new Empleado("Carlos Pérez", "Asesor", "Casas", 5_000_000, 8)); // Duplicado
        } catch (EmpleadoDuplicadoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Manejo de excepciones de propiedades
        try {
            Validaciones.validarPrecio(-200_000_000); // Error
        } catch (PrecioInvalidoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Propiedades
        sistema.agregarPropiedad(new Casa("Calle 123", 250_000_000, 2));
        sistema.agregarPropiedad(new Apartamento("Av Siempre Viva 742", 180_000_000, 4));

        // Buscar propiedad
        try {
            sistema.buscarPropiedad("No existe");
        } catch (PropiedadNoEncontradaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Mostrar todo
        System.out.println("\n=== EMPLEADOS ===");
        sistema.mostrarEmpleados();

        System.out.println("\n=== PROPIEDADES ===");
        sistema.mostrarPropiedades();
    }
}
