package chapter16.practice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import chapter16.practice.entity.Category;
import chapter16.practice.entity.Item;
import chapter16.practice.service.LibraryManager;

// = 도서 관리 시스템 = //
// : 도서 카테고리 ENUM 자료형 추가
// >> 조회 기능(카테고리별 검색 - 필터링)
public class Main {
	public static void main(String[] args) {
		LibraryManager manager = new LibraryManager();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("=== 도서관리시스템 ===");
			System.out.println("1. 카테고리별 검색");
			
			System.out.print("메뉴를 선택해주세요: ");
			
			try {
				int choice = Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				case 1:
					System.out.println("카테고리를 입력해주세요.");
					String searchCategory = sc.nextLine();
					
					// 문자열 값을 enum 타입으로 변환
					Category searchCategoryEnum = Category.fromString(searchCategory);
					
					List<Item> categoryResults = manager.searchByCategory(searchCategoryEnum);
					
					if (categoryResults.isEmpty()) {
						System.out.println("해당 카테고리의 책이 없습니다.");
					} else {
						categoryResults.forEach(Item::display);
//						categoryResults.forEach(x -> x.display());
					}
				}
				
			} catch (NumberFormatException e) {
				System.out.println("유효한 숫자값을 입력해주세요.");
				System.err.println("유효한 숫자값을 입력해주세요.");
				// syse: 인자 내의 문자열을 오류로 인식하고 출력
			} catch (NoSuchElementException e) {
				// : 컬렉션에서 요소를 가져올 때, 요소가 없는 경우 발생
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
