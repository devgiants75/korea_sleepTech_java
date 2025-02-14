package chapter05;

// 사칙연산 클래스
// : 두 개의 값을 매개변수로 받아 사칙연산 수행
class MyMath {
	int add(int a, int b) {
		return a + b;
	}
	int subtract(int a, int b) {
		return a - b;
	}
	int multiply(int a, int b) {
		return a * b;
	}
	int divide(int a, int b) {
		// 메서드의 조건부 반환
		if (b == 0) {
			System.out.println("정수 0으로 나눌 수 없습니다.");
			return b;
		} else {
			return a / b;			
		}
	}
	
	void noReturn() {
		System.out.println("해당 메서드는 반환값이 없습니다.");
		
		// return;
		// : 자바 컴파일러가 자동으로 반환타입을 읽고 void인 경우
		//		해당 메서드의 마지막에 return;을 자동 추가
	}
	
	int max(int a, int b) {
		// 정수 a와 b를 비교하여 둘 중 더 큰 값을 반환
		if (a > b) return a;
		else return b;
	}
	
	int min(int a, int b) {
		// 삼항 연산자를 사용한 조건부 반환
		return a > b ? b : a;
	}
}

public class C_Method {
	public static void main(String[] args) {
		MyMath myMath = new MyMath();
		System.out.println(myMath.add(10, 0)); // 10
		// cf) 인자값과 매개변수의 관계
		// : 자바는 값에 의한 호출 방식을 사용
		// >> 메서드 호출 시 인자값이 '매개변수에 복사'되어 전달
		
		// System.out.println(myMath.divide(10, 0)); 
		// : java.lang.ArithmeticException
		// >> 자바에서는 0으로 수를 나누면 예외가 발생
		
		// cf) 실수형 연산(0.0으로 나누기)에서는 예외가 발생하지 X
		
		System.out.println(myMath.divide(10, 0));
		// 정수 0으로 나눌 수 없습니다.
		
		System.out.println(myMath.max(10, 20)); // 20
		System.out.println(myMath.min(10, 20)); // 10
	}
}