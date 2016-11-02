package edu.arizona.ece373.InterglacticPioneers.Model;

import java.util.ArrayList;
import java.util.Random;

public class Store {
	private Double priceScaler;
	private ArrayList<StoreItem> items;
	
	// Constructor(s)
	public Store(Double pc){
		this.priceScaler = pc + 1;
		this.items = new ArrayList<StoreItem>();
		this.buildStoreItems();
	}
	
	private void buildStoreItems(){
		Integer chance = new Random().nextInt(100);
		// All Stores will Sell Food
		this.items.add(new StoreItem("Food", 1));
		// Most Stores (75%) will Sell ???
		if(chance < 75)this.items.add(new StoreItem("Something", 1));
		// Half Stores (50%) will Sell ???
		if(chance < 50)this.items.add(new StoreItem("Something Else", 1));
		// Few Stores (25%) will Sell ???
		if(chance < 25)this.items.add(new StoreItem("Rare Item", 1));
		// Even Less Stores (10%) will Sell ???
		if(chance < 10)this.items.add(new StoreItem("Very Rare Item", 1));
		// One in 100 Stores will Sell ???
		if(chance < 2)this.items.add(new StoreItem("Extreamly Rare Item", 1));
	}
	
	class StoreItem{
		private String description;
		private Double price;
		private Integer quantity;
		
		public StoreItem(String d, Integer p){
			this.description = d;
			this.price = p * Store.this.priceScaler;
			this.quantity = new Random().nextInt(100);
		};
		
		// Get'ers and Set'ers
		public String getDescription(){return this.description;}
		public Double getPrice(){return this.price;}
		public Integer getQuantity(){return this.quantity;}
	};
}
