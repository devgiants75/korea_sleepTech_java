package chapter10.practice02.entity;

public abstract class Item {
	private String id; // 고유 식별자
	private String name; // 상품명
	private int price; // 상품 가격
	private int quantity; // 상품 재고 수량
	
	public Item(String id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getId() { return id; }
	public String getName() { return name; }
	public int getPrice() { return price; }
	public int getQuantity() { return quantity; }
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public abstract String getCategory();
	
	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name 
				+ ", Price: " + price  + ", Quantity: " + quantity;
	}
}
