# Laboratorio 1. Fundamentos de Programación

En este laboratorio, aprenderás cómo compilar y ejecutar software utilizando Maven. Maven es una herramienta de gestión y comprensión de proyectos que proporciona una forma sencilla de gestionar las dependencias, compilar el código, ejecutar pruebas y empaquetar el software.

## Objetivos
- Compilar software en Java
- Configurar un proyecto Maven.
- Compilar el proyecto.
- Ejecutar el proyecto.
- Generar informes de pruebas y cobertura de código.
- Realizar análisis de código y seguridad.


## Clase simple

### Plan
1. Crear una clase simple en Java llamada `HelloWorld`.
2. Incluir un método `main` que imprima "Hola, Mundo!" en la consola.
3. Proporcionar instrucciones para compilar y ejecutar el código en la terminal de Linux.

### Código
```java
// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hola, Mundo!");
    }
}
```

### Instrucciones para compilar y ejecutar
1. Guarda el código en un archivo llamado `HelloWorld.java`.
2. Abre una terminal y navega al directorio donde guardaste el archivo.
3. Compila el archivo con el siguiente comando:
   ```sh
   javac HelloWorld.java
   ```
4. Ejecuta el programa compilado con el siguiente comando:
   ```sh
   java HelloWorld
   ```

Esto imprimirá "Hola, Mundo!" en la consola.

---

## Múltiples clases

### Plan
1. Crear una clase principal llamada `App` que contenga el método `main`.
2. Crear una clase llamada `Greeting` que tenga un método para devolver un mensaje de saludo.
3. Crear una clase llamada `Farewell` que tenga un método para devolver un mensaje de despedida.
4. Proporcionar instrucciones para compilar y ejecutar el código en la terminal de Linux/Windows/MacOS.

### Código

### Archivo: `App.java`
```java
public class App {
    public static void main(String[] args) {
        Greeting greetings = new Greeting();
        Farewell farewell = new Farewell();

        System.out.println(greetings.getMessage());
        System.out.println(farewell.getMessage());
    }
}
```

### Archivo: `Greeting.java`
```java
public class Greeting {
    public String getMessage() {
        return "Hola, Mundo!";
    }
}
```

### Archivo: `Farewell.java`
```java
public class Farewell {
    public String getMessage() {
        return "Adiós, Mundo!";
    }
}
```

### Instrucciones para compilar y ejecutar
1. Guarda los archivos `App.java`, `Greeting.java` y `Farewell.java` en el mismo directorio.
2. Abre una terminal y navega al directorio donde guardaste los archivos.
3. Compila todos los archivos con el siguiente comando:
   ```sh
   javac App.java Greeting.java Farewell.java
   ```
4. Ejecuta el programa compilado con el siguiente comando:
   ```sh
   java App
   ```

Esto imprimirá "Hola, Mundo!" y "Adiós, Mundo!" en la consola.

---

## Despliegue local básico

### Plan
1. Crear una estructura de directorios para organizar los archivos Java.
2. Escribir un script de shell para compilar y ejecutar los archivos automáticamente.

### Estructura de directorios
```
proyecto/
├── src/
│   ├── App.java
│   ├── Greeting.java
│   └── Farewell.java
└── bin/
```

### Script de shell: `build-run-hello-world-java.sh`
```sh
#!/bin/bash

# Crear el directorio bin si no

mkdir -p bin

# Compilar los archivos Java
javac -d bin src/*.java

# Ejecutar el programa
java -cp bin App
```

### Instrucciones para compilar y ejecutar
1. Crea la estructura de directorios y guarda los archivos Java en el directorio `src`.
2. Guarda el script de shell `build-run-hello-world-java.sh` en el directorio `proyecto`.
3. Abre una terminal y navega al directorio `proyecto`.
4. Haz el script ejecutable con el siguiente comando:
   ```sh
   chmod +x build-run-hello-world-java.sh.sh
   ```
5. Ejecuta el script con el siguiente comando:
   ```sh
   ./build-run-hello-world-java.sh.sh
   ```

Esto compilará los archivos Java en el directorio `bin` y ejecutará el programa, imprimiendo "Hola, Mundo!" y "Adiós, Mundo!" en la consola.

---

## Herramientas de `Build`: Maven

### Links

1. Tutorial Maven - https://www.arteco-consulting.com/articulos/tutorial-maven/

2. Maven in 5 minutes - https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html


### Plan
1. Utilizar Maven como herramienta de build para gestionar el proyecto.
2. Crear un archivo `pom.xml` para definir las dependencias y configuraciones del proyecto.
3. Estructurar el proyecto según la convención de Maven (deben tener esta estructura de directorio los proyectos en Maven).
4. Proporcionar instrucciones para compilar y ejecutar el proyecto usando Maven.

### Estructura de directorios
```
proyecto/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── App.java
│   │   │   ├── Greeting.java
│   │   │   └── Farewell.java
└── pom.xml
```


### Archivo: `pom.xml`
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ejemplo</groupId>
    <artifactId>proyecto</artifactId>
    <version>1.0-SNAPSHOT</version>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### Instrucciones para compilar y ejecutar
1. Crea la estructura de directorios y guarda los archivos Java en el directorio `src/main/java`.
2. Guarda el archivo `pom.xml` en el directorio `proyecto`.
3. Abre una terminal y navega al directorio `proyecto`.
4. Compila el proyecto con el siguiente comando:
   ```sh
   mvn compile
   ```
5. Ejecuta el proyecto con el siguiente comando:
   ```sh
   mvn exec:java -Dexec.mainClass="App"
   ```

Esto compilará y ejecutará el proyecto, imprimiendo "Hola, Mundo!" y "Adiós, Mundo!" en la consola.

---

## Empaquetar software: JAR


### Plan
1. Actualiza el `pom.xml` para incluir el plugin de Maven JAR.
2. Usa comandos de Maven para empaquetar el proyecto en un archivo JAR.

### Actualizar `pom.xml`
Añade la siguiente configuración del plugin a la sección `<build>` de tu `pom.xml`:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.2.0</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>App</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

### Instrucciones para crear un archivo JAR
1. Asegúrate de que tu `pom.xml` esté actualizado con la configuración anterior.
2. Abre una terminal y navega al directorio raíz de tu proyecto Maven.
3. Ejecuta el siguiente comando para empaquetar el proyecto en un archivo JAR:
   ```sh
   mvn package
   ```

Esto creará un archivo JAR en el directorio `target` de tu proyecto.

### Instrucciones para ejecutar el archivo JAR
1. Navega al directorio `target`:
   ```sh
   cd target
   ```
2. Ejecuta el archivo JAR usando el siguiente comando:
   ```sh
   java -jar proyecto-1.0-SNAPSHOT.jar
   ```

Esto ejecutará el archivo JAR e imprimirá "Hola, Mundo!" y "Adiós, Mundo!" en la consola.

---

## Herramientas de `Build`: Dependencias

### Plan
1. Identificar las dependencias externas que necesitas para tu proyecto.
2. Agregar las dependencias al archivo `pom.xml` bajo la sección `<dependencies>`.

### Ejemplo
Supongamos que quieres agregar la biblioteca Gson para el análisis de JSON. Seguirías estos pasos:

### Actualizar `pom.xml`
Añade la siguiente dependencia a la sección `<dependencies>` de tu `pom.xml`:

```xml
<dependencies>
    <!-- Otras dependencias existentes -->

    <!-- Dependencia de Gson -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.8</version>
    </dependency>
</dependencies>
```

### Ejemplo Completo de `pom.xml`
Así es como podría verse tu `pom.xml` con la dependencia de Gson y las configuraciones anteriores:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ejemplo</groupId>
    <artifactId>proyecto</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <!-- Dependencia de Gson -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.8</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.2.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>App</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

## Herramientas de `Build`: Actualizar Dependencias

### Plan
1. Identificar las dependencias específicas y sus versiones que necesitas para tu proyecto.
2. Agregar estas dependencias a la sección `<dependencies>` de tu archivo `pom.xml`.

### Ejemplo
Supongamos que necesitas agregar la biblioteca Gson versión 2.8.8 a tu proyecto Maven.

### Actualizar `pom.xml`
Agrega las siguientes dependencias a la sección `<dependencies>` de tu `pom.xml`:

```xml
<dependencies>
    <!-- Dependencia de Gson -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.8</version>
    </dependency>

</dependencies>
```

### Instrucciones para agregar dependencias específicas de una versión
1. Abre tu archivo `pom.xml`.
2. Añade las dependencias necesarias dentro de la sección `<dependencies>`.
3. Guarda el archivo `pom.xml`.
4. Abre una terminal y navega al directorio raíz de tu proyecto Maven.
5. Ejecuta el siguiente comando para actualizar las dependencias del proyecto:
   ```sh
   mvn clean install
   ```

Esto descargará las dependencias especificadas y las incluirá en tu proyecto Maven.

---

## Pruebas software: JUnit

JUnit es un marco de pruebas unitarias para el lenguaje de programación Java. Permite escribir y ejecutar pruebas repetibles para asegurar que el código funciona como se espera. A continuación, se muestra cómo integrar JUnit en tu proyecto Maven y cómo escribir pruebas unitarias para el código existente.

### 1. Añadir Dependencia de JUnit

Primero, necesitas añadir la dependencia de JUnit 4 a tu archivo `pom.xml`. Asegúrate de que la sección `<dependencies>` incluya lo siguiente:

```xml
<dependencies>
    <!-- Otras dependencias existentes -->

    <!-- Dependencia de Gson -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.8</version>
    </dependency>

    <!-- Dependencia de JUnit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### 2. Estructura de Directorios para Pruebas

Las pruebas unitarias deben ubicarse en el directorio `src/test/java`. La estructura de directorios debería verse así:

```
proyecto/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── App.java
│   │   │   ├── Greeting.java
│   │   │   └── Farewell.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── AppTest.java
│   │   │   ├── GreetingTest.java
│   │   │   └── FarewellTest.java
└── pom.xml
```

### 3. Escribir Pruebas Unitarias

A continuación, se muestran ejemplos de pruebas unitarias para las clases `Greeting` y `Farewell`.

##### Archivo: `src/test/java/GreetingTest.java`
```java
import org.junit.Test;
import static org.junit.Assert.*;

public class GreetingTest {
    @Test
    public void testGetMessage() {
        Greeting greeting = new Greeting();
        assertEquals("Hello, World!", greeting.getMessage());
    }
}
```

#### Archivo: `src/test/java/FarewellTest.java`
```java
import org.junit.Test;
import static org.junit.Assert.*;

public class FarewellTest {
    @Test
    public void testGetMessage() {
        Farewell farewell = new Farewell();
        assertEquals("Goodbye, World!", farewell.getMessage());
    }
}
```

#### Archivo: `src/test/java/AppTest.java`
```java
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testMain() {
        // No es común probar el método main directamente, pero puedes probar la lógica subyacente
        Greeting greeting = new Greeting();
        Farewell farewell = new Farewell();

        assertEquals("Hello, World!", greeting.getMessage());
        assertEquals("Goodbye, World!", farewell.getMessage());
    }
}
```

### 4. Ejecutar Pruebas

Para ejecutar las pruebas unitarias, abre una terminal y navega al directorio raíz de tu proyecto Maven. Luego, ejecuta el siguiente comando:

```sh
mvn test
```

Esto ejecutará todas las pruebas en el directorio `src/test/java` y mostrará los resultados en la consola.

---

## Herramientas de `Build`: Integrar pruebas

Para integrar las pruebas en el proceso de build, asegúrate de que el plugin de surefire esté configurado en tu `pom.xml`. Maven Surefire Plugin es el responsable de ejecutar las pruebas unitarias.

Añade la siguiente configuración a la sección `<build>` de tu `pom.xml`:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.2</version>
        </plugin>
    </plugins>
</build>
```

Con esta configuración, las pruebas se ejecutarán automáticamente cada vez que compiles tu proyecto con Maven.

---

### Ejercicios


1. Añade una nueva clase llamada `SaludoPersonalizado` que acepte un nombre y devuelva un saludo personalizado.
2. Escribe pruebas unitarias para la clase `SaludoPersonalizado`.
   
---

## Generar Informes de Cobertura de Código en Proyectos Java con Maven

Para generar informes de cobertura de código en proyectos Java con Maven, puedes utilizar el plugin `jacoco-maven-plugin`. Este plugin permite medir la cobertura de código de tus pruebas unitarias y generar informes detallados.

#### Pasos para Configurar y Generar Informes de Cobertura de Código

1. **Añadir el Plugin de JaCoCo a tu `pom.xml`**:
   Añade la configuración del plugin `jacoco-maven-plugin` a la sección `<build>` de tu archivo `pom.xml`.

```xml
<build>
    <plugins>
        <!-- Plugin de compilación -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>

        <!-- Plugin para empaquetar en JAR -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.2.0</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>App</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>

        <!-- Plugin de JaCoCo para cobertura de código -->
        <plugin>
            <groupId>org.jacoco</groupId>
            <artifactId>jacoco-maven-plugin</artifactId>
            <version>0.8.7</version>
            <executions>
                <execution>
                    <goals>
                        <goal>prepare-agent</goal>
                    </goals>
                </execution>
                <execution>
                    <id>report</id>
                    <phase>test</phase>
                    <goals>
                        <goal>report</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

2. **Ejecutar las Pruebas y Generar el Informe de Cobertura**:
   Abre una terminal y navega al directorio raíz de tu proyecto Maven. Luego, ejecuta el siguiente comando para ejecutar las pruebas y generar el informe de cobertura de código:

```sh
mvn clean test
```

3. **Ver el Informe de Cobertura**:
   Después de ejecutar las pruebas, el informe de cobertura de código se generará en el directorio `target/site/jacoco`. Abre el archivo `index.html` en un navegador web para ver el informe detallado.

### Resumen

Con estos pasos, puedes configurar el plugin JaCoCo en tu proyecto Maven para medir la cobertura de código de tus pruebas unitarias y generar informes detallados. Esto te ayudará a identificar áreas de tu código que no están siendo cubiertas por las pruebas y mejorar la calidad general de tu software.

---

## Integrar Checkstyle y OWASP Dependency Check en tu Proyecto Maven

Para asegurar la calidad y seguridad del código en tu proyecto Maven, puedes integrar herramientas como Checkstyle y OWASP Dependency Check. A continuación, se explica cómo configurar y utilizar estos plugins paso a paso.

#### 1. Añadir el Plugin de Checkstyle

Checkstyle es una herramienta de análisis estático que ayuda a asegurar que el código sigue las convenciones de estilo definidas. Detecta problemas de formato y estilo en el código.

##### Actualizar `pom.xml`
Añade la configuración del plugin de Checkstyle a la sección `<build>` de tu archivo `pom.xml`:

```xml
<build>
    <plugins>
        <!-- Otros plugins existentes -->

        <!-- Plugin de Checkstyle -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-checkstyle-plugin</artifactId>
            <version>3.1.2</version>
            <executions>
                <execution>
                    <phase>validate</phase>
                    <goals>
                        <goal>check</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

##### Ejecutar Checkstyle
Para ejecutar Checkstyle y verificar el estilo del código, abre una terminal y navega al directorio raíz de tu proyecto Maven. Luego, ejecuta el siguiente comando:

```sh
mvn checkstyle:check
```

Este comando analizará el código y generará un informe de cualquier problema de estilo que encuentre.

En este momento la fase de build se detendrá al tener errores la fase de checkstyle, lo normal es que los checkstyle sean tratados como warning pero no detengan la ejecución de código para eso tenemos que hacer cierto ajustes.

En primer lugar debemos ajustar una configuración del plugin de checkstyle agregando el siguiente fragmento de XML en la configuración del plugin.

```xml
 <configuration>
    <configLocation>checkstyle.xml</configLocation>
    <encoding>UTF-8</encoding>
    <consoleOutput>true</consoleOutput>
    <failsOnError>false</failsOnError>
</configuration>
```

La configuración de checkstyle se encuentra en el fichero `checkstyle.xml` que debemos crear en el raíz del proyecto, junto al fichero `pom.xml`.

```xml
<!DOCTYPE module PUBLIC
    "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN"
    "https://checkstyle.org/dtds/configuration_1_3.dtd">

<module name="Checker">
    <module name="TreeWalker">
        <module name="JavadocMethod">
            <property name="severity" value="warning"/>
        </module>
        <!-- Otras reglas -->
    </module>
</module>
```

Ahora mismo podríamos usar el comando  `mvn checkstyle:check` y dejaríamos de ver los errores, puesto que han pasado a tener una `severity` de `warning`. 

El último paso que nos quedaría es poder tener reportes generados para conocer qué ha sucedido. Para conseguir tener reportes, necesitamos modificar el fichero `pom.xml`, en este caso debemos agregar una nueva sección `reporting` diferente a `build` en el que especificamos que se quiere generar el reporte.


```xml
 <reporting>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-checkstyle-plugin</artifactId>
            <version>3.1.2</version>
            <reportSets>
                <reportSet>
                    <reports>
                        <report>checkstyle</report>
                    </reports>
                </reportSet>
            </reportSets>
        </plugin>
    </plugins>
</reporting>
```

Finalmente nos quedaría ejecutar el comando `nvm site` para poder generar el reporte, el cual se encontará en el directorio `site`.


#### 2. Añadir el Plugin de OWASP Dependency Check

OWASP Dependency Check es una herramienta que analiza las dependencias de tu proyecto en busca de vulnerabilidades conocidas. Ayuda a identificar y mitigar riesgos de seguridad en las bibliotecas que utilizas.

##### Actualizar `pom.xml`
Añade la configuración del plugin de OWASP Dependency Check a la sección `<build>` de tu archivo `pom.xml`:

```xml
<build>
    <plugins>
        <!-- Otros plugins existentes -->

        <!-- Plugin de OWASP Dependency Check -->
        <plugin>
            <groupId>org.owasp</groupId>
            <artifactId>dependency-check-maven</artifactId>
            <version>6.1.6</version>
            <executions>
                <execution>
                    <goals>
                        <goal>check</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

##### Ejecutar OWASP Dependency Check
Para ejecutar OWASP Dependency Check y analizar las dependencias de tu proyecto, abre una terminal y navega al directorio raíz de tu proyecto Maven. Luego, ejecuta el siguiente comando:

```sh
mvn dependency-check:check
```

Este comando analizará las dependencias y generará un informe de cualquier vulnerabilidad conocida que encuentre.

#### Resumen

Con estos pasos, puedes integrar Checkstyle y OWASP Dependency Check en tu proyecto Maven para asegurar la calidad y seguridad del código. Aquí tienes un resumen de los comandos y su propósito:

- **Checkstyle**:
  - **Comando**: `mvn checkstyle:check`
  - **Propósito**: Analizar el código en busca de problemas de estilo y formato.

- **OWASP Dependency Check**:
  - **Comando**: `mvn dependency-check:check`
  - **Propósito**: Analizar las dependencias del proyecto en busca de vulnerabilidades conocidas.

Estas herramientas te ayudarán a mantener un código limpio y seguro, mejorando la calidad general de tu software antes de ponerlo en producción.

## Generar un Informe de Pruebas Unitarias en Formato XML con el Plugin Surefire de Maven

El plugin Maven Surefire es una herramienta que permite ejecutar pruebas unitarias y generar informes de los resultados. A continuación, se explica cómo configurar el plugin Surefire para generar informes de pruebas unitarias en formato XML.

#### 1. Añadir el Plugin Surefire a tu `pom.xml`

Primero, asegúrate de que el plugin Surefire esté configurado en tu archivo `pom.xml`.

##### Actualizar `pom.xml`
Añade la configuración del plugin Surefire a la sección `<build>` de tu archivo `pom.xml`:

```xml
<build>
    <plugins>
        <!-- Otros plugins existentes -->

        <!-- Plugin de Surefire -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.2</version>
        </plugin>
    </plugins>
</build>
```

#### 2. Ejecutar las Pruebas Unitarias

Para ejecutar las pruebas unitarias y generar el informe, abre una terminal y navega al directorio raíz de tu proyecto Maven. Luego, ejecuta el siguiente comando:

```sh
mvn test
```

Este comando ejecutará todas las pruebas unitarias ubicadas en el directorio `src/test/java`.

#### 3. Ver el Informe de Pruebas Unitarias

Después de ejecutar las pruebas, Maven Surefire generará un informe en formato XML. El informe se ubicará en el directorio `target/surefire-reports`.

Para ver el informe, revisa que se generan diferentes ficheros en formato XML.

```
target/surefire-reports/
```

### Resumen

Con estos pasos, puedes configurar el plugin Surefire en tu proyecto Maven para ejecutar pruebas unitarias y generar informes en formato XML. Aquí tienes un resumen de los comandos y su propósito:

- **Configurar el Plugin Surefire**:
  - **Propósito**: Asegurar que el plugin Surefire esté configurado en el archivo `pom.xml`.

- **Ejecutar las Pruebas Unitarias**:
  - **Comando**: `mvn test`
  - **Propósito**: Ejecutar todas las pruebas unitarias y generar el informe.

- **Ver el Informe de Pruebas Unitarias**:
  - **Ruta del Informe**: `target/surefire-reports/index.html`
  - **Propósito**: Ver el informe de pruebas unitarias en formato HTML en un navegador web.

Estas configuraciones y comandos te permitirán generar y revisar informes detallados de las pruebas unitarias, mejorando la calidad y la confiabilidad de tu software.




## Resumen de Comandos

1. **Compilar el Proyecto**:
   ```sh
   mvn compile
   ```

2. **Ejecutar Pruebas Unitarias y Generar Informes**:
   ```sh
   mvn test
   ```

3. **Ver el Informe de Pruebas Unitarias**:
   - Abre el archivo `target/surefire-reports/index.html` en un navegador web.

4. **Ejecutar Checkstyle**:
   ```sh
   mvn checkstyle:check
   ```

5. **Ejecutar OWASP Dependency Check**:
   ```sh
   mvn dependency-check:check
   ```

6. **Generar Informes de Cobertura de Código**:
   - Los informes se generarán en el directorio `target/site/jacoco`.

Con esta configuración en tu archivo `pom.xml`, tendrás un proceso de compilación y chequeo completo que incluye la ejecución de pruebas unitarias, generación de informes, análisis de estilo de código y análisis de seguridad.


# Prácticas a Entregar

Todas las prácticas deben desarrollarse creando capturas de pantalla, ficheros auxiliares (scripts, código, etc.), y debe crearse una documentación explicando qué se ha realizado.

Esta documentación se realizará utilizando Markdown o equivalente y se entregará a través de **GitHub Classroom** del módulo **Puesta en Producción Segura**.

## Práctica 1.1. Java y Maven (2.5 puntos)

1. Realiza la práctica guiada de Java y MAVEN paso a paso para demostrar su desarrollo con evidencias.

## Práctica 1.2. Proyecto real usando Maven (2 puntos)

Dados los siguientes repositorios donde encontraremos programado en JAVA las siguientes aplicaciones:

1. Juego de Ajedrez en terminal (https://github.com/eliezergarbin/ChessSystem) - (1 punto).
2. Calculadora de BMI (https://github.com/claudiavegarodriguez/bmicalc/) - (1 punto).

Debemos realizar las siguientes tareas para cada uno de los proyectos anteriores:

1. Adaptar la estructura de directorios para ser un proyecto en Maven.
2. Crear el fichero pom.xml y mostrar que el proyecto se compila y ejecuta correctamente.
3. Genera el empaquetado en JAR usando Maven.
4. Incluye las dependencias de Test y ejecuta los Test de los proyectos.
   1. Los proyectos están desarrollados utilizando la versión de Junit 5, esta dependencia es localizada en Maven con los siguientes datos `groupId: org.junit.jupiter`, `artifactId: junit-jupiter` y `version: 5.10.0`.
5. Incluye el plugin checkstyle e integralo en la compilación. En primer lugar muestra que el build se detiene al detectar errores de formateo. Acto seguido genera el reporte en un fichero externo (página html).
6. Incluye el plugin de OWASP Dependency check e integralo en la compilación.
 - Regístrate en la `National Vulnerability Database` (https://nvd.nist.gov/developers) para conseguir un API token y descargar la base de datos más rápidamente (configura el plugin)
 - Añade las siguientes dependencias con vulnerabilidades y describe que vulnerabilidades tienen las dependencias.

```xml
<!-- Dependencias con vulnerabilidades conocidas -->
        <dependency>
            <groupId>commons-collections</groupId>
            <artifactId>commons-collections</artifactId>
            <version>3.2.1</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.1.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.9</version>
        </dependency>
        <dependency>
            <groupId>org.apache.struts</groupId>
            <artifactId>struts2-core</artifactId>
            <version>2.3.20</version>
        </dependency>
```

7. Incluye el plugin de cobertura de test e integralo en la compilación.


## Práctica 1.3. JavaScript y Node.js (2 puntos)

Debe realizar los mismos pasos que se han realizado en la práctica guiada de JAVA pero usando un lenguaje de programación/entorno de desarrollo diferente.

En este caso se realizará usando node.js (interpretado)

A modo de guía se deben mostrar las evidencias y comprobaciones del correcto funcionamiento utilizando el siguiente índice:

1. **Instalación y configuración de Node.js**
   - Instale node.js y npm en linux (`npm --version`, `node --version`)
   - ¿Qué es y cómo funciona Node.js?
2. **Configurar un Proyecto Node.js**
   - ¿Qué es y cómo funciona npm?
   - Inicializar un proyecto Node.js con `package.json`
   - ¿Qué información tiene el fichero `package.json`? ¿Para qué sirve cada una de las partes del fichero?
   - ¿Cómo se instalan las dependencias? ¿Dónde se puede ver que se han instalado nuevas dependencias?

3. **Crear una Aplicación Simple**
   - Crear un archivo `app.js` con un mensaje de "Hola, Mundo!"
   - Proporcionar instrucciones para ejecutar el código (usando node en lugar de java/javac).
   - ¿Qué diferencias hay entre los comandos java/javac y el comando node? ¿Por qué hay dos comandos para las aplicaciones JAVA y solo uno para node?
 

4. **Múltiples Módulos**
   - Crear módulos `greeting.js` y `farewell.js`
   - Crear un archivo principal `app.js` que utilice estos módulos
   - Proporcionar instrucciones para ejecutar el código

5. **Despliegue Local Básico**
   - Crear una estructura de directorios para organizar los archivos
   - Escribir un script de npm para ejecutar la aplicación

6. **Empaquetar Software: npm**
   - Crear un script de npm para empaquetar el proyecto
   - Proporcionar instrucciones para ejecutar el paquete

7. **Dependencias**
   - Identificar y agregar dependencias externas necesarias
   - Proporcionar ejemplos de dependencias comunes

8. **Pruebas de Software: Mocha y Chai**
    - Integrar Mocha y Chai para pruebas unitarias 
    - Escribir pruebas unitarias para el código existente
    - Proporcionar instrucciones para ejecutar las pruebas

9. **Generar Informes de Cobertura de Código: nyc**
     - Configurar nyc para generar informes de cobertura de código
     - Proporcionar instrucciones para generar y ver los informes

10. **Análisis de Código: ESLint**
    - Configurar ESLint para análisis de estilo de código   
    - Proporcionar instrucciones para ejecutar ESLint

11. **Análisis de Seguridad: npm audit**
    - Utilizar `npm audit` para analizar las dependencias en busca de vulnerabilidades
    - Proporcionar instrucciones para ejecutar `npm audit`

### Herramientas/Plugins Utilizados

1. **npm**: Gestor de paquetes para Node.js.
2. **Mocha**: Framework de pruebas para Node.js.
3. **Chai**: Biblioteca de aserciones para Node.js.
4. **nyc**: Herramienta para generar informes de cobertura de código.
5. **ESLint**: Herramienta de análisis estático para identificar problemas de estilo de código.
6. **npm audit**: Herramienta para analizar las dependencias en busca de vulnerabilidades.

### Ejemplo de `package.json`

```json
{
  "name": "proyecto-node",
  "version": "1.0.0",
  "description": "Proyecto Node.js equivalente a las tareas de Maven",
  "main": "app.js",
  "scripts": {
    "start": "node app.js",
    "test": "mocha",
    "coverage": "nyc mocha",
    "lint": "eslint .",
    "audit": "npm audit"
  },
  "dependencies": {
    "express": "^4.17.1"
  },
  "devDependencies": {
    "mocha": "^8.3.2",
    "chai": "^4.3.4",
    "nyc": "^15.1.0",
    "eslint": "^7.24.0"
  }
}
```

### Instrucciones para Ejecutar

1. **Inicializar el Proyecto**:
   ```sh
   npm init -y
   ```

2. **Instalar Dependencias**:
   ```sh
   npm install express
   npm install --save-dev mocha chai nyc eslint
   ```

3. **Ejecutar la Aplicación**:
   ```sh
   npm start
   ```

4. **Ejecutar Pruebas**:
   ```sh
   npm test
   ```

5. **Generar Informes de Cobertura**:
   ```sh
   npm run coverage
   ```

6. **Ejecutar ESLint**:
   ```sh
   npm run lint
   ```

7. **Ejecutar Análisis de Seguridad**:
   ```sh
   npm run audit
   ```


## Práctica 1.4. Proyecto real de JAVA usando SpringBoot (1.5 puntos)

En esta práctica, trabajaremos con un proyecto real de Java utilizando Spring Boot. Spring Boot es un framework que facilita la creación de aplicaciones Java basadas en Spring, proporcionando configuraciones predeterminadas para agilizar el desarrollo.

### Repositorio de Ejemplo

Para esta práctica, utilizaremos un proyecto de ejemplo disponible en GitHub. El repositorio seleccionado es un proyecto completo que demuestra las funcionalidades básicas de Spring Boot, incluyendo controladores, servicios, repositorios y pruebas unitarias.

**Nombre del Repositorio:** [spring-petclinic](https://github.com/spring-projects/spring-petclinic)

**Descripción:** El proyecto Spring PetClinic es una aplicación web que gestiona una clínica veterinaria. Este proyecto incluye ejemplos de controladores, servicios, repositorios, y pruebas unitarias, proporcionando una base sólida para entender cómo funciona una aplicación Spring Boot.

### Pasos para Configurar y Ejecutar el Proyecto

1. **Clonar el Repositorio:**
   ```sh
   git clone https://github.com/spring-projects/spring-petclinic.git
   cd spring-petclinic
   ```

2. **Importar el Proyecto en un IDE:**
   - Abre tu IDE favorito (IntelliJ IDEA, Eclipse, etc.).
   - Importa el proyecto como un proyecto Maven existente.

3. **Compilar el Proyecto:**
   ```sh
   ./mvn clean install
   ```

4. **Ejecutar la Aplicación:**
   ```sh
   ./mvn spring-boot:run
   ```

5. **Probar la Aplicación:**
   - Abre un navegador web y navega a `http://localhost:8080`.
   - Deberías ver la página de inicio de la aplicación PetClinic.

### Estructura del Proyecto

- **src/main/java/org/springframework/samples/petclinic**: Contiene los archivos fuente de la aplicación.
  - **PetClinicApplication.java**: Clase principal que inicia la aplicación Spring Boot.
  - **controller**: Contiene los controladores REST.
  - **service**: Contiene las clases de servicio.
  - **repository**: Contiene las interfaces de repositorio.
  - **model**: Contiene las clases de modelo.

- **src/test/java/org/springframework/samples/petclinic**: Contiene las pruebas unitarias para la aplicación.

### Tareas

1. Ejecuta el proyecto y ponlo en marcha.
2. Explica del fichero POM todos sus plugins y dependencias, ¿Qué hacen los plugins y dependencias y cómo funcionan?
3. Incluye los plugins y dependencias que necesitamos para completar el cilo de vida del desarrollo de software.


## Prática 1.5. Proyecto real de TypeScript usando Angular (Frontend) (1 punto).

En esta práctica, trabajaremos con un proyecto real de TypeScript utilizando Angular. Angular es un framework de desarrollo web que facilita la creación de aplicaciones web dinámicas y de alto rendimiento. A continuación, se detallan los pasos para clonar, configurar, ejecutar y modificar un proyecto real de Angular.

### Repositorio de Ejemplo

Para esta práctica, utilizaremos un proyecto de ejemplo disponible en GitHub. El repositorio seleccionado es un proyecto completo que demuestra las funcionalidades básicas de Angular, incluyendo controladores, servicios, repositorios y pruebas unitarias.

**Nombre del Repositorio:** [angular-realworld-example-app](https://github.com/gothinkster/angular-realworld-example-app)

**Descripción:** Esta base de código fue creada para demostrar una aplicación completamente desarrollada con Angular que interactúa con un servidor backend real, incluyendo operaciones CRUD, autenticación, enrutamiento, paginación y más. Hemos hecho grandes esfuerzos para adherirnos a la guía de estilo de Angular y las mejores prácticas.

### Paso 1: Clonar el repositorio

Primero, clona un repositorio real de GitHub que utilice Angular. Por ejemplo, puedes usar el siguiente repositorio:

```bash
git clone git@github.com:gothinkster/angular-realworld-example-app.git
cd angular-realworld-example-app
```

### Paso 2: Instalar dependencias

Instala las dependencias del proyecto utilizando npm o yarn:

```bash
npm install
# o
yarn install
```

### Paso 3: Configurar el entorno

Crea un archivo `environment.ts` en la carpeta `src/environments` y configura las variables de entorno necesarias. Puedes basarte en el archivo `environment.example.ts` si está disponible.

```bash
cp src/environments/environment.example.ts src/environments/environment.ts
# Edita el archivo environment.ts con tus configuraciones
```

### Paso 4: Ejecutar el proyecto

Inicia el servidor de desarrollo:

```bash
npm start
# o
yarn start
```

### Paso 5: Probar la aplicación

Abre tu navegador y navega a `http://localhost:4200` para ver la aplicación en funcionamiento.

### Paso 6: Modificar el proyecto

Realiza cambios en el código fuente según los requerimientos de tu práctica. Puedes encontrar los archivos principales en la carpeta `src/app`.

### Paso 7: Compilar el proyecto

Para compilar el proyecto para producción, ejecuta:

```bash
npm run build
# o
yarn build
```

### Paso 8: Ejecutar pruebas

Ejecuta las pruebas unitarias para asegurarte de que todo funcione correctamente:

```bash
npm test
# o
yarn test
```
### Recursos adicionales

- [Documentación oficial de Angular](https://angular.io/docs)
- [Repositorio de ejemplo en GitHub](https://github.com/gothinkster/angular-realworld-example-app)

### Tareas

1. Ejecuta el proyecto y ponlo en marcha.
2. Explica del fichero package.json todas sus dependencias, ¿Qué hacen las dependencias y cómo funcionan?
3. Explica los npm scripts, ¿qué funcionalidades tienen?
4. Reflexiona qué incluirías para desarrollar el ciclo de vida en la configuración y crea un script para realizar toda la fase de build con chequeos y comprobaciones.

## Práctica 1.6. Compilado/Transpilado/Interpretado usando diferentes plataformas (1 punto).

En esta práctica, exploraremos el proceso de compilación, transpilación e interpretación utilizando diferentes lenguajes de programación y plataformas. El objetivo es entender las diferencias entre estos procesos y cómo se aplican en distintos lenguajes.

### Lenguajes Compilados

Los lenguajes compilados son aquellos que se traducen directamente a código máquina antes de ser ejecutados. Este proceso de compilación generalmente produce un archivo binario que puede ser ejecutado directamente por el sistema operativo.

#### Ejemplos de Lenguajes Compilados:
- **C**: Un lenguaje de programación de propósito general que es ampliamente utilizado en sistemas operativos y software de alto rendimiento.
- **C++**: Una extensión de C que incluye características de programación orientada a objetos.
- **Rust**: Un lenguaje de programación de sistemas que se centra en la seguridad y el rendimiento.
- **Go**: Un lenguaje de programación desarrollado por Google que es conocido por su simplicidad y eficiencia.
- **.NET (C#)**: Un framework desarrollado por Microsoft que soporta múltiples lenguajes de programación, siendo C# uno de los más populares.

### Lenguajes Interpretados

Los lenguajes interpretados son aquellos que se ejecutan directamente a partir del código fuente mediante un intérprete. Este proceso puede ser más lento en comparación con los lenguajes compilados, pero ofrece mayor flexibilidad y facilidad de uso.

#### Ejemplos de Lenguajes Interpretados:
- **Python**: Un lenguaje de programación de alto nivel conocido por su simplicidad y legibilidad.
- **JavaScript**: Un lenguaje de programación que se ejecuta principalmente en navegadores web y es esencial para el desarrollo web.
- **Ruby**: Un lenguaje de programación dinámico y orientado a objetos, conocido por su simplicidad y productividad.
- **PHP**: Un lenguaje de programación ampliamente utilizado para el desarrollo web del lado del servidor.
- **Perl**: Un lenguaje de programación de propósito general conocido por su capacidad de procesamiento de texto.

### Lenguajes Transpilados

Los lenguajes transpilados son aquellos que se convierten de un lenguaje de alto nivel a otro lenguaje de alto nivel antes de ser ejecutados. Este proceso es común en el desarrollo web moderno.

#### Ejemplos de Lenguajes Transpilados:
- **TypeScript**: Un superconjunto de JavaScript que se transpila a JavaScript.
- **CoffeeScript**: Un lenguaje que se transpila a JavaScript y ofrece una sintaxis más concisa.
- **Sass**: Un preprocesador CSS que se transpila a CSS.

### Ejercicio

1. **Elegir un Lenguaje Compilado**:
   - Selecciona uno de los lenguajes compilados mencionados anteriormente.
   - Escribe un programa simple en ese lenguaje.
   - Compila el programa y ejecuta el binario resultante.

2. **Elegir un Lenguaje Interpretado**:
   - Selecciona uno de los lenguajes interpretados mencionados anteriormente.
   - Escribe un programa simple en ese lenguaje.
   - Ejecuta el programa utilizando el intérprete correspondiente.

3. **Elegir un Lenguaje Transpilado**:
   - Selecciona uno de los lenguajes transpilados mencionados anteriormente.
   - Escribe un programa simple en ese lenguaje.
   - Transpila el programa al lenguaje de destino y ejecuta el resultado.

### Ejemplo de Código

#### Lenguaje Compilado (C)
```c
#include <stdio.h>

int main() {
    printf("Hola, Mundo!\n");
    return 0;
}
```
Compilar y ejecutar:
```sh
gcc hello.c -o hello
./hello
```

#### Lenguaje Interpretado (Python)
```python
print("Hola, Mundo!")
```
Ejecutar:
```sh
python hello.py
```

#### Lenguaje Transpilado (TypeScript)
```typescript
let message: string = "Hola, Mundo!";
console.log(message);
```
Transpilar y ejecutar:
```sh
tsc hello.ts
node hello.js
```

Esta práctica te ayudará a comprender las diferencias entre los procesos de compilación, transpilación e interpretación, y cómo se aplican en diferentes lenguajes de programación.



# Investigación/Expansión

Las prácticas de investigación/expansión de este laboratorio son las siguientes:


## Investigación 1. Proyecto real usando Grade (Investigación)

Gradle es una herramienta de automatización de construcción de código abierto que se utiliza principalmente para proyectos de software. Es especialmente popular en el ecosistema Java, pero también es compatible con otros lenguajes de programación como Groovy, Kotlin, Scala, y más.

### Características principales de Gradle

1. **Construcción basada en tareas**: Gradle utiliza un modelo de construcción basado en tareas, donde cada tarea representa una unidad de trabajo que se puede ejecutar de manera independiente.
2. **Soporte para múltiples lenguajes**: Aunque es muy popular en proyectos Java, Gradle también soporta otros lenguajes de programación y puede manejar proyectos poliglotas.
3. **Configuración flexible**: Gradle permite la configuración de scripts de construcción utilizando Groovy o Kotlin, proporcionando una gran flexibilidad y poder expresivo.
4. **Gestión de dependencias**: Gradle facilita la gestión de dependencias externas, descargándolas automáticamente desde repositorios remotos como Maven Central o JCenter.
5. **Integración con IDEs**: Gradle se integra bien con entornos de desarrollo integrados (IDEs) como IntelliJ IDEA, Eclipse y Android Studio, facilitando el flujo de trabajo de desarrollo.
6. **Construcción incremental**: Gradle optimiza el proceso de construcción mediante la ejecución de solo las tareas que han cambiado desde la última construcción, lo que mejora significativamente el rendimiento.

### Recursos adicionales

- [Documentación oficial de Gradle](https://gradle.org/docs/)
- [Repositorio de Gradle en GitHub](https://github.com/gradle/gradle)


### Tarea a realizar

Desarrolla todo el proceso del ciclo de vida de la fase de puesta en producción de los repositorios de JAVA pero utilizando Grade en lugar de Maven

1. Juego de Ajedrez en terminal (https://github.com/eliezergarbin/ChessSystem).
2. Calculadora de BMI (https://github.com/claudiavegarodriguez/bmicalc/).

## Investigación 2. Proyecto real de TypeScript usando NestJS (Backend)

Desarrolla todo el proceso de ciclo de vida de la fase de puesta en producción de los repositorio

NestJS es un framework de desarrollo backend para Node.js que está construido con TypeScript y utiliza principios de programación orientada a objetos, programación funcional y programación reactiva. NestJS se inspira en Angular, lo que facilita la creación de aplicaciones escalables y mantenibles.

### Características principales de NestJS

1. **Modularidad**: NestJS permite dividir la aplicación en módulos, lo que facilita la organización y el mantenimiento del código.
2. **Inyección de dependencias**: Utiliza un sistema de inyección de dependencias que permite gestionar las dependencias de manera eficiente.
3. **Soporte para TypeScript**: Aunque también se puede usar con JavaScript, NestJS está diseñado para aprovechar al máximo las características de TypeScript.
4. **Arquitectura basada en controladores y servicios**: Facilita la separación de responsabilidades y la creación de aplicaciones bien estructuradas.
5. **Middleware y Guards**: Permite el uso de middleware y guards para gestionar la lógica de las solicitudes y la seguridad de la aplicación.
6. **Soporte para WebSockets y Microservicios**: Incluye soporte nativo para WebSockets y microservicios, lo que facilita la creación de aplicaciones en tiempo real y distribuidas.

### Recursos adicionales

- [Documentación oficial de NestJS](https://docs.nestjs.com/)
- [Repositorio de ejemplo en GitHub](https://github.com/nestjs/nest)

NestJS es una excelente opción para desarrollar aplicaciones backend modernas y escalables, aprovechando las ventajas de TypeScript y una arquitectura bien definida.

### Tarea a realizar

Desarrolla todo el proceso del ciclo de vida de la fase de puesta en producción de un proyecto real usando NestJS

1. https://github.com/lujakob/nestjs-realworld-example-app


## Investigación 3. Proyecto real de App móvil usando Android

En esta investigación, trabajaremos con un proyecto real de una aplicación móvil utilizando Android y Gradle, pero sin utilizar interfaces gráficas ni IDEs. Todo el proceso se realizará mediante la línea de comandos (CLI).

### Paso 1: Clonar el repositorio

Primero, clona un repositorio real de GitHub que utilice Android. Por ejemplo, puedes usar el siguiente repositorio:

```bash
git clone https://github.com/android/sunflower.git
cd sunflower
```

### Paso 1: Clonar el repositorio

Primero, clona un repositorio real de GitHub que utilice Android. Por ejemplo, puedes usar el siguiente repositorio:

```bash
git clone https://github.com/android/sunflower.git
cd sunflower
```

### Paso 2: Instalar el SDK de Android y Gradle

1. **Instalar el SDK de Android**:
   - Descarga el SDK de Android desde [aquí](https://developer.android.com/studio#downloads).
   - Extrae el archivo descargado y configura la variable de entorno `ANDROID_HOME` apuntando a la ruta del SDK.

   ```bash
   export ANDROID_HOME=/path/to/android-sdk
   export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
   ```

2. **Instalar Gradle**:
   - Descarga e instala Gradle desde [aquí](https://gradle.org/install/).
   - Configura la variable de entorno `GRADLE_HOME` apuntando a la ruta de Gradle.

   ```bash
   export GRADLE_HOME=/path/to/gradle
   export PATH=$PATH:$GRADLE_HOME/bin
   ```

### Paso 3: Configurar el proyecto

1. Asegúrate de que todas las dependencias del proyecto estén instaladas. Ejecuta el siguiente comando en la raíz del proyecto:

   ```bash
   ./gradlew dependencies
   ```

### Paso 4: Revisión de gradle

1. Asegúrate de que los archivos de configuración de Gradle (`build.gradle`) estén correctamente configurados.

### Paso 5: Compilar el proyecto con Gradle

1. En la raíz del proyecto, ejecuta el siguiente comando para compilar la aplicación en modo release:

   ```bash
   ./gradlew assembleRelease
   ```

### Paso 6: Probar la aplicación

1. Utiliza el emulador de Android o conecta un dispositivo físico para probar la aplicación.
2. Para iniciar un emulador desde la línea de comandos, usa el siguiente comando:

   ```bash
   emulator -avd <nombre_del_emulador>
   ```

3. Para instalar el APK en el dispositivo/emulador, usa el siguiente comando:

   ```bash
   adb install -r app/build/outputs/apk/release/app-release.apk
   ```

### Paso 7: Preparar la puesta en producción

1. **Optimizar el código**:
   - Elimina el código no utilizado y optimiza las dependencias.
   - Minimiza y ofusca el código para dificultar la ingeniería inversa.

2. **Configurar permisos y políticas**:
   - Revisa y ajusta los permisos solicitados por la aplicación.
   - Asegúrate de cumplir con las políticas de Google Play y las regulaciones de privacidad.

### Paso 8: Generar un APK firmado

1. **Crear un archivo de firma (keystore)**:
   - Si no tienes un keystore, crea uno usando el siguiente comando:

   ```bash
   keytool -genkey -v -keystore my-release-key.jks

 -

keyalg RSA -keysize 2048 -validity 10000 -alias my-alias
   ```

2. **Firmar el APK**:
   - Configura el archivo `build.gradle` para incluir la firma del APK.
   - Añade la configuración de firma en el archivo `gradle.properties`:

   ```properties
   MYAPP_RELEASE_STORE_FILE=my-release-key.jks
   MYAPP_RELEASE_KEY_ALIAS=my-alias
   MYAPP_RELEASE_STORE_PASSWORD=<tu_password>
   MYAPP_RELEASE_KEY_PASSWORD=<tu_password>
   ```

   - Compila el APK firmado:

   ```bash
   ./gradlew assembleRelease
   ```

### Criterios de Evaluación Asociados

| RA1 | Prueba aplicaciones web y aplicaciones para dispositivos móviles analizando la estructura del código y su modelo de ejecución |
|------|-------------------------------------------------------------------------------------------------------------|
| 1.a  | Se han comparado diferentes lenguajes de programación de acuerdo a sus características                       |
| 1.b  | Se han descrito los diferentes modelos de ejecución de software                                             |
| 1.c  | Se han reconocido los elementos básicos del código fuente, dándoles significado                             |
| 1.d  | Se han ejecutado diferentes tipos de prueba de software                                                     |
| 1.e  | Se han evaluado los lenguajes de programación de acuerdo a la infraestructura de seguridad que proporcionan |

| RA5  | Implanta sistemas seguros de desplegado de software, utilizando herramientas para la automatización de la construcción de sus elementos |
|------|---------------------------------------------------------------------------------------------------------------------------------------|
| 5.a  | Se han identificado las características, principios y objetivos de la integración del desarrollo y operación del software              |



### Recursos adicionales

- [Documentación oficial de Android Studio](https://developer.android.com/studio/intro)
- [Guía de lanzamiento de aplicaciones en Google Play](https://developer.android.com/distribute/best-practices/launch/launch-checklist)
- [Repositorio de ejemplo en GitHub](https://github.com/android/sunflower)

Esta guía te ayudará a configurar, desarrollar, probar y poner en producción una aplicación móvil en Android de manera segura utilizando Gradle y la línea de comandos. ¡Buena suerte!


---
Author: Carlos Caballero González (https://www.carloscaballero.io)
