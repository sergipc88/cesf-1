package com.pablomonteserin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		LibroBO libroBO = new LibroBO();
		String pagina = "consulta.jsp";
		if (action.equals("consulta_libros")) {
			List<Libro> libros = libroBO.getLibros();
			request.setAttribute("libros", libros);
			
		}else if(action.equals("alta")) {
			String titulo = request.getParameter("tituloAlta");
			int precio = Integer.parseInt(request.getParameter("precioAlta"));
			List <Libro> libros = libroBO.alta(titulo, precio);
			request.setAttribute("libros", libros);
		}else if(action.equals("borrar")) {
			int id = Integer.parseInt(request.getParameter("idDelLibroABorrar"));
			List <Libro> libros = libroBO.borrar(id);
			request.setAttribute("libros", libros);

		}else if(action.equals("modificar")) {
			int id = Integer.parseInt(request.getParameter("idDelLibroABorrar"));
			String titulo = request.getParameter("tituloLibro");
			int precio = Integer.parseInt(request.getParameter("precioLibro"));
			List <Libro> libros = libroBO.modificar(titulo, precio,id);
			request.setAttribute("libros", libros);

		}
		
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
