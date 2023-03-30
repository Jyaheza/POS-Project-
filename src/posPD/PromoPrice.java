package posPD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class PromoPrice extends Price {

	private BigDecimal price;
	LocalDate effectiveDate;
	LocalDate endDate;
	
	
	

	public PromoPrice() {
		// TODO - implement PromoPrice.PromoPrice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param price
	 * @param effectiveDate
	 * @param endDate
	 */
	public PromoPrice(BigDecimal price, String effectiveDate, String endDate) {
		// TODO - implement PromoPrice.PromoPrice
		//throw new UnsupportedOperationException();
		this.price=price;
		this.effectiveDate= LocalDate.parse(effectiveDate,DateTimeFormatter.ofPattern("MM/dd/yy"));
		this.endDate= LocalDate.parse(endDate,DateTimeFormatter.ofPattern("MM/dd/yy"));
	}
	public PromoPrice(BigDecimal price, LocalDate effectiveDate, LocalDate endDate) {
		// TODO - implement PromoPrice.PromoPrice
		//throw new UnsupportedOperationException();
		this.price=price;
		this.effectiveDate= effectiveDate;
		this.endDate= endDate;
	}

	/**
	 * 
	 * @param date
	 */
	public boolean isEffective(LocalDate date) {
//		LocalDate effectiveDate= LocalDate.parse(this.effectiveDate,DateTimeFormatter.ofPattern("dd/MM/yy"));
//		LocalDate endDate= LocalDate.parse(this.effectiveDate,DateTimeFormatter.ofPattern("dd/MM/yy"));
		if(date.isAfter(this.effectiveDate) && date.isBefore(this.endDate)) {
			return true;
		}
		else 
			return false;
	
	}
	public BigDecimal getPrice() {
		return this.price;
	}
	public LocalDate getEffectiveDate() {
		return this.effectiveDate;
	}
	public LocalDate getEndDate() {
		return this.endDate;
	}

	public String toString() {
		// TODO - implement PromoPrice.toString
		return ""+this.price;
	}

}