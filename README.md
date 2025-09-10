# Ejercicio 1
>Estudiar en detalle los Code Smells y los Refactoring del libro y una  con flechas los code smells y los refactoring a los que se relacionan.

### Duplicate Code
Si se ve la misma estructura de código en mas de un lugar, entonces puede haber una manera en la cual el programa pueda "unificarlos".
El problema mas simple de código duplicado es cuando tengo la misma expresión en dos métodos de la misma clase. Por lo tanto lo que se tiene que hacer es aplicar el refactoring "Extract Method" e invocar ese código en **ambos  lugares**.

Otro problema común de código duplicado es cuando aparece la misma **expresión** pero en dos subclases hermanas. Se puede eliminar dicha duplicación utilizando Extract Method y después haciendo un Pull Up Method. En caso de que el código sea similar **pero no el mismo**, entonces se separa lo similar con lo que difiere. En esos casos se recomienda utilizar un "Form Template Method"

**Form Template Method**
Esto se aplica cuando el código duplicado aparece en subclases. Lo que se hace es agarrar el flujo el cual es común en ambas clases y subirlo a un método plantilla en la superclase, y los pasos los cuales derivan se las subclases y son diferentes se definen como métodos abstractos en la superclase para así cada subclase implementara a su manera.

>Otra alternativa seria cuando yo tengo dos clases que poseen código duplicado pero no están relacionadas. Lo que se debe hacer es aplicar "Extract Class" y entonces invocar esa clase en ambas.

---
### Large Class
Cuando una clase intenta hacer varias cosas, realmente se nota porque posee varias variables de instancia y métodos largos con código repetido. Esto puede generar code smells como la duplicación de código y que sea muy complejo.
Es por eso que se utiliza "Extract Class" para poder agrupar esas variables en otras clases que las cuales tengan mas sentido y que cumplan cierto propósito dentro de ellas.  Prefijos o sufijos que son comunes en un subconjunto de variables o métodos pueden indicar que ese conjunto puede extraerse.

Si un conjunto de variables o métodos pertenecen a un "tipo especializado" de clase, se puede convertir en subclase. A veces es mas fácil el extract class cuando existe una relación jerárquica natural.

Se puede utilizar también "Extract Interface" cuando hay distintos clientes que usan la clase de una manera diferente, esto permite separar responsabilidades y reducir acoplamiento.

---
### Long Method
Desde los primeros días de programación la gente llega a la conclusion de que, a medida que el proceso es mas largo, mas complicado es entenderlo.
La idea central es que los métodos que son cortos y tienen un buen nombre hacen que los programas Orientados a Objetos puedan ser mas claros, mantenibles y duraderos en el tiempo.
El problema no es la longitud, sino la distancia **semántica** entre lo que hace el método y como lo hace.

Las ventajas de los métodos pequeños es que explican mejor la intención del código mediante nombres de métodos, facilitan la reutilización y reemplazo del código y mejoran la legibilidad del mismo, ya que se puede entender el propósito sin tener que mirar la implementacion.

**Estrategias a utilizar:**
*Extract Method:* Lo que se hace es identificar los bloques de código que deberían ir juntos y convertirlos en métodos con nombres que sean claros, los cuales expliquen bien el propósito del mismo.
*Replace Temp with Query:* Si existen muchas variables temporales que lo que hacen es que complican la extracción, entonces se reemplazan con otros métodos que las calculen.
*Introduce Parameter Object:* si la lista de los parámetros es muy larga, entonces se encapsulan en un objeto.
*Replace method with Method Object:*  Esto es cuando todo lo anteriormente mencionado falla, y el método es demasiado grande o complejo.

>Acá quiero hacer una aclaración sobre este code smell ya que menciona una heuristica muy interesante:
>Cada vez que necesites un comentario para tener que explicar el código, ten en consideración extraer un método el cual su nombre refleje la intención del mismo.

---

### Data Class
Es una clase que solo posee datos, y getters y setters para esos datos, pero no poseen un comportamiento propio. O sea no sabe hacer nada por si misma, sino que solo guarda información que otras clases utilizan y manipulan.
Cuando otras clases manipulan exageradamente los campos de esta Data Class, el código se vuelve frágil y acoplado.

**Refactoring a aplicar:**
*Encapsulate field:* Si tenes campos públicos, entonces se convierten en privados y se controla su acceso con getters/setters.

*Encapsulate Collection:* Si los campos son colecciones, hay que asegurarse de que estos estén correctamente encapsulados para que otras clases no los manipulen de manera directa.

*Remove Setting Method:* Si los campos son colecciones, hay que asegurarse de que estén correctamente encapsuladas para que otras clases no las manipulen directamente.

*Mover comportamiento a la Data Class:* Buscar métodos que usen getters/setters en otras clases y aplica **Move Method** para trasladar la lógica a la Data Class. En caso de que solo una parte lógica puede moverse, primero utiliza **Extract Method** y luego mueve ese nuevo método.

*Hide Method:* Una vez que la lógica se ha movida y la Data Class es mas "inteligente", se puede ocultar el acceso directo a getters/setters innecesarios.

---
### Feature Envy
Un método parece estar mas interesado en los datos de otras clase que en los de la propia. Un ejemplo claro seria que un método llama repetidamente a getters y setters de otro objeto para así poder calcular un valor.
El problema es que la lógica estaría "celosa" de otra clase, esto rompe el encapsulamiento y dificulta el mantenimiento: cada cambio en la otra clase con los datos puede afectar métodos de otras.

**Refactoring:**
*Move Method:* Trasladar el método a la clase que posee la mayoría de los datos que utiliza.
*Pasos Extra:* Usar Extract Method para separar la parte que es celosa y mover luego solo esa parte a la clase concreta.

---
### Long Parameter List
Un método con demasiados parámetros es difícil de leer, de mantener, y cuando quieres hacer un cambio, tienes que modificar todas las llamadas.
Existen varios Refactorings que se pueden utilizar dependiendo de la situación:

*Replace Parameter with Method:* Si un parámetro se puede obtener simplemente pidiéndoselo a un objeto que ya conoce, entonces mejor reemplazarlo por esa llamada y eliminar el parámetro.
*Preserve Whole Object:* Si estas pasando varios atributos de un mismo objeto, es preferible pasar el objeto completo directamente.
*Introduce Parameter Object:* Si ya se tiene un grupo de parámetros que viajan juntos todo el rato pero no tiene un objeto que los represente, se crea uno nuevo.

---
### Switch Statement
El problema cuando hay muchos switch o  if-else repetidos es que, al agregar un nuevo caso, se tienen que modificar todos esos lugares relacionados. Esto lo que lleva es a duplicación y termina siendo frágil el código.
La solución a este problema es usar polimorfismo para reemplazar el `switch`, identificar el método cuyo comportamiento depende del type code y entonces mover ahí la lógica.

**Refactorings:**
*Replace Type Code with Sub classes:* Seria crear una jerarquía de clases
*Replace Type Code with State/Strategy:* Aplicar composición o strategy dependiendo de si cambia el type code en tiempo de ejecución o no.

>Posterior a eso aplicar `Replace Conditional with polymorfism`

Existen excepciones. Si hay pocos casos, afectan a un solo método y no van a cambiar seguido, el polimorfismo seria overkill.

**En esos casos, se podrían utilizar:**
- Replace parameter with Explicit Methods.
- Introduce Null object (en caso de que algunos casos pregunte si es un objeto nulo).


![[Pasted image 20250910125341.png]]

# Ejercicio 0
>Estudie los refactorings listados del libro “Refactoring - Improving The Design of Existing Code” de Martin Fowler y liste el conjunto de pre condiciones para cada uno

● Rename Variable/field
● Rename Method 
● Extract Method 
● Move Method 
● Replace Conditional with Polymorphism 
● Replace temp with query 
● Pull Up Field 
● Pull up Method

---
**Rename Variable/field**
- El nuevo nombre refleja mejor lo que hace y no genera ambigüedad.
- No se genera conflicto con otros identificadores que tengan el mismo alcance.
- Todas las referencias a la variable o campo pueden ser actualizadas de manera consistente.
- No se rompe ninguna convención o contrato externo

---
**Rename Method**
- El nuevo nombre describe claramente lo que le corresponde al método.
- Ninguna otra sobrecarga de la misma clase tendrá conflicto de nombre.
- Todas las llamadas al método pueden ser actualizadas.
- El método no es parte de una API publica estable donde el cambio rompa clientes externos.

**Pasos a aplicar para poder implementar este refactoring:**
 - Primero hay que verificar que el método que se va rebombar existe en una superclase o subclase. Si es así el caso, entonces se debe aplicar el renombrado en todas las implementaciones de esa jerarquía. Si no existe, se puede renombrar solo en donde esta.
 - Declara un nuevo método con el nuevo nombre, copie el cuerpo del método viejo al nuevo, y haz las alteraciones necesarias para que quepa.
 - Compila
 - Cambia el cuerpo del viejo método para que simplemente haga una llamada al nuevo.
 - Compila y test.
 - Encuentra todas las referencias del método viejo y cámbialas al nuevo método. Compila y testea por cada cambio.
 - Elimina el método viejo.
 - Compila y testea.


---
**Extract Method**
- El fragmento de código que se extrae no depende de demasiadas variables locales externas.
- Las variables que usa pueden pasarse como parámetros o declararse dentro del nuevo método.
- El fragmento aparece en un solo bloque lógico, o sea, con un propósito claro.
- No rompe invariantes del objeto.

**Pasos a aplicar para poder implementar este refactoring:**
- Crear un nuevo método, y nombrarlo con la intención del mismo (nombrarlo por lo que hace, no por como).
- Copiar el código extraído del método raíz al nuevo método.
- Analiza el código extraído en busca de referencias a cualquier variable que sea local al método original. Estas son las variables y parámetros del método.
- Revisa las variables temporales que son SOLO utilizadas en el código extraído. Si es así, declararlas en el método nuevo como variables temporales.
- Mira si alguna de estas variables locales es modificada por el código que se quiere extraer. Si solo se modifica una variable, chequea si puedes tratar el código extraído como query (consulta) que devuelve un valor, y luego asignar ese valor a la variable correspondiente. Si esto resulta incomodo, o si hay mas de una variable modificada, no puedes extraer el método tal como esta. En ese caso , puede que se necesite usar Split Temporary Variable y luego intentar extraer el método nuevamente. También podes eliminar variables temporales usando Replace Temp with Query.
- Pasa al método nuevo como parámetros las variables locales que son leídas en el código extraído.
- Compila cuando ya te has encargado con todas las variables con alcance local.
- Reemplaza el código extraído de el método raíz por una llamada el método nuevo.
- Compila y testea.


---
**Move Method**
- El método usa mas datos de otra clase que de su clase actual.
- El movimiento no rompe encapsulamiento.
- Las referencias al método pueden redirigirse.
- Si la clase original lo sigue necesitando, puede mantenerse un delegation method.

**Pasos a aplicar para poder implementar este refactoring:**
- Examinar todas las características usadas por el método raíz que están definidas en la clase raíz. Considera the deben ser también movidas.
- Chequea las sub y super clases de la clase raíz en busca de otras declaraciones del método. Si hay otras declaraciones, no podrías hacer el movimiento, a no ser que el polimorfismo pueda ser expresado en el objetivo.
- Declara el método en la clase target (clase deseada).
- Copia el código del método raíz al target. Ajusta el método para que funcione en su nueva casa.
- Compila la clase target.
- Determina como referenciar el objeto target correcto del raíz.
- Convierte el método raíz en un método delegación.
- Compila y testea.
- Decide si se tiene que eliminar el método raíz o dejarlo retenido como un método delegación. O sea que simplemente delega la implementacion y simplemente la llama al método target.
- Si eliminas el método raíz, reemplaza todas las referencias por referencias al nuevo método target.
- Compila y testea.


---
**Replace Conditional with Polymorfism**
- El condicional depende del tipo de objeto (switch o case sobre un type code).
- Existe una jerarquía de clases O se puede crear.
- Cada rama del condicional se puede expresar como un comportamiento distinto en una subclase.
- No hay dependencia fuerte con lógica externa que no pueda trasladarse a las subclases.

**Pasos a aplicar para poder implementar este refactoring:**
Antes de poder comenzar con **Replace Conditional with Polymorphism** (Reemplazar condicional con polimorfismo) necesitas tener la estructura de herencia necesaria.

- Puede que ya tengas esta estructura de refactorings anteriores.
- Si no la tienes, necesitas crearla.

Para crear la estructura de herencia tienes dos opciones:
1. Replace Type Code with Subclasses (Reemplazar código de tipo con subclases).
2. Replace Type Code with State/Strategy (Reemplazar código de tipo con patrón Estado/Estrategia).

- Las subclases son la opción más simple, úsalas si puedes.
- Si actualizas el código de tipo después de crear el objeto**, no puedes usar subclases y debes usar State/Strategy.
- También necesitas State/Strategy si ya estás usando subclases de esta clase por otra razón.
- Si varios `case` están usando el mismo código de tipo, solo necesitas una estructura de herencia para ese código de tipo.

Ahora puedes atacar el condicional. El código objetivo puede ser un switch (case) o un if.
Pasos:
1. Si la declaración condicional es parte de un método más grande**, separa el condicional y usa Extract Method (110).
2. Si es necesario, usa Move Method (142) para colocar el condicional al inicio de la estructura de herencia.
3. Elige una de las subclases.
    - Crea un método en la subclase que sobrescriba el método del condicional.
        
    - Copia el cuerpo de esa rama del condicional en el método de la subclase y ajustalo para que funcione allí.
        
	- Es posible que necesites cambiar algunos miembros privados de la superclase a protected para poder hacerlo.
	
1. **Compila y prueba**.
2. **Elimina la rama copiada del condicional**.
3. **Compila y prueba de nuevo.**


---
**Replace Temp with Query**
- La variable temporal almacena el resultado de una  expresión que puede calcularse sin costo excesivo.
- El valor no cambia a lo largo del método.
- Eliminarla no introduce duplicación de cálculos muy costosos.
- La consulta extraída (query) puede implementarse como un método que devuelve el mismo resultado.

**Pasos a aplicar para poder implementar este refactoring:**
- Busca una variable temporal que solo se le asigne un valor una vez.
	- Si la variable temporal se asigna más de una vez, considera usar Split Temporary Variable (128).
- Declara la variable temporal como final.
- Compila.
	- Esto asegura que la variable temporal solo se asigne una vez.
- Extrae el lado derecho de la asignación a un método.
	- Inicialmente marca el método como private. Puede que le encuentres más uso más adelante, pero siempre puedes relajar la protección después.
	- Asegúrate de que el método extraído no tenga efectos secundarios, es decir, que no modifique ningún objeto.
	- Si no es libre de efectos secundarios, usa Separate Query from Modifier (279).

- Compila y prueba.
- Usa Replace Temp with Inline Temp (119) sobre la variable temporal.


---
**Pull Up Field**
- Varias subclases tienen el mismo campo.
- El campo representa el mismo concepto en todas ellas.
- No hay conflicto de tipos o de inicialización.
- Moverlo a la superclase mejora la cohesión.

**Pasos a aplicar para poder implementar este refactoring:**
1. Inspecciona todos los usos de los campos candidatos para asegurarte de que se usan de la misma manera.
2. Si los campos no tienen el mismo nombre, renombralos para que tengan el nombre que deseas usar en el campo de la superclase.
3. Compila y prueba.
4. Crea un nuevo campo en la superclase.
    - Si los campos son privados, necesitarás proteger el campo de la superclase para que las subclases puedan referirse a él.
5. Elimina los campos de las subclases.
6. Compila y prueba.
7. Considera usar Self Encapsulate Field (171) sobre el nuevo campo.


---
**Pull Up Method**
- Dos o más subclases tienen métodos con código idéntico o muy similar.
- La implementación puede generalizarse sin depender de detalles particulares de la subclase.
- Moverlo a la superclase no rompe la semántica.
- Si hay pequeñas diferencias, pueden resolverse con parámetros o métodos abstractos auxiliares.

**Pasos a aplicar para poder implementar este refactoring:**
- Inspecciona los métodos para asegurarte de que son idénticos.
    - Si los métodos parecen hacer lo mismo pero no son idénticos, usa sustitución de algoritmo en uno de ellos para que queden idénticos.
- Si los métodos tienen firmas diferentes, cámbialas a la que deseas usar en la superclase.
- Crea un nuevo método en la superclase, copia el cuerpo de uno de los métodos, ajustalo y compila.
    - Si estás en un lenguaje fuertemente tipado y el método llama a otro que está presente en ambas subclases pero no en la superclase, declara un método abstracto en la superclase.
    - Si el método usa un campo de la subclase, usa Pull Up Field (320) o Self Encapsulate Field (171) y declara y usa un método getter abstracto.
- Elimina un método de la subclase.
- Compila y prueba.
- Continúa eliminando métodos de subclases y probando hasta que solo quede el método en la superclase.
- Revisa los llamadores de este método para ver si puedes cambiar un tipo requerido a la superclase.


---
# Ejercicio 1








