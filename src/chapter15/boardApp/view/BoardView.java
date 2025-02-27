package chapter15.boardApp.view;

import java.util.List;
import java.util.Scanner;

import chapter15.boardApp.controller.BoardController;
import chapter15.boardApp.dto.BoardRequestDto;
import chapter15.boardApp.dto.BoardResponseDto;

/*
 * === 게시글 관리 시스템 ===
 * 
 * Board 게시판
 * : Create, Read(전체/단건), Update, Delete
 * */
public class BoardView {
	public static void main(String[] args) {
		BoardController boardController = new BoardController();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// View: 프론트엔드
			// Controller: 사용자의 입력과 선택을 받아 제어하는 역할 (백엔드)
			try {
				System.out.println("[ 게시판 관리 시스템 ]");
				System.out.println("1. 게시글 등록");
				System.out.println("2. 게시글 전체 조회(게시글 목록)");
				System.out.println("3. 게시글 단건 조회(게시글 상세 페이지)");
				System.out.println("4. 게시글 수정");
				System.out.println("5. 게시글 삭제");
				System.out.println("0. 프로그램 종료");
				System.out.print("선택해주세요 >>");
				int choice = sc.nextInt();
				sc.nextLine(); // 버퍼 제거
				
				switch (choice) {
				case 1:
					System.out.println("게시글 등록(제목, 내용, 작성자를 입력해주세요)");
					System.out.print("제목: ");
					String title = sc.nextLine();
					System.out.print("내용: ");
					String content = sc.nextLine();
					System.out.print("작성자: ");
					String author = sc.nextLine();
					boardController.createBoard(new BoardRequestDto(title, content, author));
					break;
				case 2:
					System.out.println("게시글 전체 조회");
					List<BoardResponseDto> result = boardController.getAllBoards();
					result.forEach(System.out::println);
					break;
				case 3:
					System.out.println("게시글 단건 조회");
					System.out.print("조회할 게시글 ID");
					long id = sc.nextLong();
					sc.nextLine();
					
					BoardResponseDto board = boardController.getBoardById(id);
					System.out.println(board);
					break;
				case 4:
					System.out.println("게시글 수정");
					System.out.print("수정할 게시글 ID");
					long updateId = sc.nextLong();
					sc.nextLine();
					
					System.out.print("새 제목: ");
					String newTitle = sc.nextLine();
					
					System.out.print("새 내용: ");
					String newContent = sc.nextLine();
					
					BoardRequestDto dto = new BoardRequestDto(newTitle, newContent, "수정은 작성자필드를 포함하지 않음");
					// BoardCreateRequestDto: 제목, 내용, 작성자
					// BoardUpdateRequestDto: 제목, 내용
					boardController.updateBoard(updateId, dto);
					break;
				case 5:
					System.out.println("게시글 삭제");
					System.out.println("삭제할 게시글 ID");
					long deleteId = sc.nextLong();
					sc.nextLine();
					
					boardController.deleteBoard(deleteId);
					break;
					
				case 0:
					System.out.println("종료합니다.");
					sc.close();
					return; // 반복문(무한루프)을 종료
				default:
					System.out.println("잘못된 선택입니다. 0 ~ 5 사이의 값을 입력해주세요.");
				}
			} catch (IllegalArgumentException e) {
				// 인수값으로 부적절한 값을 넘길 때 발생하는 예외
				System.out.println("예외 발생: " + e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}