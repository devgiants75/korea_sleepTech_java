package chapter07;

// == final 키워드 == //
// : 변수, 메서드, 클래스에서 사용 가능
// 1) 변수: 값을 변경할 수 없는 상수 선언
// 2) 메서드: 자식 클래스에서 재정의(오버라이드)할 수 없는 메서드 선언
//			>> 해당 메서드는 재정의 될 수 X
// 3) 클래스: 상속될 수 없는 클래스 선언

class MyFinalClass {
	// 1. final 변수
	// : 상수를 지정하는 키워드
	// - 선언과 동시에 '초기화', 재할당 불가능
	// - UPPER_SNAKE_CASE(전체 키워드를 대문자로 작성)
	final int FINAL_VARIABLE = 30;
}

public class C_Final {
	public static void main(String[] args) {
		
	}
}
