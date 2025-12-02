package co.edu.sena.Semanas.Semana07.servicio;

import java.util.ArrayList;
import co.edu.sena.Semanas.Semana07.modelo.*;
import co.edu.sena.Semanas.Semana07.excepciones.*;

public class SistemaInmobiliaria {

    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Propiedad> propiedades = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) throws EmpleadoDuplicadoException {
        for (Empleado e : empleados) {
            if (e.getNombre().equalsIgnoreCase(empleado.getNombre())) {
                throw new EmpleadoDuplicadoException("Ya existe un empleado llamado " + empleado.getNombre());
            }
        }
        empleados.add(empleado);
    }

    public void agregarPropiedad(Propiedad propiedad) {
        propiedades.add(propiedad);
    }

    public Propiedad buscarPropiedad(String direccion) throws PropiedadNoEncontradaException {
        for (Propiedad p : propiedades) {
            if (p.getDireccion().equalsIgnoreCase(direccion)) {
                return p;
            }
        }
        throw new PropiedadNoEncontradaException("No se encontró la propiedad en " + direccion);
    }

    public void mostrarPropiedades() {
        for (Propiedad p : propiedades) {
            p.mostrarInformacion();
            System.out.println("-------------------------");
        }
    }

    public void mostrarEmpleados() {
        for (Empleado e : empleados) {
            e.mostrarInformacion();
            System.out.println("-------------------------");
        }
    }
}
