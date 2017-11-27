package irsDbase.control;

import java.sql.*;
import java.util.*;

import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 

import irsDbase.model.*;

/*
 * Wrapper class that holds Accounts collection
 * and populates it referencing database
 * Provides Jersey RESTful web service retrieval
 * http://localhost:8080/IrsDbase/rest/AccountServices/accounts
 * http://localhost:8080/IrsDbase/rest/AccountServices/accounts/mac
 */

@Path("/AccountServices")
public class AccountServices {
	public List<Account> accounts = new ArrayList<Account>();
	
	public AccountServices() {
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
					results.getInt("Income")));
			}
			
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    @GET 
	@Path("/accounts") 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Account> accounts() {
    	return accounts;
    }
    
    @GET
    @Path("/accounts/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("username") String username){
      Account matched = null;
      
      for(int index = 0; index < accounts.size(); index ++) {
         if(accounts.get(index).getUsername().equals(username)) {
            matched = accounts.get(index);
         }
      }
      
      return matched;
    }
}
