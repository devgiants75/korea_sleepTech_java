package chapter13.practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
// : 추상 클래스 - 직접적인 인스턴스화 X, 하위 클래스 생성자 내에서 호출 용도로 정의
@ToString
@Getter
public abstract class Book {
	private int id;
	private String title;
	private String author;
}
