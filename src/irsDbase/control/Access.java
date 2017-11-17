package irsDbase.control;

import java.sql.*;

/*
 * Helper class calls database to authenticate
 */

public class Access {
	public boolean granted = false;
	public String fullName;
	
	public Access(String user, String pass) {
		try {
			// Instantiate database common class
			Database db = new Database();
			PreparedStatement query = db.sql.prepareStatement(
					"SELECT First, Last " + 
					"FROM Accounts " +
					"WHERE Username=? AND Password=ENCRYPT(?,'Trinity')"
			);
			query.setString(1, user);
			query.setString(2, pass);
	 
			ResultSet result = query.executeQuery();

			// Successful, so determine logged in user's real name
			// and set authentication to true
			if (result.next()) {
				granted = true;
				fullName = result.getString("First") + " " + result.getString("Last");
			}
			
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
