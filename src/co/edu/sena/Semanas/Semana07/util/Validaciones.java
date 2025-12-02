package co.edu.sena.Semanas.Semana07.util;

import co.edu.sena.Semanas.Semana07.excepciones.PrecioInvalidoException;

public class Validaciones {

    public static void validarPrecio(double precio) throws PrecioInvalidoException {
        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio no puede ser negativo o cero.");
        }
    }
}
