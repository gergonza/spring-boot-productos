# spring-boot-productos
Repositorio correspondientes al API REST para Obtener Productos

Proyecto que publica un API de Servicios REST que lee un listado de Productos proveniente de un servicio implementado previamente, filtrado los mismos por el Atributo Tipo de Item (ITEM_CONDITION) de cada Producto obtenido.

Este valor de negocio tiene dos Valores, Nuevo o Usado.

El API desarrollado filtra el listado obtenido por el Atributo ITEM_CONDITION generando un listado final por Tipo de Condición de acuerdo a un parámetro pasado por la URL publicada del API, en caso de que no se especifique el mismo, se obtienen todos los productos ordenados por Tipo de Condición.

El servicio sólo acepta las letras N y U como parámetros válidos, de lo contrario, lanzará un mensaje de error de parámetro no válido.

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
