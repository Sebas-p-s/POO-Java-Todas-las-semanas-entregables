package co.edu.sena.Semanas.Semana05;

import java.util.ArrayList;

// maneja empleados usando polimorfismo
public class SistemaInmobiliaria {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado agregado: " + empleado.getNombre() +
                " (" + empleado.getClass().getSimpleName() + ")");
    }

    public void mostrarInformacionEmpleados() {
        System.out.println("\nInformación de empleados:");
        for (Empleado e : empleados) {
            e.mostrarInformacion(); // polimorfismo
            System.out.println("-----------");
        }
    }

    public void evaluarCargosAltos() {
        System.out.println("\nEvaluación de cargos altos:");
        for (Empleado e : empleados) {
            System.out.println(e.getNombre() + " -> " +
                    (e.esCargoAlto() ? "Cargo alto" : "Cargo normal"));
        }
    }
}
