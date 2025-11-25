# Análisis Orientado a Objetos - [Inmobiliaria "Casas y Apartamentos S.A."]

## 1. Identificación del Dominio

**Nombre del negocio:** [Casas y Apartamentos S.A.]
**Tipo:** [Inmobiliaria]
**Descripción:** [Casas y Apartamentos S.A. es una inmobiliaria que ofrece servicios de compra, venta, arriendo y administración de propiedades. Cuenta con 12 asesores inmobiliarios y gestiona un portafolio de más de 200 propiedades.]

## 2. Objetos Identificados

### Objeto Principal: [Propiedad o Inmueble]
**¿Qué es?:** [Es las propiedades o inmuebles que posee la empresa]
**Atributos identificados:**
- atributo1: tipoPropiedad - Es el tipo de propiedad que es el inmueble (Apartamento, Casa, Finca, entre otros.)
- atributo2: direccion - Es la direccion o ubicacion del inmueble
- atributo3: ciudad - Es la ciudad de donde está el inmueble
- atributo4: estrato - Es el estrato al cual pertenece el inmueble según su ubicación
- atributo5: valor - Es el valor o precio del inmueble 
- atributo6: enVenta - Dice si el inmueble esta en venta o no

**Métodos identificados:**
- cuotaInmobiliaria(): Dice cuanto sera el valor a pagar más la cuota que cobra la inmobiliaria
- mostrarInformacion(): Muestra toda la informacion o todos los atributos del objeto
- getTipoPropiedad(): Me entrega el tipo de propiedad del objeto seleccionado
- setEnVenta(): Le puedo colocar a ese atributo que si esta en venta o no

### Objeto Secundario: [Empleado]
**¿Qué es?:** [Son los trabajadores de la empresa.]
**Atributos identificados:**
- atributo1: nombre - Es el nombre completo del empleado
- atributo2: cargo - Es el cargo o ocupacion que tiene el empleado
- atributo3: tipoDePropiedadEncargada - Es el tipo de propiedad que el encargado puede vender
- atributo4: salario - Es el salario que se le paga al trabajador
- atributo5: ventasHechas - Es la cantidad ventas que han hecho los trabajadores

**Métodos identificados:**
- ventaHecha(): Aumenta las ventas hechas de los empleados
- mostrarInformacion(): Muestra toda la información o todos los atributos del objeto
- esCargoAlto(): Dice si es un cargo alto por su salario o si no lo es
- getNombre(): Dice el nombre que corresponde a la persona

## 3. Relación entre Objetos

**Tipo de relación:** [Asociación, composición, etc.]
**Descripción:** Ambos tienen relacion porque ambos pertenecen a una empresa en este contexto serian los trabajadores y propiedades, ademas que los trabajadores administran las propiedades.

Ejemplo: "Un empleado puede estar en que un empleado puede administrar algunas propiedades"

## 4. Justificación del Diseño

**¿Por qué elegí estos objetos?**
Elegi estos objetos porque me parecieron que son los más importantes de esta empresa.

**¿Por qué estos atributos son importantes?**
Porque son los que identifican de buena forma los objetos, además de que algunos sirven para contrastar cuanto se gasta la empresa

**¿Por qué estos métodos son necesarios?**
Porque son los que muestran información además de que algunos administran las propiedades y cuantas ventas ha hecho ciertos empleados a esas propiedades

## 5. Comparación: POO vs Programación Estructurada

**Sin POO (Estructurado):**
Tendria que crear varias variables con diccionarios que definan estos metodos

**Con POO:**
Que ya no tengo que usar diccionarios o muchas variables, sino que tengo mi plantilla que uso cuando quiera crear una

**Ventajas específicas en mi dominio:**
1. Orden
2. Facil de modificar cada objeto
3. Facil de escalar

