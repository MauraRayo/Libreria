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

@WebServlet("/ModificarReal")
public class ModificarReal extends HttpServlet implements I_Constantes {
	private static final long serialVersionUID = 1L;
       
    public ModificarReal() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id_libro = 0;
		if(request.getParameter("p_id_libro") !=null) {
			id_libro = Integer.parseInt(request.getParameter("p_id_libro"));
		}

		
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
		double precio = 0;
		if (request.getParameter("p_precio") != null) {
			precio = Double.parseDouble(request.getParameter("p_precio"));
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
		
		Libro libro = new Libro(id_libro, titulo, isbn, stock, precio, FK_categoria, FK_autor);
		
		
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		
		db.modificarLibro(libro, con);
		List<V_Libro> ListaLibros = db.obtenerTodosLibros(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_LIBROS, ListaLibros);
		
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
