package co.edu.sena.Semanas.Semana02;

public class Pago {
    private Cliente cliente; // Relacion con clase cliente
    private String Fecha;
    private String Lugar;
    private double DineroPagado;

    // Completo
    public Pago(Cliente cliente, String Fecha, String Lugar, double DineroPagado) {
        this.cliente = cliente;
        this.Fecha = Fecha;
        this.Lugar = Lugar;
        this.DineroPagado = DineroPagado;
    }

    // Sin lugar
    public Pago(Cliente cliente, String Fecha, double DineroPagado) {
        this(cliente, Fecha, "Sin lugar", DineroPagado);
    }

    // Sin cliente (si no quieres relacionarlo)
    public Pago(String Fecha, String Lugar, double DineroPagado) {
        this(null, Fecha, Lugar, DineroPagado);
    }

    public String obtenerInformacion() {
        String info = "===Factura O Pago===\n"
                + "Fecha: " + Fecha + "\n"
                + "Lugar: " + Lugar + "\n"
                + "Dinero que se pago: " + String.format("$%.2f", DineroPagado);
        return info;
    }

    public String getFecha(){
        return Fecha;
    }

    public double dineroRestante(){
        return cliente.getDineroActual() - DineroPagado;
    }

    // Getters
    public Cliente getCliente() { return cliente; }
    public String getLugar() { return Lugar; }
    public double getDineroPagado() { return DineroPagado; }
}
