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
		// recoger la id
		int id = Integer.parseInt(request.getParameter("id"));
		// selectPorId para editar ese en concreto
		HamburguesaModelo hamburguesaModelo = new HamburguesaModelo();
		Hamburguesa hamburguesa = hamburguesaModelo.selectPorId(id);
		// guardar en el request
		request.setAttribute("hamburguesa", hamburguesa);
		// enviar al form
		request.getRequestDispatcher("formEditar.jsp").forward(request, response);
	}
}
