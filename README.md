# [Tarea 3](https://github.com/alejandrombc/PDI_Tarea3)

## Contenido
* Desarrollo y ejecucion
* Integrantes

## Desarrollo y ejecucion
La tarea se desarrollo en el lenguaje de JAVA, especificamente usando el IDE de NetBeans 8.1 en Windows (y solo fue probada en esta version).

Para ejecutarla puede agregar la carpeta "ide" directamente a Netbeans y enlazar las librerias de la carpeta "lib" (requeridas para que funcione el programa), otra forma mas sencilla es ejecutar directamente el .jar contenido en la carpeta "bin".

Una vez ejecutada se presentara una interfaz de usuario con la que podra interactuar, las acciones de brillo, contraste y umbralizacion funcionan en base al slider que se muestra. Se mueve el slider hacia la cantidad que desee y luego se le debe hacer click al boton para realizar el efecto deseado.

Todas las acciones son acumulativas, es decir, si usted aplica brillo y luego contraste el contraste se le aplicara a la imagen con brillo, esto aplica en todas las acciones del programa. En caso de querer volver a la imagen original simplemente debe presionar el boton de "Original". 

Los filtros se aplican segun la lista de matrices, es decir, seleccionando un filtro Box con la opcion 3x3 se realizara dicho filtro con su matriz de convolucion 3x3, asi para todos. Ademas puede crear su propio filtro con la opcion "Personalizado" y se abrira una ventana con una matriz segun la cantidad escogida. 

El programa acepta imagenes con formato .bmp (1,4,8,16,24 bits) y de otros formatos como .jpg y .png.

## Integrantes

**Alejandro Moises Barone Cavalieri**

**CI: 24206267**

**Jesus Alberto Cibeira Castiblanco**

**CI: 24203933**