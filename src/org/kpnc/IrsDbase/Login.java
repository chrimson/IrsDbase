package org.kpnc.IrsDbase;

import com.mysql.jdbc.Driver;
import java.sql.*;

public class Login {
	public boolean isAuthorized = false;
	public String fullName;
	
	Login(String user, String pass) {
		try {
			DriverManager.registerDriver(new Driver());
			Connection sql = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Irs", "root", "");
 
			PreparedStatement query = sql.prepareStatement(
					"SELECT First, Last " + 
					"FROM Accounts " +
					"WHERE Username=? AND Password=ENCRYPT(?,'Trinity')"
			);
			query.setString(1, user);
			query.setString(2, pass);
	 
			ResultSet result = query.executeQuery();

			if (result.next()) {
				isAuthorized = true;
				fullName = result.getString("First") + " " + result.getString("Last");
			}
			
			result.close();
			query.close();
			sql.close();
			DriverManager.deregisterDriver(new Driver());;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
