package POSDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import posPD.Cashier;
import posPD.Check;
import posPD.Credit;
import posPD.Item;
import posPD.Person;
import posPD.Price;
import posPD.PromoPrice;
import posPD.Register;
import posPD.Sale;
import posPD.SaleLineItem;
import posPD.Session;
import posPD.Store;
import posPD.TaxCategory;
import posPD.TaxRate;
import posPD.UPC;
import posPD.AddingExistingElementException;
import posPD.Cash;
import posPD.CashDrawer;

public class StoreDM {
	private BufferedReader bufferedReader;
	private String line= null;
	boolean pause=false;
	String []currentLine=null;
	Store store;
	Session session;
	Sale sale;
	Store allStore;
	String lineTest;
	public void loadData(Store store) {
		String fileName="src/POSDM/StoreData_v2021.csv";
		try {
			FileReader fileReader= new FileReader(fileName);
			bufferedReader= new BufferedReader(fileReader);
		}
		catch( FileNotFoundException e){
			System.out.println("Unable to open File "+fileName);
		}
	}
	public void printStoreinfo() {
		
		try {
			do {
				line=bufferedReader.readLine();
				if(line!=null) {
					 currentLine= line.split(",");
					 switch(currentLine[0]) {
					 case "Store":
						 store= new Store(currentLine[1]);
						 System.out.println(store);
						 break;
					 case "TaxCategory":
							 System.out.println(getTaxCategories(currentLine));
							 line=bufferedReader.readLine();
							 currentLine=line.split(",");
							 if(currentLine[0].equals("TaxCategory")) {
								 System.out.println(getTaxCategories(currentLine));
							 }
						 break;
					
					 case "Cashier":
						 System.out.println("========================");
						 System.out.println("Cashiers");
						 System.out.println("=========================");
						 System.out.println(getCashier(currentLine));
						 line=bufferedReader.readLine();
						 currentLine=line.split(",");
						 if(currentLine[0].equals("Cashier")) {
							 System.out.println(getCashier(currentLine));
						 }
						 break;
					 case "Item":
						 System.out.println("========================");
						 System.out.println("Items");
						 System.out.println("=========================");
						 System.out.println(getItem(currentLine));
						 for(int i=0;i<=2;i++) {
							 line=bufferedReader.readLine();
							 currentLine=line.split(",");
							 if(currentLine[0].equals("Item")) {
								 System.out.println(getItem(currentLine));
							 } 
						 }
						 
						 break;
					 case "Register":
						 System.out.println("========================");
						 System.out.println("Registers");
						 System.out.println("=========================");
						 System.out.println(getRegister(currentLine));
						 line=bufferedReader.readLine();
						 currentLine=line.split(",");
						 if(currentLine[0].equals("Register")) {
							 System.out.println(getRegister(currentLine));
						 }
						 break;
					 case "Session1":
						 System.out.println("==========================");
						 System.out.println("Sessions");
						 System.out.println("===========================");
						 System.out.println(getSession(currentLine));
						// if(bufferedReader.readLine().equals("Sale")) {
							// getSale()
						// }
						 break; 
					 case "Session2":
						 System.out.println(getSession(currentLine));
						 break;
						 
					 case "Sale":
						 String printPayment="      1";
						 sale= getSale(currentLine);
						for(int i=0;i<2;i++) {
							line=bufferedReader.readLine();
							 currentLine=line.split(",");
							 if(currentLine[0].equals("SaleLineItem"))
							System.out.println(printSaleLineItem(currentLine,sale));
							 sale.addSaleLineItem(getSaleLineItem(currentLine));
						}
						line=bufferedReader.readLine();
						currentLine=line.split(",");
						if(currentLine[0].equals("Payment")) {
							
							if(currentLine[1].equals("Cash")) {
								
							Cash cash=new Cash(currentLine[1],new BigDecimal(currentLine[3]),new BigDecimal(currentLine[2]));
							sale.addPayment(cash,"cash");
							printPayment= cash.toString();
							}
							else if(currentLine[1].equals("Credit")) {
								Credit credit = new Credit(new BigDecimal(currentLine[2]),currentLine[4],currentLine[5],currentLine[6]);
								sale.addPayment(credit,"credit");
								printPayment= credit.toString();
							}
							else if(currentLine[1].equals("Check")) {
								Check check = new Check(new BigDecimal(currentLine[2]),currentLine[4],currentLine[5]);
								sale.addPayment(check,"check");
								printPayment = check.toString();
							}
							
						}
						System.out.println("                        ");
						session.addSale(sale);
						session.getCashier().setCashCount(sale.calcTotal());
						store.addSession(session);
						System.out.print("   "+sale);
						System.out.println(printPayment);
						System.out.println("                        ");
						 break;
						 
		
					 }
		             //if(currentLine[0].equals("Store")) {
		            	 //pause=true;
		            	 
		             }
		 
				
				}while(line!=null);
			//bufferedReader.close();
		 
		}
		catch(IOException e) {
			System.out.println("Error reading File");
		}
		allStore=store;
		
	}
	public Store getAllStore() {
		return this.allStore;
	}
public String getTaxCategories(String [] line) {
	LocalDate date;
	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
	date= LocalDate.parse(line[3],formatter);
	TaxRate taxRate=new TaxRate();
	taxRate.setTaxRate(new BigDecimal(line[2]));
	TaxCategory taxCategory= new TaxCategory(line[1],date,taxRate);
	store.addTaxCategory(taxCategory);
		return ""+taxCategory;
	}
public String getCashier(String[] line) {
	Person person=new Person(line[2],line[4],line[8]);
	Cashier cashier = new Cashier(line[1],person,line[9]);
	try {
		store.addCashier(cashier);
	} catch (AddingExistingElementException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ""+cashier;
}
	public String getItem(String[] line) {
//	LocalDate startDate;
//	LocalDate endDate;
	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
//	startDate= LocalDate.parse(line[6],formatter);
//	endDate= LocalDate.parse(line[8],formatter);
	UPC upc= new UPC(line[2]);
		TaxCategory taxCategory;
		taxCategory=store.findTaxCategoryByName(line[4]);
		if(line.length<=7) {
			PromoPrice promoPrice= null;
		}
		PromoPrice promoPrice= new PromoPrice(new BigDecimal(line[7]),line[8],line[9]);
		Price price= new Price(line[5],LocalDate.parse(line[6],DateTimeFormatter.ofPattern("MM/dd/yy")),promoPrice);
		Item item= new Item(line[1],line[3],taxCategory,price,upc);
		upc.addItem(item);
		store.addUPC(upc);
		//item.setPrice(item.getPriceForDate(LocalDate.now()));
		store.addItem(item);
		
		return ""+item.toStringTwo();
	}
	public String getRegister(String[] line) {
		CashDrawer cashDrawer= new CashDrawer(new BigDecimal("0"));
		Register register= new Register(line[1],cashDrawer);
		try {
			store.addRegister(register);
		} catch (AddingExistingElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ""+register;
	}
	public String getSession(String[] line) {
		
	 session = new Session (store.findCashierForNumber(line[1]),
				store.findRegisterByNumber(line[2]));
		return "Session: "+"Cashier: "+session.getCashierName()+" Register: "+session.getRegisterNumber()+" Date:"+LocalDateTime.now()
		.format(DateTimeFormatter.ofPattern("dd-MM-YY HH:mm:ss"));
		
}
	public Sale getSale(String[] line) {
		 sale= new Sale(line[1]);
//		getSaleLineItem()
//		
//		//sale1= new Sale(false);
//		SaleLineItem saleLineItem1= new SaleLineItem(sale1,item1,2);
//		SaleLineItem saleLineItem2= new SaleLineItem(sale1,item2,1);
//		sale1 = new Sale(saleLineItem1);
//		sale1.addSaleLineItem(saleLineItem2);
//		Session session1= new Session(cashier1,register1,sale1);
//		System.out.println(session1);	
//		for(int i=0;i<sale1.getSaleLineItems().size();i++) {
//			System.out.println(sale1.getSaleLineItems().get(i));
//		}
//		System.out.println(sale1);
//	}
		return sale;
	}
	public String printSaleLineItem(String[] line,Sale sale){
		SaleLineItem saleLineItem1= new SaleLineItem(store.findItemForNumber(line[1]),Integer.parseInt(line[2]));
		saleLineItem1.getItem().setItemCount(Integer.parseInt(line[2]));
		sale.addSaleLineItem(saleLineItem1);
		return ""+saleLineItem1.toStringTwo()+"  "+LocalDateTime.now()
		.format(DateTimeFormatter.ofPattern("MM-dd-YY HH:mm:ss"));
	}
	public SaleLineItem getSaleLineItem(String[]line ) {
		SaleLineItem saleLineItem1= new SaleLineItem(store.findItemForNumber(line[1]),Integer.parseInt(line[2]));
		return saleLineItem1;
	}
	
}
