package posPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Item{

	private String number;
	private String description;
	private SaleLineItem saleLineItems;
	private TreeMap<String,UPC> uPCs;
	private BigDecimal prices;
	private ArrayList<Price> pricesList;
	private ArrayList<PromoPrice> promoPrices;
	private TaxCategory taxCategory;
	private Price price;
	private int itemCount=0;
	
	private UPC upc;
	/**
	 * sets the number and description of the item
	 * params number for number , description for the description
	 * @param number
	 * @param description
	 */
	public Item() {
		// TODO - implement Store.Store
		//throw new UnsupportedOperationException();

		uPCs= new TreeMap<String, UPC>();
		pricesList= new ArrayList<Price>();
		promoPrices= new ArrayList<PromoPrice>();
	}
		
	public Item(String number, String description,TaxCategory taxCategory,UPC upc) {
		// TODO - implement Item.Item
		//throw new UnsupportedOperationException();
		this();
		this.number=number;
		this.description=description;
		this.taxCategory=taxCategory;
		this.uPCs.put(upc.getUPCNumber(), upc);
		this.upc= upc;
	}
	public Item(String number, String description,TaxCategory taxCategory,Price price,UPC upc) {
		// TODO - implement Item.Item
		//throw new UnsupportedOperationException();
		this();
		this.number=number;
		this.description=description;
		this.taxCategory=taxCategory;
		this.price= price;
		this.upc=upc;
		this.uPCs.put(upc.getUPCNumber(), upc);
		this.pricesList.add(price);
	}
public void setItemCount(int count) {
this.itemCount= this.itemCount+count;

}
public int getItemCount() {
	return this.itemCount;
}
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return this.getPriceForDate(LocalDate.now());
	}
	public BigDecimal getPriceForDate(LocalDate date) {
		
		if(this.price.getPromoPrice().isEffective(date)) {
			setPrice(this.price.getPromoPrice().getPrice());
			return this.price.getPromoPrice().getPrice();
		}
	  if(!(this.price.getPromoPrice().isEffective(date))&& this.price.isEffective(date)){
			this.price.setPrice(price.getPrice());
			return this.price.getPrice();
		}
	  
		else {
			setPrice(new BigDecimal("0"));
			return new BigDecimal("0");
		}
			
	}

	
	/**
	 * adds a price
	 * params price for the price
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		// TODO - implement Item.addPrice
		//throw new UnsupportedOperationException();
		this.prices= price;
	}
	public void addUPC(UPC upc) {
		this.uPCs.put(upc.getUPCNumber(), upc);
	}
public void addPromoPrice(PromoPrice price) {
	this.promoPrices.add(price);
}
public void addPrice(Price price) {
	this.pricesList.add(price);
}
public void setTaxCategory(TaxCategory cat) {
	this.taxCategory= cat;
}
public void setUPC(UPC upc) {
	this.upc=upc;
}
	/**
	 * removes a price
	 * params price for the price to be removed
	 * @param price
	 */
	public void removePrice(Price price) {
		// TODO - implement Item.removePrice
		//throw new UnsupportedOperationException();
	}
	public void deleteUPC(UPC upc) {
		this.uPCs.remove(upc.getUPCNumber());
	}
	public TreeMap<String,UPC> getUPCs(){
		return this.uPCs;
	}
	public ArrayList<Price> getPrices(){
		return this.pricesList;
	}
	public TaxCategory getTaxCategory() {
		return this.taxCategory;
	}
	public String toStringTwo() {
		return this.number+"  "+this.description+"  "+ this.getPriceForDate(LocalDate.now())+"  "+ taxCategory.getTaxRateforDate(LocalDate.now());
	}
	public String toString() {
		return this.number+" "+this.description+" "+ this.price+" "+ taxCategory.getTaxRateforDate(LocalDate.now())+" "+upc.getUPCNumber();
	}
	public String reportToString() {
		return this.number+"              "+this.description+"                    "+this.itemCount;
	}

}