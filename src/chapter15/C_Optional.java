package chapter15;

import java.util.Optional;
/*
 * === Optional 클래스 ===
 * : 값이 존재할 수도 있고, 없을 수도 있는 객체를 감싸는 컨테이너 (자바 8 이후)
 * - null 값을 다룰 때 발생하는 NullPointerException(NPE) 문제를 줄이고
 * 		, 명시적으로 값의 유무를 처리하도록 설계
 * 
 * 1. Optional 클래스
 * : null이 아닌 값을 포함하거나, 값이 없는 상태를 나타낼 수 잇음
 * - 값을 명시적으로 검사하고 처리하는 방식
 * */

public class C_Optional {
	public static void main(String[] args) {
		// 2. Optional 생성 방법
		// 1) .of() 메서드
		//		: null이 아닌 값을 감싸는 메서드
		//		- null 전달 시 NPE 발생
		
		Optional<String> optional1 = Optional.of("Hello Optional!");
		// Optional<String> optional2 = Optional.of(null); // NullPointerException
		
		// 2) .ofNullable() 메서드
		//		: null일 수도 있는 값을 감싸는 메서드
		//		- null 전달 시 빈 Optional 객체를 반환
		Optional<String> optional3 = Optional.ofNullable(null);
		
		// 3) .empty() 메서드
		//		: 빈 Optional 객체를 생성
		Optional<String> optional4 = Optional.empty();
		
		// 3. Optional의 주요 메서드
		// 1) 값이 있는지 확인
		// - isPresent()
		//		: 존재 할 경우(true), 존재하지 않을 경우(false) 
		
		// - isEmpty()
		//		: 존재 할 경우(false), 존재하지 않을 경우(true)
		
		System.out.println(optional1.isPresent()); // true
		System.out.println(optional1.isEmpty()); // false
		
		System.out.println(optional3.isPresent()); // false
		System.out.println(optional3.isEmpty()); // true
		
		
		
		
	}
}
