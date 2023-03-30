package posPD;

import java.math.BigDecimal;
import java.util.*;

public class Cashier {

	private String number;
	private Person person;
	private Collection<Session> sessions;
	private String password;
	private BigDecimal cashCount= new BigDecimal(0);

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return this.person.getName();
	}
	public String getPassword() {
		return this.password;
	}
public void setCashCount(BigDecimal count) {
	this.cashCount=this.cashCount.add(count);
}
public BigDecimal getCashCount() {
	return this.cashCount;
}
	public Cashier() {
		// TODO - implement Cashier.Cashier
		//throw new UnsupportedOperationException();
	}

	/**
	 * sets the info about a cashier
	 * params number, person,password
	 * @param number
	 * @param person
	 * @param password
	 */
	public Cashier(String number, Person person, String password) {
		// TODO - implement Cashier.Cashier
		this.number= number;
		this.person=person;
		this.password=password;
		//throw new UnsupportedOperationException();
	}

	/**
	 * adds a session
	 * params session for the session to be added
	 * @param session
	 */
	public void addSession(Session session) {
		// TODO - implement Cashier.addSession
		//throw new UnsupportedOperationException();
	}
	/**
	 * removes a session
	 * params session for the session to be removed
	 * @param session
	 */
	public void removeSession(Session session) {
		// TODO - implement Cashier.removeSession
		//throw new UnsupportedOperationException();
	}
public Person getPerson() {
	return this.person;
}
	/**
	 * checks if password is authorized
	 * params password for the password to be checked
	 * @param passwordd
	 */
	public boolean isAuthorized(String password) {
		if(password.equals(this.password)) {
			return true;
		}
		else {
			return false;
	}
	}
	public String reportToString() {
		return this.number+"              "+this.person.getName()+"              "	+this.cashCount;
				}
	public String toString() {
		// TODO - implement Cashier.toString
		return ""+this.getName();
	}

}