package chapter10;

import java.util.HashSet;
import java.util.Set;

// == Set 인터페이스 == //
// : 중복 X, 순서 X
// - 중복된 요소를 포함하지 않는 객체의 집합
// - 객체가 저장 순서를 저장하지 않음 (삽입 순서 유지 X)
// - null 요소 포함 가능

// cf) List 인터페이스: 중복 O, 순서 O, null 요소 포함 가능

// == Set 컬렉션 종류 (구현체) == //
// 1. HashSet
// : 가장 많이 사용되는 Set 구현체
// - 빠른 데이터 접근, 삽입을 지원
// - 정렬 또는 순서 보장 X

// 2. LinkedHashSet
// : HashSet + 순서 (HashSet의 기능 확장 형태)
// - 중복 X, 순서 O

// 3. TreeSet
// : 데이터가 자동 정렬, 중복 제거와 정렬된 순서 유지가 필요할 경우
// - 중복 X, 순서 O

public class D_Set {
	public static void main(String[] args) {
		// == Set 컬렉션의 주요 메서드 == //
		// : add(), remove(), contains(), size(), isEmpty()
		
		// Set 컬렉션 선언 방법
		// Set<타입> set명 = new Set컬렉션종류<>();
		Set<String> programming = new HashSet<>();
		
		programming.add("자바");
		programming.add("파이썬");
		programming.add("C++");
		programming.add("자바스크립트");
		
		System.out.println(programming); // [C++, 파이썬, 자바, 자바스크립트]
		
		programming.add("자바");
		System.out.println(programming);
		
		boolean result = programming.remove("파이썬"); // remove: 제거 후 완료 여부 반환
		System.out.println(programming); // [C++, 자바, 자바스크립트]
		System.out.println(result); // true
		
		boolean falseResult = programming.remove("R");
		System.out.println(falseResult); // false
		
		System.out.println(programming.size()); // 3
		
		System.out.println(programming.contains("파이썬")); // false
		System.out.println(programming.contains("자바")); // true
		
		System.out.println(programming.isEmpty()); // false
		programming.clear();
		System.out.println(programming.isEmpty()); // true
	}
}
