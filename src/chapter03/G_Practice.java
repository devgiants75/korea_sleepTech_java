package chapter03;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class G_Practice {
	public static void main(String[] args) {
		/*
			단어 퀴즈 맞추기 게임
			: 동적 배열에 단어 5개를 삽입
			
			무작위의 수를 생성(0 ~ 4)하여 단어 5개 중에서 1가지를 선택
			
			사용자로부터 입력받은 값이 무작위로 선택된 단어가 일치할 경우 게임 종료
			, 정답을 맞출 때까지 무한 반복
			+) "종료" 입력 시 프로그램 종료
		*/
		
		// ArrayList 생성
		ArrayList<String> items = new ArrayList<>();
		
		items.add("커피");
		items.add("볼펜");
		items.add("핸드폰");
		items.add("포스트잇");
		items.add("리모콘");
		
		// cf) Random 모듈: 자바 내부 라이브러리 기능
		// - 난수(무작위 수)와 관련된 기능의 집합
		Random random = new Random();
		
		// random객체.nextInt(숫자값);
		// : 0부터 해당 숫자 미만의 정수가 생성
		int index = random.nextInt(items.size()); // 0부터 5미만까지의 정수 (items의 인덱스 번호)
		
		// 무작위 아이템 추출
		String selectedItem = items.get(index);
		
		// == 사용자 입력 스캐너 생성 == //
		Scanner sc = new Scanner(System.in);
		String userGuess; // 반복문 내에서 스캐너를 통해 값 할당
		
		while (true) {
			System.out.println("아이템을 맞춰보세요.");
			userGuess = sc.nextLine();
			
			// A문자열.equals(B문자열)
			// : 일치의 결과값을 boolean으로 반환
			if (userGuess.equals(selectedItem)) {
				System.out.println("정답입니다.");
				break; // 반복문 종료 키워드
			} else if (userGuess.equals("종료")) {
				break;
			} else {
				System.out.println("틀렸습니다. 다시 시도해주세요.");
			}
		}
		
		sc.close();
		System.out.println("프로그램이 종료되었습니다.");
	}
}
