package chapter15.boardApp.service;

import java.util.List;

import chapter15.boardApp.dto.BoardRequestDto;
import chapter15.boardApp.dto.BoardResponseDto;

public interface BoardService {
	// CR(전체/단건)UD
	void createBoard(BoardRequestDto dto);
	
	// 조회(전체)
	List<BoardResponseDto> findAllBoards();
	// 조회(단건)
	BoardResponseDto findBoardById(long id);
	
	void updateBoard(long id, BoardRequestDto dto);
	void deleteBoard(long id);
}
