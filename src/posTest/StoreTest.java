package posTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import POSDM.StoreDM;
import POSHI.POSFrame;
import posPD.CashDrawer;
import posPD.Cashier;
import posPD.Item;
import posPD.Person;
import posPD.Price;
import posPD.Register;
import posPD.Sale;
import posPD.SaleLineItem;
import posPD.Session;
import posPD.Store;
import posPD.TaxCategory;
import posPD.TaxRate;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating a store 
		/*
		Store store = new Store("Maurice's Store","SN001");
		
//creating 4 persons
		Person person1= new Person("Maurice Jyaheza Irakoze","Edmond, Oklahoma","4058565468");
		Person person2= new Person("Mike Manzi","Edmond, Oklahoma","4058565468");
		Person person3= new Person("John Doe","Edmond, Oklahoma","4058565468");
		Person person4= new Person("Alain MUkiza Mugisha","Edmond, Oklahoma","4058565468");
		// Making two of the persons cashiers
		Cashier cashier1= new Cashier("1",person1,"123456yhfgvbngf");
		Cashier cashier2= new Cashier("2",person3,"24535kjhuyjhgbn");
		Cashier cashier3= new Cashier ("3",person4,"1234879oljkhjgh");
		store.addCashier(cashier1);
		store.addCashier(cashier2);
		store.addCashier(cashier3);
		System.out.println("===========================");
		System.out.println("Cashiers");
		System.out.println("===========================");
		for(Cashier i: store.getCashiers().values()) {
		System.out.println(i.getName());
		}
		//creating cash Drawers
		CashDrawer cashDrawer1= new CashDrawer();
		CashDrawer cashDrawer2= new CashDrawer();
		//creating registers
		Register register1= new Register("001",cashDrawer1);
		Register register2= new Register("002",cashDrawer2);
		store.addRegister(register1);
		store.addRegister(register2);
		System.out.println("===========================");
		System.out.println("Registers");
		System.out.println("===========================");
		for(Register i:store.getRegisters().values() ) {
			System.out.println(i.getNumber());
		}
		System.out.println("===========================");
		System.out.println("Items");
		System.out.println("===========================");
		//Creating a Tax Rates 
		TaxRate foodTaxRate= new TaxRate(LocalDate.now(),new BigDecimal("0.07"));
		TaxRate beverageTaxRate= new TaxRate(LocalDate.now(),new BigDecimal("0.09"));
		//creating Tax Categories
		TaxCategory foodTax = new TaxCategory("Food Tax",foodTaxRate.getEffectiveDate(),foodTaxRate);
		TaxCategory beverageTax= new TaxCategory("Beverage Tax",beverageTaxRate.getEffectiveDate(),beverageTaxRate);
		store.addTaxCategory(foodTax);
		store.addTaxCategory(beverageTax);
		//creating items
			
			Price price1= new Price("7.99",LocalDate.now());
			Price price2= new Price("2.99",LocalDate.now());
			Item item1 = new Item("I001","Banana Cake",foodTax,price1);
			Item item2= new Item("I002","Coca cola zero",beverageTax,price2);
			Item item3 = new Item("I003","Pringles",foodTax,price2);
			
			store.addItem(item1);
			store.addItem(item2);
			store.addItem(item3);
			for(Item i: store.getItems().values()) {
			System.out.println(i);	
			}
			System.out.println("=======================");
			System.out.println("Sessions");
			System.out.println("========================");
			//Creating a sale
			Sale sale1;
			sale1= new Sale(false);
			SaleLineItem saleLineItem1= new SaleLineItem(sale1,item1,2);
			SaleLineItem saleLineItem2= new SaleLineItem(sale1,item2,1);
			sale1 = new Sale(saleLineItem1);
			sale1.addSaleLineItem(saleLineItem2);
			Session session1= new Session(cashier1,register1,sale1);
			System.out.println(session1);	
			for(int i=0;i<sale1.getSaleLineItems().size();i++) {
				System.out.println(sale1.getSaleLineItems().get(i));
			}
			System.out.println(sale1);
		}
		*/
		Store store= new Store();
		StoreDM storeData = new StoreDM();
		System.out.println("Ready to Open Store");
		storeData.loadData(store);
		storeData.printStoreinfo();
		System.out.println("Store Open: David's QuickMart");
		//System.out.println(storeData.getTaxCategories());
	  POSFrame.open(storeData.getAllStore());
		System.out.println(store);
	}

}
