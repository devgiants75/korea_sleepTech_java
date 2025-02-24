package chapter13;

// === Singleton 패턴 === //
// : 소프트웨어 설계 패턴 중 하나
// - 클래스의 인스턴스가 하나만 생성되도록 보장
// - 해당 클래스의 인스턴스에 전역적 접근은 제공하지만 일관된 상태를 유지

// 1) 사용 목적
// - 객체의 유일성을 보장
// - 자원의 절약

// 2) 장단점
// - 장점
//		: 자원의 중복 생성을 방지 > 메모리 사용 최적화
//		: 전역 상태 공유 + 통제된 접근
// - 단점
//		: 전역 상태 관리 + 다른 클래스에 영향 (결합의 가능성)
// 		: 테스트가 어려움

// 3) 사용 방법
class Singleton {
	// 필드값: static - 인스턴스화 없이 호출 가능 & 자원이 하나의 값을 가짐
	private static Singleton instance;
	
	// 생성자: private
	// - 외부에서 직접적인 인스턴스화 불가
	private Singleton() {};
	
	// 싱글톤 패턴의 전역 접근성을 제공하는 메서드 정의 (인스턴스화 담당)
	public static Singleton getInstance() {
		// 주로 getInstance 메서드명을 사용
		if (instance == null) {
			// 필드에 초기화 이전 >> 아직 인스턴스화 X
			instance = new Singleton(); // 인스턴스를 진행
		}
		
		return instance; 
		// 1) if 조건문이 true라면 인스턴스화 된 객체를 반환
		// 2) if 조건문이 false라면 기존의 필드에 객체를 반환
		
		// >> 객체는 반드시 단 하나!!
	}
}

public class D_Singleton {
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
