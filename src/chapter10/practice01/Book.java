package chapter10.practice01;

public class Book extends Item {
	// id, name
	private String isbn; // 책 고유 번호 (전 세계 통용)
	private String author;
	private String publisher;
	private int publishYear;
	private int price;
	private int stock;
	private String category;
	
	public Book(String id, String name, String isbn, String author, String publisher, int publishYear
			, int price, int stock, String category) {
		super(id, name);
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}
	
	public String getIsbn() { return isbn; }
	public String getAuthor() { return author; }
	public String getPublisher() { return publisher; }
	public int getPublishYear() { return publishYear; }
	public int getPrice() { return price; }
	public int getStock() { return stock; }
	public String getCategory() { return category; }
	
	public void updateStock(int quantity) {
		this.stock += quantity;
	}
	
	@Override
	public void display() {
		System.out.println("ID: " + getId() + ", Name: " + getName() + ", ISBN: " + isbn);
	}
}
