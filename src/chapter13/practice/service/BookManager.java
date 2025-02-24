package chapter13.practice.service;

import java.util.List;

/*
 * 도서 관리 시스템의 비즈니스 로직을 인터페이스화
 * : CRUD 기능
 * - 제네릭 타입을 통해 책의 타입을 정의 
 * */
public interface BookManager<T> {
	// T: 타입 변수 
	// - 해당 인터페이스로 실질적인 비즈니스 로직 구현 시 타입을 명시
	void addBook(T book);
	List<T> listAllBooks(); // 전체 조회
	T findBookById(int id); // 단건 조회
	void updateBook(int id, T updateBook);
	void removeBook(int id);
}
