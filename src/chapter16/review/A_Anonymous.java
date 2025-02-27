package chapter16.review;

// == 익명 (내부, 중첩) 클래스 == //
// : 클래스를 정의하면서 동시에 인스턴스화가 이뤄지는 방법
// >> 이름 X, 재사용 X

// 1. 인터페이스 구현 예시
interface Animal {
	void sound(); // 추상 메서드 >> 인터페이스의 추상 메서드는 public abstract 생략
	
	// cf) 람다 표현식으로 변환 가능한 인터페이스는 '함수형 인터페이스'
	//		>> 단 하나의 추상 메서드만을 가짐
}

// cf) 인터페이스로 구현한 클래스 - 재사용 O
class Dog implements Animal {
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}

// 2. 추상 클래스 구현 예시
abstract class Vehicle {
	abstract void run(); // 추상 메서드 >> abstract 키워드 생략 불가
}


public class A_Anonymous {
	public static void main(String[] args) {
		
		// 인터페이스
		Animal dog1 = new Animal() {
			@Override
			public void sound() {
				System.out.println("익명 - 멍멍1");
			}
		};
		
		Animal dog2 = new Animal() {
			@Override
			public void sound() {
				System.out.println("익명 - 멍멍2");
			}
		};
		
		dog1.sound();
		dog2.sound();
		
		// 추상 메서드
		Vehicle car = new Vehicle() {
			@Override
			void run() {
				System.out.println("자동차가 달립니다.");
			}
		};
		car.run(); // 자동차가 달립니다.
	}
}
