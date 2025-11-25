package co.edu.sena.Semanas.Semana01;

public class Propiedad {
    // Mis 6 atributos de una inmobiliaria
    private String tipoPropiedad;
    private String direccion;
    private String ciudad;
    private int estrato;
    private double valor;
    private boolean enVenta;


    // Constructor completo
    public Propiedad(String tipoPropiedad, String direccion, String ciudad, int estrato, double valor, boolean enVenta) {
        this.tipoPropiedad = tipoPropiedad;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estrato = estrato;
        this.valor = valor;
        this.enVenta = enVenta;
    }

    // Constructor sin ciudad
    public Propiedad(String tipoPropiedad, String direccion, int estrato, double valor) {
        this(tipoPropiedad, direccion, "Sin ciudad", estrato, valor, true);
    }

    // Constructor mínimo
    public Propiedad(String tipoPropiedad) {
        this(tipoPropiedad, "Sin dirección", "Sin ciudad", 1, 0.0, true);
    }

    // Aqui creamos una funcion que muestra la informacion(metodo void)
    public void mostrarInformacion() {
        System.out.println("==== PROPIEDAD ====");
        System.out.println("Tipo de propiead: " + tipoPropiedad);
        System.out.println("Dirección: " + direccion);
        System.out.println("Estrato: " + estrato);
        System.out.println("Valor: " + String.format("$%.2f",valor));
        System.out.println("Estado: " + (enVenta ? "En venta" : "No esta en venta" ));
    }

    // Aqui creo una funcion de calculo sobre la cuota del 10% que cobra la inmobiliaria
    public double cuotaInmobiliaria() {
        return  valor * 1.10;
    }

    // Getters
    public String getTipoPropiedad() { return tipoPropiedad; }
    public String getDireccion() { return direccion; }
    public String getCiudad() { return ciudad; }
    public int getEstrato() { return estrato; }
    public double getValor() { return valor; }
    public boolean isEnVenta() { return enVenta; }

    // Setter
    public void setEnVenta(boolean enVenta) {
        this.enVenta = enVenta;
    }
    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor debe ser positivo");
        }
        this.valor = valor;
    }
    public void setEstrato(int estrato) {
        if (estrato < 1 || estrato > 6) {
            throw new IllegalArgumentException("Estrato inválido");
        }
        this.estrato = estrato;
    }


}
