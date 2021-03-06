package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Hamburguesa;
import modelo.HamburguesaModelo;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// coger HamburguesaModelo
		HamburguesaModelo hamburguesaModelo = new HamburguesaModelo();
		// hacer el selectAll
		ArrayList<Hamburguesa> hamburguesas = hamburguesaModelo.selectAll();
		// guardarlo en el request
		request.setAttribute("hamburguesas", hamburguesas);
		// enviarlo a la vista
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}
}
