<%@page import="com.ipartek.modelo.I_Constantes"%>
<%@page import="com.ipartek.modelo.V_Libro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    List<V_Libro> listaLibros = new ArrayList<>();
    if(request.getAttribute(I_Constantes.ATR_LISTA_LIBROS)!=null){
    	listaLibros = (List<V_Libro>)request.getAttribute(I_Constantes.ATR_LISTA_LIBROS);
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

			<form action="InsertarLibro" method="get">
				<label for="p_titulo">Titulo: </label>
				<input type="text" name="p_titulo" id="p_titulo" required> <br>
				
				<label for="p_isbn">ISBN: </label>
				<input type="number" name="p_isbn" id="p_isbn" min="0" required> <br>
				
				<label for="p_stock">Stock: </label>
				<input type="text" name="p_stock" id="p_stock" required> <br>
				
				<label for="p_precio">Precio(€): </label>
				<input type="number" name="p_precio" id="p_precio" min="0" step="0.01" required> <br>
				
				<label for="p_FK_categoria">Categoria:</label>
				<select
					name="p_FK_categoria" id="p_FK_categoria" required>
					<option value="1">Anónimo</option>
					<option value="2">Ciencia ficción</option>
					<option value="3">Fantasía</option>
					<option value="4">Misterio</option>
					<option value="5">Suspence</option>
					<option value="6">Historia</option>
					<option value="7">Aventuras</option>
			   </select><br>
			   
			   	<label for="p_FK_autor">Autor:</label>
				<select
					name="p_FK_autor" id="p_FK_autor" required>
					<option value="1">  Homero                      </option>
					<option value="2">  Dante Alighieri             </option>
					<option value="3">  Jane Austen                 </option>
					<option value="4">  Victor Hugo                 </option>
					<option value="5">  William Shakespeare         </option>
					<option value="6">  Johann Wolfgang von Goethe  </option>
					<option value="7">  León Tolstói                </option>
					<option value="8">  Miguel de Cervantes         </option>
					<option value="9">  Edgar Allan Poe             </option>
					<option value="10"> James Joyce                 </option>
					<option value="11"> Haruki Murakami             </option>
					<option value="12"> Margaret Atwood             </option>
					<option value="13"> Anónimo                     </option>
					<option value="14"> Fiódor Dostoyevski          </option>
			   </select> <br>
			   
			<input type="submit" value="Insertar Libro">
			</form>

		</section>
    
      
      <table>
			<thead>
				<tr>
					<th>id</th>
					<th>Titulo</th>
					<th>ISBN</th>
					<th>Stock</th>
					<th>Precio</th>
					<th> Categoria</th>
					<th>Autor</th>
					
					<th>Editar</th>
					<th>Borrar</th>
				
				</tr>
			</thead>
			<tbody>
			
				<%for (V_Libro elem : listaLibros) {%>

				<tr>
					<td><%=elem.getId_libro()%></td>
					<td><%=elem.getTitulo()%></td>
					<td><%=elem.getIsbn() %></td>
					<td><%=elem.getStock() %> libros</td>
					<td><%=elem.getPrecio()%> €</td>
					<td><%=elem.getCategoria() %></td>
					<td><%=elem.getAutor() %> </td>
					 
					<td>
						<a href="FrmModificar?p_id=<%=elem.getId_libro()%>">
						<img alt="" src="imagenes/iconos/ico_editar.png" width="30"  height="30">
						</a>
					</td>
					
					<td>
					
						<a href="BorrarLibro?p_id_libro=<%=elem.getId_libro()%>">
						<img alt="" src="imagenes/iconos/ico_borrar.png" width="30"  height="30">
						</a>
					</td>
				</tr>
				
				<%}%>
			</tbody>
		</table>
      
      
    </main>

   	<%@include file="includes/pie.jsp" %>

</body>
</html>