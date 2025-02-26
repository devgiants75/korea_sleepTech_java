package chapter15.boardApp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import chapter15.boardApp.entity.Board;

public class BoardRepository {
	private final List<Board> boardStorage = new ArrayList<Board>();
	private long idSquence = 1;

	public void save(Board board) {
		board.setId(idSquence++);
		boardStorage.add(board);
	}

	public List<Board> findAll() {
		return boardStorage;
	}

	public Optional<Board> findById(long id) {
		return boardStorage.stream().filter(board -> board.getId() == id).findFirst();
		// .findFirst()
		//		: Stream()에서 조건에 맞는 첫 번째 요소를 반환 - Optional 타입의 객체를 반환
	}

	public void delete(long id) {
		// .removeIf()
		//		: 조건에 부합하는 것은 삭제, 그렇지 않은 것은 리스트에 남겨둠
		boardStorage.removeIf(board -> board.getId() == id);
	}
}
