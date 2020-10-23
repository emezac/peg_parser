Este repositorio tiene como objetivo generar un analizador para leer archivos de ajedrez en formato PGN.
Admite uno o más movimientos, que terminan con la puntuación, como "1. e4 e5 ... 0-1", pero también formatos largos: "1. d2d4 Cg8f6", el clásico enroque "OO oo" pero también "e1g1 e8g8 ", admite el análisis de encabezados y comentarios.

PGN es el estándar de facto para juegos de ajedrez, especialmente cuando se trata de interoperabilidad. Desafortunadamente, PGN está algo mal diseñado. Aparentemente, no soy solo yo quien piensa eso. PGN está diseñado para facilitar a los humanos la lectura de archivos PGN y editarlos o escribirlos manualmente con un editor de texto. Con un costo, es decir, que es difícil analizarlo con computadoras.

Lo extraño aquí es que los archivos PGN rara vez se crean manualmente, casi todo el mundo usa un programa de ajedrez para ingresar o editar movimientos y luego guardar la partida. Ese es el mal diseño básico.

La principal dificultad para analizar archivos PGN, aparte de muchas ambigüedades, es la notación SAN, es decir, falta el campo de origen de un movimiento. Para un humano es fácil detectar el campo fuente, pero para una computadora significa que el programa tiene que conocer las reglas del ajedrez para determinar qué movimiento se ejecuta.

Este analizador se generó mediante el uso de canopy, un compilador analizador PEG (Parsing Expression Grammars).

¿Por qué decidí utilizar un analizador PEG?

Porque tiene varias ventajas:
1. Puedo generar el analizador para Python, Ruby, Java y JS
2. Tengo que desarrollar solo un 50% más del analizador
3. Seguramente mi conocimiento de PEG Parsers será importante para mi próxima tarea: un lenguaje de patrones para el ajedrez.

Canopy.

Canopy es un compilador analizador dirigido a Java, JavaScript, Python y Ruby. Toma un archivo que describe una gramática de expresión de análisis y lo compila en un módulo de análisis en el idioma de destino. Los analizadores generados no dependen del tiempo de ejecución del propio Canopy.

Para obtener documentación de uso, consulte canopy.jcoglan.com.
