package chapter14;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// == 람다식 == //
// : 함수형 인터페이스를 간결하게 구현하는 코드식

// == 함수형 인터페이스 == //
// : 자바의 함수형 인터페이스
// - 딱 한가지 일을 처리하는 메서드를 모아놓은 패키지

// 1. Predicate<T>(판단하다)
// : 입력 값을 받아 조건을 검사하는 데 사용
// : 메서드
//		- boolean test(T t): 주어진 입력 값이 조건을 만족하면 true / 그렇지 않으면 false 반환
//		- and(Predicate other), or(Predicate other), negate(): Predicate 조합에 사용

// cf) negate(부정하다): 현재의 결과를 역전

// 2. Function<T, R>(실행하다)
// : 입력 값을 받아 특정 연산을 수행한 후 결과를 반환
// : 메서드
//		- R apply(T t): 입력값을 받아 변환한 값을 반환
//		- andThen(Function after): 현재 결과를 다른 Function의 입력으로 연결
//		- compose(Function before): 다른 Function의 결과를 현재 입력으로 연결

// 3. Consumer<T>(소비하다)
// : 입력 값을 받아 소비(출력 또는 상태 변경)하는 데 사용
// : 메서드
//		- void accept(T t): 입력값을 소비
//		- andThen(Consumer after): 연속적인 소비 작업을 위해 사용

// 4. Supplier<T>(공급하다)
// : 값을 공급(생성)하는 데 사용, 입력 값이 필요로 하지 X
// : 외부에서 값을 가져오거나, 데이터를 생성하여 반환하는 역할
// : 메서드
//		- T get(): 반환

public class E_Lambda {
	public static void main(String[] args) {
		// == Predicate == //
		System.out.println("== Predicate ==");
		// 인터페이스<타입,,,> 메서드명 = (매개변수,,,) -> 실행문;
		
		Predicate<Integer> isEven = n -> n % 2 == 0;
		Predicate<Integer> isPositive = n -> n > 0;
		
		/*
		 * @FunctionalInterface
		 * interface Predicate<T> {
		 * 		boolean test(T t);
		 * } 
		 * */
		
		// 기본 조건 검사
		System.out.println(isEven.test(10)); // true
		System.out.println(isPositive.test(-10)); // false
		
		// 짝수이면서 양수인 경우를 검사
		Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
		System.out.println(isEvenAndPositive.test(4)); // true
		System.out.println(isEvenAndPositive.test(-4)); // false
		
		// == Function == //
		System.out.println("== Function ==");
		
		/*
		 * @FunctionalInterface
		 * interface Function<T, R> {
		 * 		R apply(T t);
		 * }
		 * */
		Function<String, Integer> stringLength = s -> s.length();
		Function<Integer, Integer> square = n -> n * n;
		Function<String, String> upperString = s -> s.toUpperCase();
		
		System.out.println(stringLength.apply("이도경 메롱"));
		System.out.println(upperString.apply("nice to meet you"));
		
		Function<String, Integer> lengthAndSquare = stringLength.andThen(square);
		// : 문자열의 길이(숫자)값을 인자로 받아 계산
		System.out.println(lengthAndSquare.apply("이 문자열 길이의 제곱값은?"));
		
		
	
		// == Consumer == //
		System.out.println("== Consumer ==");
		
		/*
		 * @FuntionalInterface
		 * interface Consumer<T> {
		 * 		void accept(T t);
		 * }
		 * */
		Consumer<String> printMessage = msg -> System.out.println(msg);
		Consumer<String> printLength = msg -> System.out.println(msg.length());
		
		printMessage.accept("안녕하세요 :)");
		printLength.accept("1234567"); // 7
		
		Consumer<String> combinedConsumer = printMessage.andThen(printLength);
		combinedConsumer.accept("123"); // 3
		
		// == Supplier == //
		System.out.println("== Supplier ==");
		
		/*
		 * @FunctionalInterface
		 * interface Supplier<T> {
		 * 		T get();
		 * }
		 * */
		
		// Math.random(): 0.0과 1.0 사이의 무작위 실수를 반환
		Supplier<Double> randomValue = () -> Math.random();
		System.out.println(randomValue.get());
		
		// == Map 활용 람다식 == //
		Map<String, Integer> scores = new HashMap<>();
		scores.put("이승아", 90);
		scores.put("이도경", 100);
		scores.put("이지희", 95);
		
		scores.forEach((name, score) -> System.out.println(name + ": " + score));
	}
}