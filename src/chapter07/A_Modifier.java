package chapter07;

// cf) 자바 패키지 또는 클래스 파일 간의 코드 연결
// : import 문을 사용

// 1) 같은 패키지 내: import 클래스파일명;
// 2) 다른 패키지 내: import 패키지명.클래스파일명;
//import otherPackage.OtherClass;
//import otherPackage.PublicClass;

import otherPackage.*;
// : * 기호는 전체를 의미
// - 다만, 프로그램의 향상성을 위해 권장하지 않음

// == 접근 제어자(제한자) == //
// : 클래스, 변수, 메서드의 접근 범위를 제어
// - 외부로부터 데이터를 보호, 객체 간의 의존성을 최소화하는 역할
// - 코드의 보안성을 향상, 캡슐화 구현

// 1. 접근 제어자 종류
// : public, (default), protected, private
// - 생략 시 default 값 지정

// cf) 클래스 자체에 접근 제어자 사용 X
// : 중첩 클래스가 아닌 경우 명시적인 접근제어자 사용 X
// >> 클래스 파일의 경우 작성 가능
class Modifier {}

// 2. 접근 제어자 범위
// public > protected > (default) > private

// 1) private
// : 같은 클래스 내에서만 접근 가능
class PrivateClass {
	private int myField;
	private void myMethod() {
		System.out.println(myField); // PrivateClass 내부에서만 사용 가능
	}
}

// 2) (default)
// : 같은 패키지 내라면 접근 가능
// - 패키지 외부에서는 접근 불가능
class DefaultClass {
	int myField;
	void myMethod() {}
}

// 3) protected
// : 동일한 패키지 내의 모든 클래스에서 접근 가능
// : 다른 패키지에 있는 경우, 해당 클래스를 상속받은 하위 클래스에서만 접근 가능
class ProtectedClass extends OtherClass {
	
	// String otherField;
	
	ProtectedClass() {
		// 상속받은 부모 클래스의 필드 & 메서드
		System.out.println(otherField);
		otherMethod(); //
	}
}

class NotProtectedClass {
	public NotProtectedClass() {
		// 클래스 내부의 속성 사용이라 할지라도 protected 접근 제어자는
		// : 상속받지 않는 경우 외부 패키지에서 접근 불가!
		
		// System.out.println(OtherClass.otherField);
		// OtherClass.otherMethod();
	}
}

// 4) public 
// : 클래스나 패키지의 위치와 상관없이 접근 가능

public class A_Modifier {
	
	public class Modifier {} // 중첩 클래스: 접근 제어자 사용 제한 X
	
	public static void main(String[] args) {
		PrivateClass privateClass = new PrivateClass();
		// privateClass.myField;
		// privateClass.myMethod();
		// : 접근제어자는 가시성을 나타냄
		// - 해당 클래스(PrivateClass) 내부에서만 접근 가능
		
		DefaultClass defaultClass = new DefaultClass();
		System.out.println(defaultClass.myField); // 0 - 타입의 기본값으로 초기화
		defaultClass.myField = 10;
		defaultClass.myMethod();
		
		ProtectedClass protectedClass = new ProtectedClass();
		// protectedClass.myField = "다른 패키지의 필드값 변경";
		
		PublicClass publicClass = new PublicClass();		
		System.out.println(publicClass.publicField);
		publicClass.publicMethod();		
	}
}