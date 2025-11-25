# Jerarquía de Clases - Semana 04 (Propiedades)

## Diagrama

        Propiedad
            |
     +------+------+
     |             |
    Casa      Apartamento


## Justificación
Escogí la jerarquía de propiedades porque una inmobiliaria maneja diferentes tipos
de inmuebles, pero todos comparten información básica como dirección, ciudad y valor.

La clase padre “Propiedad” permite reutilizar esa información y evitar repetir código.
Cada subclase añade características propias, manteniendo una estructura clara y flexible.

## Atributos Heredados
- direccion (String)
- ciudad (String)
- valor (double)

## Métodos Sobrescritos
### Casa
- calcularImpuesto(): Aumenta el impuesto a 1.5% por tener más mantenimiento.

### Apartamento
- calcularImpuesto(): Aplica 1.2% por tener costos menores de infraestructura.

## Beneficios de la Herencia
- Evita duplicar código
- Permite usar polimorfismo
- Facilita agregar nuevos tipos de propiedades
