package co.edu.sena.Semanas.Semana02;

public class Main {
    public static void main(String[] args) {
        // Creo instancias de Clientes
        Cliente cliente1 = new Cliente("Sofia Ramírez", "Lote de Terreno", 50_000000);
        Cliente cliente2 = new Cliente("Carlos Vives", "Casa Campestre", 850_000_000);

        // Creo instancias de Pagos
        Pago pagoA = new Pago("2025-11-20", "Oficina Principal", 100_000_000);
        Pago pagoB = new Pago("2025-11-21", "Notaría 12", 2_000_000);

        // Creo la entidad Escrituras
        Escrituras miEscritura = new Escrituras(101);

        // Agregar los Pagos a la Escritura
        miEscritura.agregarPago(pagoA);
        miEscritura.agregarPago(pagoB);

        // Mostrar la información y el conteo
        miEscritura.mostrarTodosLosPagos();
        System.out.println("Total de pagos registrados: " + miEscritura.contarPagos());
    }
}


