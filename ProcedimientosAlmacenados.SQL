/*----------------INGRESAR INSUMOS--------------------*/
CREATE PROCEDURE `ingresar_insumo` (nombre varchar(60))
BEGIN	
	INSERT INTO insumo(nombre) VALUES (nombre);
END
/*----------------MODIFICAR INSUMOS--------------------*/
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificar_insumo`(nom varchar(60),st double,id int)
BEGIN	
	UPDATE insumo SET nombre = nom, stock = st WHERE idinsumo = id;
END
/*----------------BORRAR INSUMOS--------------------*/
CREATE DEFINER=`root`@`localhost` PROCEDURE `borrar_insumo`(id int)
BEGIN
	DELETE FROM insumo WHERE idinsumo = id;

END
/*----------------MOSTRAR CONTEO--------------------*/
CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_conteo`(descripcion varchar(60))
BEGIN	
	select producto.idproducto, producto.nombre, presentacion.descripcion from producto	
	inner join productopresentacion on producto.idproducto = productopresentacion.idproducto	
	inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion	
	inner join categoria on productopresentacion.idcategoria = categoria.idcategoria	
	where categoria.descripcion =descripcion;
END
/*-------------LISTAR INSUMOS--------------------*/
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_insumo`()
BEGIN
	SELECT idinsumo, nombre, stock FROM insumo;
END
/*-------------OBTENER INVENTARIO DE PRODUCTOS--------------------*/
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_inventario`(orden varchar(60))
BEGIN
	SELECT producto.idproducto, producto.nombre,presentacion.descripcion ,categoria.descripcion, productopresentacion.stock, productopresentacion.precio, (productopresentacion.stock*productopresentacion.precio) AS VALORIZACION
	FROM producto
	inner join productopresentacion on producto.idproducto = productopresentacion.idproducto
	inner join categoria on productopresentacion.idcategoria = categoria.idcategoria
	inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion
	ORDER BY orden;
END
/*-------------CARGAR PRODUCTOS--------------------*/
CREATE DEFINER=`root`@`localhost` PROCEDURE `cargar_productos`()
BEGIN
	SELECT idProducto, nombre FROM producto;
END
/*-------------REGISTRAR INSUMOS--------------------*/
/*-------------REGISTRAR INSUMOS--------------------*/
/*-------------REGISTRAR INSUMOS--------------------*/
/*-------------REGISTRAR INSUMOS--------------------*/
/*-------------REGISTRAR INSUMOS--------------------*/
/*-------------REGISTRAR INSUMOS--------------------*/
/*-------------REGISTRAR INSUMOS--------------------*/
/*-------------REGISTRAR INSUMOS--------------------*/