package posPD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;


public class SaleLineItem {

	private Item item;
	private int quantity;
	private Sale sale;

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void saleLineItem() {
		// TODO - implement SaleLineItem.saleLineItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sale
	 * @param item
	 * @param quantitee
	 */
	public SaleLineItem(Sale sale, Item item, int quantity) {
		// TODO - implement SaleLineItem.saleLineItem
		this.item= item;
		this.quantity=quantity;
		this.sale= sale;
		//throw new UnsupportedOperationException();
	}

	public SaleLineItem(Item item, int quantity) {
		this.item= item;
		this.quantity=quantity;
	}
	public Item getItem() {
		return this.item;
	}
	public BigDecimal calcSubTotal() {
		// TODO - implement SaleLineItem.calcSubTotal
		//throw new UnsupportedOperationException();
		BigDecimal totalWithoutTax,subTotal;
		totalWithoutTax= new BigDecimal(this.quantity).multiply(item.getPriceForDate(LocalDate.now()));
		subTotal= totalWithoutTax.add(this.item.getTaxCategory().getTaxRateforDate(LocalDate.now()).multiply(new BigDecimal(this.quantity)));	
					
		return subTotal;
	}
public BigDecimal calcTotalWithoutTax() {
	return new BigDecimal(this.quantity).multiply(item.getPriceForDate(LocalDate.now()));
}
	public BigDecimal calcTax() {
		return (this.item.getTaxCategory().getTaxRateforDate(LocalDate.now()).multiply(new BigDecimal(this.quantity))).multiply(this.item.getPrice());
	}
public String toStringTwo() {
	return this.item.toStringTwo()+" quantity "+this.quantity+ " "+ new BigDecimal(this.quantity).multiply(item.getPriceForDate(LocalDate.now()));
}
	public String toString() {
		// TODO - implement SaleLineItem.toString
		//throw new UnsupportedOperationException();
		return this.item.toStringTwo()+" quantity "+this.quantity+ " "+ new BigDecimal(this.quantity).multiply(item.getPriceForDate(LocalDate.now()));
	}

}