<%@page import="com.ipartek.modelo.Categoria"%>
<%@page import="com.ipartek.modelo.I_Constantes"%>
<%@page import="com.ipartek.modelo.V_Libro"%>
<%@page import="com.ipartek.modelo.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    V_Libro listaLibros = new V_Libro();
    if(request.getAttribute(I_Constantes.ATR_LISTA_LIBROS)!=null){
    	listaLibros = (V_Libro) request.getAttribute(I_Constantes.ATR_LISTA_LIBROS);
    }
    
    List<Autor> listaAutores = new ArrayList<>();
    if(request.getAttribute(I_Constantes.ATR_LISTA_AUTORES)!= null){
    	listaAutores = (List<Autor>) request.getAttribute(I_Constantes.ATR_LISTA_AUTORES);
    }
    
    List<Categoria> listaCategoria = new ArrayList<>();
    if(request.getAttribute(I_Constantes.ATR_LISTA_CATEGORIAS)!=null){
    	listaCategoria = (List<Categoria>) request.getAttribute(I_Constantes.ATR_LISTA_CATEGORIAS);
    }
    
    
    
    %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Libreria</title>
    <link rel="stylesheet" href="styles/tablas.css" >
    <link rel="stylesheet" href="styles/style.css" >
</head>
<body>
    
    <%@include file="includes/cabecera.jsp" %>

   	<%@include file="includes/menu.jsp" %>

    <main>
		<section>
			<form action="ModificarReal" method="get">
				
				
				<label for="p_id_libro">ID: </label>
				<input type="text" name="p_id_libro" id="p_id_libro" value="<%=listaLibros.getId_libro()%>"  required> <br>
				
				<label for="p_titulo">Titulo: </label>
				<input type="text" name="p_titulo" id="p_titulo" value="<%=listaLibros.getTitulo()%>"  required> <br>
				
				<label for="p_isbn">ISBN: </label>
				<input type="number" name="p_isbn" id="p_isbn" min="0" value="<%=listaLibros.getIsbn() %>" required> <br>
				
				<label for="p_stock">Stock: </label>
				<input type="text" name="p_stock" id="p_stock" value="<%=listaLibros.getStock()%>" required> <br>
				
				<label for="p_precio">Precio(€): </label>
				<input type="number" name="p_precio" id="p_precio" min="0" value="<%=listaLibros.getPrecio() %>"  required> <br>
				
				<label for="p_FK_categoria">Categoria:</label>
				<select name="p_FK_categoria" id="p_FK_categoria" required>
				 <% for(Categoria elem : listaCategoria){
					 if(elem.getId_categoria()!=listaLibros.getFK_categoria()){ %>
					 	 
					 	 <option value="<%=elem.getId_categoria() %>"> <%=elem.getCategoria() %>  </option>
					 	 
					 <% } else { %>	
						 
						 <option value="<%=elem.getId_categoria() %>"> <%=elem.getCategoria() %>  </option>
						 
					<% } 	 	 
				 }	 
				 %>					
			   </select><br>
			   
			   	<label for="p_FK_autor">Autor:</label>
			   	
				<select name="p_FK_autor" id="p_FK_autor" required>
					<% for(Autor elem : listaAutores){
					 if(elem.getId_autor()!=listaLibros.getFK_autor()){ %>
					 	 
					 	 <option value="<%=elem.getId_autor() %>"> <%=elem.getAutor() %></option>
					 	 
					 <% } else { %>	
						 
						 <option value="<%=elem.getId_autor() %>"> <%=elem.getAutor() %></option>
						 
					<% } 	 	 
				 }	 %>
			   </select> <br>
			   <input type="submit" value="Modificar Libro">
			</form>
		</section>
	</main>

   	<%@include file="includes/pie.jsp" %>

</body>
</html>