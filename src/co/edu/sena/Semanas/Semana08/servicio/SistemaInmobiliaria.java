package co.edu.sena.Semanas.Semana08.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import co.edu.sena.Semanas.Semana08.modelo.*;
import co.edu.sena.Semanas.Semana08.excepciones.*;

public class SistemaInmobiliaria {

    // Aqui se usan listas con generics de forma correcta
    private List<Empleado> empleados = new ArrayList<>();
    private List<Propiedad> propiedades = new ArrayList<>();

    // Aqui agregas un HashMap para cumplir el Ejercicio 2
    private Map<String, Propiedad> propiedadesPorDireccion = new HashMap<>();

    // Aqui agregas otro HashMap opcional (bonus)
    private Map<String, List<Propiedad>> propiedadesPorTipo = new HashMap<>();

    // Aqui agregas un empleado con validacion de duplicados
    public void agregarEmpleado(Empleado empleado) throws EmpleadoDuplicadoException {
        for (Empleado e : empleados) {
            if (e.getNombre().equalsIgnoreCase(empleado.getNombre())) {
                throw new EmpleadoDuplicadoException("Ya existe un empleado llamado " + empleado.getNombre());
            }
        }
        empleados.add(empleado);
    }

    // Aqui agregas una propiedad y la registras en los 2 HashMap
    public void agregarPropiedad(Propiedad propiedad) {
        String direccion = propiedad.getDireccion();

        if (propiedadesPorDireccion.containsKey(direccion)) {
            throw new IllegalArgumentException("Ya existe una propiedad registrada en " + direccion);
        }

        propiedades.add(propiedad);
        propiedadesPorDireccion.put(direccion, propiedad);

        String tipo = obtenerTipo(propiedad);

        if (!propiedadesPorTipo.containsKey(tipo)) {
            propiedadesPorTipo.put(tipo, new ArrayList<>());
        }
        propiedadesPorTipo.get(tipo).add(propiedad);
    }

    // Aqui se busca propiedad en O(1) usando HashMap
    public Propiedad buscarPropiedad(String direccion) throws PropiedadNoEncontradaException {
        Propiedad p = propiedadesPorDireccion.get(direccion);
        if (p == null) {
            throw new PropiedadNoEncontradaException("No se encontro la propiedad en " + direccion);
        }
        return p;
    }

    // Aqui se eliminan propiedades tanto de la lista como del HashMap
    public boolean eliminarPropiedad(String direccion) {
        Propiedad p = propiedadesPorDireccion.remove(direccion);
        if (p != null) {
            propiedades.remove(p);

            String tipo = obtenerTipo(p);
            propiedadesPorTipo.get(tipo).remove(p);

            return true;
        }
        return false;
    }

    // Aqui se listan propiedades
    public void mostrarPropiedades() {
        for (Propiedad p : propiedades) {
            p.mostrarInformacion();
            System.out.println("-------------------------");
        }
    }

    // Aqui se listan empleados
    public void mostrarEmpleados() {
        for (Empleado e : empleados) {
            e.mostrarInformacion();
            System.out.println("-------------------------");
        }
    }

    // Aqui se obtiene el tipo usando instanceof
    private String obtenerTipo(Propiedad p) {
        if (p instanceof Casa) return "Casa";
        if (p instanceof Apartamento) return "Apartamento";
        return "Otro";
    }

    // Aqui se filtra por tipo
    public List<Propiedad> filtrarPorTipo(String tipo) {
        return propiedadesPorTipo.getOrDefault(tipo, new ArrayList<>());
    }

    // Aqui se filtra por rango de precio
    public List<Propiedad> filtrarPorPrecio(double min, double max) {
        List<Propiedad> resultado = new ArrayList<>();

        for (Propiedad p : propiedades) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Aqui se calcula el total de precios
    public double calcularTotalVentas() {
        double total = 0;
        for (Propiedad p : propiedades) {
            total += p.getPrecio();
        }
        return total;
    }

    // Aqui se calcula el promedio
    public double calcularPromedio() {
        if (propiedades.isEmpty()) return 0;
        return calcularTotalVentas() / propiedades.size();
    }

    // Aqui se obtiene la propiedad mas cara
    public Propiedad obtenerPropiedadMasCara() {
        if (propiedades.isEmpty()) return null;

        Propiedad max = propiedades.get(0);
        for (Propiedad p : propiedades) {
            if (p.getPrecio() > max.getPrecio()) {
                max = p;
            }
        }
        return max;
    }

    // Aqui se cuentan propiedades por tipo
    public Map<String, Integer> contarPorTipo() {
        Map<String, Integer> conteo = new HashMap<>();

        for (Propiedad p : propiedades) {
            String tipo = obtenerTipo(p);
            conteo.put(tipo, conteo.getOrDefault(tipo, 0) + 1);
        }

        return conteo;
    }
}
