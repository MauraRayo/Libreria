package com.ipartek.libros;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Constantes;
import com.ipartek.modelo.Libro;
import com.ipartek.modelo.V_Libro;

@WebServlet("/InsertarLibro")
public class InsertarLibro extends HttpServlet implements I_Constantes {
	private static final long serialVersionUID = 1L;

	public InsertarLibro() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// PASO 1
		String titulo = "";
		if (request.getParameter("p_titulo") != null) {
			titulo = request.getParameter("p_titulo");
		}

		//private String isbn;
		String isbn = "";
		if (request.getParameter("p_isbn") != null) {
			isbn = request.getParameter("p_isbn");
		}

		//private int stock;
		int stock = 0;
		if (request.getParameter("p_stock") != null) {
			stock = Integer.parseInt(request.getParameter("p_stock"));
		}

		//private double precio;
		int precio = 0;
		if (request.getParameter("p_precio") != null) {
			precio = Integer.parseInt(request.getParameter("p_precio"));
		}

		//private int FK_categoria;
		int FK_categoria = 0;
		if (request.getParameter("p_FK_categoria") != null) {
			FK_categoria = Integer.parseInt(request.getParameter("p_FK_categoria"));
		}

		//private int FK_autor;
		int FK_autor = 0;
		if (request.getParameter("p_FK_autor") != null) {
			FK_autor = Integer.parseInt(request.getParameter("p_FK_autor"));
		}
//PASO 2
		Libro libro = new Libro(0, titulo, isbn, stock, precio, FK_categoria, FK_autor);
		
//PASO 3
		DB_Helper db = new DB_Helper();
		Connection con= db.conectar();
		
//PASO 4
		db.insertarLibro(libro , con);
		List<V_Libro> listaLibros = db.obtenerTodosLibros(con);
	
		
//PASO 5
		db.desconectar(con);
		
//PASO 6
		request.setAttribute(ATR_LISTA_LIBROS, listaLibros);
		
		
//PASO 7
//		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
		response.sendRedirect("Cargar");
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
