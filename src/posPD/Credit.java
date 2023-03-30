package posPD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;


public class Credit extends AuthorizedPayment {
	
    private BigDecimal amount= new BigDecimal("0");
	private String cardType;
	private String acctNumber;
	private String expireDate;

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAcctNumber() {
		return this.acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public Credit() {
		// TODO - implement Credit.Credit

	}
public void setAmount(BigDecimal amt) {
	this.amount=amt;
}
	/**
	 * 
	 * @param amount
	 * @param cardType
	 * @param acctNumber
	 * @param expireDate
	 */
	public Credit(BigDecimal amount, String cardType, String acctNumber, String expireDate) {
		// TODO - implement Credit.Credit
		this.amount= amount;
		this.cardType= cardType;
		this.acctNumber=acctNumber;
		this.expireDate=expireDate;
	}

	public boolean isAuthorized() {
		// TODO - implement Credit.isAuthorized
		throw new UnsupportedOperationException();
	}
public BigDecimal getAmount() {
	return this.amount;
}
	public String toString() {
		// TODO - implement Credit.toString
		return "  Payment: "+ this.amount+" Change: 0.00" ;
	}

}