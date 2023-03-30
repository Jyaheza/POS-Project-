package posPD;

import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Sale {

	private ArrayList<Payment> payments;
	private ArrayList<SaleLineItem> saleLineItems;
	private SaleLineItem sli;
	private LocalDateTime dateTime;
	private Payment payment;
	private boolean taxFree;
	private BigDecimal amtTendered;
	Cash cash=new Cash();
	Check check=new Check();
	Credit credit=new Credit();

	 public Sale() {
		// TODO - implement Sale.Sale
		 payments= new ArrayList<Payment>();
		 saleLineItems= new ArrayList<SaleLineItem>();
		 dateTime=LocalDateTime.now();
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * params taxFree
	 * @param taxFree
	 */
	public Sale(SaleLineItem sli) {
		// TODO - implement Sale.Sale
		//throw new UnsupportedOperationException();
		this();
		this.sli=sli;
		saleLineItems.add(sli);
	}
	
	public Sale(boolean taxFree) {
		this();
		this.taxFree=taxFree;
		
	}
	public BigDecimal getCheckAmount() {
		return this.check.amount;
	}
	public Sale( String taxFree) {
		this();
		if(taxFree.equals("y") || taxFree.equals("Y")||taxFree.equals("Yes")){
			this.taxFree=true;
		}
		else
		this.taxFree=false;
	}

	/**
	 * adds payment
	 * params payment for the payment to be added
	 * @param payment
	 */
	public void addPayment(Payment payment,String type) {
		// TODO - implement Sale.addPayment
		switch(type) {
		case "cash":
			check.setAmount(new BigDecimal("0"));
			credit.setAmount(new BigDecimal("0"));
			cash.setAmount(this.calcTotal());
			break;
		case "credit":
			check.setAmount(new BigDecimal("0"));
			cash.setAmount(new BigDecimal("0"));
			credit.setAmount(this.calcTotal());
			break;
		case "check":
			cash.setAmount(new BigDecimal("0"));
			credit.setAmount(new BigDecimal("0"));
			check.setAmount(this.calcTotal());
			break;
			default:
				System.out.print("Unknown Payment");
		}
		this.payment=payment;
		payments.add(payment);
		
	}
	public void setPayment(Payment payment) {
		this.payment=payment;
	}
public Payment getPayment() {
	return this.payment;
}
	/**
	 * removes payment
	 * params payment for the payment to be removed
	 * @param payment
	 */
	public void removePayment(Payment payment) {
		// TODO - implement Sale.removePayment
		int count=0;
		for(int i=0;i<payments.size();i++) {
			if(payments.get(i)==payment) {
				payments.remove(i);
				count++;
			}
		}
		if(count==0) {
			System.out.println("Attempting to remove a non exixting payment");
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * adds a sale line item
	 * params sli for the sale line item to be added
	 * @param sli
	 */
	public void addSaleLineItem(SaleLineItem sli) {
		// TODO - implement Sale.addSaleLineItem
		saleLineItems.add(sli);
		//throw new UnsupportedOperationException();
	}

	/**
	 * removes sale line item
	 * params sli for the sale line item to be removed
	 * @param sli
	 */
	public void removeSaleLineItem(SaleLineItem sli) {
		// TODO - implement Sale.removeSaleLineItem
		int count=0;
		for(int i=0;i<saleLineItems.size();i++) {
			if(saleLineItems.get(i)==sli) {
				saleLineItems.remove(i);
				count++;
			}
		}
		if(count==0) {
			System.out.println("Attempting to remove a non exixting sale line item");
		}
		throw new UnsupportedOperationException();
	}
	public void setIsTaxIsFree(boolean taxFree) {
		this.taxFree=taxFree;
	}

	/**
	 * calculates the total sales
	 * returns BigDecimal
	 */
	public BigDecimal calcTotal() {
		// TODO - implement Sale.calcTotal
		//throw new UnsupportedOperationException();
		if(this.taxFree==true) {
			return this.calcSubTotal();
		}
		BigDecimal total= new BigDecimal("0");
		for(int i=0;i<saleLineItems.size();i++) {
			total=total.add(saleLineItems.get(i).calcSubTotal());
		}
		return total;
	}

	/**
	 * calculates the sub total
	 * returns BigDecimal
	 */
	public BigDecimal calcSubTotal() {
		// TODO - implement Sale.calcSubTotal
		//throw new UnsupportedOperationException();
		BigDecimal subTotal= new BigDecimal("0");
		for(int i=0;i<saleLineItems.size();i++) {
			subTotal= subTotal.add(saleLineItems.get(i).calcTotalWithoutTax());
		}
		return subTotal;
	}

	/**
	 * calculates tax
	 * returns BigDecimal
	 */
	public void setAmtTendered(BigDecimal amt) {
		this.amtTendered=amt;
	}
	public BigDecimal getAmtTendered() {
		return this.amtTendered;
	}
	public BigDecimal calcTax() {
		// TODO - implement Sale.calcTax
		//throw new UnsupportedOperationException();
		if(this.taxFree==true) {
			
			return new BigDecimal("0");
		}
		BigDecimal totalTax= new BigDecimal("0");
		for(int i=0;i<saleLineItems.size();i++) {
			totalTax= totalTax.add(saleLineItems.get(i).calcTax());
		}
		return totalTax;
	}

	/**
	 * gets total payments
	 * returns BigDecimal
	 */
	public BigDecimal getTotalPayments() {
		// TODO - implement Sale.getTotalPayments
		throw new UnsupportedOperationException();
	}

	/**
	 * checks if payment is enough
	 * returns boolean
	 */
	public boolean isPaymentEnough() {
		// TODO - implement Sale.isPaymentEnough
		throw new UnsupportedOperationException();
	}

	/**
	 * calculates amount for payment
	 * params amtTendered for the amount tendered
	 * @param amtTendered
	 */
	public void calcAmountForPayment(BigDecimal amtTendered) {
		// TODO - implement Sale.calcAmountForPayment
		throw new UnsupportedOperationException();
	}

	/**
	 * calculates change
	 * returns big decimal
	 */
	public BigDecimal calcChange() {
		// TODO - implement Sale.calcChange
		throw new UnsupportedOperationException();
	}

	/**
	 * calculates amount tendered
	 * returns BigDecimal
	 */
	public BigDecimal calcAmtTendered() {
		// TODO - implement Sale.calcAmtTendered
		throw new UnsupportedOperationException();
	}
	public ArrayList<SaleLineItem> getSaleLineItems(){
		return this.saleLineItems;
	}

	public String toString() {
		// TODO - implement Sale.toString
		//hrow new UnsupportedOperationException();
		return "Sale: SubTotal: "+ this.calcSubTotal()+ " Tax: "+this.calcTax().setScale(2, RoundingMode.HALF_UP) +" Total:"+(this.calcSubTotal().add(this.calcTax())).setScale(2, RoundingMode.HALF_UP);
	}
	public String toString2() {
		return "Sale: SubTotal: "+ this.calcSubTotal()+ " Tax: "+this.calcTax()+" Total:"+this.calcTotal();
	}
	public String reportToString() {
		
		return LocalTime.now()+"          "+cash.getAmount()+"          "+check.getAmount()+"          "+credit.getAmount()+"  ";
	}

}