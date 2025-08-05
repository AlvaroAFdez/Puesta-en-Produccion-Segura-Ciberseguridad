# Laboratorio: Introducción a Docker

## Objetivos
- Comprender los conceptos básicos de contenedores.
- Aprender a utilizar Docker para gestionar contenedores.

## Prerrequisitos
- Tener Docker instalado en tu sistema.
- Conocimientos básicos de línea de comandos.

Para instalar Docker en tu sistema, sigue los pasos correspondientes a tu sistema operativo:

## Instalación
#### En Windows
1. Descarga el instalador de Docker Desktop desde [docker.com](https://www.docker.com/products/docker-desktop).
2. Ejecuta el instalador y sigue las instrucciones en pantalla. Asegúrate de seleccionar las opciones predeterminadas a menos que tengas una razón específica para cambiarlas.
3. Una vez completada la instalación, abre Docker Desktop desde el menú de inicio.

#### En macOS
1. Descarga el instalador de Docker Desktop desde [docker.com](https://www.docker.com/products/docker-desktop).
2. Abre el archivo `.dmg` y arrastra Docker a la carpeta de Aplicaciones.
3. Abre Docker desde la carpeta de Aplicaciones y sigue las instrucciones en pantalla.

#### En Linux
1. Abre la terminal.
2. Instala Docker utilizando el gestor de paquetes de tu distribución. Por ejemplo, en Debian/Ubuntu:
    ```bash
    sudo apt-get update
    sudo apt-get install docker-ce docker-ce-cli containerd.io
    ```
   En Fedora:
    ```bash
    sudo dnf install docker-ce docker-ce-cli containerd.io
    ```
   En Arch Linux:
    ```bash
    sudo pacman -S docker
    ```
3. Inicia el servicio de Docker:
    ```bash
    sudo systemctl start docker
    ```
4. Verifica la instalación comprobando la versión de Docker:
    ```bash
    docker --version
    ```

Una vez que hayas instalado Docker, puedes proceder a la configuración inicial y a los demás pasos del laboratorio.


## 1. Configuración Inicial

Antes de comenzar a trabajar con Docker, es importante configurar tu entorno para que los contenedores que crees estén correctamente configurados. Esta configuración solo necesita hacerse una vez por máquina.

### 1.1. Verificar la Instalación de Docker

Para asegurarte de que Docker está correctamente instalado y funcionando, puedes ejecutar el siguiente comando para verificar la versión de Docker:

```bash
docker --version
```

### 1.2. Configuración del Usuario en Docker

Docker utiliza el usuario del sistema para ejecutar los contenedores. Asegúrate de que tu usuario tiene los permisos necesarios para ejecutar Docker sin necesidad de usar `sudo`. Puedes añadir tu usuario al grupo `docker` con el siguiente comando:

```bash
sudo usermod -aG docker $USER
```

Después de ejecutar este comando, cierra la sesión y vuelve a iniciarla para que los cambios surtan efecto.

### 1.3. Verificar la Configuración

Para verificar que tu usuario puede ejecutar Docker sin `sudo`, ejecuta el siguiente comando:

```bash
docker run hello-world
```

Este comando descarga una imagen de prueba y ejecuta un contenedor que imprime un mensaje de bienvenida. Si ves el mensaje de bienvenida, Docker está correctamente configurado.

Una vez que hayas configurado Docker, puedes proceder a los demás pasos del laboratorio.

## 2. Primeros Pasos: Diferencia entre Imagen y Contenedor

En esta sección aprenderás a diferenciar entre una imagen y un contenedor en Docker, y realizarás tus primeros comandos básicos.

### 2.1. Comprobar las Imágenes Descargadas

Para ver las imágenes que tienes descargadas en tu sistema, utiliza el siguiente comando:

```bash
docker image ls
```

Este comando lista todas las imágenes disponibles en tu sistema.

### 2.2. Descargar una Imagen

Descarga tu primera imagen de Docker. En este caso, descargaremos la imagen `nginx:alpine`:

```bash
docker image pull nginx:alpine
```

Este comando descarga la imagen `nginx:alpine` desde el repositorio de Docker Hub.

### 2.3. Comprobar la Construcción de una Imagen

Para ver cómo se ha construido una imagen, puedes utilizar los siguientes comandos:

- Ver el historial de la imagen:

```bash
docker image history nginx:alpine
```

Este comando muestra las capas de la imagen y cómo se ha construido.

- Inspeccionar la imagen:

```bash
docker image inspect nginx:alpine
```

Este comando muestra información detallada sobre la imagen, incluyendo su configuración y metadatos.

### 2.4. Ejecutar una Imagen

Para ejecutar una imagen y entrar en el interior del contenedor, utiliza el siguiente comando:

```bash
docker container run -it --name=alpine-xxxx nginx:alpine /bin/sh
```

Este comando crea y ejecuta un contenedor a partir de la imagen `nginx:alpine`, asignándole el nombre `alpine-xxxx`, y abre una sesión interactiva de shell dentro del contenedor.

Notas:
- Asegúrate de reemplazar `xxxx` con un identificador único para tu contenedor.
- El flag `-it` permite la interacción con el contenedor a través de la terminal.
- El comando `/bin/sh` abre una sesión de shell dentro del contenedor.


### 2.5. Ejecutar una Imagen en Modo Demonio

Para ejecutar otra imagen en modo demonio (segundo plano) y asignarle un nombre diferente, utiliza el siguiente comando:

```bash
docker container run -d --name=alpine-xxxx-1 nginx:alpine
```

Este comando crea y ejecuta un contenedor a partir de la imagen `nginx:alpine` en modo demonio, asignándole el nombre `alpine-xxxx-1`. A diferencia del primer contenedor que ejecutamos en modo interactivo, este contenedor se ejecuta en segundo plano y no podemos interactuar con él directamente.

**¿Qué diferencias hay con el primero?**

- **Modo de ejecución**: El primero se ejecuta en modo interactivo (`-it`), permitiéndonos interactuar con el contenedor a través de la terminal. El segundo se ejecuta en modo demonio (`-d`), funcionando en segundo plano sin interacción inmediata.
- **Interacción**: En el primer contenedor, entramos directamente al shell del contenedor al iniciarlo. En el segundo, necesitamos ejecutar un comando adicional para interactuar con él.

### 2.6. Entrar en el Contenedor en Modo Demonio

Para entrar en el contenedor que se está ejecutando en modo demonio, utiliza el siguiente comando:

```bash
docker container exec -it alpine-xxxx-1 /bin/sh
```

Este comando te permite abrir una sesión interactiva de shell dentro del contenedor `alpine-xxxx-1` que está corriendo en segundo plano.

### 2.7. Borrar los Contenedores Anteriores

Para eliminar los dos contenedores creados anteriormente, ejecuta los siguientes comandos:

```bash
docker container rm -f alpine-xxxx-1
docker container rm -f alpine-xxxx
```

El flag `-f` fuerza la detención y eliminación del contenedor si está en ejecución.

### 2.8. Comprobar que No Existe Ningún Contenedor

Para verificar que no existe ningún contenedor en tu sistema, ejecuta:

```bash
docker container ps -a
```

Este comando lista todos los contenedores, incluyendo los que no están en ejecución. Si la lista está vacía, significa que todos los contenedores han sido eliminados correctamente.

## 3. Primeros Pasos: Redes


### 3.1. Crear una red personalizada y listar redes existentes

Crear una red personalizada de tipo `bridge`, listar las redes disponibles y obtener información detallada sobre la red creada.


1. **Listar las redes existentes**  
   Antes de crear una red, veamos las redes actuales en tu sistema:  
   ```bash
   docker network ls
   ```
   **Explicación:** Este comando muestra las redes disponibles. Deberías ver algo como esto:
   ```plaintext
   NETWORK ID     NAME      DRIVER    SCOPE
   abc123456789   bridge    bridge    local
   def987654321   host      host      local
   ghi567890123   none      null      local
   ```

2. **Crear una red personalizada**  
   Usa el comando `docker network create` para crear una red llamada `mi_red`:  
   ```bash
   docker network create mi_red
   ```
   **Explicación:** Esto crea una red de tipo `bridge` (por defecto). El sistema asignará automáticamente un rango de direcciones IP y una pasarela para esta red.

3. **Verificar la nueva red**  
   Lista nuevamente las redes para asegurarte de que `mi_red` fue creada:  
   ```bash
   docker network ls
   ```
   Deberías ver algo como:  
   ```plaintext
   NETWORK ID     NAME      DRIVER    SCOPE
   abc123456789   bridge    bridge    local
   xyz654321098   mi_red    bridge    local
   ```

4. **Inspeccionar la red personalizada**  
   Obtén información detallada sobre la red `mi_red`:  
   ```bash
   docker network inspect mi_red
   ```
   **Explicación:** Este comando muestra detalles como:
   - Dirección de red (`Subnet`)
   - Pasarela (`Gateway`)
   - Contenedores conectados (actualmente ninguno)
   - Configuración avanzada de la red

   Salida ejemplo:  
   ```json
   [
       {
           "Name": "mi_red",
           "Id": "xyz654321098",
           "Created": "2024-12-03T10:00:00.000Z",
           "Scope": "local",
           "Driver": "bridge",
           "IPAM": {
               "Config": [
                   {
                       "Subnet": "172.18.0.0/16",
                       "Gateway": "172.18.0.1"
                   }
               ]
           },
           "Containers": {}
       }
   ]
   ```

5. **Eliminar la red (opcional)**  
   Si ya no necesitas la red, puedes eliminarla:  
   ```bash
   docker network rm mi_red
   ```
   **Nota:** No puedes eliminar una red si hay contenedores conectados a ella.


### 3.2. Configurar un entorno multi-contenedor
  
Configurar dos contenedores que se comuniquen entre sí usando una red personalizada de tipo `bridge`.


1. **Crear una red personalizada**  
   Crea una red llamada `multi_red` con el comando:  
   ```bash
   docker network create multi_red
   ```
   **Explicación:** Esto crea una red de tipo `bridge` donde los contenedores pueden comunicarse por nombre dentro de la red.

2. **Lanzar un contenedor con un servidor de base de datos**  
   Inicia un contenedor llamado `db` con Redis, conectado a la red `multi_red`:  
   ```bash
   docker run -d --name db --network multi_red redis
   ```
   **Explicación:**  
   - `-d`: Ejecuta el contenedor en segundo plano.  
   - `--name db`: Asigna el nombre `db` al contenedor, permitiendo que otros contenedores lo localicen por este nombre.  
   - `--network multi_red`: Conecta el contenedor a la red `multi_red`.  

3. **Lanzar otro contenedor conectado a la misma red**  
   Inicia un contenedor llamado `app`, conectado también a la red `multi_red`, basado en Alpine Linux:  
   ```bash
   docker run -it --rm --name app --network multi_red alpine sh
   ```
   **Explicación:**  
   - `-it`: Inicia el contenedor en modo interactivo.  
   - `--rm`: Elimina automáticamente el contenedor al salir de la sesión.  
   - `--name app`: Asigna el nombre `app` al contenedor.  
   - `sh`: Abre una shell interactiva en el contenedor.  

4. **Verificar la conectividad entre contenedores**  
   Dentro del contenedor `app`, instala la herramienta `ping` para probar la conectividad:  
   ```bash
   apk add --no-cache iputils
   ping db
   ```
   **Explicación:**  
   - `apk add --no-cache iputils`: Instala el paquete `iputils`, que incluye el comando `ping`.  
   - `ping db`: Prueba la conectividad con el contenedor `db` utilizando su nombre.

   Deberías ver una salida similar:  
   ```plaintext
   PING db (172.18.0.2): 56 data bytes
   64 bytes from 172.18.0.2: seq=0 ttl=64 time=0.123 ms
   ```

5. **Inspeccionar la red**  
   Abre una nueva terminal y ejecuta el comando para inspeccionar la red `multi_red`:  
   ```bash
   docker network inspect multi_red
   ```
   Busca los contenedores conectados y sus direcciones IP.

Conclusiones:

- Los dos contenedores están conectados a la red `multi_red` y pueden comunicarse entre sí utilizando sus nombres (`db` y `app`).  
- La red personalizada proporciona un entorno aislado para los contenedores.




Suponemos para este ejemplo que no existe ningún servidor web montado en el S.O. anfitrión (Ubuntu server). Esto es fundamental por la asignación de puertos que queramos usar.

### 3.3. Publicar un servicio al exterior

Ejecuta el siguiente comando para iniciar un contenedor con nginx y exponer el puerto 80:
```bash
docker container run -d -p 80:80 --name=alpine-xxxx nginx:alpine
```

Este comando inicia un contenedor en segundo plano (`-d`) con la imagen `nginx:alpine`, exponiendo el puerto 80 del contenedor en el puerto 80 del S.O. anfitrión.

#### 3.3.1: Comprender el funcionamiento de este contenedor que contiene nginx

Para comprender cómo funciona el contenedor que contiene nginx, realiza las siguientes acciones:

1. **Verificar la configuración de red en el S.O. anfitrión**:
    
```bash
ifconfig
```

Este comando muestra la configuración de red del S.O. anfitrión.

2. **Verificar las conexiones de red en el S.O. anfitrión**:
   
```bash
    netstat -puta
```
Este comando muestra todas las conexiones de red y puertos en uso en el S.O. anfitrión.

3. **Verificar las conexiones de red dentro del contenedor**:
    
- Accede al contenedor:
```bash
    docker exec -it alpine-xxxx /bin/sh
```
- Ejecuta `netstat -puta` dentro del contenedor para ver las conexiones de red y puertos en uso dentro del contenedor.

4. **Probar la conexión al servidor nginx desde el S.O. anfitrión**:
    ```bash
    wget localhost
    ```
    Este comando descarga la página de inicio del servidor nginx en el S.O. anfitrión.

5. **Probar la conexión al servidor nginx desde otro equipo**:
    - Abre un navegador web en otro equipo y accede a `http://IP:80`, donde `IP` es la dirección IP del S.O. anfitrión.

Para detener el contenedor, ejecuta el siguiente comando:
```bash
clear && netstat -puta && docker container ps -all && docker container stop alpine-xxxx && netstat -puta && wget localhost:80
```

Este comando limpia la pantalla, muestra las conexiones de red, lista todos los contenedores, detiene el contenedor `alpine-xxxx`, muestra nuevamente las conexiones de red y prueba la conexión al servidor nginx.

Para arrancar el contenedor nuevamente, ejecuta el siguiente comando:
```bash
clear && netstat -puta && docker container start alpine-xxxx && netstat -puta && wget localhost:80
```
Este comando limpia la pantalla, muestra las conexiones de red, arranca el contenedor `alpine-xxxx`, muestra nuevamente las conexiones de red y prueba la conexión al servidor nginx.

#### 3.3.2: Ejecutar otro contenedor exponiendo un puerto diferente

Ejecuta el siguiente comando para iniciar otro contenedor con nginx y exponer el puerto 81:
```bash
docker run -d -p 81:80 --name=alpine-xxxx2 nginx:alpine && netstat -puta
```

Este comando inicia un nuevo contenedor en segundo plano (`-d`) con la imagen `nginx:alpine`, exponiendo el puerto 80 del contenedor en el puerto 81 del S.O. anfitrión.


Para comprender cómo funcionan los dos contenedores en ejecución, realiza las siguientes acciones:

1. **Verificar las conexiones de red en el S.O. anfitrión**:
    ```bash
    netstat -puta
    ```
    Este comando muestra todas las conexiones de red y puertos en uso en el S.O. anfitrión.

2. **Verificar las conexiones de red dentro de cada contenedor**:
    - Accede a cada contenedor y ejecuta `netstat -puta` para ver las conexiones de red y puertos en uso dentro de cada contenedor.

3. **Probar la conexión a cada servidor nginx desde el S.O. anfitrión**:
    ```bash
    wget localhost:80
    wget localhost:81
    ```
    Estos comandos descargan la página de inicio de cada servidor nginx en el S.O. anfitrión.

Reinicia el S.O. anfitrión con el siguiente comando:
```bash
init 6
```

Después de reiniciar, verifica si los dos contenedores están arrancados. Reflexiona sobre qué hubiera pasado si fueran contenedores de producción y cómo podrías arreglarlo. Para asegurarte de que los contenedores se inicien automáticamente al arrancar el S.O., edita el archivo `/etc/rc.local`:

```bash
nano /etc/rc.local
```

Agrega los comandos necesarios para iniciar los contenedores al final del archivo:
```bash
docker container start alpine-xxxx
docker container start alpine-xxxx2
```

### 3.4: Conectar un contenedor a múltiples redes

Conectar un contenedor a más de una red y verificar su conectividad con otros contenedores en diferentes redes.


1. **Crear dos redes personalizadas**  
   Vamos a crear dos redes de tipo `bridge` llamadas `red1` y `red2`:
   ```bash
   docker network create red1
   docker network create red2
   ```
   **Explicación:**  
   - `docker network create red1` y `docker network create red2` crean dos redes de tipo `bridge` que se utilizarán para conectar contenedores.

2. **Lanzar un contenedor en la red `red1`**  
   Crea un contenedor llamado `web1` conectado a `red1`:
   ```bash
   docker run -d --name web1 --network red1 httpd
   ```
   **Explicación:**  
   - `--network red1`: Especifica que el contenedor `web1` se conecta a la red `red1`.

3. **Lanzar un contenedor en la red `red2`**  
   Crea otro contenedor llamado `web2` conectado a `red2`:
   ```bash
   docker run -d --name web2 --network red2 httpd
   ```
   **Explicación:**  
   - `--network red2`: Especifica que el contenedor `web2` se conecta a la red `red2`.

4. **Verificar la conectividad entre los contenedores**  
   Los contenedores `web1` y `web2` están en redes diferentes, por lo que no pueden comunicarse directamente. Vamos a intentar hacer ping entre ellos:
   - Desde el contenedor `web1`, intenta hacer ping a `web2` usando su nombre:
     ```bash
     docker exec web1 ping web2
     ```
     **Resultado esperado:** El ping fallará, ya que los contenedores están en redes separadas.

5. **Conectar `web1` a `red2`**  
   Ahora vamos a conectar el contenedor `web1` a la red `red2` para que ambos contenedores estén en las mismas redes:
   ```bash
   docker network connect red2 web1
   ```
   **Explicación:** Esto conecta el contenedor `web1` a la red `red2`, además de `red1`, lo que le permite comunicarse con `web2`.

6. **Verificar la conectividad entre los contenedores nuevamente**  
   Intenta hacer ping entre los contenedores ahora que ambos están en `red2`:
   - Desde el contenedor `web1`, intenta hacer ping a `web2`:
     ```bash
     docker exec web1 ping web2
     ```

   **Resultado esperado:** Ahora debería ser posible hacer ping exitosamente entre los dos contenedores, ya que ambos están conectados a la misma red `red2`.

7. **Desconectar el contenedor de `web1` de `red1`**  
   Si ya no necesitas que el contenedor `web1` esté en `red1`, puedes desconectarlo:
   ```bash
   docker network disconnect red1 web1
   ```

8. **Verificar las redes conectadas al contenedor**  
   Inspecciona el contenedor `web1` para ver a qué redes está conectado:
   ```bash
   docker inspect web1 --format '{{json .NetworkSettings.Networks}}'
   ```

   **Explicación:** Este comando te muestra las redes a las que el contenedor `web1` está conectado. Deberías ver algo como:
   ```json
   {
       "red2": {
           "NetworkID": "abcd1234",
           "IPAddress": "172.18.0.2",
           "Gateway": "172.18.0.1"
       }
   }
   ```

- Los contenedores pueden estar conectados a múltiples redes, lo que les permite acceder a otros servicios y contenedores en diferentes redes.
- Los contenedores `web1` y `web2` inicialmente no podían comunicarse debido a que estaban en redes diferentes. Al conectar `web1` a `red2`, pudieron intercambiar información.



## 4. Persistencia de datos


### 4.1: Modificar el fichero index.html en cada contenedor

1. Entra en cada uno de los contenedores y cambia el fichero `index.html` para que sea diferente:

```bash
    docker container exec -it alpine-xxxx /bin/sh
    docker container exec -it alpine-xxxx2 /bin/sh
    find / -iname "index.html"
```
    
- Utiliza `wget localhost:80` y `wget localhost:81` para verificar los cambios.

### 4.2: Copiar el fichero index.html al S.O. anfitrión

1. Crea un directorio en el S.O. anfitrión para almacenar el fichero copiado:
    ```bash
    mkdir /root/dockers/web
    ```
2. Copia el fichero `index.html` de cualquiera de los contenedores al S.O. anfitrión:
    ```bash
    docker container cp alpine-xxxx:/usr/share/nginx/html/index.html /root/dockers/web
    ```

### 4.3: Parar y destruir los contenedores

1. Para y elimina los dos contenedores:
```bash
docker container rm -f alpine-xxxx
docker container rm -f alpine-xxxx2
```

### 4.4: Arrancar un contenedor montando un directorio del S.O. anfitrión

1. Arranca un primer contenedor montando un directorio del S.O. anfitrión:
```bash
    docker container run -d -p 80:80 -v /root/dockers/web:/usr/share/nginx/html --name=alpine-xxxx nginx:alpine
```

### 4.5: Arrancar un segundo contenedor sin montar directorio

1. Arranca un segundo contenedor sin montar un directorio:

```bash
    docker container run -d -p 81:80 --name=alpine-xxxx2 nginx:alpine
```

### 4.6: Comparar los dos contenedores

1. Observa la diferencia entre los dos contenedores en relación al directorio del servidor web.
2. Reflexiona sobre en qué otros servicios podrías necesitar usar montajes de volúmenes.

## 5. Construyendo nuestras propias imágenes


### 5.1: Creación de imagen desde un contenedor en ejecución

Partiremos de una imagen base de Ubuntu. Instalaremos curl en un contenedor en ejecución, personalizaremos la imagen resultante, la guardaremos como un archivo `.tar` y la cargaremos en otro sistema.

#### Descargar la imagen base

Ejecutamos el comando para obtener la imagen oficial de Ubuntu:
```bash
docker pull ubuntu:latest
```

#### Crear y ejecutar un contenedor

Lanzamos un contenedor interactivo basado en la imagen de Ubuntu:
```bash
docker run -it --name ubuntu-custom ubuntu:latest
```

#### Personalizar el contenedor

Dentro del contenedor en ejecución, instalamos curl:
```bash
apt update && apt install -y curl
```

Verificamos que curl está instalado:
```bash
curl --version
```

#### Crear una nueva imagen personalizada

Salimos del contenedor (`exit`) y creamos una nueva imagen desde él:
```bash
docker commit ubuntu-custom ubuntu-curl:1.0
```
Este comando genera una nueva imagen llamada `ubuntu-curl` con la etiqueta `1.0`.

#### Guardar la imagen en un archivo .tar

Usamos el comando `docker save` para exportar la imagen:
```bash
docker save ubuntu-curl:1.0 > ubuntu-curl.tar
```

#### Cargar la imagen en otro sistema

En un sistema diferente, usamos el archivo exportado para cargar la imagen:
```bash
docker load --input ubuntu-curl.tar
```

Comprobamos que la imagen está disponible:
```bash
docker images
```

### 5.2. Publicación de imagen en DockerHub

En este ejercicio, modificaremos un contenedor existente para incluir un archivo con información personalizada, crearemos una nueva imagen y la subiremos a DockerHub.

#### Autenticarse en DockerHub

Asegúrate de estar autenticado en DockerHub. Usa tu nombre de usuario y contraseña:
```bash
docker login
```

Si la autenticación es exitosa, verás:

```plaintext
Login Succeeded
```

#### Crear y ejecutar un contenedor

Usa la imagen base de Ubuntu para crear un contenedor interactivo:
```bash
docker run -it --name ubuntu-info ubuntu:latest
```

#### Modificar el contenedor

Dentro del contenedor, crea un archivo con información personalizada:
```bash
echo "Author: Tu Nombre" > /opt/info.txt
```

Verifica que el archivo fue creado correctamente:
```bash
cat /opt/info.txt
```

#### Crear una imagen personalizada

Sal del contenedor (`exit`) y usa `docker commit` para guardar los cambios en una nueva imagen:
```bash
docker commit ubuntu-info usuarioDockerHub/ubuntu-info:1.0
```
Nota: Sustituye `usuarioDockerHub` por tu nombre de usuario en DockerHub.

#### Subir la imagen a DockerHub

Usa el comando `docker push` para subir la imagen a DockerHub:
```bash
docker push usuarioDockerHub/ubuntu-info:1.0
```

#### Verificar la imagen en DockerHub

Ve a tu cuenta en DockerHub y verifica que la imagen `ubuntu-info:1.0` esté disponible.


Otros usuarios pueden descargar esta imagen con el comando:

```bash
docker pull usuarioDockerHub/ubuntu-info:1.0
```

### 5.3. Construcción de una imagen usando un Dockerfile básico

Este ejercicio consiste en crear un Dockerfile que personalice una imagen `nginx:alpine`, añadiendo un archivo `index.html` para servir como página principal. Luego, construimos y ejecutamos la imagen para verificar el resultado.

- Crear un directorio de trabajo
- Crea un directorio para almacenar los archivos necesarios:

```bash
mkdir docker-nginx
cd docker-nginx
```

- Crear el archivo index.html. Dentro del directorio, crea un archivo index.html con contenido básico:

```bash
echo "<!DOCTYPE html>
<html>
<head>
    <title>My Custom Nginx</title>
</head>
<body>
    <h1>Hello, Docker!</h1>
</body>
</html>" > index.html
```

- Crear el Dockerfile. En el mismo directorio, crea un archivo llamado Dockerfile y añade las siguientes instrucciones:

```dockerfile
Copy code
# Usar nginx:alpine como base
FROM nginx:alpine

# Copiar el archivo index.html al directorio de contenido de nginx
COPY index.html /usr/share/nginx/html/

# Exponer el puerto 80
EXPOSE 80
```

- Construir la imagen personalizada. Usa el comando docker build para crear la imagen, asignándole un nombre y una etiqueta:

```bash
docker build -t custom-nginx:1.0 .
```

- Ejecutar un contenedor con la imagen personalizada. Lanza un contenedor basado en la imagen recién creada:

```bash
docker run -d -p 8080:80 custom-nginx:1.0
```

- Verificar el resultado. Abre un navegador y accede a http://localhost:8080. Deberías ver la página personalizada con el mensaje Hello, Docker!.

 La imagen creada puede ser reutilizada y compartida.

### 5.4: Uso de `docker build` con un contexto remoto

Este ejercicio consiste en crear un repositorio en GitHub que contenga un Dockerfile y luego utilizarlo como contexto remoto para construir una imagen con `docker build`.

1. **Preparar el Dockerfile y otros archivos**  
   Crea un directorio local para tu proyecto y un archivo Dockerfile:  
```bash
mkdir docker-node-app
cd docker-node-app
```

Dentro del directorio, crea el archivo `Dockerfile` con este contenido:  

```dockerfile
   # Usar Node.js como base
   FROM node:16

   # Establecer el directorio de trabajo
   WORKDIR /usr/src/app

   # Copiar el archivo de dependencias
   COPY package.json .

   # Instalar las dependencias
   RUN npm install

   # Copiar el resto de los archivos al contenedor
   COPY . .

   # Exponer el puerto de la aplicación
   EXPOSE 3000

   # Comando de inicio
   CMD ["node", "app.js"]
```

2. **Añadir archivos adicionales**  
   Crea un archivo `package.json` con el siguiente contenido:  
   ```json
   {
       "name": "docker-node-app",
       "version": "1.0.0",
       "description": "A sample Node.js app",
       "main": "app.js",
       "dependencies": {
           "express": "^4.17.1"
       },
       "scripts": {
           "start": "node app.js"
       }
   }
   ```

   También crea el archivo `app.js` para una aplicación básica de Node.js:  

```javascript
   const express = require('express');
   const app = express();

   app.get('/', (req, res) => {
       res.send('Hello from Docker!');
   });

   const PORT = 3000;
   app.listen(PORT, () => {
       console.log(`Server running on http://localhost:${PORT}`);
   });
```

3. **Subir el proyecto a GitHub**  
   Inicializa un repositorio local, añade los archivos, y súbelos a GitHub:  

```bash
   git init
   git add .
   git commit -m "Initial commit"
   git remote add origin https://github.com/tu-usuario/docker-node-app.git
   git branch -M main
   git push -u origin main
```

4. **Construir la imagen desde el repositorio**  
   Usa el comando `docker build` para construir la imagen utilizando el enlace al repositorio como contexto:  

```bash
   docker build -t docker-node-app:1.0 https://github.com/tu-usuario/docker-node-app.git#main
```

5. **Ejecutar un contenedor con la imagen**  
   Lanza un contenedor para verificar que la imagen funciona correctamente:  
```bash
   docker run -d -p 3000:3000 docker-node-app:1.0
```

6. **Verificar el resultado**  
   Abre un navegador y accede a `http://localhost:3000`. Deberías ver el mensaje **Hello from Docker!**.


Este ejercicio demuestra cómo usar un repositorio remoto como contexto para construir una imagen Docker. Esto es útil para entornos de **integración continua** o cuando deseas compartir tu proyecto en equipo.

### 5.5: Integración de variables de entorno

En este ejercicio, crearemos un Dockerfile que use variables de entorno definidas durante la construcción y las utilice dentro del contenedor para configurar su comportamiento. Veremos cómo estas variables pueden influir en los scripts o aplicaciones que se ejecutan dentro del contenedor.

1. **Crear un directorio de trabajo**  
   Crea un nuevo directorio para este ejercicio:  

```bash
   mkdir docker-env-app
   cd docker-env-app
```

2. **Crear un archivo Dockerfile**  
   Crea un archivo `Dockerfile` con el siguiente contenido:  

```dockerfile
   # Usar la imagen base de Node.js
   FROM node:16

   # Establecer un directorio de trabajo
   WORKDIR /usr/src/app

   # Definir una variable de entorno para la URL del servicio
   ARG SERVICE_URL=http://localhost

   # Establecer la variable de entorno dentro del contenedor
   ENV SERVICE_URL=$SERVICE_URL

   # Copiar y crear un archivo de prueba que use esta variable
   COPY test-env.js .

   # Instalar dependencias (vacío aquí, pero necesario para npm init)
   RUN npm init -y

   # Ejecutar el script como punto de entrada
   CMD ["node", "test-env.js"]
```

3. **Crear el archivo de prueba `test-env.js`**  
   Este archivo leerá la variable de entorno `SERVICE_URL` y la imprimirá en la consola:  
   
```javascript
   console.log(`Service URL is: ${process.env.SERVICE_URL}`);
```

4. **Construir la imagen con una variable de entorno personalizada**  
   Usa el comando `docker build` para crear la imagen, definiendo el valor de la variable `SERVICE_URL`:  
   
```bash
   docker build -t env-app:1.0 --build-arg SERVICE_URL=https://api.example.com .
```

5. **Ejecutar un contenedor con la imagen**  
   Lanza un contenedor basado en la imagen:  
   
```bash
   docker run env-app:1.0
```

6. **Observar el resultado**  
   El contenedor debería imprimir en la consola:  

```plaintext
   Service URL is: https://api.example.com
```

7. **Probar con otra variable en tiempo de ejecución**  
   
También puedes sobrescribir la variable de entorno durante la ejecución del contenedor:  

```bash
docker run -e SERVICE_URL=https://new-api.example.com env-app:1.0
```

Ahora debería imprimir:  
```plaintext
   Service URL is: https://new-api.example.com
```

#### Explicación del resultado
Este ejercicio muestra cómo usar `ARG` y `ENV` para definir y manejar variables de entorno en Dockerfiles. Estas variables son útiles para personalizar imágenes y contenedores según las necesidades del entorno de despliegue.

### 5.6: Gestión de capas con Dockerfile

En este ejercicio optimizaremos las capas creadas durante la construcción de una imagen Docker. Usaremos múltiples instrucciones en un Dockerfile y observaremos el impacto en el número de capas y el tamaño de la imagen.


1. **Crear un directorio de trabajo**  
   Crea un nuevo directorio para este ejercicio:  
   ```bash
   mkdir docker-layers
   cd docker-layers
   ```

2. **Crear un Dockerfile con múltiples capas**  
   Escribe un Dockerfile donde cada instrucción `RUN` crea una nueva capa:  
```dockerfile
   FROM ubuntu:latest

   # Actualizar el sistema
   RUN apt update

   # Instalar herramientas básicas
   RUN apt install -y curl

   # Instalar Git
   RUN apt install -y git
```

3. **Construir la imagen**  
   Usa el comando `docker build` para crear la imagen:  

```bash
   docker build -t multi-layer:1.0 .
```

4. **Ver las capas creadas**  
   Usa el comando `docker history` para observar las capas de la imagen:  

```bash
   docker history multi-layer:1.0
```

   Notarás que cada `RUN` ha creado una capa separada.

5. **Optimizar el Dockerfile**  
   Combina las instrucciones `RUN` en una sola línea para reducir el número de capas:  

```dockerfile
   FROM ubuntu:latest

   # Actualizar el sistema e instalar herramientas en una sola capa
   RUN apt update && apt install -y curl git
```

6. **Construir la imagen optimizada**  
   Crea una nueva imagen basada en el Dockerfile optimizado:  
```bash
   docker build -t single-layer:1.0 .
```

7. **Comparar las capas**  
   Usa nuevamente el comando `docker history` para la nueva imagen:  

```bash
   docker history single-layer:1.0
```

   Observa que ahora hay menos capas en comparación con la imagen anterior.

8. **Construir la imagen sin caché**  
   Para probar los cambios sin reutilizar capas anteriores, construye la imagen con el flag `--no-cache`:  

```bash
   docker build --no-cache -t no-cache-layer:1.0 .
```
Este ejercicio demuestra cómo la estructura del Dockerfile afecta el número de capas en la imagen. Menos capas significan imágenes más pequeñas y rápidas de construir. Sin embargo, al combinar instrucciones, se pierde algo de flexibilidad en la reutilización de capas caché.

### 5.7: Uso del archivo `.dockerignore`

En este ejercicio aprenderemos cómo utilizar un archivo `.dockerignore` para excluir ciertos archivos y directorios del contexto de construcción de una imagen Docker, reduciendo su tamaño y mejorando el tiempo de construcción.


1. **Crear un directorio de trabajo**  
   Crea un directorio para este ejercicio:  
```bash
   mkdir docker-ignore
   cd docker-ignore
```

2. **Añadir archivos al proyecto**  
   Crea algunos archivos y carpetas simulando un proyecto de Node.js:  
```bash
   echo "node_modules/" > .dockerignore
   mkdir node_modules
   touch node_modules/dummy.txt
   echo "console.log('Hello, Docker!');" > app.js
   echo "{}" > package.json
```

Ahora tienes la siguiente estructura:  
```
   docker-ignore/
   ├── .dockerignore
   ├── app.js
   ├── node_modules/
   │   └── dummy.txt
   └── package.json
```

3. **Crear un archivo `.dockerignore`**  
   El archivo `.dockerignore` ya está creado con el contenido:  

```plaintext
   node_modules/
```

   Esto excluye la carpeta `node_modules` del contexto de construcción.

4. **Escribir el Dockerfile**  
   Crea un archivo `Dockerfile` con el siguiente contenido:  

```dockerfile
   FROM node:16

   WORKDIR /usr/src/app

   # Copiar el archivo package.json y app.js al contenedor
   COPY package.json .
   COPY app.js .

   # Instalar dependencias (aunque no están en el contexto)
   RUN npm install

   CMD ["node", "app.js"]
```

5. **Construir la imagen**  
   Usa el comando `docker build` para crear la imagen:  
```bash
   docker build -t ignore-example:1.0 .
```

6. **Verificar el contexto de construcción**  
   Usa el flag `--no-cache` para forzar una nueva construcción y observa el tamaño del contexto:  

```bash
docker build --no-cache -t ignore-example:1.0 .
```

La salida indicará el tamaño del contexto de construcción. La carpeta `node_modules` no se incluirá.

7. **Ejecutar el contenedor**  
   Lanza un contenedor con la imagen recién construida:  
```bash
docker run --rm ignore-example:1.0
```

Deberías ver el mensaje:  
```plaintext
Hello, Docker!
```

El archivo `.dockerignore` excluye archivos innecesarios del contexto de construcción. Esto reduce el tiempo de transferencia de datos al daemon de Docker y minimiza el tamaño de la imagen, lo que es crucial en proyectos grandes con dependencias como `node_modules`.

### 5.8: Creación de una imagen con aplicaciones preinstaladas

En este ejercicio crearemos un Dockerfile que incluye una aplicación de Python preinstalada. El contenedor ejecutará un script automáticamente al iniciarse.


1. **Crear un directorio de trabajo**  
   Crea un nuevo directorio para este ejercicio:  
```bash
   mkdir docker-python-app
   cd docker-python-app
```

2. **Escribir un script en Python**  
   Crea un archivo llamado `app.py` con el siguiente contenido:  
```python
   print("Welcome to your custom Docker container!")
```

3. **Crear el Dockerfile**  
   Escribe un Dockerfile para incluir Python y configurar el script como ejecutable principal:  
```dockerfile
   # Usar la imagen base de Python
   FROM python:3.9

   # Establecer el directorio de trabajo en el contenedor
   WORKDIR /usr/src/app

   # Copiar el script al contenedor
   COPY app.py .

   # Establecer el comando principal
   CMD ["python", "app.py"]
```

4. **Construir la imagen**  
   Usa el comando `docker build` para construir la imagen:  
```bash
   docker build -t python-app:1.0 .
```

5. **Ejecutar un contenedor basado en la imagen**  
   Lanza un contenedor con la imagen recién construida:  
```bash
   docker run --rm python-app:1.0
```

6. **Observar el resultado**  
   El contenedor ejecutará automáticamente el script y mostrará:  
```plaintext
   Welcome to your custom Docker container!
```

7. **Probar con un script más complejo**  
   Modifica el archivo `app.py` para incluir más lógica. Por ejemplo:  
```python
   import sys
   print(f"Arguments passed: {sys.argv[1:]}")
```

   Luego, reconstruye la imagen:  
```bash
   docker build -t python-app:1.1 .
```

   Ejecuta el contenedor pasando argumentos:  
```bash
   docker run --rm python-app:1.1 arg1 arg2
```

   Verás algo como:  
```plaintext
   Arguments passed: ['arg1', 'arg2']
```

Vamos a construir **todo el ejercicio 9 adaptado para Angular**, desde cero, integrando el proceso de build dentro del Dockerfile usando el enfoque multietapa. Esto automatizará la creación de la aplicación Angular y su despliegue con `nginx`.

---

### 5.9 Construcción de una imagen Angular desde cero

#### 1. Crear el proyecto Angular

1. **Instalar Angular CLI (si no lo tienes ya):**
   ```bash
   npm install -g @angular/cli
   ```

2. **Crear un proyecto Angular básico:**
   ```bash
   ng new angular-project
   cd angular-project
   ```

   Selecciona las opciones predeterminadas para el proyecto.

3. **Probar el proyecto localmente:**
   Verifica que el proyecto funciona correctamente:
   ```bash
   ng serve
   ```
   Accede a `http://localhost:4200` y confirma que la aplicación se carga.

---

#### 2. Modificar el contenido de la aplicación

1. **Cambiar el mensaje de bienvenida:**
   Abre `src/app/app.component.html` y edita el contenido:
   ```html
   <h1>Welcome to My Improved Angular App!</h1>
   ```

#### 3. Crear el Dockerfile con enfoque multietapa

En el directorio raíz del proyecto (`angular-project`), crea un archivo `Dockerfile` con este contenido:

```dockerfile
# Etapa 1: Construcción de la aplicación Angular
FROM node:16 AS builder

# Establecer el directorio de trabajo
WORKDIR /usr/src/app

# Copiar los archivos de configuración y dependencias
COPY package*.json ./
RUN npm install

# Copiar el resto del proyecto al contenedor
COPY . .

# Construir la aplicación para producción
RUN npm run build --prod

# Etapa 2: Servir la aplicación con nginx
FROM nginx:alpine

# Limpiar archivos predeterminados de nginx
RUN rm -rf /usr/share/nginx/html/*

# Copiar los archivos generados en la etapa 1
COPY --from=builder /usr/src/app/dist/angular-project /usr/share/nginx/html

# Exponer el puerto 80
EXPOSE 80

# Comando para iniciar nginx
CMD ["nginx", "-g", "daemon off;"]
```

#### 4. Crear el archivo `.dockerignore`

Para excluir archivos innecesarios del contexto de construcción, crea un archivo `.dockerignore`:

```plaintext
node_modules/
dist/
.git/
.angular/
```

#### 5. Construir la imagen Docker

1. **Ejecutar el comando de build:**
   ```bash
   docker build -t angular-app:1.0 .
   ```

   Esto realizará:
   - Instalación de dependencias.
   - Construcción de la aplicación Angular.
   - Configuración del servidor `nginx` para servir la aplicación.

2. **Verificar la imagen creada:**
   Lista las imágenes creadas:
   ```bash
   docker images
   ```

#### 6. Ejecutar el contenedor

1. **Lanzar el contenedor:**
   ```bash
   docker run -d -p 8080:80 angular-app:1.0
   ```

2. **Probar la aplicación:**
   Abre `http://localhost:8080` en tu navegador. Deberías ver el mensaje personalizado:  
   **"Welcome to My Improved Angular App!"**

#### 7. Realizar cambios y reconstruir

1. **Cambiar el mensaje nuevamente:**
   Modifica `src/app/app.component.html`:
   ```html
   <h1>Angular App Updated with Docker!</h1>
   ```

2. **Reconstruir la imagen:**
   ```bash
   docker build -t angular-app:1.1 .
   ```

3. **Reiniciar el contenedor con la nueva imagen:**
   ```bash
   docker stop <container_id>
   docker run -d -p 8080:80 angular-app:1.1
   ```

4. **Probar nuevamente:**
   Ve a `http://localhost:8080` y verifica los cambios.

En esta práctica hemos conseguido:

- Una imagen Docker que automatiza todo el proceso de construcción y despliegue de una aplicación Angular.
- Uso de un servidor `nginx` para servir la aplicación.
- Actualizaciones rápidas mediante la modificación del código y la reconstrucción de la imagen (nos vamos acercando a la puesta en producción).

### 5.10: Automatización de tareas con ENTRYPOINT

En este ejercicio crearemos un contenedor Docker que ejecute una tarea automáticamente al iniciarse. Usaremos un script que comprima archivos en un directorio y exploremos el uso de `ENTRYPOINT` para automatizarlo.


1. **Crear un directorio de trabajo**  
   Crea un directorio para este ejercicio:  
   ```bash
   mkdir docker-entrypoint-task
   cd docker-entrypoint-task
   ```

2. **Crear un script de automatización**  
   Crea un archivo `compress.sh` que comprimirá todos los archivos en un directorio dado:  
   ```bash
   #!/bin/bash
   set -e

   # Directorio de entrada
   INPUT_DIR=${1:-/data/input}

   # Directorio de salida
   OUTPUT_DIR=${2:-/data/output}

   echo "Comprimiremos los archivos de $INPUT_DIR en $OUTPUT_DIR"

   # Crear el directorio de salida si no existe
   mkdir -p "$OUTPUT_DIR"

   # Comprimir cada archivo en el directorio de entrada
   for file in "$INPUT_DIR"/*; do
       if [ -f "$file" ]; then
           filename=$(basename -- "$file")
           tar -czf "$OUTPUT_DIR/$filename.tar.gz" -C "$INPUT_DIR" "$filename"
           echo "Archivo $filename comprimido en $filename.tar.gz"
       fi
   done
   ```

Asegúrate de que el script sea ejecutable:  
   
```bash
   chmod +x compress.sh
```


1. **Crear el Dockerfile**  
   Escribe un `Dockerfile` que copie el script al contenedor y configure `ENTRYPOINT` para ejecutarlo:  
   ```dockerfile
   # Usar una imagen base de Linux ligera
   FROM alpine:latest

   # Instalar tar para la compresión
   RUN apk add --no-cache tar

   # Crear los directorios necesarios
   RUN mkdir -p /data/input /data/output

   # Copiar el script al contenedor
   COPY compress.sh /usr/local/bin/compress.sh

   # Hacer que el script sea el comando predeterminado
   ENTRYPOINT ["/usr/local/bin/compress.sh"]
   ```

2. **Construir la imagen**  
   Construye la imagen Docker:  
   ```bash
   docker build -t compress-task:1.0 .
   ```


3. **Ejecutar el contenedor**  
   Usa el contenedor para comprimir archivos. Primero, crea un directorio local con archivos para comprimir:  
   ```bash
   mkdir -p input_files
   echo "File 1 content" > input_files/file1.txt
   echo "File 2 content" > input_files/file2.txt
   ```

Luego, lanza el contenedor, vinculando los directorios locales con los del contenedor:  
   
```bash
   docker run --rm -v $(pwd)/input_files:/data/input -v $(pwd)/output_files:/data/output compress-task:1.0
```

4. **Verificar los archivos comprimidos**  
   Lista el contenido del directorio `output_files`:  
   ```bash
   ls output_files
   ```
   Deberías ver los archivos comprimidos:  
   ```plaintext
   file1.txt.tar.gz
   file2.txt.tar.gz
   ```

---

1. **Uso de ENTRYPOINT:**  
   El script `compress.sh` se ejecuta automáticamente al iniciar el contenedor. Puedes pasar argumentos adicionales, como los directorios de entrada y salida.

2. **Automatización completa:**  
   El contenedor está configurado para ejecutar una tarea específica, lo que lo hace útil para pipelines CI/CD o procesos batch.

4. **Flexibilidad:**  
   Puedes modificar el script o los parámetros sin reconstruir la imagen.

## 6. Docker-Compose

### 6.1. Configuración básica de un contenedor web y una base de datos con Docker Compose

El objetivo es aprender a configurar un entorno básico utilizando **Docker Compose**, donde se ejecutan dos contenedores: uno con un servidor web (por ejemplo, Nginx) y otro con una base de datos (como MySQL o PostgreSQL). Se abordarán conceptos fundamentales como la definición de servicios, la gestión de redes y la exposición de puertos.

1. **Crear un archivo `docker-compose.yml`**
   
   En un directorio nuevo, crea un archivo llamado `docker-compose.yml`. Este archivo definirá los servicios que se ejecutarán, incluyendo un servidor web y una base de datos. El archivo podría tener el siguiente contenido:
   
   ```yaml
   version: '3.7'
   services:
     web:
       image: nginx:latest
       container_name: web
       ports:
         - "8080:80"
       networks:
         - app_network

     db:
       image: mysql:5.7
       container_name: db
       environment:
         MYSQL_ROOT_PASSWORD: toor
       networks:
         - app_network

   networks:
     app_network:
       driver: bridge
   ```

   - **`version: '3.7'`**: Define la versión de Docker Compose que estamos utilizando.
   - **`services`**: Define los servicios (contenedores) que se ejecutarán.
     - **`web`**: Un contenedor que ejecuta Nginx.
       - **`image: nginx:latest`**: Usa la última versión de la imagen oficial de Nginx.
       - **`ports`**: Mapea el puerto 8080 del host al puerto 80 del contenedor (Nginx).
       - **`networks`**: Conecta este contenedor a la red `app_network`.
     - **`db`**: Un contenedor que ejecuta MySQL.
       - **`environment`**: Define las variables de entorno necesarias, en este caso, la contraseña del root para MySQL.
       - **`networks`**: Conecta el contenedor de base de datos a la misma red `app_network`.
   - **`networks`**: Define la red `app_network` usando el controlador `bridge` para que los contenedores se comuniquen entre sí.

2. **Iniciar los servicios con Docker Compose**
   
   Con el archivo `docker-compose.yml` configurado, puedes iniciar los servicios (contenedores) ejecutando el siguiente comando en la misma carpeta donde está el archivo:
   
   ```bash
   docker-compose up -d
   ```

3. **Verificar que los servicios están en funcionamiento**
   
   Una vez que los contenedores estén en ejecución, puedes verificar el estado de los servicios con el siguiente comando:
   
   ```bash
   docker-compose ps
   ```

4. **Acceder al servidor web**
   
   Abre tu navegador y accede a `http://localhost:8080`. Deberías ver la página predeterminada de Nginx, lo que confirma que el servicio web está funcionando correctamente.

5. **Verificar la base de datos**
   
   Para verificar que el contenedor de la base de datos está funcionando, puedes acceder al contenedor de MySQL y realizar algunas consultas. Primero, accede al contenedor:
   
   ```bash
   docker exec -it db mysql -u root -p
   ```

   Luego, ingresa la contraseña `toor` cuando se te pida. Después de ingresar a MySQL, puedes verificar que la base de datos esté en funcionamiento con un comando como:
   
   ```sql
   SHOW DATABASES;
   ```

6. **Detener los servicios**

   Cuando termines, puedes detener y eliminar los contenedores ejecutando:
   
```bash
docker-compose down
```


### 6.2. Gestión de volúmenes con Docker Compose

Aprender a usar volúmenes en Docker Compose para persistir datos de los contenedores. Este ejercicio se centrará en cómo gestionar los volúmenes para servicios como bases de datos, lo que garantiza que los datos persistan incluso después de que los contenedores se reinicien o se eliminen.


1. **Crear un archivo `docker-compose.yml` con volumen para la base de datos**

En este ejercicio, vamos a modificar el archivo `docker-compose.yml` que creamos en el ejercicio anterior para incluir un volumen que persista los datos de MySQL.

```yaml
   version: '3.7'
   services:
     web:
       image: nginx:latest
       container_name: web
       ports:
         - "8080:80"
       networks:
         - app_network

     db:
       image: mysql:5.7
       container_name: db
       environment:
         MYSQL_ROOT_PASSWORD: example
       volumes:
         - db_data:/var/lib/mysql
       networks:
         - app_network

   volumes:
     db_data:
       driver: local

   networks:
     app_network:
       driver: bridge
   ```

   - **`volumes` en el servicio `db`**: El contenedor de la base de datos MySQL ahora tiene un volumen llamado `db_data`, que se montará en el directorio `/var/lib/mysql` dentro del contenedor. Este es el directorio donde MySQL almacena sus datos.
   - **`volumes` en el nivel raíz**: Definimos un volumen llamado `db_data` para Docker Compose. El volumen será gestionado automáticamente por Docker y persistirá incluso si el contenedor se reinicia o se elimina.
   
1. **Iniciar los servicios con Docker Compose**

Ejecuta los servicios con el siguiente comando:

```bash
docker-compose up -d
```

1. **Verificar que el volumen ha sido creado**

Verifica que el volumen `db_data` ha sido creado y está siendo utilizado por Docker:

```bash
docker volume ls
```

Deberías ver algo como:

```plaintext
   DRIVER              VOLUME NAME
   local               db_data
```

Esto indica que Docker ha creado y está utilizando el volumen `db_data`.

2. **Acceder al contenedor y verificar la persistencia de datos**

Para verificar que los datos están siendo persistidos, accede al contenedor MySQL:

```bash
docker exec -it db mysql -u root -p
```

Ingresa la contraseña `example`. Luego, crea una base de datos para verificar que los cambios persisten:

```sql
   CREATE DATABASE testdb;
   SHOW DATABASES;
   ```

   Sal de MySQL con `exit`.

3. **Reiniciar los contenedores y verificar la persistencia de datos**

   Detén y elimina los contenedores para probar la persistencia de los datos:

   ```bash
   docker-compose down
   ```

   **Nota:** Los volúmenes no se eliminan con `docker-compose down`, lo que garantiza que los datos persisten.

   Vuelve a iniciar los contenedores:

   ```bash
   docker-compose up -d
   ```

   Accede nuevamente al contenedor MySQL y verifica que la base de datos `testdb` aún existe:

   ```bash
   docker exec -it db mysql -u root -p
   SHOW DATABASES;
   ```

   **Resultado esperado**: La base de datos `testdb` debería aparecer, lo que indica que los datos se han mantenido gracias al volumen.

4. **Eliminar el volumen (opcional)**

Si deseas eliminar el volumen y todos los datos persistentes, ejecuta:

```bash
   docker-compose down -v
```

   **Explicación**: La opción `-v` elimina los volúmenes asociados a los servicios, eliminando así los datos persistentes.


### 6.3. Uso de redes personalizadas en Docker Compose
 
Aprender a configurar redes personalizadas en Docker Compose para aislar servicios y gestionar su comunicación de manera más segura y controlada.

1. **Modificar `docker-compose.yml` para incluir redes personalizadas**

   Ampliaremos el archivo `docker-compose.yml` para separar los servicios `web` y `db` en redes diferentes, manteniendo un punto de conexión específico entre ellos.

   ```yaml
   version: '3.7'
   services:
     web:
       image: nginx:latest
       container_name: web
       ports:
         - "8080:80"
       networks:
         - front_end
         - back_end

     db:
       image: mysql:5.7
       container_name: db
       environment:
         MYSQL_ROOT_PASSWORD: example
       networks:
         - back_end

   networks:
     front_end:
       driver: bridge
     back_end:
       driver: bridge
   ```

   **Explicación:**
   - **`networks` en `web` y `db`**: Los servicios `web` y `db` están conectados a la red `back_end` para que puedan comunicarse entre sí. Además, el servicio `web` está conectado a la red `front_end` para manejar solicitudes externas.
   - **`front_end`**: Una red aislada que conecta el servicio `web` al host.
   - **`back_end`**: Una red privada para la comunicación entre `web` y `db`.

2. **Iniciar los servicios con Docker Compose**

   Ejecuta los servicios con el comando habitual:

   ```bash
   docker-compose up -d
   ```

   Docker Compose creará automáticamente las redes `front_end` y `back_end` y conectará los contenedores a las redes especificadas.

3. **Verificar las redes creadas**

   Lista las redes creadas para asegurarte de que `front_end` y `back_end` están activas:

   ```bash
   docker network ls
   ```

   Busca las redes `front_end` y `back_end` en la salida.

4. **Inspeccionar las redes**

   Inspecciona la configuración de una de las redes para ver los contenedores conectados:

   ```bash
   docker network inspect back_end
   ```

   Deberías ver que tanto `web` como `db` están conectados a `back_end`.

5. **Probar la conectividad entre contenedores**

   - Desde el contenedor `web`, verifica la conexión con `db` mediante su nombre:
     ```bash
     docker exec -it web ping db
     ```
   - Desde el contenedor `db`, intenta hacer ping a `web`:
     ```bash
     docker exec -it db ping web
     ```

   **Resultado esperado:**
   - El contenedor `web` puede comunicarse con `db` porque ambos están en la red `back_end`.
   - El contenedor `db` no puede comunicarse con el exterior ni con la red `front_end`, garantizando el aislamiento.

6. **Detener los servicios**

   Detén y elimina los servicios:

   ```bash
   docker-compose down
   ```

   Esto eliminará los contenedores y las redes asociadas.

### 6.4. Uso de variables de entorno en Docker Compose
 
Aprender a utilizar variables de entorno en Docker Compose para configurar servicios de manera dinámica y segura. Este enfoque es fundamental en entornos de producción para evitar la exposición de datos sensibles como contraseñas, claves API y configuraciones específicas.


1. **Crear un archivo `.env` para las variables de entorno**

   Crea un archivo `.env` en el mismo directorio que tu archivo `docker-compose.yml`. Este archivo almacenará las variables de entorno que utilizarán los servicios:

   ```env
   MYSQL_ROOT_PASSWORD=supersecurepassword
   API_KEY=myapikey123
   ```

   **Explicación:**
   - **`MYSQL_ROOT_PASSWORD`**: Contraseña del usuario `root` de MySQL.
   - **`API_KEY`**: Ejemplo de una clave API que podría usarse en otro servicio.

2. **Modificar `docker-compose.yml` para usar las variables de entorno**

   Modifica el archivo `docker-compose.yml` para integrar las variables definidas en `.env`:

   ```yaml
   version: '3.7'
   services:
     web:
       image: nginx:latest
       container_name: web
       ports:
         - "8080:80"
       environment:
         - API_KEY=${API_KEY}
       networks:
         - front_end
         - back_end

     db:
       image: mysql:5.7
       container_name: db
       environment:
         MYSQL_ROOT_PASSWORD: ${MYSQL_ROOT_PASSWORD}
       networks:
         - back_end

   networks:
     front_end:
       driver: bridge
     back_end:
       driver: bridge
   ```

   **Explicación:**
   - **`environment`**: Usa `${VARIABLE}` para acceder a las variables definidas en el archivo `.env`.
   - **Separación de datos sensibles**: Las contraseñas y claves no están codificadas directamente en el archivo `docker-compose.yml`.

3. **Ejecutar los servicios con Docker Compose**

   Inicia los servicios con el comando habitual:

   ```bash
   docker-compose up -d
   ```

   **Nota:** Docker Compose cargará automáticamente las variables definidas en el archivo `.env`.

4. **Verificar que las variables están configuradas**

   Verifica que las variables de entorno se pasaron correctamente al contenedor:

   - Inspecciona el contenedor `db` para comprobar que la contraseña se estableció correctamente:
     ```bash
     docker exec -it db printenv MYSQL_ROOT_PASSWORD
     ```
   - Inspecciona el contenedor `web` para verificar que la clave API está presente:
     ```bash
     docker exec -it web printenv API_KEY
     ```

5. **Actualizar las variables de entorno**

   Si necesitas cambiar los valores de las variables de entorno, edita el archivo `.env` y reinicia los servicios para aplicar los cambios:

   ```bash
   docker-compose down
   docker-compose up -d
   ```

6. **Proteger el archivo `.env`**

   Asegúrate de que el archivo `.env` no se incluya en sistemas de control de versiones como Git. Añade la siguiente línea a tu archivo `.gitignore`:

   ```plaintext
   .env
   ```

   **Explicación:** Esto evita que las credenciales sensibles se suban accidentalmente a un repositorio.

7. **Detener los servicios**

   Cuando termines, detén los servicios y elimina los contenedores:

   ```bash
   docker-compose down
   ```


## 7. Securización de contenedores

### 7.1. Uso de imágenes seguras y verificadas

Este ejercicio tiene como propósito:
1. Enseñar a identificar y usar imágenes seguras y verificadas desde Docker Hub.
2. Habilitar **Docker Content Trust (DCT)** para garantizar la autenticidad e integridad de las imágenes.
3. Firmar imágenes propias para reforzar la seguridad durante su distribución.

---

1. **Verificar imágenes seguras en Docker Hub**

   - Accede a [Docker Hub](https://hub.docker.com) y busca una imagen oficial, como `nginx` o `node`.  
   - Verifica que sea una imagen oficial mediante los indicadores de confianza, como la etiqueta **"Official Image"**.

2. **Habilitar Docker Content Trust (DCT)**

   - Activa Docker Content Trust en tu entorno estableciendo la variable de entorno `DOCKER_CONTENT_TRUST`:
     ```bash
     export DOCKER_CONTENT_TRUST=1
     ```
   - **Prueba con una imagen firmada:**  
     Descarga una imagen oficial que esté firmada, como `alpine` o cualquier otra:
     ```bash
     docker pull alpine:latest
     ```
   - **Prueba con una imagen NO firmada:**
      Descarga una imagen NO firmada (busca en dockerhub).

   - **Resultado esperado:** Si la imagen no está firmada, Docker rechazará la descarga. De lo contrario, la imagen será descargada con éxito (debes obtener los dos resultados).

3. **Firmar imágenes propias**

   - Crea una imagen básica basada en `nginx`:
     ```dockerfile
     # Dockerfile
     FROM nginx:latest
     RUN echo "Hello from a secure image!" > /usr/share/nginx/html/index.html
     ```

   - Construye la imagen:
     ```bash
     docker build -t my-secure-image:1.0 .
     ```

   - Firma la imagen al subirla a un repositorio:
     ```bash
     docker tag my-secure-image:1.0 <tu_usuario>/my-secure-image:1.0
     docker push <tu_usuario>/my-secure-image:1.0
     ```
     **Nota:** Durante este paso, se te pedirá que configures una clave de firma si es la primera vez que usas DCT.

4. **Verificar la firma de la imagen**

   - Usa el siguiente comando para verificar que la imagen está firmada correctamente:
     ```bash
     docker trust inspect --pretty <tu_usuario>/my-secure-image:1.0
     ```
  
5. **Desactivar temporalmente Docker Content Trust**

   - Si necesitas deshabilitar DCT temporalmente, usa:
     ```bash
     DOCKER_CONTENT_TRUST=0 docker pull imagen-no-firmada-del-anterior-ejercicio:latest
     ```
   Deberías descargar la imagen NO firmada pero solo en este caso concreto que se ha aceptado.


### 7.2. Restricción de privilegios en contenedores

Configurar contenedores con privilegios mínimos para mejorar la seguridad. Este ejercicio cubre:  
1. Uso del flag `--read-only` para montar el sistema de archivos del contenedor en modo solo lectura.  
2. Restricción de capacidades del kernel mediante el flag `--cap-drop`.  
3. Uso del flag `--user` para ejecutar contenedores con un usuario no root.  

---

1. **Preparar un contenedor básico**  
   - Crea un contenedor basado en una imagen ligera como `alpine` para realizar pruebas.  
     ```bash
     docker run --rm -it alpine sh
     ```
   - Dentro del contenedor, verifica que puedes escribir en el sistema de archivos:  
     ```bash
     touch /tmp/testfile
     ```
   - Sal del contenedor con `exit`.

2. **Ejecutar un contenedor con sistema de archivos de solo lectura**  
   - Usa el flag `--read-only` para montar el sistema de archivos del contenedor en modo solo lectura:  
     ```bash
     docker run --rm -it --read-only alpine sh
     ```
   - Dentro del contenedor, intenta crear un archivo en el sistema de archivos:  
     ```bash
     touch /tmp/testfile
     ```
     **Resultado esperado:** Deberías obtener un error similar a:  
     ```plaintext
     touch: /tmp/testfile: Read-only file system
     ```

3. **Probar la restricción de capacidades del kernel**  
   - Por defecto, los contenedores Docker tienen capacidades del kernel activadas, como `CAP_SYS_ADMIN`.  
   - Ejecuta un contenedor y prueba montar un sistema de archivos (necesita privilegios elevados):  
     ```bash
     docker run --rm -it alpine sh -c "mkdir /mnt/test && mount -t tmpfs none /mnt/test"
     ```
     **Resultado esperado:** La operación debería completarse sin errores.  
   - Ahora ejecuta el contenedor con `--cap-drop=ALL` para deshabilitar todas las capacidades del kernel:  
     ```bash
     docker run --rm -it --cap-drop=ALL alpine sh
     ```
   - Intenta nuevamente montar un sistema de archivos:  
     ```bash
     mkdir /mnt/test && mount -t tmpfs none /mnt/test
     ```
     **Resultado esperado:** Deberías recibir un error similar a:  
     ```plaintext
     mount: permission denied (are you root?)
     ```

4. **Ejecutar contenedores con un usuario no root**  
   - Por defecto, los contenedores Docker ejecutan procesos como `root`. Usa el flag `--user` para ejecutar el contenedor como un usuario no root:  
     ```bash
     docker run --rm -it --user 1000:1000 alpine sh
     ```
   - Verifica que estás ejecutando como un usuario diferente con:  
     ```bash
     id
     ```
     **Resultado esperado:** El UID y GID deberían ser `1000`.  
   - Intenta crear un archivo en un directorio protegido como `/root`:  
     ```bash
     touch /root/testfile
     ```
     **Resultado esperado:** El sistema debería rechazar la operación debido a permisos insuficientes.

5. **Combinar todas las restricciones**  
   - Ejecuta un contenedor con todas las restricciones habilitadas:  
     ```bash
     docker run --rm -it --read-only --cap-drop=ALL --user 1000:1000 alpine sh
     ```
   - Verifica que:
     - El sistema de archivos es de solo lectura.
     - No puedes usar capacidades avanzadas del kernel.
     - Estás operando como un usuario no root.


### 7.3. Construcción segura de imágenes

Aplicar buenas prácticas de seguridad al construir imágenes Docker para reducir riesgos y minimizar vulnerabilidades. Este ejercicio incluye:

1. Uso de imágenes base mínimas.  
2. Creación de un archivo `.dockerignore` para proteger datos sensibles.  
3. Uso de usuarios no root en la construcción de la imagen.

---

1. **Preparar un Dockerfile básico**  
   Crea un archivo `Dockerfile` con el siguiente contenido inicial para una aplicación simple basada en Nginx:  
   ```dockerfile
   FROM nginx:latest
   COPY . /usr/share/nginx/html
   ```
   **Problema:** Este enfoque inicial tiene varios problemas de seguridad:
   - Usa una imagen genérica que puede incluir más herramientas de las necesarias.  
   - No asegura que los datos sensibles queden fuera de la imagen.  
   - Ejecuta procesos como root.

2. **Usar una imagen base mínima**  
   Modifica el Dockerfile para usar una imagen base más ligera, como `alpine`, que es más segura por su tamaño reducido:  
   ```dockerfile
   FROM nginx:alpine
   COPY . /usr/share/nginx/html
   ```
   **Explicación:** Usar imágenes mínimas reduce la superficie de ataque al contener solo las dependencias esenciales.

3. **Crear un archivo `.dockerignore`**  
   Para evitar incluir archivos innecesarios o sensibles en la imagen, crea un archivo `.dockerignore` con el siguiente contenido:  
   ```plaintext
   .env
   .git/
   node_modules/
   ```
   **Explicación:** Esto excluye archivos y carpetas como configuraciones locales, credenciales o dependencias del host, evitando su inclusión accidental en la imagen.

4. **Usar un usuario no root en la imagen**  
   Modifica el Dockerfile para crear y usar un usuario no root durante la ejecución:  
   ```dockerfile
   FROM nginx:alpine

   # Crear un usuario no root
   RUN addgroup -S appgroup && adduser -S appuser -G appgroup

   # Cambiar al usuario no root
   USER appuser

   # Copiar los archivos de la aplicación
   COPY . /usr/share/nginx/html
   ```
   **Explicación:** Esto asegura que el contenedor no opere con privilegios elevados, minimizando los riesgos en caso de compromiso.

5. **Construir la imagen segura**  
   Construye la imagen con las modificaciones realizadas:  
   ```bash
   docker build -t secure-nginx:1.0 .
   ```

6. **Verificar la seguridad de la imagen**  
   - Inspecciona los metadatos de la imagen para confirmar que está usando el usuario no root:  
     ```bash
     docker inspect secure-nginx:1.0
     ```
     Busca el campo `"User"` en la salida.  
   - Ejecuta un contenedor basado en esta imagen y verifica el usuario activo:  
     ```bash
     docker run --rm secure-nginx:1.0 id
     ```
     **Resultado esperado:** El UID y GID deberían coincidir con el usuario `appuser` creado en el Dockerfile.

7. **Probar la imagen segura**  
   - Inicia un contenedor con la imagen construida:  
     ```bash
     docker run -d -p 8080:80 secure-nginx:1.0
     ```
   - Abre `http://localhost:8080` en tu navegador para confirmar que el servidor Nginx funciona correctamente.


####  Optimizar el tamaño de la imagen**

1. **Reducir capas en el Dockerfile**  
   Combina instrucciones para minimizar el número de capas:  
   ```dockerfile
   FROM nginx:alpine

   RUN addgroup -S appgroup && adduser -S appuser -G appgroup \
       && apk add --no-cache curl

   USER appuser
   COPY . /usr/share/nginx/html
   ```
   **Explicación:** Combinar instrucciones reduce el tamaño de la imagen y simplifica la cadena de capas.

2. **Verificar el tamaño de la imagen**  
   Compara el tamaño de la nueva imagen con otras usando:  
   ```bash
   docker images
   ```
 😊

### 7.4. Configuración de límites de recursos para prevenir ataques DoS

Configurar límites de uso de memoria y CPU en los contenedores para prevenir ataques de Denegación de Servicio (DoS) o sobrecarga del sistema. Este ejercicio incluye el uso de flags como `--memory`, `--memory-reservation` y `--cpus` para gestionar recursos.

1. **Preparar un contenedor básico sin límites de recursos**  
   - Inicia un contenedor de prueba basado en la imagen `alpine`:
     ```bash
     docker run --rm -it alpine sh
     ```
   - Dentro del contenedor, genera un alto consumo de memoria:
     ```bash
     yes > /dev/null
     ```
   - Sal del contenedor con `Ctrl+C`.  
     **Problema:** Este contenedor podría consumir toda la memoria disponible, afectando otros procesos.

2. **Establecer un límite de memoria con `--memory`**  
   - Inicia un contenedor con un límite estricto de memoria:
     ```bash
     docker run --rm -it --memory=64m alpine sh
     ```
   - Dentro del contenedor, verifica el límite de memoria disponible:
     ```bash
     cat /sys/fs/cgroup/memory/memory.limit_in_bytes
     ```
     **Resultado esperado:** El límite debería ser de 64 MB.

   - Intenta consumir más memoria de la permitida:
     ```bash
     yes > /dev/null
     ```
     **Resultado esperado:** El contenedor debería ser detenido automáticamente por Docker debido al límite.

3. **Establecer una reserva de memoria con `--memory-reservation`**  
   - Usa el flag `--memory-reservation` para garantizar una cantidad mínima de memoria:
     ```bash
     docker run --rm -it --memory=128m --memory-reservation=64m alpine sh
     ```
   - **Explicación:**  
     - `--memory-reservation=64m`: Reserva 64 MB de memoria como mínimo.
     - `--memory=128m`: Establece un límite máximo de 128 MB.

4. **Configurar límites de CPU con `--cpus`**  
   - Inicia un contenedor con un límite de CPU:
     ```bash
     docker run --rm -it --cpus=0.5 alpine sh
     ```
   - Dentro del contenedor, genera una carga alta de CPU:
     ```bash
     yes > /dev/null
     ```
   - En otra terminal, monitorea el uso de CPU del contenedor:
     ```bash
     docker stats
     ```
     **Resultado esperado:** El contenedor no debería utilizar más del 50% de una CPU.

5. **Combinar límites de recursos**  
   - Inicia un contenedor con límites combinados de memoria y CPU:
     ```bash
     docker run --rm -it --memory=128m --memory-reservation=64m --cpus=1 alpine sh
     ```
   - Realiza pruebas de consumo de memoria y CPU para verificar que los límites se aplican correctamente.

6. **Aplicar límites en un archivo `docker-compose.yml`**  
   Si estás utilizando Docker Compose, configura los límites en el archivo `docker-compose.yml`:
   ```yaml
   version: '3.7'
   services:
     app:
       image: alpine
       deploy:
         resources:
           limits:
             memory: 128m
             cpus: "0.5"
           reservations:
             memory: 64m
   ```
   - Inicia los servicios con:
     ```bash
     docker-compose up -d
     ```
   - Verifica que los límites están aplicados con:
     ```bash
     docker stats
     ```

## 8. Herramientas de securización: Docker Scout

### 8.1 Análisis básico de vulnerabilidades en imágenes Docker

Utilizar **Docker Scout CLI** para realizar un análisis inicial de vulnerabilidades en una imagen Docker. El objetivo es identificar CVEs (vulnerabilidades conocidas) y categorizarlas por severidad.

1. **Instalar Docker Scout CLI (si no está instalado)**  
   Debes tener instalado en tu sistema operativo Docker Scout CLI.

2. **Seleccionar una imagen para analizar**  
   Elige una imagen pública conocida como `nginx:latest` para el análisis. Asegúrate de tenerla en tu sistema ejecutando:
   ```bash
   docker pull nginx:latest
   ```
   Elige otra imagen pública elegida por tí, una que te llame especialmente la atención y haz el ejercicio completo también con esta imagen.

3. **Ejecutar el análisis básico con Docker Scout CLI**  
   Realiza un análisis inicial para identificar vulnerabilidades en las dos imagenes seleccionadas (nginx y la tuya):
   ```bash
   docker scout cves nginx:latest
   ```
   **Explicación:**  
   - Este comando analiza la imagen y muestra las vulnerabilidades detectadas, categorizadas por severidad (crítico, alto, medio, bajo).

4. **Interpretar los resultados**  
   Examina la salida del comando, que debería ser similar a esto:
   ```plaintext
   IMAGE           HIGH   MEDIUM   LOW
   nginx:latest    5      10       20
   ```

5. **Filtrar vulnerabilidades por severidad**  
   Si solo te interesan vulnerabilidades críticas o altas, puedes usar el flag `--severity`:
   ```bash
   docker scout cves nginx:latest --severity=high
   ```

6. **Obtener detalles sobre un CVE específico**  
   Usa el ID de un CVE listado en los resultados para obtener más información:
   ```bash
   docker scout cves nginx:latest --cve=CVE-2023-12345
   ```

7. **Analizar la imagen desde un registro remoto**  
   Usando una imagen propia en Docker Hub o un registro privado, analiza directamente desde el registro:
   ```bash
   docker scout cves your-repo/your-image:tag
   ```
### 8.2. Filtrar vulnerabilidades y recomendaciones en imágenes

Utilizar **Docker Scout CLI** para filtrar vulnerabilidades en imágenes Docker según su severidad y obtener recomendaciones prácticas para mitigarlas.

Este ejercicio debe hacerse con la imagen mostrada y con una imagen seleccionada por el estudiante (repitiendo los pasos).

1. **Seleccionar una imagen para el análisis**  
   Asegúrate de tener una imagen lista para analizar. Usa una imagen pública como `node:16`:
   ```bash
   docker pull node:16
   ```

2. **Ejecutar un análisis básico con Docker Scout CLI**  
   Realiza un análisis inicial para listar todas las vulnerabilidades:
   ```bash
   docker scout cves node:16
   ```
   **Salida esperada:**  
   ```plaintext
   IMAGE           HIGH   MEDIUM   LOW
   node:16         7      15       30
   ```

3. **Filtrar por severidad específica**  
   Si deseas enfocarte solo en vulnerabilidades críticas o altas, usa el flag `--severity`:
   ```bash
   docker scout cves node:16 --severity=high
   ```

4. **Listar recomendaciones prácticas**  
   Ejecuta el comando con el flag `--recommendations` para incluir sugerencias sobre cómo mitigar las vulnerabilidades detectadas:
   ```bash
   docker scout recommendations node:16
   ```
   **Ejemplo de salida:**  
   ```plaintext
   CVE-2023-12345 (HIGH): Update package 'openssl' to version 1.1.1 or higher.
   CVE-2023-23456 (MEDIUM): Consider switching to node:18 (latest LTS).
   ```

5. **Analizar recomendaciones en detalle**  
   Selecciona un CVE específico de la salida anterior y obtén más información sobre el impacto y las acciones sugeridas:
   ```bash
   docker scout cves node:16 --cve=CVE-2023-12345
   ```

6. **Comparar imágenes para evaluar mejoras**  
   Descarga una versión más reciente de la imagen y compárala con la versión actual:
   ```bash
   docker pull node:18
   docker scout compare node:16 node:18
   ```
   **Resultado esperado:**  
   La salida debería indicar si la versión más reciente ha reducido el número de vulnerabilidades.

7. **Generar un informe para revisión posterior**  
   Redirige la salida del análisis a un archivo para su documentación:
   ```bash
   docker scout recommendations node:16 > scout-report.txt
   ```

8. **Evaluar el impacto de las recomendaciones**  
   - Aplica una de las recomendaciones, como cambiar a una imagen más reciente (`node:18`) o eliminar paquetes inseguros en tu imagen personalizada.
   - Analiza nuevamente para verificar si las vulnerabilidades se han reducido:
     ```bash
     docker scout cves node:18
     ```

### 8.3: Comparar imágenes Docker para analizar mejoras de seguridad

Utilizar **Docker Scout CLI** para comparar imágenes Docker y analizar si las actualizaciones o cambios en las imágenes han mejorado o empeorado la seguridad.


1. **Seleccionar dos versiones de una imagen Docker**  
   Descarga dos versiones diferentes de una misma imagen, como `nginx:1.19` y `nginx:1.23`:
   ```bash
   docker pull nginx:1.19
   docker pull nginx:1.23
   ```

2. **Realizar análisis individuales con Docker Scout CLI**  
   Analiza cada versión por separado para identificar sus vulnerabilidades:
   ```bash
   docker scout cves nginx:1.19
   docker scout cves nginx:1.23
   ```

3. **Comparar las dos versiones con Docker Scout CLI**  
   Usa el comando `docker scout compare` para analizar las diferencias en las vulnerabilidades:
   ```bash
   docker scout compare --to nginx:1.19 nginx:1.23
   ```

4. **Comparar imágenes personalizadas (opcional)**  
   Si tienes una imagen personalizada, compárala con la base para evaluar los riesgos adicionales.  
   - Construye una imagen personalizada:
     ```dockerfile
     FROM nginx:1.23
     RUN apt-get update && apt-get install -y curl
     ```
   - Construye y analiza la imagen:
     ```bash
     docker build -t custom-nginx:1.23 .
     docker scout compare --to nginx:1.23 custom-nginx:1.23
     ```

5. **Probar imágenes en un registro remoto**  
   Si trabajas con imágenes almacenadas en Docker Hub o un registro privado, realiza la comparación directamente desde el registro:
   ```bash
   docker scout compare --to my-repo/nginx:1.19 my-repo/nginx:1.23
   ```

6. **Documentar los resultados**  
   - Guarda los resultados de la comparación para su análisis posterior:
     ```bash
     docker scout compare --to nginx:1.19 nginx:1.23 --details > comparison-report.txt
     ```


### 8.4. Generar informes detallados y visualizarlos en Docker Scout Web**

Generar un informe detallado sobre vulnerabilidades y configuraciones inseguras utilizando **Docker Scout CLI**, y explorar los resultados en la plataforma **Docker Scout Web** para analizar visualmente las capas y los paquetes de una imagen.


1. **Preparar una imagen para el análisis**  
   - Descarga una imagen pública, como `nginx:1.23`:
     ```bash
     docker pull nginx:1.23
     ```

2. **Generar un informe detallado con Docker Scout CLI**  
   - Ejecuta el comando para analizar vulnerabilidades y generar un informe:
     ```bash
     docker scout quickview nginx:1.23
     ```

3. **Guardar el informe para revisión posterior**  
   - Redirige la salida del análisis a un archivo para facilitar su revisión:
     ```bash
     docker scout quickview nginx:1.23 > scout-report.txt
     ```

   **Contenido esperado del informe:**
   - Número total de vulnerabilidades.
   - Paquetes afectados y CVEs asociados.
   - Recomendaciones prácticas.

4. **Explorar el informe en Docker Scout Web**  
   - Inicia sesión en la plataforma **Docker Scout Web**:  
     [https://hub.docker.com/scout](https://hub.docker.com/scout)
   - Sube el informe generado o analiza la imagen directamente desde el registro remoto.

   **Pasos para subir la imagen al registro Docker Hub:**
   - Etiqueta y sube la imagen a tu cuenta de Docker Hub:
     ```bash
     docker tag nginx:1.23 <tu_usuario>/nginx:1.23
     docker push <tu_usuario>/nginx:1.23
     ```

   - En Docker Scout Web, selecciona la imagen subida para visualizar el análisis.

5. **Explorar capas y vulnerabilidades**  
   - En Docker Scout Web, explora las capas de la imagen y las vulnerabilidades asociadas a cada capa.  
   - Identifica en qué etapa del Dockerfile se introdujeron los paquetes vulnerables.

6. **Probar análisis de imágenes personalizadas**  
   - Construye una imagen personalizada basada en `nginx:1.23`:
     ```dockerfile
     FROM nginx:1.23
     RUN apt-get update && apt-get install -y curl
     ```
   - Etiqueta y sube la imagen:
     ```bash
     docker build -t <tu_usuario>/custom-nginx:1.23 .
     docker push <tu_usuario>/custom-nginx:1.23
     ```
   - Analiza la imagen personalizada en Docker Scout Web para observar los paquetes y configuraciones adicionales.

7. **Comparar resultados entre imágenes**  
   - Usa la función de comparación en Docker Scout Web para observar diferencias de seguridad entre la imagen base `nginx:1.23` y la personalizada.



## Criterios de Evaluación Asociados

| **RA 5: Implanta sistemas seguros de desplegado de software, utilizando herramientas para la automatización de la construcción de sus elementos** |                                                                 |
|-------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| **a)** Identificación de características, principios y objetivos de la integración del desarrollo y operación del software. |                                                                 |
| **b)** Implantación de sistemas de control de versiones, administrando los roles y permisos solicitados.               |                                                                 |
| **c)** Instalación, configuración y verificación de sistemas de integración continua, conectándolos con sistemas de control de versiones. |                                                                 |
| **d)** Planificación, implementación y automatización de planes de desplegado de software.                             |                                                                 |
| **e)** Evaluación de la capacidad del sistema desplegado para reaccionar de forma automática a fallos.                |                                                                 |
| **f)** Documentación de tareas realizadas y procedimientos para la recuperación ante desastres.                       |                                                                 |
| **g)** Creación de bucles de retroalimentación ágiles entre los miembros del equipo.                                    |                                                                 |


## Práctica 3.1. Uso de contenedores (5.5 puntos)

1. Realiza la práctica guiada de contenedores. Paso a paso.

La puntuación es la siguiente:

- Configuración Inicial (0.25 puntos)
- Primeros Pasos: Diferencia entre Imagen y Contenedor (0.25 puntos)
- Primeros Pasos: Redes (0.75 puntos)
- Persistencia de datos (0.75 puntos)
- Construyendo nuestras propias imágenes (1.50 puntos)
- Docker-Compose (0.75 puntos)
- Securización (0.75 puntos)
- Docker scout (1 punto)

## Práctica 3.2. Estudio de diferentes docker-compose (3 puntos)

Dada la sigiuente lista de docker-compose por la comunidad:

- [https://github.com/docker/awesome-compose](https://github.com/docker/awesome-compose).

Debes seleccionar al menos 2 docker-compose de la lista anterior, siendo uno perteneciente a la categoría [https://github.com/Haxxnet/Compose-Examples?tab=readme-ov-file#software-development---project-management-devops](https://github.com/Haxxnet/Compose-Examples?tab=readme-ov-file#software-development---project-management-devops) de herramientas de desarrollo.

Debe realizar las siguientes tareas:

1. Explicar detalladamente qué hace el docker-compose.
2. Adaptar el docker-compose con las variables de entorno (si fueran necesarias), volumenes, y redes de nuestra puesta en producción.
3. Realizar la securización de las imagenes/docker-compose
4. Realizar un análisis de vulnerabilidades y reflexionar la seguridad.
5. Intentar solucionar una de las vulnerabilidades.
   

## Práctica 3.3. Despliegue de software vulnerable (1.5 puntos)

Siguiendo el PDF y el material proporcionado en la Moodle del curso 


# Investigación

## Investigación 3.1. Uso de la herramienta Trivy.

1. Instala/Configura Trivy.
2. Realiza algunas comparaciones de seguridad de las imagenes usando Trivy.



---
Author: Carlos Caballero González (https://www.carloscaballero.io)
