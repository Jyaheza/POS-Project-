package posPD;

import java.math.BigDecimal;

public class Check extends AuthorizedPayment {

	BigDecimal amount= new BigDecimal("0");
	private String routingNumber;
	private String accountNumber;
	private String checkNumber;

	public String getRoutingNumber() {
		return this.routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCheckNumber() {
		return this.checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Check() {
		// TODO - implement Check.Check

	}

	/**
	 * 
	 * @param amount
	 * @param accountNumber
	 * @param checkNumber
	 */
	public Check(BigDecimal amount, String accountNumber, String checkNumber) {
		// TODO - implement Check.Check
		this.amount= amount;
		this.accountNumber= accountNumber;
		this.checkNumber= checkNumber;
	}
	public void setAmount(BigDecimal amt) {
		this.amount=amt;
	}
public BigDecimal getAmount(){
	return this.amount;
}
	public boolean isAuthorized() {
		// TODO - implement Check.isAuthorized
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement Check.toString
		return " Payment:"+this.amount+" change: 0.00";
	}

}