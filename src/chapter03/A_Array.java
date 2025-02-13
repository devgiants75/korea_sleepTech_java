// == 패키지 == //
// : 폴더 (파일 분리 저장소)
package chapter03; // chapter03 폴더 내의 파일임을 명시

// == 클래스 == //
// : 파일 (코드 저장소)
// : 한 개의 파일에는 하나의 클래스가 포함
// - 모든 코드가 클래스 안에서 동작
public class A_Array { // 클래스명 == 파일명 (대문자로 시작)
	// 코드 작성

	// == 메인 메서드 == //
	// : 프로그램 실행의 시작점
	public static void main(String[] args) {

		// 배열 (Array)
		// : 같은 타입의 여러 변수를 하나의 집합으로 묶어서 처리하는 구조
		// - 데이터를 연속적으로 저장
		// - 순서 O (index 인덱스 번호, 0부터 1씩 증가되는 값)
		// - 중복 O (동일한 값을 여러 요소에 저장 가능)
		// +) 요소: 배열에서 각각의 데이터를 의미

		// 1) 변수
		int korean = 80;
		int math = 95;
		int english = 85;

		// 2) 배열
		// : 생성하여 사용 - new 연산자

		// == 배열의 선언 == //
		// : 생성한 배열을 담을 그릇
		// >> 데이터타입[] 배열명;
		// >> 데이터타입 배열명[];

		int[] scores; // - 정수형 데이터를 담을 수 있는 배열
		// int scores[];

		// cf) 배열명
		// : 복수 형태의 변수명 사용을 권장

		// == 배열의 생성 == //
		// : 실제 데이터가 저장 X
		// - 데이터 배열이 저장된 첫 번째 메모리 주소가 저장
		// >> new 데이터타입[배열의 길이];

		scores = new int[3]; // 요소의 개수가 3개인 배열 생성

		// cf) 참조 자료형 - 주소값 저장
		System.out.println(scores); // [I@2f92e0f4

		// == 배열 요소에 접근 == //
		// : 배열명[인덱스 번호]
		// +) 데이터 변경(삽입): 배열명[인덱스번호] = 데이터값;
		
		System.out.println(scores[0]); // 줄 복사: ctrl + alt + 방향키
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		
		// cf) 배열 생성 시 모든 요소는 해당 데이터 타입의 기본값으로 초기화
		// >> 숫자(0), 문자열(""), 논리형(false)
		
		scores[0] = 80;
		scores[1] = 90;
		scores[2] = 85;
		
		System.out.println(scores[0]); // 줄 복사: ctrl + alt + 방향키
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		// System.out.println(scores[3]); // ArrayIndexOutOfBoundsException
		
		// == 배열의 선언과 동시에 초기화 == //
		// : new 연산자 사용 + 직접적인 요소 대입의 배열 생성 시 길이 지정 X
		// >> 요소의 개수를 파악하여 길이가 자동 지정
		
		// 1) 데이터타입[] 배열명 = new 데이터타입[] {요소1, 요소2, ... };
		int[] scoreList = new int[] {90, 85, 75};
		System.out.println(scoreList[0]); // 90
		
		// 2) 데이터타입[] 배열명 = {요소1, 요소2, ... };
		char[] greet = {'h', 'e', 'l', 'l', 'o'};
		System.out.print(greet[0]);
		System.out.print(greet[1]);
		System.out.print(greet[2]);
		System.out.print(greet[3]);
		System.out.print(greet[4]); // hello
		System.out.println();
		
		System.out.println(greet[5]);
		
		
	}
}
