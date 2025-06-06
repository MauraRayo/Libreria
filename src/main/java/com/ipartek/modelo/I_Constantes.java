package com.ipartek.modelo;

public interface I_Constantes {

	// constantes de la BD
	String BD = "jsp_libreria";
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/"+BD;
	String USUARIO = "root";
	String PASS = "1234";
	
	//CONSTANTES DE LOS JSP
	String JSP_INDEX = "index.jsp";
	String JSP_MODIFICAR="frmModificar.jsp";

	//CONTANTES DE VIEWS
	String VISTA_LIBROS = "libros";
	String V_LIBROS_ID_LIBRO = "id_libro";
	String V_LIBROS_TITULO = "titulo";
	String V_LIBROS_ISBN = "isbn";
	String V_LIBROS_STOCK = "stock";
	String V_LIBROS_PRECIO = "precio";
	String V_LIBROS_FK_CATEGORIA = "FK_categoria";
	String V_LIBROS_FK_AUTOR = "FK_autor";
	         
	String V_LIBROS_CATEGORIA = "categoria";
	String V_LIBROS_AUTOR = "autor";
			       
	
	//CONSTANTES DE PROCEDURES
	String TABLA_LIBROS = "libros";
	
	String TABLA_ID_LIBRO = "id_libro";
	String LIBRO_TITULO = "titulo";
	String LIBRO_ISBN = "isbn";
	String LIBRO_STOCK = "stock";
	String LIBRO_PRECIO = "precio";
	String LIBRO_FK_CATEGORIA = "FK_categoria";
	String LIBRO_FK_AUTOR = "FK_autor";
	       
	String TABLA_LIBROS_CATEGORIA = "categoria";
	String LIBRO_ID_AUTOR = "id_autor";
	String LIBROS_AUTOR = "autor";
	
	String TABLA_CATEGORIAS= "categorias";
	String CATEGORIA_ID_CATEGORIA= "id_categoria";
	String CATEGORIA_CATEGORIA="CATEGORIA";
	
	String TABLA_NACIOLIDADES= "nacionalidades";
	String TABLA_ID_NACIONALIDAD="id_nacionalidad";
	String TABLA_NACIONALIDAD= "nombre";
	
	String TABLA_AUTORES = "autores"; 
	String AUTORES_ID_AUTORES = "id_autor";
	String AUTORES_AUTOR = "autor";
	String AUTORES_FECHA_NACIMIENTO= "fecha_nacimiento";
	String AUTORES_FECHA_DEFUNCION = "fecha_defuncion";
	String AUTORES_FK_NACIONALIDAD = "FK_nacionalidad";	
	
	
	//CONSTANTES DE LA MOCHILA
	String ATR_LISTA_LIBROS = "atr_lista_libros";
	String ATR_LISTA_AUTORES = "atr_lista_autores";
	String ATR_LISTA_CATEGORIAS = "atr_lista_categorias";
	String ATR_LIBRERIA = "atr_libreria";
	

	
	//STORED PROCEDURES
	String SP_LIBROS_OBTENER_TODOS = "Call sp_libros_obtener_todos();";
	String SP_LIBROS_OBTENER_ID ="call sp_libros_obtener_id(?);";
	String SP_LIBROS_INSERTAR = "call sp_libros_insertar(?, ?, ?, ?, ?, ?);";
	String SP_LIBROS_BORRAR ="call sp_libros_borrar(?); ";
	String SP_LIBROS_MODIFICAR = "call sp_libros_modificar(?, ?, ?, ?, ?, ?, ?);";
	
	
	
	String SP_AUTORES_OBTENER_TODOS = "call sp_autores_obtener_todos();";
	String SP_CATEGORIAS_OBTENER_TODAS = "call sp_categorias_obetener_todas();";	
}
