package posPD;

import java.util.TreeMap;

public class UPC implements Comparable<UPC> {

	private String uPC;
	private Item item;
	

	public UPC() {
		
	}

	/**
	 * 
	 * @param upc
	 */
	public UPC(String upc) {
		this();
		// TODO - implement UPC.UPC
		uPC= upc;
		//throw new UnsupportedOperationException();
	}
	public String getUPCNumber() {
		return this.uPC;
	}
public void addItem(Item item) {
	this.item=item;
}
public Item getItem() {
	return this.item;
}
public int compareTo(UPC o) {
//	// TODO - implement Price.compareTo
//	//throw new UnsupportedOperationException();
return 1;
}
public void setUpcNumber(String number) {
this.uPC=number;	
}
	public String toString() {
		// TODO - implement UPC.toString
		return ""+this.uPC;
	}

}