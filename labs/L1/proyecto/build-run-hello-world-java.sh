#!/bin/bash

# Crear el directorio bin si no

mkdir -p bin

# Compilar los archivos Java
javac -d bin src/*.java

# Ejecutar el programa
java -cp bin App