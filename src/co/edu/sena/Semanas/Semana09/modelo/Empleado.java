package co.edu.sena.Semanas.Semana09.modelo;

public class Empleado {
    private String nombre;
    private String cargo;
    private String tipoPropiedadEncargada;
    private double salario;
    private int ventas;

    public Empleado(String nombre, String cargo, String tipoPropiedadEncargada, double salario, int ventas) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.tipoPropiedadEncargada = tipoPropiedadEncargada;
        this.salario = salario;
        this.ventas = ventas;
    }

    public String getNombre() { return nombre; }
    public String getCargo() { return cargo; }
    public String getTipoPropiedadEncargada() { return tipoPropiedadEncargada; }
    public double getSalario() { return salario; }
    public int getVentas() { return ventas; }

    public void mostrarInformacion() {
        System.out.println("Empleado: " + nombre +
                "\nCargo: " + cargo +
                "\nTipo encargado: " + tipoPropiedadEncargada +
                "\nSalario: " + salario +
                "\nVentas: " + ventas);
    }
}
