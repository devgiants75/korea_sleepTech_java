package chapter05;

// == (메서드) 오버로딩 == //
// : overloading - 중복 정의
// : 한 클래스 내에서 동일한 이름의 '메서드'를 여러 개 정의하는 것

// cf) 변수는 같은 영역 내에서 동일한 이름의 재선언이 불가!

// 1. 오버로딩 성립 조건
// - 메서드 이름은 동일
// - 단, 매개변수의 개수 또는 타입이 달라야 함.
// +) 반환타입은 오버로딩 성립에 영향이 없음

// 2. 오버로딩의 장점
// - 사용자가 메서드의 매개변수 순서를 외우지 않아도 사용 가능
// - 작업의 본질이 동일한 메서드를 하나의 이름으로 그룹화가 가능
//		: 코드의 재사용성, 가독성 향상
// - 컴파일 시 타입 체크 강화
//		: 올바른 매개변수를 가진 메서드를 자동 선택

// 3. 오버로딩 단점
// : 중복적으로 의미없이 생성하는 경우, 실질적으로 필요한 구현 메서드 찾기에 어려움 (복잡성)

class Calc {
	int add (int a, int b) { return a + b; }
	// long add (int a, int b) { return a + b; }
	// : 실제 반환되는 값의 차이가 아닌, 입력받는 매개변수의 차이가 필요!
	// >> 반드시, 매개변수의 개수 또는 타입의 구성이 달라야 함!
	
	// == 매개변수 타입 차이 == //
	int add (short a, short b) { return a + b; } // 개수 동일, 구성 상이
	double add(double x, double y) { return x + y; }
	
	double add(int x, double y) { return x + y; }
	double add(double x, int y) { return x + y; }
	
	// == 매개변수 개수 차이 == //
	int add (int a, int b, int c) { return a + b + c; }
}


public class F_Overloading {
	public static void main(String[] args) {
		
		Calc calc = new Calc();
		System.out.println(calc.add(10, 20, 30));
		System.out.println(calc.add(10, 20));
		System.out.println(calc.add(10.5, 20.3));
		System.out.println(calc.add(10.3, 20));
		System.out.println(calc.add(10, 20.9));
	}
}