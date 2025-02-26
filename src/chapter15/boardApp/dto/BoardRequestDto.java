package chapter15.boardApp.dto;

import chapter15.boardApp.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

// BoardRequestDto
// : 사용자에게 요청받은 데이터를 정의
// - id값을 제외한 필드를 제공
@AllArgsConstructor
@Getter
public class BoardRequestDto {
	private String title;
	private String content;
	private String author;
	
	public Board toEntity() {
		// 요청값으로 Board 객체를 생성
		return new Board(title, content, author);
	}
}
