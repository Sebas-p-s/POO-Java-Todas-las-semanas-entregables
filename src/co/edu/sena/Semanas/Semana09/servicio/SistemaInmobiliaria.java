package co.edu.sena.Semanas.Semana09.servicio;

import co.edu.sena.Semanas.Semana09.modelo.*;
import co.edu.sena.Semanas.Semana09.excepciones.*;

import java.util.*;

public class SistemaInmobiliaria {

    private List<Empleado> empleados = new ArrayList<>();
    private List<Propiedad> propiedades = new ArrayList<>();

    private Map<String, Empleado> empleadosPorNombre = new HashMap<>();
    private Map<String, Propiedad> propiedadesPorDireccion = new HashMap<>();

    // Agregar empleado
    public void agregarEmpleado(Empleado empleado) throws EmpleadoDuplicadoException {
        String key = empleado.getNombre().toLowerCase();
        if (empleadosPorNombre.containsKey(key)) {
            throw new EmpleadoDuplicadoException("Ya existe un empleado llamado " + empleado.getNombre());
        }
        empleados.add(empleado);
        empleadosPorNombre.put(key, empleado);
    }

    // Buscar empleado
    public Empleado buscarEmpleado(String nombre) {
        if (nombre == null) return null;
        return empleadosPorNombre.get(nombre.toLowerCase());
    }

    // Eliminar empleado
    public boolean eliminarEmpleado(String nombre) {
        if (nombre == null) return false;
        String key = nombre.toLowerCase();
        Empleado e = empleadosPorNombre.remove(key);
        if (e != null) {
            empleados.remove(e);
            return true;
        }
        return false;
    }

    // Agregar propiedad
    public void agregarPropiedad(Propiedad propiedad) {
        String key = propiedad.getDireccion().toLowerCase();
        if (propiedadesPorDireccion.containsKey(key)) {
            throw new IllegalArgumentException("Ya existe una propiedad en: " + propiedad.getDireccion());
        }
        propiedades.add(propiedad);
        propiedadesPorDireccion.put(key, propiedad);
    }

    // Buscar propiedad
    public Propiedad buscarPropiedad(String direccion) throws PropiedadNoEncontradaException {
        if (direccion == null) throw new PropiedadNoEncontradaException("Direccion invalida");

        Propiedad p = propiedadesPorDireccion.get(direccion.toLowerCase());

        if (p == null)
            throw new PropiedadNoEncontradaException("No se encontro propiedad en: " + direccion);

        return p;
    }

    // Actualizar propiedad
    public boolean actualizarPropiedad(String direccion, double nuevoPrecio) {
        Propiedad p = propiedadesPorDireccion.get(direccion.toLowerCase());

        if (p == null) return false;

        propiedades.remove(p);

        Propiedad nueva;

        if (p instanceof Casa c)
            nueva = new Casa(c.getDireccion(), nuevoPrecio, c.getPisos());
        else
            nueva = new Apartamento(p.getDireccion(), nuevoPrecio, ((Apartamento) p).getPiso());

        propiedades.add(nueva);
        propiedadesPorDireccion.put(direccion.toLowerCase(), nueva);
        return true;
    }

    // Eliminar propiedad
    public boolean eliminarPropiedad(String direccion) {
        Propiedad p = propiedadesPorDireccion.remove(direccion.toLowerCase());
        if (p != null) {
            propiedades.remove(p);
            return true;
        }
        return false;
    }

    // Listar
    public List<Propiedad> listarPropiedades() {
        return new ArrayList<>(propiedades);
    }

    // Filtros
    public List<Propiedad> filtrarPorPrecio(double min, double max) {
        List<Propiedad> r = new ArrayList<>();
        for (Propiedad p : propiedades) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) r.add(p);
        }
        return r;
    }

    public double calcularTotalPrecios() {
        double total = 0;
        for (Propiedad p : propiedades) total += p.getPrecio();
        return total;
    }

    public double calcularPromedioPrecios() {
        return propiedades.isEmpty() ? 0 : calcularTotalPrecios() / propiedades.size();
    }

    public Propiedad obtenerPropiedadMasCara() {
        if (propiedades.isEmpty()) return null;
        Propiedad max = propiedades.get(0);
        for (Propiedad p : propiedades)
            if (p.getPrecio() > max.getPrecio()) max = p;
        return max;
    }

    public Map<String, Integer> contarPorTipo() {
        Map<String, Integer> m = new HashMap<>();
        for (Propiedad p : propiedades) {
            String tipo = (p instanceof Casa) ? "Casa" : "Apartamento";
            m.put(tipo, m.getOrDefault(tipo, 0) + 1);
        }
        return m;
    }

    public String generarReporteResumen() {
        return "Reporte:\nTotal propiedades: " + propiedades.size() +
                "\nTotal precios: " + calcularTotalPrecios() +
                "\nPromedio: " + calcularPromedioPrecios() +
                "\nConteo por tipo: " + contarPorTipo();
    }

    public int cantidadPropiedades() { return propiedades.size(); }
}
