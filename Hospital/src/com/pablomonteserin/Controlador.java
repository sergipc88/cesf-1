package com.pablomonteserin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pablomonteserin.BO.PacienteBO;
import com.pablomonteserin.entity.Paciente;

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
		PacienteBO pacienteBO = new PacienteBO();
		String pagina = "index.jsp";
		if(action.equals("consulta")) {
			List <Paciente> pacientes = pacienteBO.list();
			request.setAttribute("pacientes", pacientes);
			pagina = "consulta.jsp";
		}else if(action.equals("alta")) {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellido");
			String fecha = request.getParameter("fecha");
			
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			Date fechadate = null;
			try {
				fechadate = s.parse(fecha);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			pacienteBO.alta(nombre, apellidos, fechadate);
		}else if(action.equals("consulta_paciente")) {
			int id = Integer.parseInt(request.getParameter("id_paciente"));
			
			Paciente paciente = pacienteBO.getPaciente(id);
			
			request.setAttribute("paciente", paciente);
			pagina = "modificacion.jsp";
		}else if(action.equals("modificacion")) {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellido");
			String fecha = request.getParameter("fecha");
			int id = Integer.parseInt(request.getParameter("id_paciente"));
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			Date fechadate = null;
			try {
				fechadate = s.parse(fecha);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Paciente paciente = new Paciente();
			paciente.setApellidos(apellidos);
			paciente.setFecha(fechadate);
			paciente.setId(id);
			paciente.setNombre(nombre);
			
			pacienteBO.salvar(paciente);
			
			request.setAttribute("paciente", paciente);
			pagina = "modificacion.jsp";
		}else if(action.equals("borrar")) {
			int id = Integer.parseInt(request.getParameter("id_paciente"));
		
		
			
			pacienteBO.borrar(id);
			
			pagina = "modificacion.jsp";
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
