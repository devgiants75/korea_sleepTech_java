package chapter16.review;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

class MethodRef {
	// 정적 메서드 참조
	static void printUpperCase(String str) {
		System.out.println(str.toUpperCase());
	}
	
	// 인스턴스 메서드 참조
	void printLowerCase(String str) {
		System.out.println(str.toLowerCase());
	}
}

// 특정 객체의 인스턴스 참조
class Calculator {
	int add(int a, int b) {
		return a + b;
	}
}

public class C_Method_Ref {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("apple", "mango", "banana");
		
		// 1. 정적 메서드 참조 >> 클래스명::정적메서드명
		fruits.forEach(MethodRef::printUpperCase);
		
		// 2. 인스턴스 메서드 참조 >> 인스턴스명::인스턴스메서드명
		List<String> fruits2 = Arrays.asList("APPLE", "MANGO", "BANANA");
		MethodRef methodRef = new MethodRef();
		fruits2.forEach(methodRef::printLowerCase);
		
		// 3. 특정 인스턴스의 메서드 참조
		// Function<T, R>: 하나의 인자를 다른 타임으로 변환시키는 함수형 인터페이스
		// BiFunction<T, U, R>
		// : 2개의 인자를 받고 1개의 객체를 리턴시키는 함수형 인터페이스
		Calculator calc = new Calculator();
		BiFunction<Integer, Integer, Integer> addtion = calc::add;
		int result = addtion.apply(5, 3);
		int result2 = addtion.apply(15, 13);
		System.out.println(result); // 8
		System.out.println(result2); // 28
	}
}
