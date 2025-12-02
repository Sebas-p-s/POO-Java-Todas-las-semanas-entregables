package co.edu.sena.Semanas.Semana07.modelo;

public class AgenteVentas extends Empleado {

    private int propiedadesVendidas;

    public AgenteVentas(String nombre, String cargo, String tipoDePropiedadEncargada,
                        double salario, int ventasHechas, int propiedadesVendidas) {
        super(nombre, cargo, tipoDePropiedadEncargada, salario, ventasHechas);
        this.propiedadesVendidas = propiedadesVendidas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Agente de ventas:");
        super.mostrarInformacion();
        System.out.println("Propiedades vendidas: " + propiedadesVendidas);
    }

    @Override
    public boolean esCargoAlto() {
        return getSalario() >= 8_000_000;
    }
}
