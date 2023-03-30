package posPD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;


public class TaxRate implements Comparable<TaxRate> {

	private BigDecimal taxRate;
	private LocalDate effectiveDate;

	public BigDecimal getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		effectiveDate= LocalDate.now();
		this.taxRate = taxRate;
	}
public void setEffectiveDate(LocalDate effectiveDate) {
	this.effectiveDate=effectiveDate;
}
	public TaxRate() {
		// TODO - implement TaxRate.TaxRate
		//throw new UnsupportedOperationException();
	}

	/**
	 * sets the effective date and rate of tax
	 * params effectiveDate, rate
	 * @param effectiveDate
	 * @param rate
	 */
	public TaxRate(LocalDate effectiveDate, BigDecimal rate) {
		// TODO - implement TaxRate.TaxRate
		this.effectiveDate=effectiveDate;
		this.taxRate=rate;
		//throw new UnsupportedOperationException();
	}

	/**
	 * checks if date is effective
	 * params date for the date to be checked
	 * returns boolean
	 * @param date
	 */
	public boolean isEffective(LocalDate date) {
		Boolean isEffective;
		if(date.isBefore(LocalDate.now())) {
		isEffective= false;
		}
		else if(date.isAfter(LocalDate.now())||date.equals(LocalDate.now())) {
			isEffective= true;
		}
		// TODO - implement TaxRate.isEffective
		throw new UnsupportedOperationException();
	}

	/**
	 * compares tax rates
	 * params taxRate for the tax rate to be compared
	 * returns int
	 * @param taxRate
	 */
//	public int compareTo(TaxRate taxRate) {
//		// TODO - implement TaxRate.compareTo
//		throw new UnsupportedOperationException();
//	}
	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}

	public BigDecimal getRate() {
		return this.taxRate;
	}
	public String toString() {
		return this.taxRate+" "+this.effectiveDate;
	}

	public int compareTo(TaxRate o) {
		// TODO Auto-generated method stub
		return 1;
		
		
			
	}

	}