package chapter12.controller;

import java.util.ArrayList;
import java.util.List;
import chapter12.model.Book;

public class BookController {
	private List<Book> books;
	
	public BookController() {
		this.books = new ArrayList<>();
	}
	
	// 1. 책 추가
	public void addBook(String title, String author, String publisher) {
		Book newBook = new Book(title, author, publisher);		
		books.add(newBook);
	}
	
	// 2. 전체 책 조회
	public List<Book> getAllBooks() {
		return books;
	}
	
	// 3. 책 검색 - 책 제목
	public List<Book> searchBook(String title) {
		List<Book> result = new ArrayList<Book>();
		
		for (Book book: books) {
			if (book.getTitle().contains(title)) {
				result.add(book);
			}
		}
		
		return result;
	}
}
