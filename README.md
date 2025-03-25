# OJS Mobile App

Este proyecto fue realizado como parte del examen de la asignatura *Programación Orientada a Objetos para Dispositivos Móviles* en la Universidad Técnica Estatal de Quevedo, dentro de la carrera de Ingeniería en Sistemas.

## Descripción

La aplicación **OJS Mobile App** utiliza la librería [PlaceHolderView](https://github.com/janishar/PlaceHolderView) para interactuar con las revistas científicas de la UTEQ mediante un Web Service. La aplicación permite:

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

   
   ![Captura de pantalla 2025-03-24 223435](https://github.com/user-attachments/assets/79a75e91-ddbf-4eef-905a-4d4235deb749)


5. **Ver artículos de una edición:**
   Al seleccionar una edición de un volumen, se muestran los artículos correspondientes usando el Web Service [revistas.uteq.edu.ec/ws/pubs.php?i_id=78](https://revistas.uteq.edu.ec/ws/pubs.php?i_id=78).
   
   ![image](https://github.com/user-attachments/assets/42d021d8-adb0-4fb1-b5b3-d11a8c4e7454)

   


7. **Visualizar el artículo en HTML o Descaaargar**
   Al seleccionar un artículo, se puede ver su contenido en formato HTML o descargar en pdf.
   
https://github.com/user-attachments/assets/a3dc05ae-88b3-4609-9a0c-f8a09aef31b9





