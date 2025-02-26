package chapter15.boardApp.controller;

import java.util.List;

import chapter15.boardApp.dto.BoardRequestDto;
import chapter15.boardApp.dto.BoardResponseDto;
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
			boardService.createBoard(dto);
			System.out.println("게시글이 등록되었습니다.");
		} else {
			System.out.println("입력값이 유효하지 않습니다.");
		}
	}
	
	// 2. 게시판 조회 (전체)
	public List<BoardResponseDto> getAllBoards() {
		List<BoardResponseDto> boards = null;
		
		try {
			boards = boardService.findAllBoards();
			
			if (boards.isEmpty()) {
				new Exception("게시글이 없습니다.");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return boards;
	}
	
	
	// 3. 게시판 조회 (단건)
	public BoardResponseDto getBoardById(long id) {
		BoardResponseDto dto = null;
		
		try {
			dto = boardService.findBoardById(id);
			
			if (dto == null) {
				new Exception("해당 id의 게시글이 존재하지 않습니다.");
			} 
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return dto;
	}
	
	
	// 4. 게시판 수정
	public void updateBoard(long updateId, BoardRequestDto dto) {
		if (isValidRequest(dto)) {
			boardService.updateBoard(updateId, dto);
			System.out.println("게시글이 수정되었습니다.");
		} else {
			System.out.println("입력값이 유효하지 않습니다.");
		}
	}
	
	// 5. 게시판 삭제
	public void deleteBoard(long deleteId) {
		try {
			boardService.deleteBoard(deleteId);
			System.out.println("게시글이 삭제되었습니다.");
		} catch(IllegalArgumentException e) {
			System.out.println("오류: " + e.getMessage());
		}
	}
	
	private boolean isValidRequest(BoardRequestDto dto) {
		String title = dto.getTitle();
		String content = dto.getContent();
		String author = dto.getAuthor();
		
		// cf) null VS isEmpty()
		// - null
		//		: 아무런 값을 참조하고 있지 않음
		// - isEmpty()
		//		: 비어 있는지 확인하는 메서드
		//		: 값은 존재하지만 그 값의 내부 내용이 비어있음을 확인
		//		>> 문자열(""), 리스트([]), 배열([]) 등에서 사용
		boolean result = title != null 
				&& !title.isEmpty() 
				&& content != null 
				&& !content.isEmpty()
				&& author != null
				&& !author.isEmpty();
		
		return result; // result값이 true가 되려면 모든 값에 null이 아니며 실질적 데이터가 존재
	}
	
}
