package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HamburguesaModelo extends Conector{

	public ArrayList<Hamburguesa> selectAll() {
		ArrayList<Hamburguesa> hamburguesas = new ArrayList<Hamburguesa>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM hamburguesas");
			while(rs.next()){
				Hamburguesa hamburguesa = new Hamburguesa();
				hamburguesa.setId(rs.getInt("id"));
				hamburguesa.setNombre(rs.getString("nombre"));
				hamburguesa.setPrecio(rs.getDouble("precio"));
				hamburguesa.setFechaCompra(rs.getDate("fecha_compra"));
				hamburguesas.add(hamburguesa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return hamburguesas;
	}

	public Hamburguesa selectPorId(int id) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM hamburguesas WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Hamburguesa hamburguesa = new Hamburguesa();
				hamburguesa.setNombre(rs.getString("nombre"));
				hamburguesa.setPrecio(rs.getDouble("precio"));
				hamburguesa.setFechaCompra(rs.getDate("fecha_compra"));
				
				return hamburguesa;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(Hamburguesa hamburguesa) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE hamburguesas SET nombre = ?, precio = ?, fecha_compra = ? WHERE id = ?");
			pst.setString(1, hamburguesa.getNombre());
			pst.setDouble(2, hamburguesa.getPrecio());
			pst.setDate(3, new java.sql.Date(hamburguesa.getFechaCompra().getTime()));
			pst.setInt(4, hamburguesa.getId());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
