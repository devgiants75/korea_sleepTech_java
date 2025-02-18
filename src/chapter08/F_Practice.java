package chapter08;

// == 인터페이스 == //
// : Fruit 과일 인터페이스 정의
// - color: 추상 메서드
// - describe: 디폴트 메서드
// - printType: 정적 메서드

interface Fruit {
	// 추상메서드: public abstract 생략
	// - 추상클래스의 추상메서드와 다름!
	String color();
	
	// 디폴트 메서드: 재정의(오버라이드) 가능
	default void describe() {
		System.out.println("과일의 색상은 " + color() + "이며, 모양은 동그랗습니다.");
	}
	
	// 정적 메서드: 재정의(오버라이등) 불가능
	static void printType() {
		System.out.println("과일(Fruit)의 타입입니다.");
	}
}

class Apple implements Fruit {
	public String color() { return "red"; }
}

class Orange implements Fruit {
	public String color() { return "orange"; }
}

class Banana implements Fruit {
	public String color() { return "yellow"; }
	
	@Override
	public void describe() {
		System.out.println("과일의 색상은 " + color() + "이며, 모양은 깁니다.");
	}
}

// 인터페이스 //
interface TropicalFruit extends Fruit {
	// extends 확장하다!
	// : 클래스 간의, 인터페이스 간의 확장
	
	// cf) implements 구현하다!
	// : 인터페이스를 클래스로 구현
	
	// [생략]
	// - color: 추상 메서드
	// - describe: 디폴트 메서드
	// - printType: 정적 메서드
	
	default void tropicalFeature() {
		System.out.println("열대 과일은 후숙하면 더 맛있습니다.");
	}
}

class Mango implements TropicalFruit {
	public String color() {
		return "yellow";
	}
	
	@Override
	public void describe() {
		System.out.println("과일의 색상은 " + color() + "이며, 모양은 타원형입니다.");
	}
}

public class F_Practice {
	public static void main(String[] args) {
		
		// 다형성 적용
		Fruit apple = new Apple();
		Fruit orange = new Orange();
		Fruit banana = new Banana();
		TropicalFruit mango = new Mango();
		
		// 업캐스팅
		// : mango가 Fruit 타입으로 형 변환 
		// > TropicalFruit가 Fruit를 상속받은 인터페이스
		Fruit[] fruits = { apple, orange, banana, mango };
		
		for (Fruit fruit: fruits) {
			fruit.describe();
			// fruit.tropicalFeature();
			
			if (fruit instanceof TropicalFruit) {
				// 다운 캐스팅
				TropicalFruit tropicalFruit = (TropicalFruit) fruit;
				tropicalFruit.tropicalFeature();
			}
		}
		
		// A instanceof B
		// : 'A' 객체가 B 클래스(종류)와 같은지 확인
		class 동물 {}
		class 고양이 extends 동물 {}
		class 강아지 extends 동물 {}
		
		동물 애니멀 = new 동물();
		동물 나비 = new 고양이();
		동물 초코 = new 강아지();
		
		if (애니멀 instanceof 고양이) {
			System.out.println("실행되지 않음!! 부모 객체는 자식 객체에 담을 수 없음!");
		}
		
		Fruit.printType(); // 과일(Fruit)의 타입입니다. - 정적 메서드(인터페이스로 호출)
	}
}