package posPD;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Cash extends Payment {
	String type;
	BigDecimal amount=new BigDecimal("0");
	BigDecimal amtTendered;
	BigDecimal change;

	public Cash() {
		// TODO - implement Cash.Cash
	}

	/**
	 * 
	 * @param amount
	 * @param amtTendered
	 */
	public Cash(String type,BigDecimal amount, BigDecimal amtTendered) {
		this.type=type;
		this.amount=amount;
		this.amtTendered=amtTendered;
		
	}
	public BigDecimal calcChange() {
		return amount.subtract(amtTendered);
	}
public void setAmount(BigDecimal amt) {
	this.amount=amt;
}
	public boolean countsAsCash() {
		if(this.type.equals("cash")||this.type.equals("Cash"))
		return true;
		else
			return false;
	}
public BigDecimal getAmount() {
	return this.amount;
}
	public String toString() {
		return " Payment: "+ this.amtTendered+" Change:"+this.calcChange();	
		}

}