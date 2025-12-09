package co.edu.sena.Semanas.Semana08.util;

import co.edu.sena.Semanas.Semana08.servicio.SistemaInmobiliaria;
import co.edu.sena.Semanas.Semana08.modelo.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SistemaInmobiliaria sistema = new SistemaInmobiliaria();
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n=== SISTEMA INMOBILIARIO ===");
            System.out.println("1. Agregar propiedad");
            System.out.println("2. Buscar propiedad por direccion");
            System.out.println("3. Listar todas las propiedades");
            System.out.println("4. Filtrar propiedades por precio");
            System.out.println("5. Ver estadisticas");
            System.out.println("6. Eliminar propiedad");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> agregarPropiedad(sistema, sc);
                case 2 -> buscarPropiedad(sistema, sc);
                case 3 -> listarPropiedades(sistema);
                case 4 -> filtrarPorPrecio(sistema, sc);
                case 5 -> mostrarEstadisticas(sistema);
                case 6 -> eliminarPropiedad(sistema, sc);
                case 0 -> System.out.println("Hasta luego...");
                default -> System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

    }

    // Aqui se agrega una propiedad
    private static void agregarPropiedad(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.println("\n--- AGREGAR PROPIEDAD ---");
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.print("Tipo (Casa / Apartamento): ");
        String tipo = sc.nextLine();

        if (tipo.equalsIgnoreCase("Casa")) {
            System.out.print("Numero de pisos: ");
            int pisos = sc.nextInt();
            sc.nextLine();

            Casa casa = new Casa(direccion, precio, pisos);
            sistema.agregarPropiedad(casa);

        } else if (tipo.equalsIgnoreCase("Apartamento")) {
            System.out.print("Piso: ");
            int piso = sc.nextInt();
            sc.nextLine();

            Apartamento apt = new Apartamento(direccion, precio, piso);
            sistema.agregarPropiedad(apt);

        } else {
            System.out.println("Tipo no valido.");
        }

        System.out.println("Propiedad registrada correctamente.");
    }

    // Aqui se busca una propiedad usando HashMap (O(1))
    private static void buscarPropiedad(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.println("\n--- BUSCAR PROPIEDAD ---");
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();

        try {
            var p = sistema.buscarPropiedad(direccion);
            System.out.println("Propiedad encontrada:");
            p.mostrarInformacion();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Aqui se listan todas las propiedades
    private static void listarPropiedades(SistemaInmobiliaria sistema) {
        System.out.println("\n--- LISTA DE PROPIEDADES ---");
        sistema.mostrarPropiedades();
    }

    // Aqui se filtra por un rango de precios
    private static void filtrarPorPrecio(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.println("\n--- FILTRAR POR PRECIO ---");

        System.out.print("Precio minimo: ");
        double min = sc.nextDouble();

        System.out.print("Precio maximo: ");
        double max = sc.nextDouble();
        sc.nextLine();

        List<Propiedad> resultado = sistema.filtrarPorPrecio(min, max);

        if (resultado.isEmpty()) {
            System.out.println("No se encontraron propiedades en ese rango.");
        } else {
            System.out.println("Propiedades encontradas:");
            for (Propiedad p : resultado) {
                p.mostrarInformacion();
                System.out.println("-------------------");
            }
        }
    }

    // Aqui se muestran todas las estadisticas
    private static void mostrarEstadisticas(SistemaInmobiliaria sistema) {
        System.out.println("\n--- ESTADISTICAS ---");

        System.out.println("Total de propiedades: " + sistema.contarPorTipo().values().stream().mapToInt(i -> i).sum());
        System.out.println("Total ventas: $" + sistema.calcularTotalVentas());
        System.out.println("Promedio de precios: $" + sistema.calcularPromedio());

        Propiedad p = sistema.obtenerPropiedadMasCara();
        if (p != null) {
            System.out.println("Propiedad mas cara:");
            p.mostrarInformacion();
        }

        System.out.println("\nConteo por tipo:");
        Map<String, Integer> conteo = sistema.contarPorTipo();
        for (var entry : conteo.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    // Aqui se elimina una propiedad
    private static void eliminarPropiedad(SistemaInmobiliaria sistema, Scanner sc) {
        System.out.println("\n--- ELIMINAR PROPIEDAD ---");
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();

        boolean eliminado = sistema.eliminarPropiedad(direccion);

        if (eliminado) {
            System.out.println("Propiedad eliminada.");
        } else {
            System.out.println("No existe propiedad registrada en esa direccion.");
        }
    }
}

