package chapter13;

import java.util.ArrayList;
import java.util.List;

// 제네릭: 다양한 데이터 타입을 처리할 수 있는 틀

// 1) 타입 변수: 무엇을 담을 지 알려주는 표시
class Basket<T> {
	private T item;
	
	public void setItem(T item) {
		this.item = item;
	}
	
	public T getItem() {
		return item;
	}
}

// 2) 제네릭 와일드 카드
// : 제네릭의 타입을 불특정하게 지정할 때 사용
// - 주로 '상속관계'에 있는 클래스 간의 유연한 타입 처리를 위해 사용
// - 물음표(?) 기호를 사용하여 표기

class Message<T> {
	private T message;
	T getMessage() {
		return message;
	}
}

public class B_Generic {
	public static void main(String[] args) {
		Basket<String> stringBasket = new Basket<>(); // 글자를 담는 바구니
		stringBasket.setItem("사과");
		System.out.println(stringBasket.getItem()); // 사과
		
		Basket<Integer> integerBasket = new Basket<>(); // 숫자를 담는 바구니
		integerBasket.setItem(777);
		System.out.println(integerBasket.getItem()); // 777
		
		// == 제네릭 와일드 카드 ==
		// : 모든 타입이 지정 가능한 클래스 타입 
		// >> 최상위 클래스인 Object 타입을 사용
		
		// 형 변환
		// : Object 클래스는 모든 참조 타입의 최상위 클래스
		// - 모든 타입 클래스와 상속 관계
		
		Message<?> m1; // 모든 타입의 Message 객체를 수용
		Message<String> m2;
		
		m1 = new Message<>();
		String s = (String) m1.getMessage(); // 명시적 형 변환 (강제 형 변환)
		Boolean b = (Boolean) m1.getMessage();
		Character c = (Character) m1.getMessage();
		
		// == 일반 와일드 카드 == //
		
		// ? : 어떤 타입이든 허용
		// >> 와일드 카드의 구조체에 값을 할당하는 경우 컴파일러가 구체적인 타입을 확인할 수 없어 오류 발생
		List<?> list1 = new ArrayList<>();
		// list1.add(integerBasket);
		// list1.add("안녕");
		list1.add(null); // Object 값에는 반드시 null 값이 허용
		
		// == 제한적 와일드 카드 == //
		
		// == 1. 상한 제한 와일드 카드 == //
		// <? extends Type>
		// : "특정" 타입 또는 그 하위 타입만 허용 
		
		// >> 정수 혹은 정수의 하위 타입만 허용
		List<? extends Number> list2 = new ArrayList<Integer>();
		// list2.add(123); - 구체적인 숫자 값 추가 불가 (타입 안정성 보장 불가)
		
		// == 2. 하한 제한 와일드 카드 == //
		// <? super Type>
		List<? super Integer> list3 = new ArrayList<Number>();
		list3.add(123);
		list3.add(456); // Integer의 구체적인 타입 값을 지정 가능 (+ Integer 하위 타입까지 추가 가능)
		// list3.add(456.789);
		
		// cf) Number: 정수 + 실수를 모두 포함하는 숫자 값
		//		Integer: 정수만을 가지는 숫자 값
		// Number >>> Integer
	}
}
