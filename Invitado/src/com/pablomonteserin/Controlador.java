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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		InvitadoBO invitadoBO = new InvitadoBO();
		String pagina = "index.jsp";
		if (action.equals("consulta")) {
			List<Invitado> invitados = invitadoBO.list();
			request.setAttribute("invitados", invitados);
			pagina = "consulta.jsp";
		} else if (action.equals("alta")) {
			String nombre = request.getParameter("nombre");
			invitadoBO.alta(nombre);
		} else if (action.equals("baja")) {
			String id = request.getParameter("identificador");
			int identificador = Integer.parseInt(id);
			invitadoBO.baja(identificador);

		}

		request.getRequestDispatcher(pagina).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
