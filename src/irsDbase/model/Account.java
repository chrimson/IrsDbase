package irsDbase.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
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
	private int income;
	
	public Account(
		String first,
		String last,
		String username,
		int income) {
		this.first = first;
		this.last = last;
		this.username = username;
		this.income = income;
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
	
    @XmlElement
	public int getIncome() {
		return income;
	}
}
