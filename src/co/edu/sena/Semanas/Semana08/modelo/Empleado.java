package co.edu.sena.Semanas.Semana08.modelo;

public class Empleado {
    private String nombre;
    private String cargo;
    private String tipoDePropiedadEncargada;
    private double salario;
    private int ventasHechas;

    public Empleado(String nombre, String cargo, String tipoDePropiedadEncargada,
                    double salario, int ventasHechas) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.tipoDePropiedadEncargada = tipoDePropiedadEncargada;
        this.salario = salario;
        this.ventasHechas = ventasHechas;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cargo: " + cargo);
        System.out.println("Tipo de propiedad a cargo: " + tipoDePropiedadEncargada);
        System.out.println("Salario: $" + salario);
        System.out.println("Ventas hechas: " + ventasHechas);
    }

    public void ventaHecha() {
        ventasHechas++;
    }

    public boolean esCargoAlto() {
        return salario >= 10_000_000;
    }

    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }
}
