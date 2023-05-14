package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnecttion {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/btl_qlcf";
		String userName = "root";
<<<<<<< HEAD
		String password = "enter";
=======
		String password = "nph@0905";
>>>>>>> f7d3efff729cd2e67f6f653a27fdf36d409267e2
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
