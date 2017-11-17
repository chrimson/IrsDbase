package irsDbase.control;

import java.sql.*;

import com.mysql.jdbc.Driver;

/*
 * Helper class for common database and methods
 */

public class Database {
	public Connection sql;
	
	public Database() throws Exception {
		DriverManager.registerDriver(new Driver());
		sql = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/Irs", "root", "");
	}
	
	public void close() throws Exception {
		sql.close();
		DriverManager.deregisterDriver(new Driver());
	}
}
