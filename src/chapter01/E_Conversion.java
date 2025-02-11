package chapter01;

public class E_Conversion {
	public static void main(String[] args) {
		/*
			자바 형 변환 (Type Conversion)
			: 하나의 타입을 다른 타입으로 바꾸는 것
			
			자료형의 크기에 따른 변환 규칙
			byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
			- 메모리 설계 상 (오류로) 정수 타입보다 실수 타입이 더 큼
			
			char (2)
			boolean (1)
		*/
		
		// 1. 자동 형 변환 (묵시적)
		// : (작은 자료형을) 크기가 큰! 자료형으로의 변환
		byte smallBox = 10; // 1byte
		int bigBox = 10000; // 4byte
		
		// 큰 자료형 = 작은 자료형
		bigBox = smallBox;
		System.out.println(bigBox);
		
		
		
		
		
		
		
		
	}
}
