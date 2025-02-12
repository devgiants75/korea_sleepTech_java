package chapter02;

import java.util.Scanner;

public class B_Switch {

	public static void main(String[] args) {
		// switch 조건문
		// : 특정 변수의 값에 따라 실행할 코드 블록의 범위를 결정
		// : 비교할 변수와 case값을 비교하여 같은 값일 경우 해당 블록부터 끝까지 실행
		// - break 키워드에서 switch문이 종료
		
		/*
			switch (조건변수) {
				case 조건값1:
					실행 문장;
				case 조건값2:
					실행 문장;
				case 조건값3:
					실행 문장;
				...
				default:
					case 조건식이 끝난 뒤 작성
					>> 어느 case에도 일치하지 않을 경우 실행
			}
			
			>> full-through 상태
				: case 영역 내에서 break 키워드를 사용
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Chapter를 선택하세요.");
		int chapter = sc.nextInt();
		
		switch (chapter) {
		case 1:
			System.out.println("자바 기본 문법");
			break;
			// System.out.println("해당 내용은 출력은?");
		case 2:
			System.out.println("자바 제어문 - 조건문/반복문");
			break;
		case 3:
			System.out.println("자바 배열");
			break;
		default:
			System.out.println("유효한 chapter가 아닙니다.");
		}
		
		sc.nextLine(); // 개행 문자(Enter) 값 처리
		
		System.out.println("과일의 이름을 입력해주세요.");
		String fruit = sc.nextLine();
		
		switch (fruit) {
		case "banana":
			System.out.println("노란색");
			break;
		case "orange":
			System.out.println("주황색");
			break;
		case "grape":
			System.out.println("보라색");
			break;
		default:
			System.out.println("유효한 과일이 아닙니다.");
		}
		
		sc.close(); // 입력기.close();
		
		// === else if VS switch === //
		// 1. else if
		// : 범위 조건식 
		// >> 앞선 조건을 모두 배제하고 남은 데이터에서 조건 검색
		
		int score = 85;
		if (score >= 90) {
			System.out.println("우수한 성적입니다.");
		} else if (score >= 70) {
			System.out.println("평균적인 성적입니다.");
		} else {
			System.out.println("조금 더 노력해봅시다.");
		}
		
		// 2. switch
		// : 특정 값(정수, 문자, 문자열 등)을 기준으로 여러 경우(case)를 비교할 때 유용
		String grade = "B";
		switch (grade) {
		case "A":
		case "B":
			System.out.println("우수한 성적입니다.");
			break;
		case "C":
		case "D":
			System.out.println("평균적인 성적입니다.");
			break;
		default:
			System.out.println("조금 더 노력해봅시다.");
		}
	}
}