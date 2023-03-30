package posPD;

import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TaxCategory{

	private String category;
	private TreeSet<TaxRate> taxRates;
	private LocalDate effectiveDate;
	private BigDecimal rate;
    
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
public void setEffectiveDate(String date) {
	
	this.effectiveDate= LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
}
 public TaxCategory() {
	 taxRates= new TreeSet<TaxRate>();
		// TODO - implement TaxCategory.TaxCategory
		
		//throw new UnsupportedOperationException();
	}

	/**
	 * sets the category, effectiveDate and TaxRate
	 * params category,effectiveDate,taxRate
	 * @param category
	 * @param effectiveDate
	 * @param taxRate
	 */
	public TaxCategory(String category, LocalDate effectiveDate, TaxRate taxRate) {
		// TODO - implement TaxCategory.TaxCategory
		this();
		this.category= category;
		this.taxRates.add(taxRate);
		this.effectiveDate= effectiveDate;
		this.rate= taxRate.getRate();		
		//throw new UnsupportedOperationException();
	}

	/**
	 * gets the tax rate for the given date
	 * params localDate for the date
	 * returns the taxRate
	 * @param date
	 */
	public BigDecimal getTaxRateforDate(LocalDate date) {
		// TODO - implement TaxCategory.getTaxRateforDate
		//throw new UnsupportedOperationException();
		return this.rate;
	}
//	public String getTaxRate {
//		return this.categor
//	}

	/**
	 * adds a given tax rate
	 * params taxRate for the tax rate to be added
	 * @param taxRate
	 */
	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}
	public void addTaxRate(TaxRate taxRate) {
		// TODO - implement TaxCategory.addTaxRate
		
			taxRates.add(taxRate);
			System.out.println("Added");
		
			if(taxRates.contains(taxRate)) {
				System.out.println("Tax Rate already exists");
			}
		
	}
public void deleteTaxRate(TaxRate taxRate) {
	if(taxRates.size()>1) {
		taxRates.remove(taxRate);
	}
}
	/**
	 * removes given taxRate
	 * params taxRate for the tax tax rate to be removed
	 * @param taxRate
	 */
	public void removeTaxRate(TaxRate taxRate) {
		// TODO - implement TaxCategory.removeTaxRate
		throw new UnsupportedOperationException();
	}
	public TreeSet<TaxRate> getTaxRates(){
		return this.taxRates;
	}
	public String toString() {
		return ""+ this.category+" "+ this.rate+" "+ this.effectiveDate;
				}

}