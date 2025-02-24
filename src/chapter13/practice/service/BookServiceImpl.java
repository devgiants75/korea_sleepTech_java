package chapter13.practice.service;

import java.util.List;

import chapter13.practice.model.Book;
import chapter13.practice.repository.BookRepository;

// 비즈니스 로직 처리 - 싱글톤 패턴 구현
public class BookServiceImpl implements BookManager<Book>{
	private static BookServiceImpl instance;
	private final BookRepository repository = new BookRepository();

	private BookServiceImpl() {}
	
	public static BookServiceImpl getInstance() {
		if (instance == null) {
			instance = new BookServiceImpl();
		}
		return instance;
	}
	
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> listAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBook(int id, Book updateBook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBook(int id) {
		// TODO Auto-generated method stub
		
	}

}
