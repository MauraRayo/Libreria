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
import com.ipartek.modelo.V_Libro;
import com.ipartek.modelo.Autor;
import com.ipartek.modelo.Categoria;


@WebServlet("/FrmModificar")
public class FrmModificar extends HttpServlet implements I_Constantes {
	private static final long serialVersionUID = 1L;
       
   
    public FrmModificar() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_libro = 0;
		if (request.getParameter("p_id") != null) {
			id_libro = Integer.parseInt(request.getParameter("p_id"));
		}
		
		
		
		DB_Helper  db = new DB_Helper();
		Connection con = db.conectar();
		
		V_Libro libro = db.obtenerLibroPorId(id_libro, con);
		List<Autor> listaAutores = db.obtenerTodosAutores(con);
		List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);
		
		
		
		System.out.println(libro);
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_LIBROS, libro);
		request.setAttribute(ATR_LISTA_AUTORES, listaAutores);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategorias);
	
		
		
		
		request.getRequestDispatcher(JSP_MODIFICAR).forward(request, response);
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
