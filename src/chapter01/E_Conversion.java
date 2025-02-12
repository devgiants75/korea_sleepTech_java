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
		System.out.println(bigBox); // 10
		
		// >> 작은 범위의 타입을 큰 타입에 넣을 때, 컴파일러가 자동으로 형 변환을 수행!
		
		byte a = 32;
		short b = a;
		int c = b;
		long d = c;
		
		float e = d; // 4byte float에 8byte long 데이터 삽입이 가능
		
		// char f = e; (묵시적 형 변환 X)
		
		// 2. 강제 형 변환 (명시적)
		// : 크기가 작은! 자료형으로의 변환
		
		int number = 1234;
		float fNumber = number;
		
		float fNumber2 = 1234.123F;
		
		// 강제 형 변환: (작은 자료형 타입) 큰 데이터값;
		int number2 = (int)fNumber2;
		
		long aa = 32L;
		int bb = (int)aa;
		short cc = (short)bb;
		byte dd = (byte)cc;
		
		// == 문자(char) 자료형의 형 변환 == //
		
		// cf) 유니코드(Unicode)
		//		: 전 세계 모든 문자를 하나의 표준으로 표현하기 위한 문자 인코딩 방식
		//		- 모든 문자에 고유한 코드 값 부여
		//		- 이모지까지 포함 
		//		- UTF-8 (웹에서 사용하는 기본 인코딩 형식)❤
		
		// 영어권(아스키코드), 한국어(EUR-KR) 등 각 언어마다 상이
		
		// 1) char(문자)를 숫자로 변환
		//		: 문자의 유니코드 값으로 변환
		char letter = 'A';
		int ascii = letter; // 문자를 숫자로 변환
		
		System.out.println(ascii); // 65
		
		char a1 =  'a';
		char a2 = 97;
		char a3 = '\u0061';
		
		System.out.println(a1); // a
		System.out.println(a2); // a - 유니코드
		System.out.println(a3); // a - 유니코드 값을 16진수로 표현
		
		// 2) int를 char로 변환
		int ascii66 = 66;
		char letter66 = (char)ascii66; // 명시적 형 변환 (강제 형 변환)
		
		System.out.println(letter66);
		
	}
}
