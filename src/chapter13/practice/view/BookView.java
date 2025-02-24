package chapter13.practice.view;

import java.util.List;
import java.util.Scanner;

import chapter13.practice.model.Book;
import chapter13.practice.model.Fiction;
import chapter13.practice.model.NonFiction;

public class BookView {
	private final Scanner sc = new Scanner(System.in);
	
	public void showMenu() {
		System.out.println("======도서관리시스템======");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 전체 조회");
		System.out.println("3. 도서 단건 조회");
		System.out.println("4. 도서 수정");
		System.out.println("5. 도서 삭제");
		System.out.println("0. 종료");
		System.out.print("선택 >> ");
	}
	
	// 사용자 입력값에 대한 유효성 검증 로직 추가
	// - 프로세스 로직(데이터) 입력값
	public int getInput() {
		int choice;
		try {
			choice = sc.nextInt();
		} catch(Exception e) {
			System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
			sc.nextLine();
			return -1;
		}
		return choice;
	}
	
	public Book getBookDetails() {
		System.out.println("도서 ID: ");
		int id = getInput();
		if (id == -1) return null;
		
		// 정상적으로 id 값이 입력된 경우(정수값) - nextInt 버퍼 처리
		sc.nextLine();
		
		System.out.println("제목: ");
		String title = sc.nextLine().trim();
		
		if (title.isEmpty()) {
			System.out.println("제목은 비어 있을 수 없습니다.");
			return null;
		}
		
		System.out.println("저자: ");
		String author = sc.nextLine().trim();
		
		if (author.isEmpty()) {
			System.out.println("저자는 비어 있을 수 없습니다.");
			return null;
		}
		
		System.out.println("1. Fiction / 2. NonFiction");
		int type = getInput();
		if (type == -1) return null;
		sc.nextLine();
		
		if (type == 1) {
			System.out.println("장르: ");
			String genre = sc.nextLine().trim();
			
			if (genre.isEmpty()) {
				System.out.println("장르는 비어 있을 수 없습니다.");
				return null;
			}
			
			return new Fiction(id, title, author, genre);
		} else if (type == 2) {
			System.out.println("분야: ");
			String field = sc.nextLine().trim();
			
			if (field.isEmpty()) {
				System.out.println("분야는 비어 있을 수 없습니다.");
				return null;
			}
			
			return new NonFiction(id, title, author, field);			
		} else {
			System.out.println("잘못된 선택입니다. 1 또는 2를 입력하세요.");
			return null;
		}
	}
	
	public void displayBooks(List<Book> books) {
		if (books.isEmpty()) {
			System.out.println("등록된 도서가 없습니다.");
		} else {
			for (Book book: books) {
				System.out.println(book.toString());
			}
		}
	}
	
	public void displayBook(Book book) {
		if (book == null) {
			System.out.println("해당 도서를 찾을 수 없습니다.");
		} else {
			System.out.println(book);
		}
	}
}
