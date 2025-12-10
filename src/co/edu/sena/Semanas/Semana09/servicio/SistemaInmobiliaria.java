package co.edu.sena.Semanas.Semana09.servicio;

import co.edu.sena.Semanas.Semana09.modelo.*;
import co.edu.sena.Semanas.Semana09.excepciones.*;

import java.util.*;

public class SistemaInmobiliaria {

    private HashMap<String, Propiedad> mapaPropiedades = new HashMap<>();
    private ArrayList<Empleado> empleados = new ArrayList<>();

    // Sobrecarga 1
    public void agregarPropiedad(String direccion) {
        mapaPropiedades.put(direccion, null);
    }

    // Sobrecarga 2
    public void agregarPropiedad(Propiedad p) {
        mapaPropiedades.put(p.getDireccion(), p);
    }

    public Propiedad buscarPropiedad(String direccion) throws PropiedadNoEncontradaException {
        if (!mapaPropiedades.containsKey(direccion))
            throw new PropiedadNoEncontradaException("Propiedad no encontrada");
        return mapaPropiedades.get(direccion);
    }

    public boolean actualizarPropiedad(String direccion, double nuevoPrecio) {
        Propiedad p = mapaPropiedades.get(direccion);
        if (p == null) return false;
        if (nuevoPrecio <= 0) return false;
        p.setPrecio(nuevoPrecio);
        return true;
    }

    public boolean eliminarPropiedad(String direccion) {
        return mapaPropiedades.remove(direccion) != null;
    }

    public List<Propiedad> listarPropiedades() {
        return new ArrayList<>(mapaPropiedades.values());
    }

    public List<Propiedad> filtrarPorPrecio(double min, double max) {
        List<Propiedad> lista = new ArrayList<>();
        for (Propiedad p : mapaPropiedades.values()) {
            if (p.getPrecio() >= min && p.getPrecio() <= max)
                lista.add(p);
        }
        return lista;
    }

    public int cantidadPropiedades() {
        return mapaPropiedades.size();
    }

    public double calcularTotalPrecios() {
        double total = 0;
        for (Propiedad p : mapaPropiedades.values()) {
            total += p.getPrecio();
        }
        return total;
    }

    public double calcularPromedioPrecios() {
        if (mapaPropiedades.isEmpty()) return 0;
        return calcularTotalPrecios() / mapaPropiedades.size();
    }

    public Propiedad obtenerPropiedadMasCara() {
        Propiedad masCara = null;
        for (Propiedad p : mapaPropiedades.values()) {
            if (masCara == null || p.getPrecio() > masCara.getPrecio())
                masCara = p;
        }
        return masCara;
    }

    public Map<String, Integer> contarPorTipo() {
        Map<String, Integer> mapa = new HashMap<>();
        for (Propiedad p : mapaPropiedades.values()) {
            String tipo = p.getClass().getSimpleName();
            mapa.put(tipo, mapa.getOrDefault(tipo, 0) + 1);
        }
        return mapa;
    }

    public String generarReporteResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== REPORTE INMOBILIARIA ===\n");
        sb.append("Total propiedades: ").append(cantidadPropiedades()).append("\n");
        sb.append("Total precios: ").append(calcularTotalPrecios()).append("\n");
        sb.append("Promedio precios: ").append(calcularPromedioPrecios()).append("\n");
        sb.append("Conteo por tipo: ").append(contarPorTipo()).append("\n");
        return sb.toString();
    }

    // Empleados
    public void agregarEmpleado(Empleado e) throws EmpleadoDuplicadoException {
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(e.getNombre()))
                throw new EmpleadoDuplicadoException("Empleado ya existe");
        }
        empleados.add(e);
    }

    public List<Empleado> listarEmpleados() {
        return empleados;
    }
}
