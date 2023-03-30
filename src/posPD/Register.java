package posPD;

public class Register {

	private String number;
	private CashDrawer cashDrawer;

	
	public Register(String number, CashDrawer cashDrawer) {
	this.number= number;
	this.cashDrawer= cashDrawer;
	}
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
public CashDrawer getCashDrawer() {
	return this.cashDrawer;
}
	public Register() {
		// TODO - implement Register.Register
		//throw new UnsupportedOperationException();
	}

	/**
	 * sets the register number
	 * params register for the register number
	 * @param number
	 */



	public String toString() {
		// TODO - implement Register.toString
		return " "+this.number;
	}

}