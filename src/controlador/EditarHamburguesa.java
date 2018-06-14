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
 * Servlet implementation class EditarHamburguesa
 */
@WebServlet("/EditarHamburguesa")
public class EditarHamburguesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarHamburguesa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recibir el id
		int id = Integer.parseInt(request.getParameter("id"));
		// llamar al modelo
		HamburguesaModelo hamburguesaModelo = new HamburguesaModelo();
		// seleccionarlo con el selectPorId
		Hamburguesa hamburguesa = hamburguesaModelo.selectPorId(id);
		// hacer el request
		request.setAttribute("hamburguesa", hamburguesa);
		// enviar a la vista, al form
		request.getRequestDispatcher("formularioEditar.jsp").forward(request, response);
	}
}
