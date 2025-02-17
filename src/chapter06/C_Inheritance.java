package chapter06;

// == 상속에서의 생성자 == //
// : 상속받은 클래스에서 생성자 호출
// : (순서) 부모에서 자식 순서로 호출!!
// - 자식 클래스에서 객체 생성 시, 자식 클래스는 해당 클래스의 생성자를 통해 객체 생성
//		>> 자식 클래스의 생성자 호출 시 '항상' 부모 클래스의 생성자가 호출!!
//		>> 반드시 사용자 정의 부모 생성자 호출 필요 X

class A {
	A() {}
	A(int a) { 
		this(); // 사용자 정의 생성자 내에서 다른 생성자 호출은 반드시 최상단에서!!
		System.out.println(a);		
	}
}

/*
	Mammal 클래스
	1) 필드: 이름(name), 나이(age)
	2) 생성자: 매개변수 X 생성자, 매개변수 O 생성자(String name) - 오버로딩
	3) 메서드: 클래스 필드 정보를 출력(displayMammal)
*/
class Mammal {
	String name = "Parent";
	
	// Mammal() {} - 빈 생성자 
	
	Mammal() {
		System.out.println("빈 부모 생성자 - 인스턴스 생성");
	}
	
	Mammal(String name) {
		this.name = name;
	}
	
	void displayMammal() {
		System.out.println(name);
	}
}

// cf) 접근제어자가 생략 되어있는 default 값의 경우
//		: 같은 패키지 내에서 접근 가능 O
//		>> 같은 패키지 내에 같은 클래스명 사용이 불가!

// class Animal {
// 		
// }

/*
	Cat 클래스(자식) - Mammal 클래스(부모)를 상속받음
	1) 필드: name(이름)
	2) 생성자: 매개변수 X 생성자, 매개변수 O 생성자(String name) - 오버로딩
	3) 메서드: 클래스 필드 정보를 출력(displayCat)
*/
class Cat extends Mammal {
	String name = "Child";
	/*
		Cat() {
			super();
			
			상속받은 자식 클래스의 경우 
			: 사용자 정의 부모 생성자의 호출이 없더라도!
			  super() 부모 클래스 생성자 호출 키워드가 정의되어 있음! (생략)
		}
	*/ 
	
	Cat() {
		super(); // 생략되어도 자동 호출 - 사용자 정의 생성자(매개변수O)가 없을 경우
		System.out.println("빈 자식 생성자 - 인스턴스 생성");
	}
	
	Cat(String name) {
		super(name);
		// super()는 부모 클래스의 생성자를 가져오는 키워드
		// : 부모 클래스 내에 정의된 생성자 형태 그대로를 사용
		// >> 여러 개의 생성자가 있는 경우(오버로딩) super의 형태도 다양할 수 있음
		
		// this.name = name;
	}
	
	void displayCat() {
		// 해당 클래스가 가진 인스턴스 변수에 접근: this
		// >> 생략 가능(지역 변수와 충돌나지 않는 경우)
		System.out.println("자식 이름: " + name);
		System.out.println("자식 이름: " + this.name);
		
		// 부모 클래스가 가진 인스턴스 변수에 접근: super
		// >> 생략 불가!!
		System.out.println("부모 이름: " + super.name);
		
		// cf) super
		//		: 부모 클래스로 생성된 객체 그 자체
		//		> 부모 클래스 내의 필드와 메서드에 접근(.연산자)
		//		  super.필드명 / super.메서드명()
		//		  super();: 부모 클래스 내의 생성자 호출
	}
}

public class C_Inheritance {
	public static void main(String[] args) {
		Cat cat1 = new Cat();
//		빈 부모 생성자 - 인스턴스 생성
//		빈 자식 생성자 - 인스턴스 생성
		
		Cat cat2 = new Cat("나비");
		System.out.println(cat2.name); // 나비
		cat2.displayCat();

		cat2.displayMammal(); // 나비
	}
}
