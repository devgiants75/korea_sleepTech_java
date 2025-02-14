package chapter04;

public class Z_reference {
	public static void main(String[] args) {
		// 참조 자료형
		// : 데이터값이 저장되는 heap 메모리의 주소를 변수에 담는 자료형
		
		// 1. 객체와 배열
		// : System.out.println() 출력 시 메모리 주소가 출력
		// : 객체와 배열의 toString() 메서드의 경우
		//		>> '배열의 클래스 타입(I - int) + @ + 해시코드' 반환
		//		>> '객체의 클래스명 + @ + 해시코드' 반환
		
		int[] numbers = {1, 2, 3};
		System.out.println(numbers); // [I@2f92e0f4
		
		String[] strings = {"안녕"};
		System.out.println(strings); // [Ljava.lang.String;@28a418fc
		
		// 2. 문자열(String)
		// : toString() 메서드가 문자열 자체를 반환하도록 설정 (오버라이딩)
//	    public String toString() {
//	        return this; - 문자열 값 자체를 반환
//	    }
		
		String str = "Hello";
		System.out.println(str); // Hello
		
		Object object = "Hello";
	}
}