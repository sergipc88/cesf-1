package com.pablomonteserin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
String destino = "index.jsp";
		if (action != null && action.equals("limpiar")) {
			session.invalidate();
		} else {

			// REQUEST
			String n1 = request.getParameter("n1");
			String n2 = request.getParameter("n2");
			Integer n1Int = Integer.parseInt(n1);
			Integer n2Int = Integer.parseInt(n2);
			int resultadoRequest = n1Int + n2Int;
			request.setAttribute("rRequest", resultadoRequest);

			// SESSION
			Integer nSession = (Integer) session.getAttribute("rSession");

			if (nSession == null) {
				nSession = 0;
			}
			nSession = nSession + resultadoRequest;
			if(nSession>1000) {
				try {
					throw new Exception();
				} catch (Exception e) {
					destino = "error.jsp";
					e.printStackTrace();
				}
				System.out.println("uuuuu");
			}
			session.setAttribute("rSession", nSession);

			// APPLICATION
			ServletContext ctx = request.getServletContext();
			Integer nContexto = (Integer) ctx.getAttribute("rContexto");

			if (nContexto == null) {
				nContexto = 0;
			}
			nContexto = nContexto + resultadoRequest;
			ctx.setAttribute("rContexto", nContexto);

		}

		request.getRequestDispatcher(destino).forward(request, response);
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
