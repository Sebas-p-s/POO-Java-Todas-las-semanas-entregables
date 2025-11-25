package co.edu.sena.Semanas.Semana02;
import java.util.ArrayList;

public class Escrituras {
    private int NumeroEscrituras;
    private ArrayList<Pago> pagos;

    // Completo
    public Escrituras(int NumeroEscrituras) {
        this.NumeroEscrituras = NumeroEscrituras;
        this.pagos = new ArrayList<>();
    }

    // Constructor por defecto
    public Escrituras() {
        this(0);
    }

    public void agregarPago(Pago pago){
        pagos.add(pago);
    }

    public void mostrarTodosLosPagos() {
        for (Pago pago : pagos) {
            System.out.println(pago.obtenerInformacion());
        }
    }

    public int contarPagos() {
        return pagos.size();
    }

    // Getters
    public int getNumeroEscrituras() { return NumeroEscrituras; }
    public ArrayList<Pago> getPagos() { return pagos; }
}
