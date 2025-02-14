package chapter05;

// 자바 객체 지향 프로그래밍
// '클래스': 객체를 생성하기 위한 템플릿(설계도)
// - 필드, 메서드, 생성자

// cf) 클래스의 필드: 클래스의 특성이 담긴 속성

// == 메서드 == //
/*
	ReturnType methodName(Parameter List) {
		- 메서드의 기능, 동작 정의
	}
	
	1. ReturnType(반환 유형)
	: 메서드 동작 후 반환하는 데이터 유형 지정
	- 반환 데이터가 없는 경우 void 지정
	
	2. methodName(메서드명)
	: lowerCamelCase 사용, 동사 사용을 권장
	cf) 변수명 - 명사 사용을 권장
	
	EX) eat(먹다) - 메서드, eating(먹기) - 변수
	
	3. parameter list (매개변수 목록)
	: 메서드에 전달되는 입력 값들의 목록
	- 0개 이상 지정(지정하지 않을 수도 있음)
	- 각 매개변수는 자료형과 함께 선언
			: 일반 변수 선언에서 쓰이는 동일한 데이터 타입의 생략이 불가
			: int a, b; (X)
*/

class Calculator {
	int a, b;
	
	int add(int a, int b) {
		// return 
		// : 메서드의 반환을 담당
		// - 반환타입과 일치하는 데이터를 동반
		// - void 타입 일 경우 생략 가능, 키워드 뒤에 데이터 생략 가능(return;)
		int sum = a + b;
		
		return sum;
//		return 10;
//		return a + b;
	}
	
	void voidMethod() {
		return;
	}
}

public class A_Method {
	public static void main(String[] args) {
		// 메서드 사용
		// 객체명.메서드();
		Calculator calc = new Calculator(); // 객체 생성
		
		// 메서드의 반환 값이 있는 경우
		// : 해당 값을 변수에 할당받아 활용 가능
		
		System.out.println(calc.add(10, 5)); // 15
		
		int result = calc.add(3, 5);
		System.out.println(result); // 8
	}
}
