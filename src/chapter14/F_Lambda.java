package chapter14;

import java.util.function.Function;
import java.util.function.Supplier;

// 메서드 참조(:: 연산자)
// : 람다 표현식을 더 간결하게 작성할 수 있도록 지원하는 문법
// - 단순히 메서드 호출만 하는 경우

// 1. 정적 메서드 참조
// - 객체(인스턴스) 생성 없이 사용할 수 있는 메서드
// - ClassName::staticMethod
class StaticMethodRef {
	// 정적 메서드: 인스턴스 없이 바로 사용 가능
	static int doubleValue(int x) {
		return x * 2;
	}
}

// 2. 인스턴스 메서드 참조
// - 객체(인스턴스)를 반드시 생성하여 사용하는 메서드
// - instance::instanceMethod

// 3. 생성자 참조
// - 새로운 객체를 만들 때 사용
// - ClassName::new
class Person {
	private String name;
	
	public Person() {
		this.name = "이름 미상";
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() { return name; }
}

// 4. 임의 객체 인스턴스 메서드 참조
// : 특정 객체가 아닌 여러 객체에 공통된 인스턴스 메서드를 사용할 때
// - ClassName::instanceMethod

public class F_Lambda {
	public static void main(String[] args) {
		Supplier<String> sayHello = () -> "안녕";
		System.out.println(sayHello.get()); // 안녕

		// 1. 정적 메서드 참조
		// 1) 람다 표현식
		Function<Integer, Integer> doubleLambda = x -> StaticMethodRef.doubleValue(x);
		// 2) 메서드 참조
		Function<Integer, Integer> doubleLambdaRef = StaticMethodRef::doubleValue;
		
		System.out.println(doubleLambda.apply(5));
		System.out.println(doubleLambdaRef.apply(10));
		
		// 2. 인스턴스 메서드 참조
		
		// 문자열 객체의 메서드를 사용
		// : Object를 상속받는 String 클래스로 만들어진 참조 자료형 변수
		// 		>> String 클래스 내부의 인스턴스 메서드를 인스턴스인 hello에서 호출 가능
		String hello = "Hello";
		
		// 1) 람다 표현식
		Supplier<String> toUpperLambda = () -> hello.toUpperCase();
		// 2) 메서드 참조
		Supplier<String> toUpperLambdaRef = hello::toUpperCase;
		
		System.out.println(toUpperLambda.get());
		System.out.println(toUpperLambdaRef.get());
		
		// 3. 생성자 참조
		// 1) 람다 표현식
		Supplier<Person> personLambda = () -> new Person("이승아");
		// 2) 메서드 참조
		// : 매개변수가 없는 생성자일 경우에만 활용 가능
		Supplier<Person> personLambdaRef = Person::new;
		
		Person p1 = personLambda.get();
		Person p2 = personLambdaRef.get();
		
		System.out.println(p1.getName()); // 이승아
		System.out.println(p2.getName()); // 이름 미상
		
		
		
		
		
		
		
		
	}
}
