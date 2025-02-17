package chapter06;

// == 오버라이딩(Overriding) == //
// : 자식 클래스가 부모 클래스에서 상속받은 '메서드'를 자신의 상황에 맞게 '재정의'
// - 상속 관계에 있는 클래스들 사이에서 사용
// - 부모 클래스의 기본 동작을 자식 클래스에서 변경하거나 확장할 때 사용

class ParentClass {
	void exercise() {
		System.out.println("달리기를 잘합니다.");
	}
}

class ChildClass extends ParentClass {
//	void exercise() {
//		System.out.println("달리기를 잘합니다.");
//	}
	
	// @Override
	// : 자바에서 제공하는 코드 어노테이션(annotation, 주석)
	// > 부모 클래스의 메서드를 자식 클래스에서 재정의!했다는 것을 명시적으로 나타냄
	
	// cf) @Override 를 생략해도 오류가 나지 않는 이유!
	//		: 자바 컴파일러가 메서드 시그니처(이름, 매개변수, 반환타입)을 비교하여
	//			부모 클래스의 메서드를 자식 클래스에서 재정의했는지 판단
	
	// >> 상속받은 메서드명과 동일한 메서드를 자식 클래스에서 정의하는 경우
	//		: 자동으로 재정의임을 판단
	@Override
	void exercise() {
		System.out.println("달리기도 잘하고 피구도 잘합니다.");
	}
}

public class D_Overriding {
	public static void main(String[] args) {
		ChildClass childClass = new ChildClass();
		childClass.exercise(); // 달리기를 잘합니다.

	}
}
