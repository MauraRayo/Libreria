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


@WebServlet("/BorrarLibro")
public class BorrarLibro extends HttpServlet implements I_Constantes {
	private static final long serialVersionUID = 1L;
       

    public BorrarLibro() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//PASO 1
		int id_libro = 0;
		if(request.getParameter("p_id_libro")!=null) {
			String id_libroTemp = request.getParameter("p_id_libro");
			id_libro = Integer.parseInt(id_libroTemp);
		}
		
		
		//PASO 3
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		//PASO 4 
		db.borrarLibroId(id_libro, con);
		List<V_Libro> listaLibros = db.obtenerTodosLibros(con);
		
		//PASO 5 DESCONECTAR LA BD
		db.desconectar(con);
		
		//PASO 6
		request.setAttribute(ATR_LISTA_LIBROS, listaLibros);
		
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
