package posPD;

import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;


public class Price  {

	private BigDecimal price;
	private TreeMap<String,Item> items;
	private LocalDate effectiveDate;
	private PromoPrice promoPrice;
	 
	
	public Price(){
		items= new TreeMap<String,Item>();
	}
	
public Price(BigDecimal price) {
	this.price=price;
}
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 
	 * @param price
	 * @param effectiveDate
	 */
	public Price(String price, LocalDate effectiveDate,PromoPrice promoPrice) {
		
		if(!(promoPrice.isEffective(effectiveDate))) {
			this.price=promoPrice.getPrice();
			this.price= new BigDecimal(price);
			this.promoPrice=promoPrice;
			this.effectiveDate= effectiveDate;
		}
		else {
		this.price= new BigDecimal(price);
		this.promoPrice=promoPrice;
		this.effectiveDate= effectiveDate;
		this.promoPrice=promoPrice;}
		//throw new UnsupportedOperationException();
	}

public Price(String price, LocalDate effectiveDate) {
		this.price= new BigDecimal(price);
		this.effectiveDate= effectiveDate;
		//throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param date
	 */
	public boolean isEffective(LocalDate date) {
		// TODO - implement Price.isEffective
		if(date.isAfter(this.effectiveDate)) {
			return true;
		}
		else 
			return false;
	}
public Boolean isPromo() {
	if((this.effectiveDate.isEqual(this.promoPrice.getEffectiveDate())||this.effectiveDate.isAfter(this.promoPrice.getEffectiveDate()))&& this.effectiveDate.isBefore(this.promoPrice.getEndDate())) {
		this.price=this.promoPrice.getPrice();
			return true;
		}
	else 
		return false;
}
	/**
	 * 
	 * @param quantity
	 */
	public BigDecimal calcAmountForQty(int quantity) {
		// TODO - implement Price.calcAmountForQty
		throw new UnsupportedOperationException();
	}
	public BigDecimal getPriceValue() {
	return	this.price;
	}
public PromoPrice getPromoPrice() {
	return this.promoPrice;
}
public void setEffectiveDate(LocalDate effectiveDate) {
	this.effectiveDate= effectiveDate;
}
	/**
	 * 
	 * @param price
	 */
public int compareTo(Price price) {
//		// TODO - implement Price.compareTo
//		//throw new UnsupportedOperationException();
	return this.price.compareTo(price.price);
  }
public LocalDate getEffectiveDate() {
	return this.effectiveDate;
}
public LocalDate getEndDate() {
	return this.promoPrice.getEndDate();
}
	public String toString() {
		// TODO - implement Price.toString
		//throw new UnsupportedOperationException();
		return ""+this.price;
	}

}