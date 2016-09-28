package br.com.rcbsystens.promotora.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	
	public Connection getConnection() throws SQLException{
		System.out.println("Conectando ao banco!!!");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/promotora_cep", "root", "Act2132br");
	}

}
