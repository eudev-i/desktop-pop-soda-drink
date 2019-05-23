package br.com.senaijandira.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection con;

	public static Connection getConnection() {

		try {
			// Tentando chamar o Driver do mariaDB
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/db_popsoda?useTimezone=true&serverTimezone=UTC";
			
			

			con = DriverManager.getConnection(dbURL, "root", "r4nd3rs0n");
			
			
			System.out.println("Deu certo");
			
			
		} catch (SQLException err) {
			err.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
