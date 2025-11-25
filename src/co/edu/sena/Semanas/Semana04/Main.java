package co.edu.sena.Semanas.Semana04;

public class Main {
    public static void main(String[] args) {
        // Creamos el arreglo
        Propiedad[] propiedades = new Propiedad[3];
        // Metemos los datos en el arreglo
        propiedades[0] = new Casa("Calle 10 #5-22", "Bogotá", 250_000_000, 2);
        propiedades[1] = new Apartamento("Cra 15 #80-12", "Medellín", 180_000_000, 7);
        propiedades[2] = new Casa("Av. Siempre Viva 742", "Cali", 320_000_000, 1);
        // Usamos un for para ver la lista de arreglos
        for (Propiedad p : propiedades) {
            p.mostrarInformacion();
            System.out.println("Impuesto: $" + p.calcularImpuesto());
            System.out.println("-------------------------");
        }
    }
}
