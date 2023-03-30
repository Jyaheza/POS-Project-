package posPD;

import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Session {

	private Cashier cashier;
	private Register register;
	private ArrayList<Sale> sales; 
	private LocalDateTime startDateTime;
	private LocalDateTime endDateTime;
	private Sale sale;
	private boolean isPaid=false;

	public  Session() {
		// TODO - implement Session.Session
		//throw new UnsupportedOperationException();
		 sales= new ArrayList<Sale>();
	}

	/**
	 * 
	 * @param cashier
	 * @param register
	 */
	
	public Session(Cashier cashier, Register register,Sale sale) {
		// TODO - implement Session.Session
		this();
		this.cashier=cashier;
		this.register=register;
		sales.add(sale);
		this.sale= sale;
		startDateTime = LocalDateTime.now();
		//throw new UnsupportedOperationException();
	}
	
	public boolean setIsPaid(boolean b) {
		this.isPaid=b;
		return isPaid;
	}
	public boolean getIsPaid() {
		return isPaid;
	}
	public Session(Cashier cashier, Register register) {
		this();
		this.cashier=cashier;
		this.register=register;
	}
	/**
	 * 
	 * @param sale
	 */
	public String getCashierName() {
		return this.cashier.getName();
	}
	public Register getRegister() {
		return this.register;
	}
	public String getCasshierNumber() {
		return this.cashier.getNumber();
	}
	public String getRegisterNumber() {
		return this.register.getNumber();
	}
	public void addSale(Sale sale) {
		boolean exists=false;
		// TODO - implement Session.addSale
		//throw new UnsupportedOperationException();
		//for(Sale salee: this.getSales()) {
			
			//if(sale==sale) {
				//exists=true;
			//}
				
			//}
//		if(exists) {
//			System.out.println("Exists");
//		}
//		else {
			sales.add(sale);
			this.sale=sale;
		//}
		
	}
	public void adddSale(Sale sale) {
		this.sale=sale;
		this.sales.add(sale);
	}
	public Cashier getCashier() {
		return this.cashier;
	}
public Sale getSale() {
	return this.sale;
}
	/**
	 * 
	 * @param sale
	 */
	public void removeSale(Sale sale) {
		// TODO - implement Session.removeSale
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cashhh
	 */
	public BigDecimal calcCashCounterDiff(int cashhh) {
		// TODO - implement Session.calcCashCounterDiff
		throw new UnsupportedOperationException();
	}

	public BigDecimal calcTotal() {
		// TODO - implement Session.calcTotal
		throw new UnsupportedOperationException();
	}
public ArrayList<Sale> getSales(){
	return this.sales;
}
public BigDecimal getTotalSales() {
	BigDecimal total= new BigDecimal("0");
	for(Sale s:this.getSales()) {
		total=(s.calcTotal().add(total));
	}
	return total;
}
	public String toString() {
		// TODO - implement Session.toString
		//throw new UnsupportedOperationException();
		return "Session:"+ " Cashier: "+this.cashier.getName()+" Register: "+ this.register.getNumber()+" Total "+ this.sale.calcTotal();
	}

}