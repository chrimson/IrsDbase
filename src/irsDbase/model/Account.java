package irsDbase.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlRootElement; 

/*
 * The Model element for a user account
 * Oddly, JSP JSTL can reference private members but
 * still requires corresponding getters
 * More peculiar things happen with serialization
 */

@XmlRootElement(name = "Account") 
public class Account implements Serializable {
    private static final long serialVersionUID = 2L; 

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
	
    @XmlElement 
	public String getFirst() {
		return first;
	}

    @XmlElement 
	public String getLast() {
		return last;
	}
	
    @XmlElement 
	public String getUsername() {
		return username;
	}
	
    @XmlTransient
    public String getPassword() {
		return password;
	}
	
    @XmlElement
	public int getIncome() {
		return income;
	}
	
    @XmlElement
	public boolean getPaid() {
		return paid;
	}
}
