package posPD;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashDrawer {

	private BigDecimal cashAmount;
	private int position;
public CashDrawer(BigDecimal cashAmount) {
	this.cashAmount=cashAmount;
}
	public BigDecimal getCashAmount() {
		return this.cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public CashDrawer() {
		// TODO - implement CashDrawer.CashDrawer
		//throw new UnsupportedOperationException();
	}

	/**
	 * removes cash in the drawer
	 * @param cash
	 */
	public void removeCash(BigDecimal cash) {
		// TODO - implement CashDrawer.removeCash
		throw new UnsupportedOperationException();
	}

	/**
	 * adds cash to the drawer
	 * @param cash
	 */
	public void addCash(BigDecimal cash) {
		// TODO - implement CashDrawer.addCash
		this.cashAmount= this.cashAmount.add(cash);
	}

	public String toString() {
		// TODO - implement CashDrawer.toString
		throw new UnsupportedOperationException();
	}

}