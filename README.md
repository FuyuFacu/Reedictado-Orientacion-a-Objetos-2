# Ejercicio 1
>Estudiar en detalle los Code Smells y los Refactoring del libro y una  con flechas los code smells y los refactoring a los que se relacionan.

### Duplicate Code
Este Code Smell puede ser tanto explicito (cuando tiene código idéntico) o preciso (son estructuras o pasos similares que cumplen el mismo propósito).

*Refactoring relacionados según el libro:*

**Form Template Method**
Esto se aplica cuando el código duplicado aparece en subclases. Lo que se hace es agarrar el flujo el cual es común en ambas clases y subirlo a un método plantilla en la superclase, y los pasos los cuales derivan se las subclases y son diferentes se definen como métodos abstractos en la superclase para así cada subclase implementara a su manera.

**Introduce Polymorphic Creation (Factory Method)**
Este se aplica cuando la duplicación en las subclases involucra el crear objetos dentro del flujo que es común.
Lo que se hace es definir un método abstracto de creación en la superclase, entonces cada subclase la implementa para devolver el objeto que le corresponde, manteniendo así el resto del flujo sin cambios.

---
### Large Class




