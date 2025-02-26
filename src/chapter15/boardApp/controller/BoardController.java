package chapter15.boardApp.controller;

import chapter15.boardApp.dto.BoardRequestDto;
import chapter15.boardApp.service.BoardService;
import chapter15.boardApp.service.BoardServiceImpl;

public class BoardController {
	private final BoardService boardService;
	
	public BoardController() {
		this.boardService = new BoardServiceImpl();
	}
	
	// 1. 게시판 생성
	public void createBoard(BoardRequestDto dto) {
		if (isValidRequest(dto)) {
			
		}
	}
	
	// 2. 게시판 조회 (전체)
	
	// 3. 게시판 조회 (단건)
	
	// 4. 게시판 수정
	
	// 5. 게시판 삭제
	
	
	private boolean isValidRequest(BoardRequestDto dto) {
		String title = dto.getTitle();
		String content = dto.getContent();
		String author = dto.getAuthor();
		
		boolean result = title != null 
				&& !title.isEmpty() 
				&& content != null 
				&& !content.isEmpty()
				&& author != null
				&& !author.isEmpty();
	}
	
}
