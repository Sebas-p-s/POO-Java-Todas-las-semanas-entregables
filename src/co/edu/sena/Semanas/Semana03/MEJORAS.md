# Mejoras - Semana 03

## Encapsulación Aplicada

### Clase: Propiedad
- Atributos encapsulados: tipoPropiedad, direccion, ciudad, estrato, valor, enVenta
- Validaciones agregadas:
    - `setEstrato(int estrato)`: estrato debe estar entre 1 y 6
    - `setValor(double valor)`: el valor debe ser positivo

### Clase: Cliente
- Atributos encapsulados: Nombre, TipoPropiedadBuscada, DineroActual
- Validaciones agregadas:
    - `setDineroActual(double dineroActual)`: no permite valores negativos

### Clase: Pago
- Atributos encapsulados: cliente, Fecha, Lugar, DineroPagado
- Validaciones agregadas: no se añadieron validaciones

### Clase: Escrituras
- Atributos encapsulados: NumeroEscrituras, pagos
- Validaciones agregadas: no aplica (manejo interno de ArrayList)

---

## Constructores Sobrecargados

### Clase: Propiedad
- Constructor 1: recibe todos los atributos
- Constructor 2: sin ciudad (usa "Sin ciudad") y enVenta = true
- Constructor 3: solo tipoPropiedad; demás datos por defecto

### Clase: Cliente
- Constructor 1: nombre, tipoPropiedadBuscada, dineroActual
- Constructor 2: nombre y tipoPropiedadBuscada (dineroActual = 0)
- Constructor 3: solo nombre; los demás datos se asignan por defecto

### Clase: Pago
- Constructor 1: cliente, fecha, lugar, dineroPagado
- Constructor 2: sin lugar (usa "Sin lugar")
- Constructor 3: sin cliente (cliente = null)

### Clase: Escrituras
- Constructor 1: recibe número de escrituras
- Constructor 2: inicializa número de escrituras en 0

---

## Beneficios Logrados
- Se asegura que los valores ingresados sean válidos mediante validaciones en setters
- Mayor seguridad y control sobre el acceso a los atributos
- Objetos más flexibles gracias a la sobrecarga de constructores
- Código más organizado, legible y fácil de mantener
- Prevención de datos inválidos dentro del sistema
