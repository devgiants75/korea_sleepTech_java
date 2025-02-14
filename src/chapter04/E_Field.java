package chapter04;

// == 객체 지향 프로그램의 '변수' == //

// == 필드 VS 지역변수 == //
// 1. 필드(속성)
// : 객체의 지속적인 상태를 저장하는 '클래스 내부'의 변수
// - 메서드의 외부에 위치(분리)
// - 명시적으로 초기화하지 않으면 기본값으로 초기화
// EX) 인스턴스(instance) 변수, 클래스(static) 변수

// = 인스턴스 필드(변수) = //
// : 클래스의 각 객체(인스턴스)에 속한 변수
// >> 클래스 내부에서 선언, '객체가 생성될 때' 메모리에 할당 
// >> 각 인스턴스 마다 다른 값을 가질 수 있음.

// = 클래스(static, 정적) 필드(변수) = //
// : 클래스의 '모든 인스턴스에서 공유되는' 데이터 변수
// : 'static 키워드'를 사용하여 선언되는 변수
// >> 해당 클래스로 생성되는 인스턴스가 '모두 동일한 값'을 가짐
// >> 프로그램이 시작될 때 생성 ~ 프로그램 종료 시 소멸
// cf) JVM의 'Method Area'라고 불리는 영역에 저장

// 2. 지역 변수
// : 메서드가 실행되는 동안에만 존재하는 '일시적인' 변수
// - 메서드(생성자 포함) 또는 블록 내부({})에서 선언
// - 자동으로 초기화 X, 반드시 초기화 후 사용
//		>> 초기화 없이 사용할 경우 에러!

class CarClass {
	// 1. 필드(속성)
	// 1) 인스턴스 필드: 각 객체 마다 다른 값을 가짐
	String brand;
	String color;
	int speed; // 일반 변수의 형태와 동일
	
	// 2) 클래스(정적, static) 필드: 클래스의 모든 객체가 동일한 값을 가짐
	static int tireNumber = 4;
	static int doorNumber;
	
	// 2. 지역변수
	void accelerate(int increment) {
		// speed: 필드
		// >> 지역변수 내에서도 접근 가능
		
		// increment: 지역 변수
		// >> 메서드 내부에서만 유효
		speed += increment; // speed = speed + increment
	}
}

public class E_Field {
	public static void main(String[] args) {
		// 클래스(정적, static) 변수 사용 방법
		// : 클래스명.필드명; || 객체명.필드명;
		System.out.println(CarClass.doorNumber); // 0
		System.out.println(CarClass.tireNumber); // 4
		CarClass.doorNumber = 4;
		System.out.println(CarClass.doorNumber); // 4
		
		// cf) 각 객체명으로 호출 가능하지만 클래스명 호출 방법을 권장!
		
		CarClass car1 = new CarClass();
		CarClass car2 = new CarClass();
		
		// 인스턴스(instance) 변수 사용 방법
		// : 객체명.필드명;
		car1.brand = "kia";
		car1.color = "black";
		
		// cf) 오류나지 않지만 사용하지 않음
		// car1.doorNumber = 10; // 객체명으로도 클래스 변수 접근 가능
		// System.out.println(car2.doorNumber); // 10
		
		car1.accelerate(100);
		System.out.println(car1.speed); // 100
	}
}