package co.edu.sena.Semanas.Semana07.modelo;

public class Gerente extends Empleado {

    private double bonoMensual;

    public Gerente(String nombre, String cargo, String tipoDePropiedadEncargada,
                   double salario, int ventasHechas, double bonoMensual) {
        super(nombre, cargo, tipoDePropiedadEncargada, salario, ventasHechas);
        this.bonoMensual = bonoMensual;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Gerente:");
        super.mostrarInformacion();
        System.out.println("Bono mensual: " + bonoMensual);
    }

    @Override
    public boolean esCargoAlto() {
        return true;
    }
}
