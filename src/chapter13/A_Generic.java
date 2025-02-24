package chapter13;

// == 제네릭(Generic, 일반적인) == //
// : 데이터의 타입(type)을 '일반화'하는 것
// - 클래스나 메서드의 데이터 타입을 미리 지정하지 않고, 
//		구체적인 타입은 사용 시점에 지정할 수 있도록 하는 기능
// - 특정 타입에 의존하지 않고 다양한 타입을 지원하는 설계 가능

// 1. 제네릭 주요 장점
// - 타입 안정성
// - 코드 재사용성
// - 가독성

// 2. 제네릭 사용 방법
// 1) 제네릭 클래스

/*
	cf) 타입 변수
		: 주로 <T> 형태로 사용 (Type: 타입), 이후에는 다음 알파벳값을 주로 사용(U, V 등)
		- 해당 기능 사용 시 작성되는 실질적인 타입이 타입 변수에 전달되어 사용 
		
	class 클래스명<제네릭타입> {
		- 제네릭 타입을 사용하여 필드, 생성자, 메서드 정의
	}
*/

class Pair<K, V> { // K: key, V: value
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() { return key; }
	public V getValue() { return value; }
	
	// 2) 제네릭 메서드
	// [접근제한자] <제네릭 타입> 반환타입 메서드명(매개변수...) { 구현부 }
	// : 메서드 호출 시 전달된 타입에 따라 메서드 내부의 타입변수 값이 결정됨
	static <T> void print(T value) {
		System.out.println(value);
	}
}

public class A_Generic {
	public static void main(String[] args) {
		// == 제네릭 클래스 사용 방법 == //
		// 클래스명<제네릭 타입> 인스턴스명 = new 클래스명<>();
		
		// cf) 제네릭 타입 명시는 필수 X
		//		: 제네릭 타입의 구조에 값이 들어올 경우 해당 값으로 타입을 자동 유추
		
		Pair<Integer, String> pair1 = new Pair<>(123, "안녕하세요"); // 인자값으로 타입을 자동 유추
		Pair<Integer, String> pair2 = new Pair<Integer, String>(123, "안녕하세요");
		// 좌항의 클래스타입에는 타입 명시
		
		// cf) 제네릭 타입의 경우 클래스 형식의 참조 자료형을 사용
		// : Wrapper 자료형
		// - int >> Integer
		// - char >> Character
		
		System.out.println(pair1.getValue()); // 안녕하세요
		System.out.println(pair1.getKey()); // 123
		
		Pair<String, Integer> pair3 = new Pair<>("문자열", 321);
		
		System.out.println(pair3.getValue()); // 321
		System.out.println(pair3.getKey()); // 문자열
		
		// == 제네릭 메서드 사용 방법 == //
		// <제네릭 타입>메서드명();
		Pair.<String>print("안녕"); // 안녕
		
		// Pair.<Integer>print("안녕");
		// The parameterized method <Integer>print(Integer) of type Pair is not applicable for the arguments (String
		
		Pair.<Integer>print(500); // 500
	}
}
