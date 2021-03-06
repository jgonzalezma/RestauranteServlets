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
		try {
			// recoger parametros
			int id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			Double precio = Double.parseDouble(request.getParameter("precio"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaCompra = sdf.parse(request.getParameter("fechaCompra"));
			
			// crear hamburguesa con esos parametros
			Hamburguesa hamburguesa = new Hamburguesa();
			hamburguesa.setId(id);
			hamburguesa.setNombre(nombre);
			hamburguesa.setPrecio(precio);
			hamburguesa.setFechaCompra(fechaCompra);
			
			// llamar al modelo
			HamburguesaModelo hamburguesaModelo = new HamburguesaModelo();
			
			// hacer el update
			hamburguesaModelo.update(hamburguesa);
			
			//volver a la vista de VerHamburguesa
			response.sendRedirect("Inicio");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
