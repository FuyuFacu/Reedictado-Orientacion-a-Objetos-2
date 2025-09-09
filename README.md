# Ejercicio 1
>Estudiar en detalle los Code Smells y los Refactoring del libro y una  con flechas los code smells y los refactoring a los que se relacionan.

### Duplicate Code
Si se ve la misma estructura de código en mas de un lugar, entonces puede haber una manera en la cual el programa pueda "unificarlos".
El problema mas simple de código duplicado es cuando tengo la misma expresión en dos métodos de la misma clase. Por lo tanto lo que se tiene que hacer es aplicar el refactoring "Extract Method" e invocar ese código en **ambos  lugares**.

Otro problema común de código duplicado es cuando aparece la misma **expresión** pero en dos subclases hermanas. Se puede eliminar dicha duplicación utilizando Extract Method y después haciendo un Pull Up Method. En caso de que el código sea similar **pero no el mismo**, entonces se separa lo similar con lo que difiere. En esos casos se recomienda utilizar un "Form Template Method"

**Form Template Method**
Esto se aplica cuando el código duplicado aparece en subclases. Lo que se hace es agarrar el flujo el cual es común en ambas clases y subirlo a un método plantilla en la superclase, y los pasos los cuales derivan se las subclases y son diferentes se definen como métodos abstractos en la superclase para así cada subclase implementara a su manera.

---
### Large Class




