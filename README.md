# Procesamiento de Transacciones Financieras

## Introducción
Este proyecto tiene como objetivo procesar y analizar un archivo CSV que contiene transacciones financieras. El reto consiste en:
- Leer el archivo.
- Calcular un balance final.
- Identificar la transacción de mayor monto.
- Contar la cantidad de transacciones de tipo **Crédito** y **Débito**.

La solución está implementada en **Java** y utiliza manejo adecuado de excepciones y lectura de archivos con codificación **UTF-8** para garantizar la integridad de los datos.

---

## Instrucciones de Ejecución

### Requisitos
No es necesario instalar dependencias externas. Solo necesitas tener **Java Development Kit (JDK)** instalado en tu sistema. Y tambien tener el jdk en path variables
La version de java que use es 17
un ide como visual studio code.

### Pasos para ejecutar el programa
1. Descarga o clona el proyecto.
2. Asegúrate de tener un archivo `data.csv` en la misma carpeta que el archivo `Reto.java` o en una ruta accesible.
3. Abre una terminal o línea de comandos y navega hasta la carpeta donde está el archivo `Reto.java`.
4. Compila el código con:
   ```bash
   javac -encoding UTF-8 Reto.java
   ```
5. Ejecuta el programa con:
   ```bash
   java Reto
   ```
El programa procesará el archivo `data.csv` y mostrará un reporte con:
- El balance final.
- La transacción de mayor monto.
- El conteo de transacciones de **Crédito** y **Débito**.

---

## Enfoque y Solución
La lógica del programa se basa en la lectura secuencial del archivo CSV, utilizando un `BufferedReader` junto con un `StringTokenizer` para dividir las líneas en campos. El programa realiza las siguientes tareas:
1. **Calcular el balance final**: Suma las transacciones de tipo **Crédito** y resta las de tipo **Débito**.
2. **Identificar la transacción de mayor monto**: Compara cada transacción con la anterior para encontrar el mayor monto.
3. **Contar transacciones de Crédito y Débito**: Lleva un registro de cuántas transacciones de cada tipo se procesan.

El uso de **UTF-8** como codificación asegura que los caracteres especiales (como tildes y acentos) se manejen correctamente, evitando problemas de codificación.

---

## Estructura del Proyecto
El proyecto consta de los siguientes archivos principales:
- **Reto.java**: Archivo principal del programa que contiene la lógica para leer el archivo CSV y calcular los resultados.
- **data.csv**: Archivo de entrada que contiene las transacciones. Este archivo debe estar en el mismo directorio que el archivo Java o en una ubicación accesible desde el programa.

### Ejemplo de estructura:
```plaintext
/Reto
    ├── Reto.java
    └── data.csv
```

Al ejecutar `java Reto`, el programa procesará el archivo `data.csv` y generará el reporte con el balance y las transacciones.  