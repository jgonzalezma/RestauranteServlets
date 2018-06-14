package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Hamburguesa;
import modelo.HamburguesaModelo;

/**
 * Servlet implementation class UpdateHamburguesa
 */
@WebServlet("/UpdateHamburguesa")
public class UpdateHamburguesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHamburguesa() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// coger datos del formulario
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			double precio = Double.parseDouble(request.getParameter("precio"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaCompra = sdf.parse(request.getParameter("fechaCompra"));
			
			Hamburguesa hamburguesa = new Hamburguesa();
			hamburguesa.setId(id);
			hamburguesa.setNombre(nombre);
			hamburguesa.setPrecio(precio);
			hamburguesa.setFechaCompra(fechaCompra);
			
			// llamar al modelo
			HamburguesaModelo hamburguesaModelo = new HamburguesaModelo();
			// hacer el update
			hamburguesaModelo.update(hamburguesa);
			// volver a ver hamburguesa
			response.sendRedirect("VerHamburguesa?id=" + id);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
