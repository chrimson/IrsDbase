package irsDbase.model;

import java.sql.*;
import java.util.*;

import irsDbase.control.*;

/*
 * Wrapper Model class that holds Accounts collection
 * and populates it referencing database
 */

public class Records {
	public List<Account> accounts = new ArrayList<Account>();
	
	public Records() {
		try {
			// Instantiate database common class
			Database db = new Database();
			Statement query = db.sql.createStatement();
			ResultSet results = query.executeQuery(
					"SELECT First, Last, Username, Password, Income, Paid " + 
					"FROM Accounts");

			while (results.next()) {
				// Sets each db entry to new account
				accounts.add(new Account(
					results.getString("First"),
					results.getString("Last"),
					results.getString("Username"),
					results.getString("Password"),
					results.getInt("Income"),
					results.getBoolean("Paid")));
			}
			
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
