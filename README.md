# OJS Mobile App

Este proyecto fue realizado como parte del examen de la asignatura *Sistemas Móviles y ubicuos* en la Universidad Técnica Estatal de Quevedo, dentro de la carrera de Ingeniería en Telemática.

## Descripción

La aplicación **OJS Mobile App** utiliza una interfaz para interactuar con las revistas científicas de la UTEQ mediante el consumo de una API Resful. La aplicación permite:

1. **Listar las revistas científicas de la UTEQ.**
2. **Seleccionar una revista** para mostrar los volúmenes publicados.
3. **Seleccionar un volumen** para listar los artículos publicados en esa edición.
4. **Visualizar los artículos** en formato HTML y ver su dirección DOI al seleccionar un artículo.


## Funcionalidades

1. **Enlistar revistas científicas:**
   Utiliza el Web Service [revistas.uteq.edu.ec/ws/journals.php](https://revistas.uteq.edu.ec/ws/journals.php) para obtener la lista de revistas científicas publicadas por la UTEQ.


   ![image](https://github.com/user-attachments/assets/9978e2cd-ec9f-415e-bffb-6b05e2f97207)

   
3. **Ver volúmenes de una revista:**
   Al seleccionar una revista, se enlistan los volúmenes publicados de esa revista utilizando el Web Service [revistas.uteq.edu.ec/ws/issues.php?j_id=2](https://revistas.uteq.edu.ec/ws/issues.php?j_id=2).

   
  ![image](https://github.com/user-attachments/assets/cfe5cc3d-375d-446a-9322-fd1e0869ef37)



5. **Ver artículos de una edición:**
   Al seleccionar una edición de un volumen, se muestran los artículos correspondientes usando el Web Service [revistas.uteq.edu.ec/ws/pubs.php?i_id=78](https://revistas.uteq.edu.ec/ws/pubs.php?i_id=78).
   
 ![image](https://github.com/user-attachments/assets/6ae1bbfa-982a-427f-9be3-e0c1a4355ef1)


   


7. **Visualizar el artículo en HTML o Descaaargar**
   Al seleccionar un artículo, se puede ver su contenido en formato HTML o descargar en pdf.
   
https://github.com/user-attachments/assets/a3dc05ae-88b3-4609-9a0c-f8a09aef31b9





