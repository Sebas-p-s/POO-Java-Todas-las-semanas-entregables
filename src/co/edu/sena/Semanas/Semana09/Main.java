package co.edu.sena.Semanas.Semana09.util;

import co.edu.sena.Semanas.Semana09.modelo.*;
import co.edu.sena.Semanas.Semana09.servicio.SistemaInmobiliaria;
import co.edu.sena.Semanas.Semana09.excepciones.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        SistemaInmobiliaria sistema = new SistemaInmobiliaria();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== SISTEMA INMOBILIARIO ===");
            System.out.println("1. Agregar propiedad");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Buscar propiedad");
            System.out.println("4. Listar propiedades");
            System.out.println("5. Actualizar precio");
            System.out.println("6. Eliminar propiedad");
            System.out.println("7. Filtrar por precio");
            System.out.println("8. Estadisticas");
            System.out.println("9. Reporte");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> agregarPropiedad(sistema, sc);
                case 2 -> agregarEmpleado(sistema, sc);
                case 3 -> buscarPropiedad(sistema, sc);
                case 4 -> listarPropiedades(sistema);
                case 5 -> actualizarPrecio(sistema, sc);
                case 6 -> eliminarPropiedad(sistema, sc);
                case 7 -> filtrarPrecio(sistema, sc);
                case 8 -> estadisticas(sistema);
                case 9 -> System.out.println(sistema.generarReporteResumen());
            }

        } while (opcion != 0);
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) { sc.next(); }
        int v = sc.nextInt(); sc.nextLine(); return v;
    }

    private static void agregarPropiedad(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.print("Direccion: "); String d = sc.nextLine();
        System.out.print("Precio: "); double p = sc.nextDouble(); sc.nextLine();
        System.out.print("Tipo (Casa/Apartamento): "); String t = sc.nextLine();

        if (t.equalsIgnoreCase("Casa")) {
            System.out.print("Pisos: "); int ps = sc.nextInt(); sc.nextLine();
            sistema.agregarPropiedad(new Casa(d, p, ps));
        } else {
            System.out.print("Piso: "); int piso = sc.nextInt(); sc.nextLine();
            sistema.agregarPropiedad(new Apartamento(d, p, piso));
        }

        System.out.println("Propiedad agregada.");
    }

    private static void agregarEmpleado(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.print("Nombre: "); String n = sc.nextLine();
        System.out.print("Cargo: "); String c = sc.nextLine();
        System.out.print("Tipo encargado: "); String te = sc.nextLine();
        System.out.print("Salario: "); double s = sc.nextDouble(); sc.nextLine();
        System.out.print("Ventas: "); int v = sc.nextInt(); sc.nextLine();

        try {
            sistema.agregarEmpleado(new Empleado(n, c, te, s, v));
            System.out.println("Empleado agregado.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void buscarPropiedad(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.print("Direccion: ");
        String d = sc.nextLine();
        try {
            sistema.buscarPropiedad(d).mostrarInformacion();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void listarPropiedades(SistemaInmobiliaria sistema) {
        var lista = sistema.listarPropiedades();
        if (lista.isEmpty()) System.out.println("No hay propiedades.");
        else lista.forEach(p -> {
            p.mostrarInformacion();
            System.out.println("--------------");
        });
    }

    private static void actualizarPrecio(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.print("Direccion: ");
        String d = sc.nextLine();
        System.out.print("Nuevo precio: ");
        double np = sc.nextDouble(); sc.nextLine();

        System.out.println(sistema.actualizarPropiedad(d, np)
                ? "Actualizado."
                : "No encontrado.");
    }

    private static void eliminarPropiedad(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.print("Direccion: ");
        String d = sc.nextLine();
        System.out.println(sistema.eliminarPropiedad(d)
                ? "Eliminada."
                : "No encontrada.");
    }

    private static void filtrarPrecio(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.print("Precio min: ");
        double min = sc.nextDouble();
        System.out.print("Precio max: ");
        double max = sc.nextDouble(); sc.nextLine();

        var lista = sistema.filtrarPorPrecio(min, max);
        if (lista.isEmpty()) System.out.println("Nada en ese rango.");
        else lista.forEach(p -> {
            p.mostrarInformacion();
            System.out.println("----");
        });
    }

    private static void estadisticas(SistemaInmobiliaria sistema) {
        System.out.println("Total propiedades: " + sistema.cantidadPropiedades());
        System.out.println("Total precios: " + sistema.calcularTotalPrecios());
        System.out.println("Promedio: " + sistema.calcularPromedioPrecios());
        System.out.println("Mas cara:");
        if (sistema.obtenerPropiedadMasCara() != null)
            sistema.obtenerPropiedadMasCara().mostrarInformacion();
        System.out.println("Conteo por tipo: " + sistema.contarPorTipo());
    }
}
