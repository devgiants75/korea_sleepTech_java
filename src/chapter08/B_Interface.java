package chapter08;

// == 인터페이스(interface) == //
// : 객체가 어떤 방식으로 동작해야 하는지 정의하는 추상 타입
// - 추상 메서드와 상수만 포함된 특수한 클래스
// - 모든 메서드는 추상 메서드 
// - 상수는 public static final 특성을 가짐
// >> 실제 구현은 인터페이스를 구현한 클래스에서 담당!

// 1. 인터페이스 특징
// 1) 메서드: 모든 메서드는 public abstract 으로 선언!
// 2) 변수(필드): 모든 변수는 public static final 로 선언!
// >> 키워드 생략 가능

// +) 다중 구현을 지원
//		: 한 클래스에서 여러 인터페이스를 동시에 구현 가능
// >> 객체의 행동을 정의하는 역할

// 2. 인터페이스 구현 방법
// : interface 키워드를 사용
// - interface 인터페이스명 {}

interface PlayingCard {
	// cf) 멤버
	// 클래스, 인터페이스의 멤버: 필드, 메서드
	
	// 1. 멤버 변수: 상수 선언
	// : public static final 특성을 가짐 (생략 가능)
	public static final int SPADE = 4;
	public static int DIAMOND = 3;
	public final int HEART = 2;
	int CLOVER = 1;
	
	// 2. 멤버 변수: 메서드 
	// : public abstract 특성을 가짐 (생략 가능)
	public abstract String getCardNumber();
	String getCardKind();
	
	// 3. 디폴트 메서드
	// : 인터페이스에서 새 기능 추가하면서 기존 구현을 포함
	// > 기본 구현 제공, 오버라이딩(재정의) 가능
	default void defaultMethod() {
		// default 반환타입 메서드명() {}
		System.out.println("디폴트 메서드입니다.");
	}
	
//	void defaultMethod2() {
//		System.out.println("default 키워드 생략 불가");
//	}
	
	// 4. 정적 메서드
	// : 인터페이스에서 직접 구현
	// > 인터페이스 이름으로 직접 호출, 오버라이딩 불가능!(객체 인스턴스 없이 사용)
	// > 인터페이스와 관련된 공통 동작(유틸리티) 메서드를 제공하기 위해 사용
	static void staticMethod() {
		System.out.println("정적 메서드입니다.");
	}
}

// interface 구현 방법
// class 클래스명 implements 인터페이스명 {}
class Card implements PlayingCard {
	
	private String cardNumber;
	private String cardKind;
	
	Card(String cardNumber, String cardKind) {
		this.cardKind = cardKind;
		this.cardNumber = cardNumber;
	}
	
	// cf) 인터페이스 안의 추상 메서드를 구현한 클래스 메서드는 public 지정
	public String getCardNumber() {
		return cardNumber;
	}
	
	public String getCardKind() {
		return cardKind;
	}
	
	// 디폴트 메서드 재정의
	@Override
	public void defaultMethod() {
		System.out.println("Card 클래스에서 재정의 된 디폴트 메서드");
	}
}

public class B_Interface {
	public static void main(String[] args) {
		Card card = new Card("7", "HEART");
		
		System.out.println(card.getCardNumber());
		System.out.println(card.getCardKind());
		
		// 재정의(오버라이딩) 선택적
		card.defaultMethod(); // Card 클래스에서 재정의 된 디폴트 메서드
		
		// card.staticMethod();
		// : 인터페이스의 static 메서드는 반드시! 인터페이스명으로 호출!
		PlayingCard.staticMethod(); // 정적 메서드입니다.
		
		// 인터페이스 필드(상수) 사용
		System.out.println(PlayingCard.CLOVER);
		System.out.println(PlayingCard.DIAMOND);
		System.out.println(PlayingCard.HEART);
	}
}

// == 추상 클래스 VS 인터페이스 == //
// 1) 추상 클래스
// : 공통적인 기능을 제공하는 '부분적 구현'
// - 구성 요소: 추상 메서드, 구체 메서드, 필드, 생성자 - 객체를 직접 생성은 불가(new 키워드 X)
// - 단일 상속만! 가능(extends, 확장하다)
// > 기본 구현을 제공 & 확장 가능

// 2) 인터페이스
// : 클래스의 행동을 정의
// - 구성 요소: 추상 메서드, 상수, 디폴트 메서드, 정적 메서드
// - 다중 구현 가능 (implements, 구현하다)
// > 객체가 해야 할 동작(행위)을 정의