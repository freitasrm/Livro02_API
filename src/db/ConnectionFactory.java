package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {

		String url = "jdbc:mysql://localhost/livraria?useTimezone=true&serverTimezone=UTC";

		try {
			return DriverManager.getConnection(url, "root", "1234");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = new ConnectionFactory().getConnection();
		System.out.println("Conex�o aberta, e agora?");
		conn.close();
	}
}
