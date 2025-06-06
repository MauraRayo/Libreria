package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB_Helper implements I_Constantes {

	public Connection conectar() {
		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);
			System.out.println("BASE DE DATOS CONECTADA");
		} catch (ClassNotFoundException e) {
			System.out.println("NO SE ENCONTRO EL DRIVER");
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTAR A LA BD");
		}

		return con;
	}

	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("BASE DE DATOS DESCONECTADA");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO DESCONECTAR");
		}
	}

	public void insertarLibro(Libro libro, Connection con) {

		try {
			CallableStatement cstmt = con.prepareCall("call sp_libros_insertar(?, ?, ?, ?, ?, ?);");

			cstmt.setString(1, libro.getTitulo());
			cstmt.setString(2, libro.getIsbn());
			cstmt.setInt(3, libro.getStock());
			cstmt.setDouble(4, libro.getPrecio());
			cstmt.setInt(5, libro.getFK_categoria());
			cstmt.setInt(6, libro.getFK_autor());

			cstmt.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public List<V_Libro> obtenerTodosLibros(Connection con) {
		
		List<V_Libro> lista = new ArrayList<>();
		try {
			
			CallableStatement cstmt = con.prepareCall(SP_LIBROS_OBTENER_TODOS);
			cstmt.execute();
			
			ResultSet rs = cstmt.getResultSet();
			
			while(rs.next()) { 
				V_Libro libro = new V_Libro();
				
				libro.setId_libro(rs.getInt(V_LIBROS_ID_LIBRO));
				libro.setTitulo(rs.getString(V_LIBROS_TITULO));
				libro.setIsbn(rs.getString(V_LIBROS_ISBN));
				libro.setStock(rs.getInt(V_LIBROS_STOCK));
				libro.setPrecio(rs.getInt(V_LIBROS_PRECIO));
				libro.setFK_categoria(rs.getInt(V_LIBROS_FK_CATEGORIA));
				libro.setFK_autor(rs.getInt(V_LIBROS_FK_AUTOR));
				
				libro.setCategoria(rs.getString(V_LIBROS_CATEGORIA));
				libro.setAutor(rs.getString(V_LIBROS_AUTOR));
				
				lista.add(libro);
			}
			return lista;
			
			
		} catch (SQLException e) {
						
			e.printStackTrace();
			return null;
		}
		

		
	}
//------------------------Fin obtenerTodosLibros --------------------------------------

	public V_Libro obtenerLibroPorId(int id_libro, Connection con) {
		 
		try {
			
			V_Libro libro = new V_Libro();
			CallableStatement cstmt = con.prepareCall(SP_LIBROS_OBTENER_ID);
			
			cstmt.setInt(1, id_libro);
			cstmt.execute();
			
			ResultSet rs = cstmt.getResultSet();	
			
			while(rs.next()) { 
				
				
				libro.setId_libro(rs.getInt(V_LIBROS_ID_LIBRO));
				libro.setTitulo(rs.getString(V_LIBROS_TITULO));
				libro.setIsbn(rs.getString(V_LIBROS_ISBN));
				libro.setStock(rs.getInt(V_LIBROS_STOCK));
				libro.setPrecio(rs.getInt(V_LIBROS_PRECIO));
				libro.setFK_categoria(rs.getInt(V_LIBROS_FK_CATEGORIA));
				libro.setFK_autor(rs.getInt(V_LIBROS_FK_AUTOR));
				
				libro.setCategoria(rs.getString(V_LIBROS_CATEGORIA));
				libro.setAutor(rs.getString(V_LIBROS_AUTOR));
				
				
			}
			return libro;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	public void borrarLibroId(int id_libro, Connection con) {
		try {
			CallableStatement cstmt = con.prepareCall(SP_LIBROS_BORRAR);

			cstmt.setInt(1, id_libro);

			cstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Autor> obtenerTodosAutores(Connection con) {
		
		List<Autor> listaAutores = new ArrayList<>();
		try {
			CallableStatement cstmt = con.prepareCall(SP_AUTORES_OBTENER_TODOS);
			
			cstmt.execute();
			
			ResultSet rs = cstmt.getResultSet();
			
			while(rs.next()) {
				Autor autor = new Autor();
				
				autor.setId_autor(rs.getInt(LIBRO_ID_AUTOR));
				autor.setAutor(rs.getString(AUTORES_AUTOR));
				autor.setFecha_nacimiento(rs.getString(AUTORES_FECHA_NACIMIENTO));
				autor.setFecha_defuncion(rs.getString(AUTORES_FECHA_DEFUNCION));
				autor.setFK_nacionalidad(rs.getInt(AUTORES_FK_NACIONALIDAD));
				
			listaAutores.add(autor);
				
			}
			return listaAutores;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Categoria> obtenerTodasCategorias(Connection con) {
		List<Categoria> listaCategoria = new ArrayList<>();
		
		try {
			CallableStatement cstmt = con.prepareCall(SP_CATEGORIAS_OBTENER_TODAS);
			cstmt.execute();
			ResultSet rs = cstmt.getResultSet();
			while(rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId_categoria(rs.getInt(CATEGORIA_ID_CATEGORIA));
				categoria.setCategoria(rs.getString(CATEGORIA_CATEGORIA));
				
				listaCategoria.add(categoria);
			}
			return listaCategoria;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return null;
	}

	public void modificarLibro(Libro libro, Connection con) {
	
		try {
			CallableStatement cstmt = con.prepareCall(SP_LIBROS_MODIFICAR);
			
			cstmt.setInt(1, libro.getId_libro());
			cstmt.setString(2, libro.getTitulo());
			cstmt.setString(3, libro.getIsbn());
			cstmt.setInt(4, libro.getStock());
			cstmt.setDouble(5, libro.getPrecio());
			cstmt.setInt(6, libro.getFK_categoria());
			cstmt.setInt(7, libro.getFK_autor());
						
			cstmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
