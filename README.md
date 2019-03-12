# spring-boot-productos
Repositorio correspondientes al API REST para Obtener Productos

Proyecto que publica un API de Servicios REST que lee un listado de Productos proveniente de un servicio implementado previamente, filtrado los mismos por el Atributo Tipo de Item (ITEM_CONDITION) de cada Producto obtenido.

Este valor de negocio tiene dos Valores, Nuevo o Usado.

El API desarrollado filtra el listado obtenido por el Atributo ITEM_CONDITION generando un listado final por Tipo de Condición de acuerdo a un parámetro pasado por la URL publicada del API, en caso de que no se especifique el mismo, se obtienen todos los productos ordenados por Tipo de Condición.

El servicio sólo acepta las letras N y U (en Mayúsculas) como parámetros válidos, de lo contrario, lanzará un mensaje de error de parámetro no válido. El API es sensible a minúsculas y mayúsculas, por lo cual las letras "n" y "u" no se consideran válidas.

Las URLs publicadas son las siguientes:

"Servidor":"Puerto"/products => Obtiene todos los Productos ordenados por Tipo de Condición.

"Servidor":"Puerto"/products/ => Obtiene todos los Productos ordenados por Tipo de Condición.

"Servidor":"Puerto"/products/N => Obtiene los Productos con Tipo de Condición Nuevo.

"Servidor":"Puerto"/products/U => Obtiene los Productos con Tipo de Condición Usado.

"Servidor":"Puerto"/products/getByItemCondition => Obtiene todos los Productos ordenados por Tipo de Condición.

"Servidor":"Puerto"/products/getByItemCondition/ => Obtiene todos los Productos ordenados por Tipo de Condición.

"Servidor":"Puerto"/products/getByItemCondition/N => Obtiene los Productos con Tipo de Condición Nuevo.

"Servidor":"Puerto"/products/getByItemCondition/U => Obtiene los Productos con Tipo de Condición Usado.

"Servidor":"Puerto"/products/getByItemCondition/"Parámetro Distinto a N o U" => Lanza Mensaje de Error de Parámetro Inválido.

Este servicio se ejecuta sobre Protocolo HTTP.

Dirección IP de Prueba: 34.73.176.5

Puerto: 8080

La sesión se mantendrá hasta que se cierre el navegador o limpie el historial.

Este servicio requiere autorización bajo los siguientes datos:

1) Primera Opción: Usuario: admin, Clave: password

2) Especificando el Header "Authorization" el siguiente dato: Basic YWRtaW46cGFzc3dvcmQ=


