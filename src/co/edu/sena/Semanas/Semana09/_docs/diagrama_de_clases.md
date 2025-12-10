## 🏗️ Arquitectura del Proyecto

> ¡Si no es bien visible recomiendo descargarlo y verlo en un editor de texto!

Diagrama de Clases
===========================================================
                DIAGRAMA UML - SISTEMA INMOBILIARIO
===========================================================

                   +----------------------+
                   |      Propiedad       | <<abstract>>
                   +----------------------+
                   | - direccion: String  |
                   | - precio: double     |
                   +----------------------+
                   | + getDireccion()     |
                   | + getPrecio()        |
                   | + setPrecio()        |
                   | + mostrarInformacion()*
                   +----------------------+
                      ^              ^
                      |              |
     +----------------+              +----------------+
     |                                               |
+--------------+                               +------------------+
|     Casa     |                               |   Apartamento    |
+--------------+                               +------------------+
| - pisos: int |                               | - piso: int      |
+--------------+                               +------------------+
| + getPisos() |                               | + getPiso()       |
| + mostrarInformacion()                       | + mostrarInformacion()
+--------------+                               +------------------+


+--------------------------------------------------------------+
|                          Empleado                            |
+--------------------------------------------------------------+
| - nombre: String                                             |
| - cargo: String                                              |
| - tipoPropiedadEncargada: String                             |
| - salario: double                                            |
| - ventas: int                                                |
+--------------------------------------------------------------+
| + getNombre()                                                |
| + getCargo()                                                 |
| + getTipoPropiedadEncargada()                                |
| + getSalario()                                               |
| + getVentas()                                                |
| + mostrarInformacion()                                       |
+--------------------------------------------------------------+


+--------------------------------------------------------------------------+
|                          SistemaInmobiliaria                             |
+--------------------------------------------------------------------------+
| - mapaPropiedades: HashMap<String, Propiedad>                            |
| - empleados: ArrayList<Empleado>                                         |
+--------------------------------------------------------------------------+
| + agregarPropiedad(String)                                               |
| + agregarPropiedad(Propiedad)                                           |
| + buscarPropiedad(String)                                               |
| + eliminarPropiedad(String)                                             |
| + actualizarPropiedad(String, double)                                   |
| + listarPropiedades()                                                   |
| + filtrarPorPrecio(double, double)                                      |
| + cantidadPropiedades()                                                 |
| + calcularTotalPrecios()                                                |
| + calcularPromedioPrecios()                                             |
| + obtenerPropiedadMasCara()                                             |
| + contarPorTipo()                                                       |
| + generarReporteResumen()                                               |
| + agregarEmpleado(Empleado)                                             |
| + listarEmpleados()                                                     |
+--------------------------------------------------------------------------+

Relaciones:
-----------
Propiedad <|-- Casa
Propiedad <|-- Apartamento
SistemaInmobiliaria --> Propiedad (gestiona)
SistemaInmobiliaria --> Empleado (registra)
Main --> SistemaInmobiliaria (usa)
Main --> Propiedad
Main --> Empleado

Excepciones:
------------
+----------------------------------+
| EmpleadoDuplicadoException       |
| (extends Exception)              |
+----------------------------------+

+----------------------------------+
| PropiedadNoEncontradaException   |
| (extends Exception)              |
+----------------------------------+


===========================================================


### Estructura de Paquetes

Paquetes:
---------
co.edu.sena.Semanas.Semana09
├── modelo
│   ├── Propiedad
│   ├── Casa
│   ├── Apartamento
│   └── Empleado
├── servicio
│   └── SistemaInmobiliaria
├── excepciones
│   ├── EmpleadoDuplicadoException
│   └── PropiedadNoEncontradaException
└── util
└── Main


