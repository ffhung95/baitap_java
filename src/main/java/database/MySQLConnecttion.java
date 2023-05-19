package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnecttion {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/btl_qlcf";
		String userName = "root";
<<<<<<< HEAD

		String password = "Huy260903-_-";

=======
		String password = "Hoangbao2310@";
>>>>>>> 9abdd73e09be36debf1dc34af43afb2be2cedce6
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
