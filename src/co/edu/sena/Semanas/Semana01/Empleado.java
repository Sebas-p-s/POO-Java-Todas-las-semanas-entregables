package co.edu.sena.Semanas.Semana01;

public class Empleado {
    private String nombre;
    private String cargo;
    private String tipoDePropiedadEncargada;
    private double salario;
    private int ventasHechas;

    // Constructor
    public Empleado(String nombre, String cargo, String tipoDePropiedadEncargada, double salario, int ventasHechas){
        this.nombre = nombre;
        this.cargo = cargo;
        this.tipoDePropiedadEncargada = tipoDePropiedadEncargada;
        this.salario = salario;
        this.ventasHechas = ventasHechas;
    }

    public void mostrarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Cargo: " + cargo);
        System.out.println("Tipo de propiedad a cargo: " + tipoDePropiedadEncargada);
        System.out.println("Salario: " + String.format("$%.2f", salario));
        System.out.println("Ventas hechas: " + ventasHechas);
    }

    public void ventaHecha(){
         ventasHechas++;
    }

    public boolean esCargoAlto(){
        return salario >= 10_000_000;
    }
    // Getters
    public String getNombre(){
        return nombre;
    }
    public String getCargo(){
        return cargo;
    }
    public String getTipoDePropiedadEncargada(){return tipoDePropiedadEncargada;}
    public double getSalario(){return salario;}
    public int getVentasHechas(){return ventasHechas;}
}

