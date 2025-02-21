package chapter12;

import chapter12.view.BookView;

// << 도서 관리 시스템 >>

// 1. == 요구사항 분석 ==
// - 새로운 도서 추가: addBook
// - 모든 도서 정보 출력: getAllBooks
// - 도서 검색 (도서 제목으로 검색): searchBookByTitle

// 2. == 프로그램 구조 ==

// Model(도서 정보를 담당)
// : Book 클래스 - 도서 정보(제목, 저자, 출판사)

// View(사용자 인터페이스 UI를 담당)
// : BookView 클래스
//		- 사용자로부터 입력을 받아 Controller에게 전달 & Controller에게 받은 정보를 출력

// Controller(사용자의 입력을 처리 - Model과 View 사이의 중재)
// : BookController 클래스
//		- 사용자의 입력에 따라 적절한 Model 메서드 호출
public class LibraryManagement {
	public static void main(String[] args) {
		BookView bookView = new BookView();
		bookView.showMenu();	
	}	
}
