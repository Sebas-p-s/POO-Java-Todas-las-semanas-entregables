package co.edu.sena.Semanas.Semana06.implementaciones;

import co.edu.sena.Semanas.Semana06.interfaces.Calificable;
import java.util.ArrayList;

public class ServicioFotografia implements Calificable {

    private ArrayList<Integer> calificaciones = new ArrayList<>();

    @Override
    public void agregarCalificacion(int estrellas) {
        calificaciones.add(estrellas);
    }

    @Override
    public double obtenerPromedioCalificaciones() {
        return calificaciones.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }
}
