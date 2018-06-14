package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Hamburguesa;
import modelo.HamburguesaModelo;

/**
 * Servlet implementation class VerHamburguesa
 */
@WebServlet("/VerHamburguesa")
public class VerHamburguesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerHamburguesa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// poner la id que recibimos
		int id = Integer.parseInt(request.getParameter("id"));
		// llamar al modelo
		HamburguesaModelo hamburguesaModelo = new HamburguesaModelo();
		// hacer un selectPorId
		Hamburguesa hamburguesa = hamburguesaModelo.selectPorId(id);
		// guardar en request
		request.setAttribute("hamburguesa", hamburguesa);
		// enviarlo a la vista
		request.getRequestDispatcher("mostrarHamburguesa.jsp").forward(request, response);
	}
}
