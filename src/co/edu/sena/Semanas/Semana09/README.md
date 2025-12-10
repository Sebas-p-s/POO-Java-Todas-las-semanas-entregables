# Proyecto Final: Inmobiliaria System

## 👤 Información del Estudiante
- **Nombre**: Juan Sebastian Pachon Sandoval
- **Ficha**: 3228973B
- **Dominio**: [Casas y Apartamentos S.A.]
- **Fecha de entrega**: 9/12/2025

## 📝 Descripción del Sistema

Este proyecto es un sistema pensado para una inmobiliaria. Su objetivo es facilitar la gestión tanto de las propiedades como de los empleados que trabajan con ellas. A través de un menú interactivo, el usuario puede agregar, buscar, listar, actualizar y eliminar información de manera sencilla.

El sistema permite manejar distintos tipos de propiedades, como casas y apartamentos, además de controlar los empleados encargados de su venta o administración. También incluye validaciones, filtros y excepciones personalizadas para evitar errores y mantener la información ordenada.

Este trabajo reúne todo lo aprendido durante el curso de POO: organización del código, uso de clases y objetos, herencia, polimorfismo, colecciones y manejo de errores. Representa el cierre completo del proceso formativo, integrando lo visto semana a semana en un solo proyecto funcional.


## 🧬 Aplicación de Conceptos POO

### Herencia
- Clase padre: `Propiedad`
- Clases hijas: `Casa`, `Apartamento`
- Justificación: Todas las propiedades comparten atributos y métodos comunes (`direccion`, `precio`, `mostrarInformacion`). Las subclases especifican detalles particulares (número de pisos, piso).

### Polimorfismo
- Métodos sobrescritos: `mostrarInformacion()` en `Casa` y `Apartamento`
- Métodos sobrecargados: `agregarPropiedad(String)` y `agregarPropiedad(Propiedad)` en `SistemaInmobiliaria`
- Uso de colecciones polimórficas: Sí, `ArrayList<Propiedad>` permite almacenar tanto `Casa` como `Apartamento` y tratarlas como `Propiedad`.

### Abstracción
- Clase abstracta: `Propiedad`
- Implementaciones: `Casa`, `Apartamento`

### Excepciones Personalizadas
1. `EmpleadoDuplicadoException`: Se lanza cuando se intenta agregar un empleado que ya existe en el sistema.
2. `PropiedadNoEncontradaException`: Se lanza cuando se busca una propiedad que no está registrada.

### Colecciones
- `HashMap<String, Propiedad>`: Para almacenar propiedades y buscarlas rápidamente por dirección (O(1)).
- `ArrayList<Empleado>`: Para almacenar la lista de empleados y permitir recorridos y listados.

---

## 🚀 Cómo Ejecutar

### Requisitos
- Java JDK 11 o superior
- IDE recomendado: IntelliJ IDEA

### Compilación
```bash
cd proyecto-final
javac -d bin src/co/edu/sena/Semanas/Semana09/*/*.java src/co/edu/sena/Semanas/Semana09/*.java
