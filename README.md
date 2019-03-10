# spring-boot-productos
Repositorio correspondientes al API REST para Obtener Productos

Proyecto que publica un API de Servicios REST que lee un listado de Productos, filtrado los mismos por Tipo de Item (ITEM_CONDITION),
N para Nuevo o U para Usado, generando una lista por Tipo de Condición, si no se especifica el mismo, se obtiene todos los productos 
ordenados por Tipo de Condición.

El servicio sólo acepta las letras N y U como parámetros válidos, de lo contrario, lanzará un mensaje de error de parámetro no válido.

Las URLs publicadas son las siguientes:

<Servidor>:<Puerto>/products => Obtiene todos los Productos ordenados por Tipo de Condición.

<Servidor>:<Puerto>/products/ => Obtiene todos los Productos ordenados por Tipo de Condición.

<Servidor>:<Puerto>/products/N => Obtiene los Productos con Tipo de Condición Nuevo.

<Servidor>:<Puerto>/products/U => Obtiene los Productos con Tipo de Condición Usado.

<Servidor>:<Puerto>/products/getByItemCondition => Obtiene todos los Productos ordenados por Tipo de Condición.

<Servidor>:<Puerto>/products/getByItemCondition/ => Obtiene todos los Productos ordenados por Tipo de Condición.

<Servidor>:<Puerto>/products/getByItemCondition/N => Obtiene los Productos con Tipo de Condición Nuevo.

<Servidor>:<Puerto>/products/getByItemCondition/U => Obtiene los Productos con Tipo de Condición Usado.

<Servidor>:<Puerto>/products/getByItemCondition/<Parámetro Distinto a N o U> => Lanza Mensaje de Error de Parámetro Inválido.
