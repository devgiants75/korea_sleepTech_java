package chapter07;

// == 다형성 == //
// : 많은 형태를 가질 수 있는 특성
// - 하나의 객체가 여러 타입의 인스턴스(객체)로 취급될 수 있는 특성
// - 상속 + 메서드 오버라이드 + 클래스 타입 변환 

// cf) instanceof 연산자
// : 참조변수값 instanceof 타입(클래스명)
// - 해당 객체가 특정 클래스의 인스턴스인지 또는 그 클래스를 상속받은 자식 클래스의 인스턴스인지 확인
// - boolean 값으로 반환

// Vehicle: 운송수단
class Vehicle {
	void displayInfo() {
		System.out.println("운송수단입니다.");
	}	
}

class Bus extends Vehicle {
	@Override
	void displayInfo() {
		System.out.println("버스를 타고 갑니다.");
	}
}

class Subway extends Vehicle {
	@Override
	void displayInfo() {
		System.out.println("지하철을 타고 갑니다.");
	}
}

class Bird {
	void displayInfo() {
		System.out.println("새는 운송수단이 아닙니다.");
	}
}

public class F_Polymorphism {
	public static void main(String[] args) {
		// == 다형성 적용 == //
		// : 부모 클래스 타입의 참조 변수로 자식 클래스 객체를 참조
		Vehicle vehicle = new Vehicle();
		Vehicle bus = new Bus();
		Vehicle subway = new Subway();
		// Vehicle bird = new Bird();
		
		if (subway instanceof Vehicle) {
			// subway 객체가 Vehicle의 인스턴스 || Vehicle을 상속받은 인스턴스 일 경우
			subway.displayInfo();
		}
		
		if (bus instanceof Vehicle) {
			bus.displayInfo();
		}
		
		if (vehicle instanceof Bus) {
			System.out.println("운송수단은 버스입니다.");
		} else {
			System.out.println("운송수단은 버스가 아닙니다.");
		}
		
		// +) instanceof 연산자가 true를 반환하는 경우
		//		: 해당 클래스 타입으로 형 변환이 가능!
	}
}
