package co.edu.sena.Semanas.Semana05;

public class Main {
    public static void main(String[] args) {

        // Crear el sistema
        SistemaInmobiliaria sistema = new SistemaInmobiliaria();

        // Crear empleados
        Empleado empleado1 = new Empleado(
                "Carlos Pérez",
                "Asesor",
                "Apartamentos",
                5_000_000,
                10
        );

        AgenteVentas agente1 = new AgenteVentas(
                "María López",
                "Agente Senior",
                "Casas",
                7_500_000,
                20,
                8
        );

        Gerente gerente1 = new Gerente(
                "Laura Gómez",
                "Gerente General",
                "Oficinas",
                12_000_000,
                5,
                2_000_000
        );

        // Agregar empleados al sistema
        sistema.agregarEmpleado(empleado1);
        sistema.agregarEmpleado(agente1);
        sistema.agregarEmpleado(gerente1);

        // Mostrar información completa de empleados
        System.out.println("======================================");
        System.out.println("Información de empleados:");
        sistema.mostrarInformacionEmpleados();

        // Evaluar cargos altos usando polimorfismo
        System.out.println("======================================");
        System.out.println("Evaluación de cargos altos:");
        sistema.evaluarCargosAltos();

        // Probar los métodos sobrecargados
        System.out.println("======================================");
        System.out.println("Métodos sobrecargados:");
        empleado1.informacionImportanteEmpleado(empleado1.getNombre());
        empleado1.informacionImportanteEmpleado(empleado1.getNombre(), empleado1.getCargo());

        // Registrar una venta nueva
        System.out.println("======================================");
        System.out.println("Registrando una nueva venta del agente...");
        agente1.ventaHecha();
        agente1.mostrarInformacion();
    }
}
