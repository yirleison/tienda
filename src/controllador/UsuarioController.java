package controllador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.Conexion;
import modelo.Usuario;

public class UsuarioController {
	
	Connection cnx;
	PreparedStatement statement;
	
	public int crearUsuario(Conexion conexion, Usuario usuario) {

		 int respuesta = 0;
		 cnx = conexion.getConnection();
		 
		 if(cnx != null) {
			 try {
				 String query = "INSERT INTO usuarios (id,nombre, primer_apellido,segundo_apellido,telefono,direccion,email,usuario,clave) "
				 		+ "VALUES(?,?,?,?,?,?,?,?,?)";
				
				statement = cnx.prepareStatement(query);
				statement.setInt(1, usuario.getId());
				statement.setString(2, usuario.getNombre());
				statement.setString(3, usuario.getPrimerApellido());
				statement.setString(4, usuario.getSegundoApellido());
				statement.setString(5, usuario.getTelefono());
				statement.setString(6, usuario.getDireccion());
				statement.setString(7, usuario.getEmail());
				statement.setString(8, usuario.getUsuario());
				statement.setString(9, usuario.getClave());
				
				int resulset = statement.executeUpdate();
				
				
				respuesta = resulset;

			} catch (Exception e) {
				System.out.println("Ha ocurrido un error al tratar de abrir la conexiòn"+e);
			}			
		 }
			 
		return respuesta;
	}
}
