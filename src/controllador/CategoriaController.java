package controllador;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.spi.DirStateFactory.Result;

import DB.Conexion;
import modelo.Categoria;

public class CategoriaController {
	
	PreparedStatement preparedStatement;	
	Connection cnx;
	int respuesta = 0;
	Conexion cn = new Conexion();
	
	
	public int crear(Categoria categoria) {
		
		try {
			cnx = cn.getConnection();
			if(cnx!=null) {
				String sql = ("INSERT INTO categorias (id,nombre,descripcion) VALUES(?,?,?)");
				preparedStatement = cnx.prepareStatement(sql);
				preparedStatement.setInt(1, categoria.getId());
				preparedStatement.setString(2, categoria.getNombre());
				preparedStatement.setString(3, categoria.getDescripcion());
				
				respuesta = preparedStatement.executeUpdate();			
			}
			
		}catch (Exception e) {
			System.err.println(e);
		}

		return respuesta;
	}
}
