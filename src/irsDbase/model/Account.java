package irsDbase.model;

/*
 * The Model element for a user account
 * Oddly, JSP JSTL can reference private members but
 * still requires corresponding getters
 */

public class Account {
	private String first;
	private String last;
	private String username;
	private String password;
	private int income;
	private boolean paid;
	
	public Account(
		String first,
		String last,
		String username,
		String password,
		int income,
		boolean paid) {
		this.first = first;
		this.last = last;
		this.username = username;
		this.password = password;
		this.income = income;
		this.paid = paid;
	}
	
	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getIncome() {
		return income;
	}
	
	public boolean getPaid() {
		return paid;
	}
}
