1. Descargado!!!, he probado los filtros rainbow, dull, y artifacter. El unico problema que me he encontrado fue con el filtro artifacter, ya que guarda los archivos temporales en un directorio que es perteneciente a un directorio de linux, y como ahora estoy en windows pues no puedo hacer que funcione el decorador correctamente.

2. Documentado!! ver diagrama.uml + diagrama.png

3. Estuve analizando exhaustivamente el ejercicio y he llegado a la conclusión de que este programa aplica el patrón strategy. En un principio creia que era patrón decorator porque, tecnicamente estas aplicando filtros de una imagen y entonces se generaria una reacción en cadena aplicando desde el ultimo filtro hasta el componente concreto. Pero en el programa original, no se comporta como un decorator, simplemente se comporta como un strategy, el cual tengo varios metodos de aplicarle filtro y todos retornan la imagen, y en base a esa imagen aplicas el filtro. No tenés rastro de cómo era la imagen en un principio. Por lo tanto a mi parecer esto es un Strategy.

4. 