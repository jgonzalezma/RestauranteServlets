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
 * Servlet implementation class AlmacenarHamburguesa
 */
@WebServlet("/AlmacenarHamburguesa")
public class AlmacenarHamburguesa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlmacenarHamburguesa() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// recoger todos los parametros
			String nombre = request.getParameter("nombre");
			Double precio = Double.parseDouble(request.getParameter("precio"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaCompra = sdf.parse(request.getParameter("fechaCompra"));
			
			// crear la hamburguesa
			Hamburguesa hamburguesa = new Hamburguesa();
			hamburguesa.setNombre(nombre);
			hamburguesa.setPrecio(precio);
			hamburguesa.setFechaCompra(fechaCompra);
			
			// llamar al modelo
			HamburguesaModelo hamburguesaModelo = new HamburguesaModelo();
			
			// hacer el insert
			hamburguesaModelo.insert(hamburguesa);
			
			// ir al Inicio para ver que esta creado
			response.sendRedirect("Inicio");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
