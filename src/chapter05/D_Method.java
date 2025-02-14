package chapter05;

// == 메서드의 종류 == //
// : (인스턴스) 메서드, 정적(클래스, static) 메서드

// cf) 클래스 '필드': (인스턴스) 필드, 정적(클래스, static) 필드

// 클래스 '메서드'
// - 인스턴스 메서드
//		: 객체(인스턴스)를 생성한 후 호출할 수 있는 메서드
// - 정적 메서드
//		: 객체 생성 없이 호출 가능한 메서드

// 1. 정적 메서드란?
// : static 키워드를 사용하여 정의된 메서드, 클래스명으로 직접 호출 가능
// - static 반환타입 메서드명() {}
// - 클래스명.메서드명();

// 2. 정적 메서드 특징
// - 인스턴스 필드(변수)에 의존하지 X
// - 클래스 수준에 공유되는 데이터를 다룰 때 적합

// 3. 정적 메서드 사용 권장 사항
// 1) 공통 데이터 사용: 모든 인스턴스에 공유되는 값(정적 필드)을 다룰 때
// 2) 독립적인 사용: 필드값과 관계없이 지역변수만으로 작업 처리 시

class Operator {
	// (인스턴스) 필드(변수)
	int a, b;
	
	// (인스턴스) 메서드
	int add() {
		// cf) 인스턴스 메서드에서 필드값을 지정하고자 하는 경우 this 키워드 사용
		//		: 필드값과 지역변수의 명이 동일할 때;
		// int result = this.a - this.b;
		
		// 인스턴스 변수 활용: 매개변수가 필요하지 않은 경우도 존재
		return a + b;
	}
	
	int multiply(int a, int b) {
		int result = this.a - this.b; // 필드값에 접근
		return result;
	}
	
	// 정적 메서드
	static int subtract(int a, int b) {
		// 필드값과 지역변수의 값이 동일한 경우
		// : 해당 지역(내부의 영역)의 변수명이 우선시
		
		return a - b;
	}
}

public class D_Method {
	public static void main(String[] args) {
		System.out.println("인스턴스 메서드");
		Operator operator = new Operator();
		
		operator.a = 10;
		operator.b = 20;
		
		System.out.println(operator.add()); // 30
		
		System.out.println("정적 메서드");
		int result = Operator.subtract(10, 20); // 클래스명.메서드명();
		System.out.println(result); // -10
	}
}