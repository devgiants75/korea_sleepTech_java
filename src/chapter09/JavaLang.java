package chapter09;

// java.lang 패키지
// : 자바 프로그램의 가장 기본적인 클래스들을 포함
// - 별도의 import 없이 사용 가능

// 1) Object 클래스
// : 자바의 모든 클래스의 최상위 클래스
// - 모든 클래스는 Object 클래스를 상속받음

// 2) Math 클래스
// : 수학 연산 및 함수를 제공하는 클래스
// - 모든 필드와 메서드는 static!

// 3) String 클래스
// : 문자열 조작을 위한 다양한 메서드를 제공

class MyClass extends Object {
	private int id;
	private String name;
	
	MyClass(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	// 1) toString() 메서드
	// : 객체의 문자열 표현을 반환
	// - 기본 구현: '객체의 클래스 이름 + @ + 메모리 주소' 반환
	// - 오버라이딩(재정의): 원하는 정보 반환
	@Override
	public String toString() {
		return "MyClass(ID: " + id + " / NAME: " + name + ")";
	}
	
	String displayInfo() {
		return "ID: " + id + " / NAME: " + name;
	}
	
	// 2) equals(Object obj) 메서드
	// : 두 객체가 동등한지 비교
	// - 두 객체의 참조를 비교 (동일한 주소값을 가지는지 확인)
}

public class JavaLang {
	public static void main(String[] args) {
		
		System.out.println("=== Object 클래스 ===");
		MyClass myClass1 = new MyClass(1, "이승아");
		System.out.println(myClass1); 
		// MyClass(ID: 1 / NAME: 이승아)
		// : 객체를 출력하는 경우 자동으로 toString() 호출 - 생략 가능
		System.out.println(myClass1.toString());
		
		System.out.println(myClass1.displayInfo()); // ID: 1 / NAME: 이승아
		
		MyClass myClass2 = new MyClass(2, "이도경");
		System.out.println(myClass1.equals(myClass2)); // false
		
		MyClass myClass3 = myClass1;
		System.out.println(myClass1.equals(myClass3)); // true
		
		String s1 = "이승아";
		String s2 = "이승아";
		System.out.println(s1.equals(s2)); // true
		// : 문자열의 equals()메서드는 두 문자열의 내용(값)을 비교 
		
		System.out.println("=== Math 클래스 ===");
		// Math 클래스는 모든 필드와 메서드가 static
		System.out.println(Math.abs(-10)); // 절대값 반환: .abs(데이터) - absolute value
		System.out.println(Math.max(10, 20)); // 최대값 반환: .max(데이터1, 데이터2)
		System.out.println(Math.min(10, 20)); // 최소값 반환
		System.out.println(Math.sqrt(16)); // 제곱근 반환
		System.out.println(Math.sqrt(25)); 
		System.out.println(Math.pow(2, 3)); // 제곱 값 반환: .pow(a, b): a의 b제곱
		System.out.println(Math.random());
		// : 무작위 난수를 생성: .random() - 0.0 이상 0.1 미만의 난수를 생성
		
		System.out.println("=== String 클래스 ===");
		String message = "Merry Christmas!";
		
		System.out.println(message.length()); // 16 - 문자 뿐만 아니라 공백, 기호까지 포함
		
		boolean isEquals = message.equals("Merry Christmas^^");
		System.out.println(isEquals); // false
		
		// substring(int start, int end)
		// : 시작 인덱스(포함)부터 끝 인덱스(미포함)까지의 부분 문자열을 반환
		// - 문자열 인덱스 번호는 0부터 시작, 공백과 기호까지 포함
		System.out.println(message.substring(6, 15)); // Christmas
		
		System.out.println(message); // 문자열은 불변성(immutable) 데이터
		
		// indexOf(String str)
		// : 문자열에서 특정 문자열의 첫 번째 위치를 반환
		int index = message.indexOf("Christmas");
		System.out.println(index); // 6
		
		// charAt(int index)
		char c = message.charAt(6);
		System.out.println(c); // C
	}
}
