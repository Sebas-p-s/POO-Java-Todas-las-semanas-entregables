package co.edu.sena.Semanas.Semana02;

public class Cliente {
    private String Nombre;
    private String TipoPropiedadBuscada;
    private double DineroActual;

    // Completo
    public Cliente(String Nombre, String TipoPropiedadBuscada, double DineroActual) {
        this.Nombre = Nombre;
        this.TipoPropiedadBuscada = TipoPropiedadBuscada;
        this.DineroActual = DineroActual;
    }

    // Solo nombre + propiedad buscada
    public Cliente(String Nombre, String TipoPropiedadBuscada) {
        this(Nombre, TipoPropiedadBuscada, 0.0);
    }

    // Solo nombre
    public Cliente(String Nombre) {
        this(Nombre, "Sin preferencia", 0.0);
    }

    public void obtenerInformacion(){
        System.out.println("===Cliente===");
        System.out.println("Nombre: " + Nombre);
        System.out.println("Tipo de propiedad buscada: " + TipoPropiedadBuscada);
        System.out.println("Dinero que posee actualmente: " + String.format("$%.2f", DineroActual));
    }

    // Getters
    public String getNombre() { return Nombre; }
    public String getTipoPropiedadBuscada() { return TipoPropiedadBuscada; }
    public double getDineroActual() { return DineroActual; }

    // Setter Modificado
    public void setDineroActual(double dineroActual){
        if (dineroActual < 0) {
            throw new IllegalArgumentException("El dinero no puede ser negativo");
        }
        this.DineroActual = dineroActual;
    }

}
