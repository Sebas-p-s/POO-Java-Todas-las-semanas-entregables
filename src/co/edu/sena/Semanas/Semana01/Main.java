package co.edu.sena.Semanas.Semana01;


public class Main {
    public static void main(String[] args) {
        // Creamos la propiedades
        Propiedad pro1 = new Propiedad("Casa","Cll 122 #82-10","Bogota", 3,350_000_000,true);
        Propiedad  pro2 = new Propiedad("Apartamento", "Calle 67 #10-22","Cali", 4,500_000_00,true);

        // Creamos los empleados
        Empleado emp1 = new Empleado("Carlos Rodriguez", "Gerente", "Casas", 12_000_000,5);
        Empleado emp2 = new Empleado("Laura Rodriguez", "Secretaria","Apartamentos",2_500_000,0);

        //Metodos de mostrar informacion
        System.out.println("=====PROPIEDADES=====");
        pro1.mostrarInformacion();
        System.out.println();
        pro2.mostrarInformacion();
        System.out.println();

        System.out.println("=====EMPLEADOS=====");
        emp1.mostrarInformacion();
        System.out.println();
        emp2.mostrarInformacion();
        System.out.println();

        //Metodos para cambiar atributos de mis objetos
        System.out.println("-QUITAMOS QUE ESTE EN VENTA-");
        pro2.setEnVenta(false);
        pro2.mostrarInformacion();
        System.out.println();

        System.out.println("-LA EMPLEADA LAURA VENDIO ESE APARTAMENTO-");
        emp2.ventaHecha();
        emp2.mostrarInformacion();
        System.out.println();

        // Aqui usamos un getter y un metodo para saber algo de un objeto
        System.out.println("¿Es " + emp1.getNombre() + " un empleado importante? " + emp1.esCargoAlto() );


    }
}