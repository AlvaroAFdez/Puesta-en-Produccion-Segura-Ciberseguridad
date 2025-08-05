# Laboratorio 4

# Índice

- [Práctica 4.1](#id1)
    - [Informes Vulnerabilidades Qlik Sense](#id2)
    - [Informes Vulnerabilidades PuTTy](#id3)
- [Práctica 4.2](#id4)
    - [Informes Vulnerabilidades OpenSSL](#id5)
    - [Informes Vulnerabilidades Active Directory](#id6)    
- [Práctica 4.3](#id7)
    - [Informes Vulnerabilidades, Amenaza, Riesgo de Wordpress](#id8)
- [Práctica 4.4](#id9)


# Práctica 4.1. Identificación de vulnerabilidades en fuentes abiertas  <a name="id1"></a>

**Objetivo:** Explorar bases de datos de vulnerabilidades como CVE y CWE para identificar fallos en software conocido.  

Analizar vulnerabilidades conocidas en software ampliamente utilizado, comprendiendo su impacto y las medidas de mitigación aplicables.

#### Software Seleccionado

  - **Qlik Sense**: Qlik Sense es una plataforma de análisis de datos completa que establece el punto de referencia para una nueva generación de análisis.
  - **PuTTy**: PuTTY es un cliente SSH y Telnet con el que podemos conectarnos a servidores remotos iniciando una sesión en ellos que nos permite ejecutar comandos.

#### Pasos a Seguir

1. **Acceder a la Base de Datos de Vulnerabilidades CVE**
   - Visitar el sitio oficial de [CVE](https://cve.mitre.org).
    
2. **Buscar Vulnerabilidades Específicas de Apache HTTP Server**
   - Utilizar la función de búsqueda para encontrar vulnerabilidades asociadas con "Apache HTTP Server".
   - Identificar al menos tres vulnerabilidades recientes relevantes.
     
3. **Analizar Detalles de Cada Vulnerabilidad**
   - Para cada vulnerabilidad identificada, recopilar la siguiente información:
     - **ID de CVE**: Identificador único de la vulnerabilidad.
     - **Descripción**: Resumen del problema de seguridad.
     - **Fecha de Publicación**: Cuándo se divulgó la vulnerabilidad.
     - **Impacto**: Consecuencias potenciales de la explotación.
     - **Vectores de Ataque**: Métodos mediante los cuales se puede explotar la vulnerabilidad.
     - **Medidas de Mitigación o Parches Disponibles**: Soluciones o recomendaciones para abordar la vulnerabilidad.

4. **Consultar la Enumeración de Debilidades Comunes (CWE)**
   - Visitar el sitio oficial de [CWE](https://cwe.mitre.org).
   - Buscar las debilidades asociadas a las vulnerabilidades identificadas en Apache HTTP Server.
   - Comprender cómo estas debilidades contribuyen a las vulnerabilidades específicas.

5. **Documentar el informe**
   - Elaborar un informe que incluya:
     - Resumen de cada vulnerabilidad con la información recopilada.
     - Análisis de las debilidades subyacentes según CWE.
     - **Reflexión** sobre la importancia de abordar estas vulnerabilidades y debilidades en el desarrollo y mantenimiento de software.

## Informe Vulnerabilidades Qlik Sense <a name="id2"></a>

### Vulnerabilidad CVE-2022-0564

#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2022-0564   

- **Descripción**: Esta vulnerabilidad de Qlik Sense Enterprise para Windows le permitia a un atacante enumerar las cuentas de usuarios de un dominio

- **Fecha de Publicación**: 21 de febrero de 2022

- **Impacto**: Una vez enumeradas las cuentas de dominios el atacante podria usar diferentes metodos para realizar daños, un ejemplo que te muestra CVE es que puede comparar los tiempos de respuesta  que tienen los diferentes usuarios del sistema para saber que cuentas son validas

- **Vectores de Ataque**: La forma por la cual explotaban la vulnerabilidad era enviandole peticiones de autentificación al sistema pero solo afecta a los sistemas que tienen el LDAP configurado

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad se encuentra desde la versión 14.X hasta la versión 14.44.0 por tanto con actualizar a una de las versiones siguientes nos serviría como medida de mitigación



#### <u>Análisis CWE asociada</u>

- **ID de CWE**: CWE-204 (Observable Response Discrepancy / Discrepancia de respuesta observable)  

- **Descripción**: Esta debilidad basicamente permite de que personas que no son autorizadas pueden obtener información a partir de las respuestas de las solicitudes fallidas ya que al ser los mensajes diferentes se puede saber si una cuenta es válida o no 

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2002-2094
   - CVE-2001-1483
   - CVE-2001-1528
   - CVE-2004-2150
   - CVE-2005-1650
   - CVE-2004-0294
   - CVE-2004-0243
   - CVE-2002-0514
   - CVE-2002-0515
   - CVE-2001-1387
   - CVE-2004-0778
   - CVE-2004-1428

<u>Reflexión sobre la vulnerabilidad</u>

Yo pienso que una vulnerabilidad que afecta a algo tan importante como el LDAP de un dominio, es algo que los creadores del software Qlik Sense deberia de ver revisado a la hora del desarrollo. Teniendo en cuenta que es algo que afecta a algo tan importante


### Vulnerabilidad CVE-2023-41266

#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2023-41266  

- **Descripción**: Los atacantes a partir de esta vulnerabilidad podian crear sesiones anonimas remotas sin necesidad de estar autenticados

- **Fecha de Publicación**: 29 de agosto de 2023

- **Impacto**: Una vez con la sesión anonima creada , el atacante podia realizar peticiones HTTP a endpoint no autorizados

- **Vectores de Ataque**: Los atacantes manipulaban las rutas para conseguir remotamente la sesion anonima sin autenticarse y acceder a endpoint no autorizados

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad se encuentra en  en Qlik Sense Enterprise para Windows para las versiones Mayo 2023 Parche 3 y anteriores, Febrero 2023 Parche 7 y anteriores, Noviembre 2022 Parche 10 y anteriores, y Agosto 2022 Parche 12 y anteriores . Esto se ha corregido en la IR (lanzamiento inicial) de agosto de 2023, el parche 4 de mayo de 2023, el parche 8 de febrero de 2023, el parche 11 de noviembre de 2022 y el parche 13 de agosto de 2022



#### <u>Análisis CWE asociada</u>

En este caso la vulnerabilidad no tenia una CWE asociada directamente en la lista de CVE por lo que he intentado encontrar la que pienso que se asocia mejor

- **ID de CWE**: CWE-35: Path Traversal: '.../...//' 

- **Descripción**: El producto utiliza una entrada externa para construir una ruta que debe estar dentro de un directorio restringido, pero no neutraliza adecuadamente las secuencias '.../...//'  que pueden resolverse en una ubicación que está fuera de ese directorio.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2005-2169
   - CVE-2005-0202


<u>Reflexión sobre la vulnerabilidad</u>

La reflexión que saco de esta vulnerabilidad es la importancia de controlar adecuadamente las rutas en el software. Un fallo tan simple como no validar correctamente las rutas puede llevar a incidentes tan graves como se muestran en en este CVE.

### Vulnerabilidad CVE-2024-55579

#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2024-55579

- **Descripción**: Un usuario sin privilegios y con acceso a la red podría crear objetos de conexión , que activen la ejecución de archivos EXE arbitrarios , es decir, un usuario podia hacer que Qlik Sense se conecte a otras fuentes de datos en las cuales podia ejcutar archivos no autorizados o maliciosos

- **Fecha de Publicación**: 9 de diciembre de 2024

- **Impacto**: Los atacantes a partir de esta vulnerabilidad pueden ejecutar archivos EXE arbitrarios que podrian ser maliciosos

- **Vectores de Ataque**: Los atacantes creaban objetos de conexión que son configuraciones o elementos que permiten que la aplicación se conecten a otras fuentes de datos para asi ejecutar archivos EXE

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad se encuentra en Qlik Sense Enterprise para Windows antes de la actualización de seguridad de noviembre de 2024 .  Esto se solucionó en la actualización de seguridad de noviembre de 2024, el parche 10 de mayo de 2024, el parche 14 de febrero de 2024, el parche 16 de noviembre de 2023, el parche 16 de agosto de 2023, el parche 18 de mayo de 2023 y el parche 15 de febrero de 2023



#### <u>Análisis CWE asociada</u>

En este caso la vulnerabilidad no tenia una CWE asociada directamente en la lista de CVE por lo que he intentado encontrar la que pienso que se asocia mejor

- **ID de CWE**: CWE-94: Improper Control of Generation of Code ('Code Injection') /Inyección de código

- **Descripción**: El producto construye todo o parte de un segmento de código utilizando información influenciada externamente desde un componente anterior, pero no neutraliza o neutraliza incorrectamente elementos especiales que podrían modificar la sintaxis o el comportamiento del segmento de código previsto.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2023-29374
   - CVE-2024-5565
   - CVE-2024-4181
   - CVE-2022-2054
   - CVE-2021-22204



<u>Reflexión sobre la vulnerabilidad</u>

La refelxión general sobre este punto es que securizar las entradas de tu aplicación es muy importante para evitar vulnerabilidades como estas que permiten injectar codigo en tu aplicación que puede ser malicioso. Ya que es un incidente bastante grave

## Informes Vulnerabilidades PuTTy <a name="id3"></a>

### Vulnerabilidad CVE-2019-9897

#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2019-9897

- **Descripción**: En las versiones de PuTTY anteriores a la 0.71 existen múltiples ataques de denegación de servicio que pueden desencadenarse escribiendo en el terminal

- **Fecha de Publicación**: 21 de marzo de 2019

- **Impacto**: Los atacantes mediante la denegación de servicios podrian impedir que los clientes accedan a un software o incluso realizar un uso excesivo de los recursos de un servidor prococando su caida

- **Vectores de Ataque**: Al no tener controladas las peticiones correctamente Putty el atacante podia realizar peticiones sin control

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad fue corregida en la versión 0.71. Por tanto con actualizar a esa versión en adelante se solucionaría


#### <u>Análisis CWE asociada</u>

En este caso la vulnerabilidad no tenia una CWE asociada directamente en la lista de CVE por lo que he intentado encontrar la que pienso que se asocia mejor

- **ID de CWE**: CWE-400: Uncontrolled Resource Consumption /Consumo de recursos descontrolados
- **Descripción**: El producto no controla adecuadamente la asignación y el mantenimiento de un recurso limitado, lo que permite a un actor influir en la cantidad de recursos consumidos, llevando finalmente al agotamiento de los recursos disponibles.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2022-21668
   - CVE-2020-7218
   - CVE-2020-3566
   - CVE-2009-2874
   - CVE-2009-1928



<u>Reflexión sobre la vulnerabilidad</u>

La denegación de servicios es una vulnerabilidad la cual se debe intentar solucionar o encontrar realizando test antes de que salga una versión (en este caso de Putty) ya que en una empresa que te realizan este ataque puede suponer que los clientes ese dia no puedan realizar compras,peticiones,etc... a tu servidor , incluso de que tus propios trabajadores no puedan trabajar ese dia ya que no se puede acceder al servidor



### Vulnerabilidad CVE-2021-36367


#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2021-36367

- **Descripción**: PuTTY hasta la versión 0.75 establecia una sesión SSH incluso si nunca ha enviado una respuesta de autenticación válida. Es decir PuTTY empezaba  sesiones SSH incluso si la autenticación no se completaba correctamente

- **Fecha de Publicación**: 9 de julio de 2021

- **Impacto**: Los atacantes podrian robarte las credenciales simulando servidores ssh reales

- **Vectores de Ataque**: Los atacantes podrían configurar servidores falsos aprovechando esta vulnerabilidad para simular un servidor ssh real con fines maliciosos, ya que no se realizaba la autenticación correctamente

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad fue corregida en la versión 0.75. Por tanto con actualizar a esa versión en adelante se solucionaría


#### <u>Análisis CWE asociada</u>

En este caso la vulnerabilidad no tenia una CWE asociada directamente en la lista de CVE por lo que he intentado encontrar la que pienso que se asocia mejor

- **ID de CWE**: CWE-345: Insufficient Verification of Data Authenticity
- **Descripción**: El producto no verifica suficientemente el origen o la autenticidad de los datos, de manera que provoca que acepte datos no válidos.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2022-30260
   - CVE-2022-30267
   - CVE-2022-30272



<u>Reflexión sobre la vulnerabilidad</u>

Es muy importante en un software (en este caso Putty) verificar correctamente los datos de la autentificación a la hora de realizar las conexiones ya que si no se comprueba correctamente facilita mucho a los atacantes el robo de los credenciales

### Vulnerabilidad CVE-2020-8585


#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2020-8585

- **Descripción**: Un paquete  llamado OnCommand Unified Manager (que es una herramienta para gestionar y monitorear sistemas de almacenamiento) en versiones anteriores a la version 5.2.5 podian revelar informacion confidencial de la cuenta a usuarios no autorizados mediante el uso de PuTTY Link que es una herramienta incluida en PuTTY para poder realizar conexiones mediante terminal sin necesidad de abrir la interfaz grafica

- **Fecha de Publicación**: 28 de enero de 2021

- **Impacto**: Los atacantes podrian robarte información confidencial como credenciales , datos sensibles , etc...

- **Vectores de Ataque**: Los atacantes inyectaban codigo malicioso ya que el funcionamiento interno de OnCommand Unified Manager funcionaba a traves de puTTY Link y no controlaban bien las entradas

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad fue corregida en la versión 5.2.5. Por tanto con actualizar a esa versión en adelante se solucionaría


#### <u>Análisis CWE asociada</u>

En este caso la vulnerabilidad no tenia una CWE asociada directamente en la lista de CVE por lo que he intentado encontrar la que pienso que se asocia mejor

- **ID de CWE**: CWE-94: Improper Control of Generation of Code ('Code Injection')/Inyección de código
- **Descripción**: El producto construye todo o parte de un segmento de código utilizando información influenciada externamente desde un componente anterior, pero no neutraliza o neutraliza incorrectamente elementos especiales que podrían modificar la sintaxis o el comportamiento del segmento de código previsto.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2023-29374
   - CVE-2024-5565
   - CVE-2024-4181
   - CVE-2022-2054
   - CVE-2021-22204



<u>Reflexión sobre la vulnerabilidad</u>

Me resulta curioso como a priori algo que no deberia de tener en principio nada que ver una cosa con la otra como es  OnCommand Unified Manager y PuTTY Link como provoca una vuonerabilidad tan grave como la posibilidad de que te inyecten codigo para robarte datos confidenciales.

# **Práctica 4.2. Identificación de vulnerabilidades en fuentes abiertas**<a name="id4"></a>

**Objetivo:** Explorar bases de datos de vulnerabilidades como CVE y CWE para identificar fallos en software conocido.  

Analizar vulnerabilidades conocidas en software ampliamente utilizado, comprendiendo su impacto y las medidas de mitigación aplicables.

En este caso debe buscar 2 software conocidos y realizar lo mismo que se ha hecho anteriormente. Deben ser 2 software populares y no simplemente al azar.

## Informes Vulnerabilidades OpenSSL <a name="id5"></a>

 OpenSSL es un conjunto de herramientas de software que permite la implementación de protocolos de seguridad para el cifrado y la autenticación

### Vulnerabilidad CVE-2024-2511


#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2024-2511

- **Descripción**: Unas configuraciones deel servidor TLS provocaban un  aumento de la memoria ilimitado  al procesas sesiones TLSv1.3.El problema solo afecta a servidores TLS que soportan TLSv1.3 y no a clientes TLS. S

- **Fecha de Publicación**: 8 de abril de 2024

- **Impacto**: El atacante explotando esta vulnerabilidad podia llegar a provocar una denegación de servicios 

- **Vectores de Ataque**: si se utiliza la opción SSL_OP_NO_TICKET no predeterminada .La caché de sesión podría entrar en un estado incorrecto y no se vaciará correctamente a medida que se llena por tanto la caché de sesión continuará creciendo de manera ilimitada. Entonces un atacante podría forzar este error para producir una denegación de servicios

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad afecta entre la versión 3.2.0 y la versión 3.2.2,la versión 3.1.0 y la versión 3.1.6,la versión 3.0.0 y la versión 3.0.14 y ente la versión 1.1.1 y la versión 1.1.1y. Por tanto con evitar estas versiones evitariamos esta vulnerabilidad 


#### <u>Análisis CWE asociada</u>


- **ID de CWE**: CWE-1325: Improperly Controlled Sequential Memory Allocation/Asignación de memoria secuencial mal controlada
- **Descripción**: El producto administra un grupo de objetos o recursos y realiza una asignación de memoria independiente para cada objeto, pero no limita adecuadamente la cantidad total de memoria que consumen todos los objetos combinados.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2020-36049
   - CVE-2019-20176
   - CVE-2013-1591



<u>Reflexión sobre la vulnerabilidad</u>

Esta vulnerabilidad destaca la importancia de realizar las configuraciones individuales como grupales de los componentes correctamente. Ya que aunque no afecta a los clientes directamente, puede provocar la denegacion de servicios de servidores TLS

### Vulnerabilidad CVE-2024-13454


#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2024-13454

- **Descripción**: El algoritmo de cifrado débil en Easy-RSA versión 3.0.5 a 3.1.7 permite que un atacante local ataque con fuerza bruta más fácilmente la clave CA privada cuando se crea usando OpenSSL 3

- **Fecha de Publicación**: 20 de enero de 2025

- **Impacto**: El atacante podria extraerte la clave privada de la entidad certificadora comprometiendo la autenticidad de las conexiones seguras y permitirle emitir certificados falsificados

- **Vectores de Ataque**: Un atacante que tiene acceso local al sistema donde se ha creado la clave privada de la Entidad Certificadora  utilizando Easy-RSA y OpenSSL 3 puede intentar un ataque de fuerza bruta contra la clave privada debido al uso de un algoritmo de cifrado débil. Esto provoca que sea mas facil ce extraer ya que ese cifrado es mas vulnerable

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad afecta entre la versión 3.0.5 y la versión 3.1.7. Actualizando a una version superior evitariamos la vulnerabilidad


#### <u>Análisis CWE asociada</u>


- **ID de CWE**: CWE-326: Inadequate Encryption Strength / Fuerza de cifrado inadecuada
- **Descripción**: El producto almacena o transmite datos confidenciales mediante un esquema de cifrado que, en teoría, es sólido, pero no es lo suficientemente fuerte para el nivel de protección requerido.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2001-1546
   - CVE-2004-2172
   - CVE-2002-1682
   - CVE-2002-1697
   - CVE-2002-1739



<u>Reflexión sobre la vulnerabilidad</u>

Esta vulnerabilidad es muy peligrosa ya que al facilitarle la extraccion de la clave privada de la CA a un atacante mediante fuerza bruta. Compromete algo tan importante como si las conexiones realizadas con esa clave son seguras o incluso dar la posibilidad al atacante de generar nuevos certificados falsificados con fines maliciosos

### Vulnerabilidad CVE-2014-0160 (Heartbleed)


#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2014-0160

- **Descripción**: He puesto esta vulnerabilidad porque es una de las mas famosas que ha sufrido OpenSSL. En las versiones 1.0.1 a 1.0.1g, esta vulnerabilidad permitía a los atacantes leer partes de la memoria de los servidores afectados. Esto se lograba mediante un ataque al protocolo TLS heartbeat (que basicamente eran solicitudes para mantener la conexion cliente servidor ),esto sucedia porque las solicitudes heartbeat mandan pequeñas cadenas de datos del cliente al servidor y el servidor le respondia con la misma cantidad de datos, la vulnerabilidad estaba en que si el cliente manipulaba la longitud de los datos que envia al servidor, el servidor le enviaba mas información de la cuenta. Llegando a poder mostrar memoria interna  la cual producia la exposición de claves privadas, contraseñas y otros datos sensibles.

- **Fecha de Publicación**: 7 de abril de 2014

- **Impacto**: El atacante podria extraerte claves privadas, contraseñas y otros datos sensibles.


- **Vectores de Ataque**: El atacante envía una solicitud Heartbeat manipulada a un servidor afectado, solicitando más datos de los que debería

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad afecta entre la versión 1.0.1 a 1.0.1g. Actualizando a una version superior evitariamos la vulnerabilidad


#### <u>Análisis CWE asociada</u>


- **ID de CWE**: CWE-125: Out-of-bounds Read/Lectura fuera de límites
- **Descripción**: El producto lee datos más allá del final o antes del comienzo del búfer previsto.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2023-1018
   - CVE-2020-11899
   - CVE-2021-40985
   - CVE-2018-10887
   - CVE-2018-16069



<u>Reflexión sobre la vulnerabilidad</u>

El aprendizaje que saco es que de cualquier detalle te pueden extraer información.De no controlar correctamente una simple solicitud que en teoria funciona para mantener una simple conexión puede desembocar en que te extrigan todas tus claves y contraseñas

## Informes Vulnerabilidades Active Directory <a name="id6"></a>

He seleccionado Active Directory porque, según nos explicaron en bastionado, es uno de los softwares más utilizados para implementar LDAP en las empresas. Se trata de una base de datos y un conjunto de servicios que conectan a los usuarios con los recursos de red necesarios para desempeñar su trabajo.

### Vulnerabilidad CVE-2025-21351

#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2025-21351

- **Descripción**: Esta vulnerabilidad afecta los servicios de dominio de  Windows Active Directory. Permite que un atacante envíe solicitudes maliciosas a la API del servicio, lo que provoca una denegación del servidor de Active Directory. 

- **Fecha de Publicación**: 11 de febrero de 2025

- **Impacto**: El servidor de Active Directory queda inactivo y los usuarios no podrian realizar sus tareas en la empresa


- **Vectores de Ataque**: El atacante envía una solicitudes malicisosas que el servidor no maneja correctamente, desencadenando de que el servidor consuma mas recursos de la cuenta y acaba en la denegación de servicios

- **Medidas de Mitigación o Parches Disponibles**: Esta vulnerabilidad afecta a varios productos de windows , que dependiendo del producto que tengamos en nuestra empresa varia las versiones en la que se encuentran. Normalmente se encuentra entre la version 10.0.1xxx.x y 10.0.17xx.xx , y entre la versión  10.0.2xxx.x y 10.0.26xx.xx. Con buscar el producto de windows que tengas y actualices a un parche que no afecte en ese producto se soluciona


#### <u>Análisis CWE asociada</u>


- **ID de CWE**: CWE-400: Uncontrolled Resource Consumption/Consumo descontrolado de recursos
- **Descripción**: El producto no controla adecuadamente la asignación y el mantenimiento de un recurso limitado, lo que permite que un actor influya en la cantidad de recursos consumidos, lo que eventualmente conduce al agotamiento de los recursos disponibles.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2022-21668
   - CVE-2020-7218
   - CVE-2020-3566
   - CVE-2009-2874
   - CVE-2009-1928



<u>Reflexión sobre la vulnerabilidad</u>

Esta vulnerabilidad es otra de las sensibles, ya que se debe controlar todo lo asociado a Active directory mucho porque es uno de los puntos criticos de las empresas. Ya que una vulnerabilidad que no administra/controla bien los recursos que se consumen puede derivar en que una empresa entera no pueda trabajar/producir 

### Vulnerabilidad CVE-2024-49019

#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2024-49019

- **Descripción**: Esta vulnerabilidad afecta al servicio de certificados de Active Directory (El servicio que se encarga de gestionar certificados dentro de una red, que sirve para autenticar usuarios de forma segura), permitiendo que un usuario  con permisos limitados pueda elevar sus privilegios.

- **Fecha de Publicación**: 12 de noviembre de 2024

- **Impacto**: Un atacante podría obtener control total sobre el dominio, comprometer cuentas privilegiadas y acceder a recursos sensibles si consigue escalar privilegios hasta por ejemplo llegar a ser admin.


- **Vectores de Ataque**: El atacante aprovecha la vulnerabilidad en la gestión de certificados (que segun la cwe asociada es que el servicio tenia una mecanismo  de autenticar a las personar que se les restringia el acesso que no es lo suficientemente fuerte) para hacerse pasar por un usuario autorizado y/o escalar privilegios dentro del sistema.

- **Medidas de Mitigación o Parches Disponibles**: Como en la anterior vulnerabilidad de Active Directory. Dependiendo del tipo de producto de windows que estes usando afecta a unas versiones u otras. La solucion es dependiendo del producto , actualizar a la version de active directory que se haya solucionado la vulnerabilidad


#### <u>Análisis CWE asociada</u>


- **ID de CWE**: CWE-1390: Weak Authentication/Autenticación débil
- **Descripción**: El producto utiliza un mecanismo de autenticación para restringir el acceso a usuarios o identidades específicos, pero el mecanismo no prueba suficientemente que la identidad declarada sea correcta.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2022-30034
   - CVE-2022-35248
   - CVE-2021-3116
   - CVE-2022-29965
   - CVE-2022-29959



<u>Reflexión sobre la vulnerabilidad</u>

Esta vulnerabilidad demuestra que incluso un sistema que debe ser muy seguro como Active Directory puede ser muy vulnerable si no se controla los usuarios que estan restringiods a acceder a los certificados. LLegando a provocar que el atacante tenga un control total del dominio

### Vulnerabilidad CVE-2024-21381

#### <u>Análisis CVE</u>

- **ID de CVE**: CVE-2024-21381

- **Descripción**: Esta vulnerabilidad afecta en el sistema de autenticación y gestión de identidades de Azure Active Directory B2C ( basicamente Active Directory en la nube ) que podia permitir a un atacante suplantar la identidad de un usuario legítimo, obteniendo acceso no autorizado a servicios o recursos.

- **Fecha de Publicación**: 13 de febrero de 2024

- **Impacto**: Un atacante podría suplantar a un usuario  confiable, obteniendo acceso a aplicaciones o sistemas que utilizan Azure AD B2C. Esto podría permitir el robo de datos sensibles o permitir realizar acciones maliciosas con permisos que normalmente no tendría.


- **Vectores de Ataque**: El atacante manipula las solicitudes de autenticación en el sistema Azure AD B2C para que se considere válida una solicitud no legítima.

- **Medidas de Mitigación o Parches Disponibles**: Segun la lista de CVE la vulnerabilidad afecta desde la version 1.0.0 hasata la fecha de publicación. Es decir desde el 13 de febrero de 2024 se soluciono (supongo que al ser en la nube lo actualizaran ellos sin necesidad de hacerlo nosotros)


#### <u>Análisis CWE asociada</u>


- **ID de CWE**: CWE-352: Cross-Site Request Forgery (CSRF)/Falsificación de solicitud entre sitios (CSRF)
- **Descripción**: La aplicación web no verifica, o no puede verificar, de manera suficiente si el usuario que envió la solicitud proporcionó intencionalmente una solicitud bien formada, válida y consistente.

- **Ejemplo de vulnerabilidades que afecta este CWE**: 
      
   - CVE-2004-1703
   - CVE-2004-1995
   - CVE-2004-1967
   - CVE-2004-1842
   - CVE-2005-1947



<u>Reflexión sobre la vulnerabilidad</u>

Esta vulnerabilidad es otro caso mas que demuestra la importancia de validar correctamente cualquier entrada de un sistema para evitar asi como en este caso que un atacante pueda suplantar a otra persona

# **Práctica 4.3: Evaluación de Amenazas, Vulnerabilidades y Riesgos**  <a name="id7"></a>

#### **Objetivo**  
Comprender la relación entre **vulnerabilidades, amenazas y riesgos** en sistemas informáticos, aplicando conocimientos del Esquema Nacional de Seguridad (ENS), Common Vulnerabilities and Exposures (CVE), Common Weakness Enumeration (CWE) y OWASP Top Ten.  


#### **Conceptos Claves Antes de Comenzar**  

Antes de realizar la práctica, es importante recordar los siguientes términos:  

- **Vulnerabilidad**: Fallo, debilidad o punto débil en un sistema. Puede deberse a errores de programación, configuraciones incorrectas o malas prácticas.  
- **Amenaza**: Acción o evento que explota una vulnerabilidad para comprometer la seguridad de un sistema. Puede ser interna o externa.  
- **Riesgo**: Probabilidad de que una amenaza se materialice aprovechando una vulnerabilidad y genere daños.  
- **Exploit**: Código o herramienta diseñada para aprovechar una vulnerabilidad específica.  
- **Zero Day (0-day)**: Vulnerabilidad desconocida por el fabricante y sin solución oficial.  


#### **1. Selección de una Aplicación de Uso Común**  

Elegir una aplicación de software ampliamente utilizada (ninguna de las ya usadas anteriormente). Puede ser un sistema operativo, una aplicación web, una herramienta de ofimática, entre otros. Se recomienda utilizar software con vulnerabilidades documentadas en bases de datos abiertas como:  

- [CVE](https://cve.mitre.org)  
- [OWASP Top Ten](https://owasp.org/Top10)  
- [CWE](https://cwe.mitre.org)  

Ejemplos de aplicaciones a analizar:  
- **Google Chrome** (navegador web)  
- **Apache HTTP Server** (servidor web)  
- **WordPress** (gestor de contenido)  
- **Windows 10/11** (sistema operativo)  

#### **2. Identificación de al Menos Tres Vulnerabilidades**  

Una vez seleccionada la aplicación, se debe investigar y documentar **tres vulnerabilidades específicas** (lo importante son las CWE) que hayan sido reportadas oficialmente en CVE y CWE (ahora vamos a documentar además las CWE).  

Para cada vulnerabilidad, se debe recopilar la siguiente información:  
- **ID de la vulnerabilidad (CVE-ID o CWE-ID)**  
- **Descripción del fallo**  
- **Componentes afectados (versión, módulo específico, etc.)**  
- **Impacto potencial**  
- **Referencias (fuente oficial o bases de datos de vulnerabilidades)**  

#### **3. Relación entre Vulnerabilidades y Amenazas**  

Para cada vulnerabilidad identificada, se debe analizar **qué amenazas podrían explotarla**.  

Ejemplo de análisis:  

- **Vulnerabilidad**: Configuración insegura en un servidor web.  
- **Amenaza**: Un atacante externo podría aprovechar esta vulnerabilidad para inyectar código malicioso.  
- **Riesgo**: Robo de información confidencial, interrupción del servicio, acceso no autorizado.  

Cada estudiante debe completar la siguiente tabla para cada vulnerabilidad encontrada:  

| Vulnerabilidad | Amenaza Potencial | Impacto |
|---------------|-------------------|---------|
| Uso de credenciales por defecto en un CMS | Un atacante puede acceder con credenciales conocidas | Robo de datos, alteración de contenido |
| Inyección SQL en una aplicación web | Un atacante puede ejecutar comandos en la base de datos | Exposición de información confidencial, alteración de registros |
| Falta de validación en entradas de usuario | Posibilidad de ataques XSS (Cross-Site Scripting) | Robo de credenciales, modificación de interfaces |


## Informes Vulnerabilidades,Amenaza,Riesgo de Wordpress <a name="id8"></a>

### Me ha resultado un poco confuso el enunciado, yo he interpretado de que buscaramos CVE o CWE que podrian afectar a la aplicación que seleccionaramos. Describirlos con los puntos que nos pides y luegos saber dividir dentro de esa información cual es la vulnerabilidad, la amenaza y el impacto. No se si sera eso lo que se pide

- **ID de la vulnerabilidad (CVE-ID o CWE-ID)**: CVE-2020-35935 
- **Descripción del fallo**  : La vulnerabilidad en el plugin Advanced Access Manager de WordPress, permite una escalada de privilegios. <br>Este fallo se produce cuando un usuario no autorizado manipula el parámetro POST aam_user_roles durante la actualización del perfil. <br>El sistema no valida correctamente si un usuario tiene permisos para asignarse roles adicionales, lo que podra permitir a un usuario con permisos limitados adquirir roles más altos, como el de administrador.
- **Componentes afectados (versión, módulo específico, etc.)**: Afecta a versiones anteriores del plugin  Advanced Access Manager para WordPress 6.6.2 
- **Impacto potencial** : Permitia realizar una escalada de privilegios que esto puede derivar en que un atacante pueda obtener permisos de administrador
- **Referencias (fuente oficial o bases de datos de vulnerabilidades)**:[Pagina de Incibe](https://www.incibe.es/node/495556), [Pagina de CVE](https://www.cve.org/CVERecord?id=CVE-2020-35935)

<br>

- **ID de la vulnerabilidad (CVE-ID CWE-ID)**: CWE-77: Improper Neutralization of Special Elements used in a Command ('Command Injection')/Neutralización incorrecta de elementos especiales utilizados en un comando ('Inyección de comando')
- **Descripción del fallo**  : Esta debilidad y muchas relacionadas con Inyección de código se encuentran en el top 3 de OWASP TOP 10 (Top de las 10 vulnerabilides mas producidas entre 3 o 4 años, que es lo que sulen tardar en actualizarlas).<br> La cual se produce cuando un producto construye un comando a partir de datos externos pero estos datos externos no son neutralizados correctamente
- **Componentes afectados (versión, módulo específico, etc.)**: Plugins y temas de WordPress que no validan adecuadamente las entradas de usuario 
- **Impacto potencial** : Un atacante podría ejecutar comandos arbitrarios en el sistema, lo que podría permitirle tomar el control completo de la aplicación, robar información sensible, modificar datos o incluso realizar instalaciones de malware
- **Referencias (fuente oficial o bases de datos de vulnerabilidades)**:[OWASP TOP 10](https://owasp.org/Top10/A03_2021-Injection/), [Pagina de CWE](https://cwe.mitre.org/data/definitions/77.html)

<br>

- **ID de la vulnerabilidad (CVE-ID o CWE-ID)**: CVE-2024-1177
- **Descripción del fallo**  :  La vulnerabilidad en el plugin WP Club Manager (plugin para gestionar equipos deportivos ) para WordPress permite la modificación no autorizada de datos debido a la falta de una comprobación de permisos adecuada en la función settings_save(). Esto facilita que atacantes no autenticados puedan actualizar la estructura de los permalinks (las URL fijas) de los clubes gestionados por el plugin.
- **Componentes afectados (versión, módulo específico, etc.)**: Afecta al plugin WP Club Manager de WordPressa todas las versiones hasta  la 2.2.10
- **Impacto potencial** : Un atacante podría modificar la estructura de las URLs de los clubes, lo que podría afectar la accesibilidad y el tráfico del sitio.
- **Referencias (fuente oficial o bases de datos de vulnerabilidades)**:[Pagina de Incibe](https://www.incibe.es/incibe-cert/alerta-temprana/vulnerabilidades/cve-2024-1177), [Pagina de CVE](https://www.cve.org/CVERecord?id=CVE-2024-1177)

<br>

| Vulnerabilidad | Amenaza Potencial | Impacto |
|---------------|-------------------|---------|
|  Manipulación del parámetro POST aam_user_roles durante la actualización del perfil | Un atacante puede realizar una escalada de privilegios  | Permite a un atacante no autorizado obtener privilegios elevados como el rol de administrador.Permitiendole el control total |
| Inyección de comandos  | Un atacante podria inyectar comandos malicioso en Wordpress  | Ejecución de comandos no autorizados, acceso no autorizado a recursos  o robo de datos sensibles.  |
| Falta de una comprobación de permisos adecuada en la función settings_save() | Un atacante podria realizar una modificación no autorizada de datos  | Modificaciones no autorizadas en la estructura de las URL afectando a la accesibilidad y tráfico del sitio  |



# **Práctica 4.4: Aplicación del estándar ASVS en seguridad de aplicaciones**  <a name="id9"></a>
**Objetivo:** Aplicar el estándar ASVS en una evaluación de seguridad.  

**Pasos:**  
1. Descargar la guía ASVS desde [OWASP ASVS](https://github.com/OWASP/ASVS).  
2. Por parejas en clase, repartiremos los diferentes puntos a analizar la guía.
3. Se deberá analizar cada uno de los puntos, explicando en qué consiste y su CWE.
4. Se expondrá en clase los puntos, sintetizando y explicando el punto que le ha sido asignado.

### Enlace a la presentación de Canvas

### [Presentación OWASP ASVS](https://www.canva.com/design/DAGhjEeDuO0/ijoVad6NHa3a5Y2GlBOW-g/edit?utm_content=DAGhjEeDuO0&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

**(La presentacion tambien se encuentra en formato pdf en la carpeta archivos_L4)** 