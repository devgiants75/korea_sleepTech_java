package chapter06;

// == 상속(Inheritance) == //
// : 한 클래스의 속성과 메서드를 다른 클래스가 물려받는 것
// - 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것
// - 코드의 재사용성, 중복 제거 (프로그램의 생산성 향상)

// 상속 구현 방법
// : extends (확장하다) 키워드를 사용하여 구현
// : class 자식클래스 extends 부모클래스 {}

class Parent {} // 부모 클래스(기존 클래스)
class Child extends Parent {} // 자식 클래스(새로운 클래스)

// cf) 명칭
// 		상속해주는 클래스(Parent) - 조상, 부모, 상위, 기반, 슈퍼 클래스
//		상속 받는 클래스(Child) - 자손, 자식, 하위, 파생, 서브 클래스

// == 동물 클래스 == //
class Animal {
	String name; // 동물의 이름
}

class Dog extends Animal {
	// 부모 클래스의 속성과 메서드를 모두 상속 받음 (생략된 것과 같음)
	// String name;
	
	// 클래스의 확장
	void bark() {
		System.out.println("강아지가 짖습니다.");
	}
}

// == Tv 클래스 == //
class Tv {
	// 속성
	boolean power; // 전원 상태(on/off)
	int channel; // 채널 번호
	
	// 행위
	// 전원을 설정, 채널 이동(업/다운)
	void setPower() {
		power = !power;
	}
	
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

class SmartTv extends Tv {
	boolean ott; // ott 플랫폼 전원 상태(on/off)
	
	void displayOtt(String platform) {
		if (ott) {
			System.out.println(platform);
		} else {
			System.out.println("OTT 연결이 되지 않았습니다.");
		}
	}
}

public class B_Inheritance {
	public static void main(String[] args) {
		Dog choco = new Dog();
		choco.name = "초코";
		System.out.println(choco.name); // 초코
		choco.bark(); // 강아지가 짖습니다.
				
		Tv tv1 = new Tv();
		tv1.power = true;
		tv1.channelUp();
		tv1.channelUp();
		tv1.channelUp();
		System.out.println(tv1.channel); // 3
		
		SmartTv smartTv1 = new SmartTv();
		smartTv1.power = true;
		
		smartTv1.channelDown();
		smartTv1.channelDown();
		smartTv1.channelDown();
		smartTv1.channelDown();
		smartTv1.channelDown();
		
		System.out.println(smartTv1.channel); // -5
		
		smartTv1.displayOtt("Netflix"); // OTT 연결이 되지 않았습니다.
		smartTv1.ott = true;
		smartTv1.displayOtt("Netflix"); // Netflix
		// 줄 복사: ctrl + alt + 방향키
		// 줄 이동: alt + 방향키
		
		// tv1.ott = true;
		// >> 부모는 자식의 기능과 행위를 전달받지 못함.
	}
}