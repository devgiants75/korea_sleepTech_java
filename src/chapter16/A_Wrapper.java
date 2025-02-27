package chapter16;

// === Wrapper 클래스 === //
// : 기본 데이터 타입을 객체로 다루기 위해 사용

// cf) 기본 데이터 타입
//		byte, short, int, long, float, double, char, boolean, void(메서드 반환)
//		>> 각 데이터 타입에 해당하는 Wrapper 클래스가 존재

// - java.lang 패키지에 정의
//		: 컬렉션 프레임워크에서는 내부에 객체만을 저장
//			>> 기본 데이터 타입의 저장을 Wrapper 클래스로 변환하여 저장

// Byte, Short, Integer, Long, Float, Double, Character, Boolean, Void

// == 박싱(Boxing) & 언박싱(UnBoxing) == //
// : 기본 타입과 해당 타입의 Wrapper 클래스 간의 자동 변환
// - 자바 컴파일러가 자동 처리

// 1) 박싱
// : 기본 >> Wrapper 클래스의 객체로 변환하는 과정

// 2) 언박싱
// : Wrapper >> 기본 타입으로 변환하는 과정

// +) 장단점
// 장점: 기본 타입과 객체 타입 간의 호환이 용이
// 단점
//		- 객체 생성 과정에서 메모리 사용량 증가(박싱, 언박싱 과정에서 성능 저하)
//		- null 값이 할당될 수 있는 Wrapper 객체를 언박싱할 경우 NullPointerException 발생 위험
public class A_Wrapper {
	public static void main(String[] args) {
		// 1) 박싱
		int i = 5;
		Integer iObject = i;
		System.out.println(iObject); // 5
		
		// 2) 언박싱
		Integer integerValue = new Integer(15);
		int iValue = integerValue;
		System.out.println(iValue); // 15
	}
}
