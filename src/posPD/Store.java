package posPD;

import java.util.*;

/**
 * This is the instance of the store it has all the info to know about a store
 */
public class Store {

	private String number;
	private String name;
	private ArrayList<Session>sessions;
	private TreeMap<String,TaxCategory> taxCategories;
	private TreeMap<String,Item> items;
	private TreeMap<String,Cashier> cashiers;
	private TreeMap<String, Register> registers;
	private TreeMap<String,UPC> upcs;
	
	
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Store() {
		// TODO - implement Store.Store
		//throw new UnsupportedOperationException();
		sessions= new ArrayList<Session>();
		taxCategories= new TreeMap<String, TaxCategory>();
		items= new TreeMap<String,Item>();
		cashiers= new TreeMap<String,Cashier>();
		registers= new TreeMap<String,Register>();
		upcs= new TreeMap<String,UPC>();
		
		
		
	}

	/**
	 * sets the name and number of the store
	 * params number of the store number , name for the store name
	 * @param numberr
	 * @param name
	 */
	public Store(String numberr, String name) {
		this();
	this.number= numberr;
	this.name= name;

	}
	public Store(String name) {
		this();
		this.name=name;
	}

	/**
	 * finds the item for a give UPC
	 * params upc for the UPC to find an item for
	 * returns item
	 *  
	 * @param upc
	 */
	public Item findItemForUPC(String upc) {
		// TODO - implement Store.findItemForUPC
		throw new UnsupportedOperationException();
	}

	/**
	 * finds the cashier give the number
	 * params number for the cashier number
	 * @param number
	 */
	public Cashier findCashierForNumber(String number) {
		// TODO - implement Store.findCashierForNumber
		//throw new UnsupportedOperationException();
		Cashier cashier= new Cashier();
		if(cashiers.containsKey(number)) {
			cashier=cashiers.get(number);
		}
		else {
			cashier.setNumber(number);
		}
		return cashier;
	}

	/**
	 * adds and item
	 * params item for an item to be added
	 * @param item
	 */
	public void addItem(Item item) {
		items.put(item.getNumber(), item);

		//throw new UnsupportedOperationException();
	}

	/**
	 * adds a upc
	 * params upc for the UPC to be added
	 * @param upc
	 */
	public void addUPC(UPC upc) {
		// TODO - implement Store.addUPC
		
		
			upcs.put(upc.getUPCNumber(), upc);
		
		//throw new UnsupportedOperationException();
	}

	/**
	 * adds a register
	 * params register for the register to be added
	 * @param register
	 */
	public void addRegister(Register register) throws AddingExistingElementException{
		// TODO - implement Store.addRegister
		if(this.registers==null) {
			this.registers.put(register.getNumber(),register);
		}
		else {
			
		if(registers.get(register.getNumber())!=null) {
			System.out.println("UPC alresdy exists");
			throw new AddingExistingElementException("attempting to add an existing register");
		}
		else 
			registers.put(register.getNumber(),register);
		//throw new UnsupportedOperationException();
		}
	}
	public void removeRegister(Register register) {
		if(registers.get(register.getNumber())!=null) {
			registers.remove(register.getNumber());
		}
		else {
			System.out.print("Attempting to fire a non existing cashier");
		}
	}
	/**
	 * adds a cashier
	 * params cashier for the cashier to be added
	 * @param cashier
	 */
	public void addCashier(Cashier cashier) throws AddingExistingElementException {
		// TODO - implement Store.addCashier
		if(this.cashiers==null) {
			this.cashiers.put(cashier.getNumber(), cashier);
		}
		else {
			if(cashiers.get(cashier.getNumber())!=null) {
				System.out.println("Cashier already exists");
				throw new AddingExistingElementException("Attempting to add an existing Cashier");
			}
			else {
				cashiers.put(cashier.getNumber(), cashier);
			}
			//throw new UnsupportedOperationException();
		}
			
	}
		
	/**
	 * removes cashier
	 * params cashier for the cashier to be removed
	 * @param cashier
	 */
	public void removeCashier(Cashier cashier) {
		// TODO - implement Store.removeCashier
		if(cashiers.get(cashier.getNumber())!=null) {
			cashiers.remove(cashier.getNumber());
		}
		else {
			System.out.print("Attempting to fire a non existing cashier");
		}
		//throw new UnsupportedOperationException();
	}

	/**
	 * adds a tax category
	 * params tax category for the tax category to be added
	 * @param taxCategory
	 */
	public void addTaxCategory(TaxCategory taxCategory) {
		// TODO - implement Store.addTaxCategory
//       if(taxCategories.get(taxCategory.getCategory())!=null) {
//			System.out.println("Category Already exists");
//		}
//        else {
//        	taxCategories.put(taxCategory.getCategory(), taxCategory);
//        }
		//throw new UnsupportedOperationException();
		if(this.taxCategories==null) {
			this.taxCategories.put(taxCategory.getCategory(), taxCategory);
		}
		else {
			if(taxCategories.get(taxCategory.getCategory())!=null) {
				System.out.println("Tax Category already exists already exists");
			}
			else {
				taxCategories.put(taxCategory.getCategory(), taxCategory);
			}
			//throw new UnsupportedOperationException();
		}
		
	}

	/**
	 * removes a tax category
	 * params taxCategory for the category to be removed
	 * @param taxCategory
	 */
	public void removeTaxCategory( TaxCategory taxCategory) {
		// TODO - implement Store.removeTaxCategory
		
			taxCategories.remove(taxCategory.getCategory());
	
	}
	public Item getItemForUPC(String upcNumber) {
		Item item;
		if(this.upcs.get(upcNumber).getItem()!=null) {
			item= this.upcs.get(upcNumber).getItem();
			return item;
		}
		else
			return item = new Item();
	}

	/**
	 * adds a session
	 * params session for the session to be added
	 * @param session
	 */
	public void addSession(Session session) {
		// TODO - implement Store.addSession
		sessions.add(session);
		//throw new UnsupportedOperationException();
	}

	/**
	 * removes a session
	 * params session for the session to be removed
	 * @param session
	 */
	public void removeSession(Session session) {
		// TODO - implement Store.removeSession
		sessions.remove(session);
		//throw new UnsupportedOperationException();
	}

	/**
	 * finds a register given the register number
	 * paramms number for the register number
	 * returns register
	 * @param number
	 */
	public Register findRegisterByNumber(String number) {
		// TODO - implement Store.findRegisterByNumber
		Register register= new Register();
		if(registers.containsKey(number)) {
			register=registers.get(number);
		}
		else {
			register.setNumber(number);
		}
		return register;
		//throw new UnsupportedOperationException();
	}

	/**
	 * finds item for a give number
	 * params number for the number of the item
	 * returns Ite,
	 * @param number
	 */
	public Item findItemForNumber(String number) {
		Item item= new Item();
		// TODO - implement Store.findItemForNumber
		if(items.get(number)!=null) {
			item=items.get(number);
		}
			else {
				System.out.println("No Item for that number");
			}
		//throw new UnsupportedOperationException();
		return item;
	}
	public void removeItem(Item item) {
		this.items.remove(item.getNumber());
	}

	/**
	 * finds the tax category by the name
	 * params category for the category
	 * returns TaxCategory
	 * @param category
	 */
	public TaxCategory findTaxCategoryByName(String category) {
		// TODO - implement Store.findTaxCategoryByName
		if(taxCategories.get(category)!=null) {
			return taxCategories.get(category);
		}
		else 
			System.out.println("No tax Category named like that"
					+ "");
		throw new UnsupportedOperationException();
	}
	public TreeMap<String,Cashier> getCashiers(){
		return this.cashiers;
	}
	public TreeMap<String,Register> getRegisters(){
		return this.registers;
	}
    public TreeMap<String,Item> getItems(){
    	return this.items;
    }
    public TreeMap<String,TaxCategory> getTaxCategories(){
    return this.taxCategories;	
    }
    public ArrayList<Session> getSessions(){
    	return this.sessions;
    }
    public String toString() {
		// TODO - implement Store.toString
		return this.name;
	}
    public boolean isOkeyToDelete(Item item) {
    	boolean isOkey=false;
    	for(Session session: this.getSessions()) {
    		for(Sale sale: session.getSales()) {
    			for(SaleLineItem saleLineItem:sale.getSaleLineItems()) {
    				if(item.getNumber().equals(saleLineItem.getItem().getNumber()))
    					isOkey=true;
    			}
    		}
    	}
    	return isOkey;
    }
    
public boolean isOkayToDelete(Register register) {
	boolean isOkey=true;
	for(Session session: this.getSessions()) {
		if(session.getRegisterNumber().equals(register.getNumber())) {
			isOkey=false;
		}
	}
	return isOkey;
}
public boolean isOkayToDelete(Cashier cashier) {
	boolean isOkey=true;
	for(Session session:this.getSessions()) {
		if((session.getCasshierNumber()).equals(cashier.getNumber())) {
			isOkey=false;
		}
	}
	return isOkey;
}
public boolean isOkeyToDelete(TaxCategory taxCategory) {
	boolean isOkey=true;
	for(Session session: this.getSessions()) {
		for(Sale sale : session.getSales()) {
			for(SaleLineItem saleLineItem: sale.getSaleLineItems()) {
				if(saleLineItem.getItem().getTaxCategory().getCategory().equals(taxCategory.getCategory())) {
					isOkey=false;
				}
			}
		}
	}
	return isOkey;
}
public ArrayList<TaxCategory> getTaxCategoryList(){
	ArrayList<TaxCategory> tcList= new ArrayList();
	for(TaxCategory cat: this.getTaxCategories().values()) {
		tcList.add(cat);
	}
	return tcList;
}
public ArrayList<Register> getRegisterList(){
	ArrayList<Register> regList= new ArrayList();
	for(Register reg: this.getRegisters().values()) {
		regList.add(reg);
	}
	return regList;
}
}