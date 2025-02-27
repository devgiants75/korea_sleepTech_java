package chapter16;

/*
 * === ENUM(열거형) 자료형 ===
 * : 서로 관련된 상수들의 집합을 표현하는 데 사용
 * - 서로 유기적인 관계성을 가짐, 자바의 클래스로 취급
 * - 특정 값들만 가질 수 있도록 제한하는데 사용
 * 
 * cf) static final 
 * */

// Enum 선언 방법
// enum 키워드를 사용 - enum Enum명 { }
// : 명명 규칙 >> 클래스와 동일
// : 중괄호 내에서 열거할 데이터를 ,로 구분하여 나열

enum Fruits {
	// final의 특징을 살려 enum 내부의 데이터는 UPPER_SNAKE_CASE 사용
	APPLE, BANANA, ORANGE
}

enum CoffeeSize {
	SMALL(200), MEDIUM(300), LARGE(400); // 각 필드는 CoffeeSize(Enum)과 대등
	// >> 생성자 호출
	
	private final int ml;
	
	CoffeeSize(int ml) {
		this.ml = ml;
	}
	
	public int getMl() { return ml; }
}

public class B_Enum {
	public static void main(String[] args) {
		// 클래스의 static fianl 필드처럼 쓰임: 각 상수는 정의된 Enum 타입으로 간주
		Fruits apple = Fruits.APPLE; 
		System.out.println(apple); // APPLE
		
		// == ENUM의 주요 메서드 ==
		// 1) values(): 열거형의 모든 값을 배열로 반환
		int[] numbers = {1, 2, 3, 4, 5};
		System.out.println(numbers);
		System.out.println(Fruits.values()); // [Lchapter16.Fruits;@3feba861
		
		for (Fruits fruit: Fruits.values()) {
			System.out.println(fruit);
		}
		
		// 2) names(): Enum 상수의 이름을 문자열로 반환
		String appleName = Fruits.APPLE.name();
		System.out.println(appleName.toLowerCase());
		
		// 3) valueOf(String name): 문자열로 Enum 상수를 반환
		// : 잘못된 문자열을 보낼 경우 IllegalArgumentException 발생
		
		Fruits orange = Fruits.valueOf("ORANGE");
		// 4) ordianl(): Enum 상수의 순서를 반환(0부터 시작)
		System.out.println(orange.ordinal()); // 2
		
		// == CoffeeSize ==
		CoffeeSize size = CoffeeSize.MEDIUM;
		System.out.println(size + "'s ml: " + size.getMl() + "ml"); // MEDIUM's ml: 300ml
				
		CoffeeSize authorSize = CoffeeSize.LARGE;
		System.out.println(authorSize + "'s ml: " + authorSize.getMl() + "ml");
		// LARGE's ml: 400ml
	}
}