package posPD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public abstract class Payment {

	private BigDecimal amount;
	private BigDecimal amtTendered;

	public abstract boolean countsAsCash();

}