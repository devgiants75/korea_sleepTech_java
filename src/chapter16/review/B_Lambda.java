package chapter16.review;

import java.util.Arrays;
import java.util.List;

// == 람다 표현식 == //
// : 함수형 프로그래밍 표현식 >> 익명 클래스를 간결하게 표현

interface AnimalInterface {
	void speak();
}

// speak 추상 메서드를 이름없이 구현
// (매개변수) -> { 실행할 코드(구현부) }

// 1. 매개변수, 반환값 모두 없는 람다
// () -> System.out.println("Hello Lambda");

// 2. 매개변수가 하나인 람다
// x -> x * x;

// 3. 매개변수가 두개 이상인 람다
// (a, b) -> a + b;

// 4. 실행문이 두 줄 이상인 람다: 중괄호 생략 불가!, return 키워드를 사용해 값을 반환
// (x, y) -> {
//		int result = x + y;
//		System.out.println("Sum: " + result);
//		return result;
// }
public class B_Lambda {
	public static void main(String[] args) {
		// @FunctionInterface
		// : 하나의 추상 메서드만을 가지는 인터페이스
		
		List<String> list = Arrays.asList("apple", "orange", "banana");
		
		// .sort(): List를 정렬하는 메서드
		
		// a.compareTo(b): a와 b 두 개의 값을 비교해서 같을경우 0, 오름차순 정렬(양수), 내림차순(음수)
		list.sort((a, b) -> a.compareTo(b));
		System.out.println(list); // [apple, banana, orange]
		
		// 일반 람다식 
		list.forEach(name -> System.out.println(name));
		// 메서드 참조
		list.forEach(System.out::println);
	}
}
