# Análisis de Diseño - Semana 06: Sistema Inmobiliario

## 1. Identificación de Abstracciones

### Clase Abstracta: PropiedadInmobiliaria

**Razón de abstracción:**
- Representa el concepto general de propiedad dentro de la inmobiliaria.
- Todas las propiedades tienen `dirección` y `precioBase`.
- El cálculo del impuesto varía según el tipo de propiedad (Casa, Apartamento).

**Jerarquía:**

PropiedadInmobiliaria  
├── Casa  
└── Apartamento

## 2. Interfaces Implementadas

### Interface 1: Vendible
**Capacidad:** Representa que una propiedad puede venderse.

Implementaciones:
- **Casa**: se vende siempre.
- **Apartamento**: también puede venderse.

### Interface 2: Alquilable
**Capacidad:** Representa que una propiedad puede alquilarse.

Implementaciones:
- **Apartamento**: algunos apartamentos pueden ser alquilados.
    - Este caso demuestra *múltiple implementación*.

### Interface 3: Calificable
**Capacidad:** Permite calificar servicios en la inmobiliaria.

Implementaciones:
- **ServicioFotografia**: permite registrar calificaciones de un servicio.

## 3. Decisiones de Diseño

### Clase abstracta vs Interface
Se usó **clase abstracta** para propiedades porque:
- Existe relación “es-una propiedad”.
- Necesitan atributos compartidos (dirección, precioBase).
- Hay comportamiento común (mostrarInformacion()).

Se usaron **interfaces** para:
- Capacidades independientes (vender, alquilar, calificar).
- Permitir múltiple implementación.
- No hay necesidad de atributos, solo contratos.

## 4. Principios SOLID aplicados

### ✔ SRP (Responsabilidad Única)
Cada clase tiene una función clara: Casa vende, Apartamento vende/alquila, Propiedad define lo común.

### ✔ OCP (Abierto/Cerrado)
Puedo añadir nuevos tipos de propiedad (LocalComercial, Oficina) sin modificar las clases existentes.

### ✔ LSP (Sustitución de Liskov)
Casa y Apartamento pueden usarse sin problema como PropiedadInmobiliaria.

### ✔ ISP (Segregación de Interfaces)
Las interfaces son pequeñas y específicas: las clases no implementan métodos innecesarios.

### ✔ DIP (Inversión de Dependencias)
El Main trabaja con **interfaces** en lugar de clases concretas.

## 5. Mejoras logradas
- Se agregó abstracción real.
- Se incorporó polimorfismo por interfaces.
- El código es más escalable y fácil de mantener.

## 6. Diagrama de Clases

