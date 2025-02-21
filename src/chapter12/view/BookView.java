package chapter12.view;

import java.util.List;
import java.util.Scanner;

import chapter12.controller.BookController;
import chapter12.model.Book;

public class BookView {
	private final BookController bookController;
	private final Scanner sc;
	
	public BookView() {
		this.bookController = new BookController();
		this.sc = new Scanner(System.in);
	}
	
	public void showMenu() {
		int choice = 0;
		while (choice != 4) {
			System.out.println("== Book Management System ==");
			System.out.println("1. Add a Book");
			System.out.println("2. Show all Books");
			System.out.println("3. Search for a book title");
			System.out.println("4. Quit");
			System.out.print("메뉴를 선택해주세요 : ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				addBookView();
				break;
			case 2:
				showAllBooksView();
				break;
			case 3:
				searchBookView();
				break;
			default:
				System.out.println(" 종료하겠습니다. ");
				break;
			}
		}	
	}
	
	private void addBookView() {
		System.out.println("책 제목 입력");
		String title = sc.nextLine();
		System.out.println("책 저자 입력");
		String author = sc.nextLine();
		System.out.println("책 출판사 입력");
		String publisher = sc.nextLine();
		
		bookController.addBook(title, author, publisher);
	}
	
	private void showAllBooksView() {
		List<Book> allBooks = bookController.getAllBooks();
		// import 자동 단축키: ctrl + shift + o
		for (Book book: allBooks) {
			System.out.println(book);
		}
	}
	
	private void searchBookView() {
		System.out.println("책을 검색해주세요");
		String title = sc.nextLine();
		List<Book> foundBooks = bookController.searchBook(title);
		for (Book book: foundBooks) {
			System.out.println(book);
		}
	}
}
