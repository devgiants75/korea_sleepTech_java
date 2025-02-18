package chapter07;

// == 도서 관리 시스템 == //
// : 책의 정보를 저장, 책의 상태(대여 가능 여부) 확인, 책의 정보 출력

// 1) Book 클래스
// : 속성) title(String, 불변성), author(String, 불변성), isAvailable(boolean)
// : 메서드) borrowBook(), returnBook(), displayInfo()
// : 생성자) 매개변수 - title, author
class Book {
	private final String title;
	private final String author;
	private boolean isAvailable = true; // 책의 초기 상태: 대여 가능

	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	// 책 대여 메서드
	void borrowBook() {
		if (isAvailable) {
			isAvailable = false;
			System.out.println("책 대여가 성공적으로 완료되었습니다.");
		} else {
			System.out.println("현재 대여 중입니다. (대여 X)");
		}
	}

	// 책 반납 메서드
	void returnBook() {
		if (!isAvailable) {
			// 책이 대여 중인 상태
			isAvailable = true;
			System.out.println("책 반납이 성공적으로 완료되었습니다.");
		} else {
			System.out.println("이미 반납된 상태입니다. (반납 X)");
		}
	}

	// 책 정보 출력 메서드
	void displayInfo() {
		System.out.println("제목: " + title + ", 저자: " + author + ", 대여 가능 여부: " + (isAvailable ? "대여 가능" : "대여 중"));
	}

	// 캡슐화를 위한 getter 메서드 추가
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
}

// 2) EBook 클래스 - Book 클래스를 상속
// 추가 속성) fileSize(double)
// 추가 메서드) displayInfo() - 재정의, fileSize()
// 생성자) EBook(title, author, fileSize)

class EBook extends Book {

//	EBook() {
//		super(); - 빈 슈퍼 생성자가 존재하지 않음
//	}

	private double fileSize;

	EBook(String title, String author, double fileSize) {
		super(title, author);
		this.fileSize = fileSize;
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("파일 크기: " + fileSize + "MB");
	}

	double getFileSize() {
		return fileSize;
	}
}

public class D_OOP_Prac {
	public static void main(String[] args) {
		// Book 객체 생성
		Book book1 = new Book("역사의 쓸모", "최태성");
		book1.displayInfo();
		book1.borrowBook(); // 책 대여가 성공적으로 완료되었습니다.
		book1.displayInfo();
		book1.borrowBook(); // 현재 대여 중입니다. (대여 X)
		
		book1.returnBook(); // 책 반납이 성공적으로 완료되었습니다.
		book1.returnBook(); // 이미 반납된 상태입니다. (반납 X)
		
		// EBook 객체 생성
		EBook ebook1 = new EBook("스위트 스팟", "샘 리처드", 131.23);
		
		ebook1.displayInfo();
//		제목: 스위트 스팟, 저자: 샘 리처드, 대여 가능 여부: 대여 가능
//		파일 크기: 131.23MB - 재정의 된 메서드(확장)
		
		ebook1.borrowBook();
	}
}