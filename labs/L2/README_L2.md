# Laboratorio 2

# Índice

- [Práctica 2.1](#id1)
- [Práctica 2.2](#id2)
- [Práctica 2.3](#id3)
- [Práctica 2.4](#id4)
- [Práctica 2.5](#id5)
- [Práctica 2.6](#id6)
- [Práctica 2.7](#id7)
- [Práctica 2.8](#id8)
- [Práctica 2.9](#id9)


# Práctica 2.1. Configuración de GIT <a name="id1"></a>

### Realiza la práctica guiada para configurar GIT en tu entorno de trabajo.

![Añadimos nuestro nombre y usuario](img2.1/image1.png)

*  Aqui se realiza la configuración del nombre y del correo de GIT

![Añadimos nuestro nombre y usuario](img2.1/image2.png)

*  Aqui se realiza la configuración del editor de texto te que va a usar git, en mi caso he usado nano 

![Añadimos nuestro nombre y usuario](img2.1/image3.png)

*  Aqui se realiza la una prueba de como se pueden usar alias para abreviar comandos de git, se suele realizar para los comandos mas frecuentes, en este caso el git status, despues se ve el comando que quita el alias

![Añadimos nuestro nombre y usuario](img2.1/image4.png)

*  En esta imagen se ve el .gitignore que configure segun mis necesidades con forme a la practica anterior, este archivo es el encargado de decirle a git que cosas se tienen que ignorar a la hora de subir el proyecto.

![Añadimos nuestro nombre y usuario](img2.1/image5.png)

*  Aqui se usa el comando que habilita el almacenamiento de las credenciales en caché para no tener que estar poniendo el usuario y la contraseña cada vez que se quiere interactuar con un repositorio remoto, este comando por defecto lo almacena durante 15 minutos, si quieres aumentar el tiempo, se usa el siguiente comando que se observa en la imagen

# Práctica 2.2. Trabajando con GIT básico <a name="id2"></a>

### Haciendo uso de algún proyecto “real” descargado desde el repositorio GitHub (consultar con el profesor antes de tomar un repositorio, puesto que debe ser de un proyecto real de gran envergadura), demostrar que sabéis usar los comandos útiles de Git para observar el repositorio de dicho proyecto (git log, git diff, git blame y git show).

### Por cada uno de estos 4 comandos, hay que evidenciar 4 capturas (junto a su explicación, ejemplo y todo lo que se desee aportar) de diferentes usos (opciones) del mismo comando. Junto a cada captura, hay que explicar con vuestras palabras lo que se quiere probar, demostrar o buscar con ese comando/opción.

En mi caso de he usado el proyecto del ajedrez usado en el primer laboratorio

-  GIT LOG

   ![Añadimos nuestro nombre y usuario](img2.2/image1.png)
      - Este comando git log es simple pero muy util ya que te permite realizar un log de los ultimos X commits que se han realizado, siendo X la cantidad de commits que quieras observar , es este caso 3

   ![Añadimos nuestro nombre y usuario](img2.2/image2.png)
      - Este comando git log en adicion al anterior contiene el " --stat " que se usa para ver las estadisticas detallas sobre los commit, como se puede observar en el ejemplo , en el commit concreto se ha modificado el README 

   ![Añadimos nuestro nombre y usuario](img2.2/image3.png)
      - Este comando git log te proporciona una visión simple de los commit junto a su ID y título , en este caso te muestra solo 10 

   ![Añadimos nuestro nombre y usuario](img2.2/image4.png)
      
      - Este comando git log te muestra  3 logs en los que se ha modificado en este caso la carpeta src pero se puede especificas el archivo o carpeta que se desee que se encuentre en el proyecto

- GIT DIFF

    ![Añadimos nuestro nombre y usuario](img2.2/image6.png)  
      - El comando git diff sirve para visualizar las diferencias que se encuentran entre el directorio de trabajo y del staging pero todavía no han sido subidos al staging

    ![Añadimos nuestro nombre y usuario](img2.2/image5.png)  
      - Este comando git diff hace una comparación  de dos commit en concreto 

    ![Añadimos nuestro nombre y usuario](img2.2/image7.png)  
      - Este comando git diff compara un archivo concreto del directorio de trabajo con la versión en HEAD , en este caso ha sido el README del proyecto el cual le he hecho una pequeña modificación 

    ![Añadimos nuestro nombre y usuario](img2.2/image8.png)  
      - Este comando git diff es util para comparar el ultimo commit realizado con lo que hay subido al staging, por ello previamente al comando he usado git add . con un pequeño cambien en el readme del proyecto 

- GIT SHOW
    
    ![Añadimos nuestro nombre y usuario](img2.2/image9.png)  
      - Este comando git show te muestra los cambios de un commit en concreto

    ![Añadimos nuestro nombre y usuario](img2.2/image10.png)  
      - Este comando git show te muestra un archivo en concreto de  un commit en concreto 

    ![Añadimos nuestro nombre y usuario](img2.2/image11.png)  
      - Este comando git show te muestra las "estadisticas" de las variaciones de un commit, esto es util si simplemente quieres ver que archivos se han modificado pero no quieres ver en concreto las lineas de codigo

    ![Añadimos nuestro nombre y usuario](img2.2/image12.png)  
      - Este comando git show te muestra las variaciones de una rama en concreto

- GIT BLAME
    ![Añadimos nuestro nombre y usuario](img2.2/image13.png)  
      - Este comando te muestra quien y cuando ha modificado un archivo en concreto

    ![Añadimos nuestro nombre y usuario](img2.2/image14.png)  
      - Este comando git blame te muestra ente X y X lineas quien y cuando lo ha modificado un archivo en concreto. En este caso muestra quien y cuando se ha modificado entre la linea 10 y 20 del README

    ![Añadimos nuestro nombre y usuario](img2.2/image15.png)  
      - Este comando git blame te muestra en que commit se añadio una línea de codigo

    ![Añadimos nuestro nombre y usuario](img2.2/image16.png)  
      - Este comando git blame es un git blame normal pero con mas información sobre un archivo en concreto


# Práctica 2.3. Ejercicio Práctico: Uso de Comandos de Git y Gitflow <a name="id3"></a>

### Secuencia del Proyecto

Una posible secuencia del proyecto podría ser la siguiente (obtenido del libro _Git, Controle la gestión de sus versiones - Samuel Dazón_):

### 1. **C1 (master)**: Primer commit del proyecto. Este commit añade la base del proyecto en el repositorio. _(Tag: versión v1.0.0)._

![Añadimos nuestro nombre y usuario](img2.3/image1.png) 

- En esta primera imagen nos encontramos con el comando `git init ` que su funcon es crear en el directorio en el que nos encontramos la inicialización del proyecto añadiendo el subdirectorio `.git` que almacena todo lo que es la configuración y historial

![Añadimos nuestro nombre y usuario](img2.3/image2.png) 

En esta imagen nos encontramos con diferentes comandos que no han aparecido anteriormente que son los siguiente:

- El comando ` git add .` que su funcion es agregar todos los archivos nuevos o modificados del directorio en el que nos encontramos al staging area 
- El comando ` git commit -m "mensaje personalizado"` como su nombre indica es el encargado de realizar un commit con los cambios añadidos en el staging area previamente añadido con ` git add .`, para realizar un commit es necesario añadir un mensaje para asociar a ese commit que se pone con ` -m "mensaje"`
- El comando ` git tag "nombre del tag"` esta variante de git tag como su nombre indica añade un tag al ultimo commit subido, mas adelante se verá la variante de añadir un tag a un commit en específico
- El comando `git branch -m "nombre rama"`, este comando lo he usado para personalizar la actividad, ya que me pedian que agregara mis apellidos a la rama master, entonces su funcion es cambier el nombre a la rama actual en la que te encuentras
- El comando ` git log ` en cual comento su utilidad en el ejercicio anterior

### 2. **C2 (develop)**: Creación de la rama `develop`. Después de este commit, las dos ramas principales están creadas.

![Añadimos nuestro nombre y usuario](img2.3/image3.png) 

En esta imagen podemos observar un comando nuevo:

-  El comando `git checkout -b "nombreRama"` el cual su funcionalidad es crear una rama y a parte desplazarte a la rama creada
- Despues para completar el apartado, una vez el la rama nueva, modifico el archivo de prueba , añado los cambios a staging con `add` y realizo el `commit ` , finalmente muestro que se ha realizado correctamente



### 3. **C3 (graph_employee)**: Creación de una rama para añadir gráficos en la página de los trabajadores (creado por Programador Nº 2).

![Añadimos nuestro nombre y usuario](img2.3/image4.png) 

- En esta imagen realizo los mismos comandos que antes, modifico el archivo,subo a staging,hago el commit y lo muestro en la siguiente imagen

![Añadimos nuestro nombre y usuario](img2.3/image5.png) 


### 4. **C4 (hotfix-negative-time)**: Creación de una rama para gestionar el caso en que un trabajador introduzca un valor negativo en una tarea.

![Añadimos nuestro nombre y usuario](img2.3/image6.png) 

En esta imagen podemos ver dos comandos nuevos 

- El comando `git branch` ,anteriormente hemos visto una variacion con el -m que era para cambiar el nombre de la rama actual, pero en este caso este comando te muestra las ramas que tiene el repositorio y en cual te encuentras.
- El comando `git checkout "nombre rama"` ,anteriormente hemos visto una variacion con el -b que era para crear una rama y desplazarte a ella, pero en este caso este comando solo te desplaza a una rama ya existente .
- Despues observamos la combinación de comandos explicados anteriormente para lograr realizar este apartado correctamente
### 5. **C5 (master)**: Integración del parche en la rama `master`. _(Tag: versión v1.0.1)._

![Añadimos nuestro nombre y usuario](img2.3/image7.png) 

 En esta imagen observamos un comando nuevo:

- El comando `git merge "nombre rama"` que su funcion es fusionar los cambios de la rama que se especifica en la rama en la que nos encontramos actualmente combinando el historial y los cambios de la rama especificada con la actual. Normalmente se suele usar para integrar una rama secundaria a una principal
- Despues he usado la combinacion de comandos explicados anteriormente de forma correcta para lograr el objetivo del enunciado

![Añadimos nuestro nombre y usuario](img2.3/image8.png) 

![Añadimos nuestro nombre y usuario](img2.3/image9.png) 

- En esta ultima imagen se observa una variante nueva del comando explicado ya git tag pero con la siguiente forma `git tag "nombreTag" "hashCommitEspecifico"`, esta variante asigna un tag a un commit especifico usando su hash
### 6. **C6 (develop)**: Integración del parche en la rama `develop`.

![Añadimos nuestro nombre y usuario](img2.3/image10.png) 

![Añadimos nuestro nombre y usuario](img2.3/image11.png) 
 
![Añadimos nuestro nombre y usuario](img2.3/image12.png) 

En este apartado quiero destacar tambien que algunas veces cuando haces un merge puede que haya conflictos entre archivos , ya que en las dos ramas se encuentra un archivo con cosas distintas, para solucionarlo tienes que dejar la versión que quieras y hacer un add y un commit como se ven en las imagenes anteriores de este apartado

### 7. **C7 (task_type)**: Creación de una rama para añadir el tipo de tareas.

![Añadimos nuestro nombre y usuario](img2.3/image13.png) 
 
### 8. **C8 (graph_employee)**: Último commit de la rama `graph_employee`.

![Añadimos nuestro nombre y usuario](img2.3/image14.png) 
 
### 9. **C9 (develop)**: Integración de la rama `graph_employee` en `develop`. Se elimina la rama `graph_employee`.

![Añadimos nuestro nombre y usuario](img2.3/image15.png) 
 
![Añadimos nuestro nombre y usuario](img2.3/image16.png) 
 
![Añadimos nuestro nombre y usuario](img2.3/image17.png) 
 
![Añadimos nuestro nombre y usuario](img2.3/image18.png) 
 
### 10. **C10 (task_type)**: Último commit de la rama `task_type`.

![Añadimos nuestro nombre y usuario](img2.3/image19.png)  

### 11. **C11 (develop)**: Integración de la rama `task_type` en `develop`.

![Añadimos nuestro nombre y usuario](img2.3/image20.png) 
![Añadimos nuestro nombre y usuario](img2.3/image21.png) 
![Añadimos nuestro nombre y usuario](img2.3/image22.png) 

### 12. **C12 (release-V1.1)**: Creación de la rama para la versión 1.1.

![Añadimos nuestro nombre y usuario](img2.3/image23.png) 


### 13. **C13 (export_csv)**: Creación de una rama para agregar una funcionalidad de exportar a CSV las tareas de un empleado durante un periodo.

![Añadimos nuestro nombre y usuario](img2.3/image24.png) 

- 
### 14. **C14 (release-V1.1)**: Parche para corregir un error en el gráfico cuando el trabajador no tiene tareas.

![Añadimos nuestro nombre y usuario](img2.3/image25.png) 

### 15. **C15 (master)**: Integración de la versión 1.1 en la rama `master`. _(Tag: versión v1.1)._

![Añadimos nuestro nombre y usuario](img2.3/image26.png) 
 
![Añadimos nuestro nombre y usuario](img2.3/image27.png) 
 
### 16. **C16 (develop)**: Integración del parche de la versión 1.1 en la rama `develop`.

![Añadimos nuestro nombre y usuario](img2.3/image28.png)  

### 17. **C17 (export_csv)**: Último commit de la rama `export_csv`.

![Añadimos nuestro nombre y usuario](img2.3/image29.png) 

### 18. **C18 (develop)**: Integración de la rama `export_csv` en `develop`.

![Añadimos nuestro nombre y usuario](img2.3/image30.png) 

![Añadimos nuestro nombre y usuario](img2.3/image31.png)  

![Añadimos nuestro nombre y usuario](img2.3/image32.png) 

## Resultado Final

![Añadimos nuestro nombre y usuario](img2.3/image33.png) 

Este seria el resultado final del historial de todas las ramas. 

En los apartados finales no he escrito mucho texto porque realmente solo usaba los comandos que he explicado en las primeras imagenes y pienso que sería muy repetitivo volver a decir lo mismo en todas las imagenes


# Práctica 2.4. Configurando hooks de GIT (1 punto) <a name="id4"></a>

En esta práctica, aprenderás a configurar y utilizar hooks en GIT para automatizar tareas comunes en tu flujo de trabajo. Los hooks son scripts que GIT ejecuta automáticamente en ciertos puntos del ciclo de vida de los commits y otras acciones de GIT. 

### Objetivos:

1. Configurar un hook pre-commit para verificar el formato del código antes de permitir un commit.
2. Configurar un hook commit-msg para asegurar que los mensajes de commit sigan un formato específico.
3. Configurar un hook post-merge para ejecutar pruebas automatizadas después de una fusión.

## Instrucciones:

### 1. Crea un repositorio GIT nuevo o utiliza uno existente.

En nuestro caso voy a usar mi propio repositorio de git para que luego se pueda ver que se ha realizado el ejercicio a parte de las capturas

### 2. Navega al directorio `.git/hooks` dentro de tu repositorio.

![Añadimos nuestro nombre y usuario](img2.4/image1.png) 

### 3. Copia y pega los scripts en los archivos correspondientes dentro del directorio `.git/hooks`

![Añadimos nuestro nombre y usuario](img2.4/image2.png) 
![Añadimos nuestro nombre y usuario](img2.4/image3.png) 
![Añadimos nuestro nombre y usuario](img2.4/image4.png) 

### 4. Asegúrate de que los scripts sean ejecutables
![Añadimos nuestro nombre y usuario](img2.4/image5.png) 
### 5. Pruebas para verificar que los hooks funcionan correctamente.

![Añadimos nuestro nombre y usuario](img2.4/image6.png) 

- Como podemos ver en la imagen anterior, al realizar un commit se ve como se ejecutan el hook de pre-commit y el commit-msg , los cuales ya se pueden configurar segun tus necesidades en el proyecto por si tienes que tener un patron especifico en los mensajes de los commit o en la forma de hacer los commits como tal

![Añadimos nuestro nombre y usuario](img2.4/image7.png) 

- Ahora vamos a comprobar que se ejecuta el hook de merge, para ello hemos creado una rama de prueba 

![Añadimos nuestro nombre y usuario](img2.4/image8.png) 

- vamos a crear un archivo nuevo de prueba para realizar un commit en la rama de prueba para posteriormente realizar el merge. Como se puede ver tambien en la imagen anterior en esta rama al hacer commit tambien se lanzar los hooks de commit ya que se lanzar en todo el repositorio

![Añadimos nuestro nombre y usuario](img2.4/image9.png) 

- Ahora nos cambiamos a la rama main y se puede comprobar en la imagen anterior poque en el log no se encuentra el commit de la otra rama

![Añadimos nuestro nombre y usuario](img2.4/image10.png) 

- Con el comando git branch corroboro mas todavia que estamos en la rama main y finalmente realizamos un merge de la rama de prueba y observamos dentro del cuadrado amarillo que se lanza el hook de merge

# Práctica 2.5. Configurando hooks usando Husky (1 punto) <a name="id5"></a>

En esta práctica, aprenderás a configurar y utilizar Husky para gestionar hooks en GIT de manera más sencilla y eficiente. Husky es una herramienta que facilita la creación y gestión de hooks en GIT, permitiendo automatizar tareas comunes en tu flujo de trabajo.

### Objetivos:
1. Instalar Husky en un proyecto GIT.
2. Configurar un hook pre-commit para verificar el formato del código antes de permitir un commit.
3. Configurar un hook commit-msg para asegurar que los mensajes de commit sigan un formato específico.
4. Configurar un hook post-merge para ejecutar pruebas automatizadas después de una fusión.

## Instrucciones:

### Si quieres puedes ver lo que he hecho en la carpeta Actividad-L2-2.5 , le he cambiado a la carpeta .git el nombre a git oculto 

### 1. Crea un repositorio GIT nuevo o utiliza uno existente.

![Añadimos nuestro nombre y usuario](img2.5/image1.png) 

- Para esta practica he creado un repositorio en un directorio nuevo

### 2. Asegúrate de tener Node.js y npm instalados en tu sistema.

![Añadimos nuestro nombre y usuario](img2.5/image2.png) 


### 3. Instala Husky en tu proyecto

![Añadimos nuestro nombre y usuario](img2.5/image3.png) 


### 4. Inicializa Husky en tu proyecto

![Añadimos nuestro nombre y usuario](img2.5/image4.png) 

- Como podemos ver al usar este comando se nos genera la carpeta ` .husky` , ` node modules `, y dos archivos .json 

### 5. Configura los hooks utilizando Husky


![Añadimos nuestro nombre y usuario](img2.5/image5.png) 


![Añadimos nuestro nombre y usuario](img2.5/image6.png) 

- Como podemos observar en estas imagenes aparecen todos los archivos de hooks dentro de ` .husky ` , he estado intentando usar los comandos del ejercicio para configurar los hooks pero me pone que estan DEPRECATED y no me los modificaba . Asi que vi que para modificarlos tenia que quitar las lineas que te dice el ` husky.sh  ` . En las siguientes imagenes se va a mostrar que pongo en cada archivo y la ultima imagen es como estan los archivos predeterminados de los hooks . 

![Añadimos nuestro nombre y usuario](img2.5/image10.png) 

![Añadimos nuestro nombre y usuario](img2.5/image7.png) 

- Archivo pre-commit

![Añadimos nuestro nombre y usuario](img2.5/image8.png) 

- Archivo commit-msg

![Añadimos nuestro nombre y usuario](img2.5/image9.png) 

- Archivo post-merge

![Añadimos nuestro nombre y usuario](img2.5/image11.png) 

- Archivo predeterminado, al cual si quieres usarlo debes de quitarle esta lineas


### 6. Realiza pruebas para verificar que los hooks funcionan correctamente

![Añadimos nuestro nombre y usuario](img2.5/image12.png) 

- Como se puede observar , hago un add y un commit de un rachivo de prueba y se ejecuta los hooks de husky

![Añadimos nuestro nombre y usuario](img2.5/image13.png) 

- Lo mismo pasa cuando hago un commit en la otra rama y a la hora de realizar el merge se ejecuta el post-merge de husky

# Práctica 2.6. Firmando commits (1.5 puntos) <a name="id6"></a>

En esta práctica, aprenderás a firmar tus commits en GIT utilizando GPG (GNU Privacy Guard) para asegurar la autenticidad e integridad de tus cambios. Firmar tus commits añade una capa adicional de seguridad y confianza, permitiendo a otros verificar que los commits realmente provienen de ti. Además, podrás ver la verificación de tus commits firmados en plataformas como GitHub.

### Objetivos:
1. Generar una clave GPG si no tienes una.
2. Configurar GIT para usar tu clave GPG.
3. Firmar tus commits con GPG.
4. Verificar la firma de tus commits en GitHub.

### Instrucciones:

### 1. Generar una clave GPG

![Añadimos nuestro nombre y usuario](img2.6/image1.png) 

- Usamos el comando ` gpg --full-generate-key` para generear las keys, esta modalidad del comando te permite configurar muchos apartados de tu key como por ejemplo se ve en la imagen anterior el timo de kay quieres. 

![Añadimos nuestro nombre y usuario](img2.6/image2.png) 

- En esta imagen elegimos como de largo queremos que sea la key

![Añadimos nuestro nombre y usuario](img2.6/image3.png) 

- En esta imagen elegimos cuanto tiempo queremos que sea valida la key, para esta prueba no tiene tiempo de expiracion pero para que sea mas segura deberia tener un tiempo de expiracion. Ponemos nuesto nombre, el correo que tiene que ser importante que sea el mismo que se usa en github.

![Añadimos nuestro nombre y usuario](img2.6/image4.png) 

- Esta es la parte final de la configuración donde, una vez que finalizas, te pide que pongas una contraseña en una ventana a parte para introducirla cuando se usa la key

### 2. Configurar GIT para usar tu clave GPG

![Añadimos nuestro nombre y usuario](img2.6/image8.png) 

- con el comando `gpg --list-keys` te muestra todas las keys que has creado y con el comando ` gpg --armor --export "id de la key"` te muestra la key completa para exportarla. Como se puede observar a partir de aqui uso una key diferente a la que cree anteriormente ya que me daba errores para hacer los commits, pensando que era culpa de la key genere una nueva pero seguia sin funcionarme  y al final era un error de exportación de  las keys con WSL de Windows pero tenia todo git y github ya configurado con la nueva key y por eso uso la nueva

![Añadimos nuestro nombre y usuario](img2.6/image11.png) 

- Con los comandos usados en el laboratorio 2:
- añado las globales de la key con su id :`git config --global user.signingkey <tu_clave_gpg>`
- añado que se firmen los commit con las keys:`git config --global commit.gpgSign true`
 

![Añadimos nuestro nombre y usuario](img2.6/image5.png) 

- Ahora vamos a configurar GitHub para que use la misma key, para ello en la parte superior derecha de la pantalla en la imagen de nuestro perfil hacemos click y despues a settings y llegariamos a la imagen anterior

![Añadimos nuestro nombre y usuario](img2.6/image6.png) 

- Ahora nos direigimos a la parte de SSh y GPG key y nos saldria esta imagen 

![Añadimos nuestro nombre y usuario](img2.6/image7.png) 

- Ahora le damos a nueva key GPG y nos saldria esta imagen

![Añadimos nuestro nombre y usuario](img2.6/image8.png) 

- Ahora volvemos a nuestro listado de keys y añadimos la key entera como se explica en el box donde se tiene que añadir y le ponemos un nombre que queramos a la key

![Añadimos nuestro nombre y usuario](img2.6/image9.png) 

- Despues de añadir la key  y ponerle un nombre le damos al botón de añadir key y te devuelve a la pantalla de settingd pero deberias ver una key como esta con tus parametros.

### 3. Firmar tus commits con GPG

![Añadimos nuestro nombre y usuario](img2.6/image10.png) 

- Ahora al realizar los commit te pide la contraseña que le pusiste a la key asignadoa y si la escribes correctamente se realiza el commit.

### 4. Verificar la firma de tus commits en GitHub

![Añadimos nuestro nombre y usuario](img2.6/image12.png) 

- Una vez realizados los commits para comprobar la firma en github realizamos un push y si nos vamos al apartado de commits de nuestro repositorio, podemos observar que los commits firmados tienen un sello de color verde con la palabra "Verified" dentro 

# Práctica 2.7. Securizando GIT: Git-Secrets (1.5 puntos) <a name="id7"></a>

En esta práctica, aprenderás a utilizar `git-secrets` para evitar que información sensible, como claves API y contraseñas, se incluya accidentalmente en tus commits de GIT. `git-secrets` es una herramienta que escanea tus commits y previene que información sensible sea añadida al repositorio.

## Objetivos:
1. Instalar `git-secrets` en tu sistema.
2. Configurar `git-secrets` en un repositorio GIT.
3. Añadir patrones para detectar información sensible.
4. Probar `git-secrets` para asegurarte de que funciona correctamente.

### Instrucciones:

### 1. Instalar `git-secrets`

![Añadimos nuestro nombre y usuario](img2.7/image1.png) 

- Para instalar git-secrets clonamos el repositorio de secrets, accedemos a la carpeta que se genera y usamos el make install para instalar git-secrets en nuestro equipo

### 2. Configurar `git-secrets` en tu repositorio

![Añadimos nuestro nombre y usuario](img2.7/image2.png) 

- Una vez realizado el paso anterior hay que inicializar git secret en nuestro repositorio con los comandos que se ven en la imagen. He tenido que forzar el comando por los hooks que 
tenia creados anteriormente de la practica anterior

![Añadimos nuestro nombre y usuario](img2.7/image3.png) 

- Ahora vamos a añadir los patrones de AWS para que al realizar un commit o se escanee el repositorio, si hay una posible variable de AWS con contraseña o algo que deberia de ser privado, te lo reconoce y en caso de intentar hacer un commit te lo bloquea hasta que la quites , para evitar posibles filtraciones

### 3. Probar `git-secrets`
![Añadimos nuestro nombre y usuario](img2.7/image4.png) 

- Aqui se puede observar como intento realizar una prueba para comprobar de que si tengo una variable de aws en uno de mis archivos del repositorio , al realizar un commit me lo bloquea pero no he conseguido que me funcione , y me parece raro poruq en las siguientes imagenes se ùede observar como aparecen los patrones de AWS en la lista de secrets, sospecho que pueda ser un problema de WSL pero no he conseguido resolverlo

### 4. Verificar la configuración

![Añadimos nuestro nombre y usuario](img2.7/image6.png) 

- En esta imagen podemos ver los hooks de secrets y la lista de patrones que tiene

### 5. Añadir patrones personalizados

![Añadimos nuestro nombre y usuario](img2.7/image7.png) 

- Aqui realizo un patron para bloquear posibles correos,realizo un cambio en el archivo test y añado un ejemplo de correo y al realizar el commit me lo bloquea.

# Práctica 2.8. Securizando GIT: Trufflehog: Local (1.25 puntos) <a name="id8"></a>

En esta práctica, aprenderás a utilizar TruffleHog para escanear tu repositorio GIT en busca de información sensible, como claves API y contraseñas, que puedan haberse incluido accidentalmente en tus commits. TruffleHog es una herramienta que busca patrones de información sensible en el historial de commits de tu repositorio.

### Objetivos:
1. Instalar TruffleHog en tu sistema.
2. Configurar TruffleHog para escanear un repositorio GIT local.
3. Ejecutar TruffleHog para detectar información sensible en el historial de commits.
4. Analizar los resultados del escaneo y tomar medidas para eliminar cualquier información sensible encontrada.

### Instrucciones:

### 1. Instalar TruffleHog

![Añadimos nuestro nombre y usuario](img2.8/image1.png) 

- Instalo el TruffleHog con el  comando que se ve en la imagen

### 2. Configurar TruffleHog para escanear un repositorio GIT local

- Esta instruccion creo que se puede omitir porque justo han actualizado trufflehog y no he encontrado ninguna forma de configurarlo, analiza el repositorio automáticamente
### 3. Ejecutar TruffleHog

![Añadimos nuestro nombre y usuario](img2.8/image2.png) 

- Con el comando que se ve e la imagen analizo el repositorio git local, en la nueva actualización de trufflehog explica que para analizar el repositorio no puedes estar dentro de la carpeta que tiene el .git, de echo si lo ejecutar ahi no lo analiza

### 4. Analizar los resultados del escaneo

- Como podemos ver en el cuadrado amarillo de la imagen anterior no ha analizado secretos en commit realizados con desconocidos ni verified , es decir , los commit firmados y sin firmar

### 5. Verificar la eliminación de información sensible

- No he eliminado nada ya que no hay información sensible, en el siguiente paso se provocará una vulnerabilidad para eliminarala

### 6. Provoca una vulnerabilidad y localizala

![Añadimos nuestro nombre y usuario](img2.8/image3.png) 

- Como se ve en la imagen de arriba, he creado un archivo ` .env` con una vulnerabilidad dentro y he realizado un commit de este.  

![Añadimos nuestro nombre y usuario](img2.8/image4.png) 

- Ahora volvemos a analizar el repositorio con trufflehog y nos damos cuanta de que aparece que en un commit hay un secreto.

![Añadimos nuestro nombre y usuario](img2.8/image5.png) 

- Una vez hemos detectado el commit vamos a proceder a eliminarlo del historial de commit para evitar que nos roben esa información. Para ello vemos todos los commit que hemos realizado y buscamos el commit con el mismo hash que detecto trufflehog. Para eliminarlo vamos a usar el comando ` git rebase -i HEAD~"numero de commit que quieres acceder a modificar"` 

![Añadimos nuestro nombre y usuario](img2.8/image6.png) 

- Unavez seleccionamos los commit que queremos modificar, en mi caso uno ya que tiene la vulnerabilidad en el ultimo commit que he realizado, se habre un archivo el cual aparece el commit/commits que has elegido que aparezcan, para eliminarlo del historial de commits hay que ponerlo drop delante como se puede ver en la imagen.

![Añadimos nuestro nombre y usuario](img2.8/image7.png) 

- Una vez que guardamos y cerramos el archivo, se elimina el commit del historial.

![Añadimos nuestro nombre y usuario](img2.8/image8.png) 

- Para comprobarlo que se a eliminado correctamente volvemos a analizar el repositorio con trufflehog y vemos que no encuentra ningun secreto

# Práctica 2.9. Securizando GIT: Trufflehog: Remoto (1.25 puntos) <a name="id9"></a>

En esta práctica, aprenderás a utilizar TruffleHog para escanear un repositorio GIT remoto en busca de información sensible.

### Objetivos:
1. Configurar TruffleHog para escanear un repositorio GIT remoto.
2. Ejecutar TruffleHog para detectar información sensible en el historial de commits del repositorio remoto.
3. Analizar los resultados del escaneo y tomar medidas para eliminar cualquier información sensible encontrada.

### Instrucciones:

### 1. Configurar TruffleHog para escanear un repositorio GIT remoto

- Como he comentado en la practica anterior en la ultima version de trufflehog no he encontrado nada que se puede configurar, lo hace todo automaticamente

### 2. Ejecutar TruffleHog

![Añadimos nuestro nombre y usuario](img2.9/image1.png) 

- Para realizar un analisis en remoto hay que pasarle la url a trufflehog como se ve en la imagen, yo he usado de ejemplo la url del repositorio de Ajedrez del laboratorio anterior

### 3. Analizar los resultados del escaneo

- Como podemos observar el repositorio de Ajedrez no tienen ningun secreto en sus commits .

### 4. Verificar la eliminación de información sensible

- No he tenido que eliminar información sensible ya que el ajedrez no tiene .