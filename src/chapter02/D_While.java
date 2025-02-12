package chapter02;

import java.util.Scanner;

public class D_While {
	public static void main(String[] args) {
		// === while문 === //
		// : 반복 횟수가 정해져있니 않을 때 사용
		
		// - 조건을 검사하고 해당 조건이 true인 경우 코드 블록을 (반복적) 실행
		//	: if문의 반복 형태
		
		/*
			while (조건) {
				조건이 참일 때 실행
			}
		
			>> for문의 초기화식과 증감식이 조건문과 분리된 형태
		*/
		
		// 1부터 5까지 1씩 증가하는 정수를 출력
		int num = 1; // 초기화
		
		while (num <= 5) {
			System.out.print(num);
			num++; // 증감식
		}
		
		// 0부터 20까지의 정수 중에서 홀수만 출력
		// 1) break;
		// : 반복문 내에서 break; 키워드를 만나면 반복문 탈출(종료)
		
		// 2) continue;
		// : 반복문 내에서 continue; 키워드를 만나면 아래의 코드를 무시하고 다시 '조건 검사'
		
		System.out.println();
		int number = 0;
		
		while (true) { // 무한 루프
			
			if (number % 2 == 0) {
				// 짝수
				number++; // 다음 수 (홀수)를 위한 작업
				continue;
			}
			
			// 홀수만 해당 내용 실행
			System.out.println(number);
			number++; // 다음 수 (짝수)를 위한 작업
			
			if (number == 20) break;
		}
		
		// cf) do-while문
		// : while문과의 차이점 - 코드가 반드시 한 번은 실행
		
//		do {
//			조건이 참인 경우 실행 (조건 검사 전 반드시 한 번은 실행)
//		} while (조건);
		
		num = 1;
		
		do {
			System.out.print(num);
			num++;
		} while (num <= 5);
		
		// while VS do-while 
		// 1) while문
		// : 조건 검사 시점 - 실행 전 검사
		// : 최소 실행 횟수 - X
		
		// 2) do-while문
		// : 조건 검사 시점 - 실행 후 검사
		// : 최소 실행 횟수 - 1번
		// >> 사용자의 입력을 받아야 하는 경우
		// >> 특정 작업을 한 번 이상 수행해야 하는 경우
		
		// == 예제 == //
		// 사용자 입력을 받아 1 ~ 10 사이의 숫자가 입력될 때까지 반복
		// : do-while문으로 작성
		// > 1 ~ 10까지의 숫자를 입력한 경우 해당 수를 출력
		// > "올바른 숫자: " + inputNumber
		System.out.println();
		Scanner sc = new Scanner(System.in);
		int inputNumber; // 초기화
		
		do {
			System.out.println("1 ~ 10 사이의 숫자를 입력하세요.");
			inputNumber = sc.nextInt();
		} while (inputNumber < 1 || inputNumber > 10);
		
		System.out.println("올바른 숫자: " + inputNumber);
	}
}
