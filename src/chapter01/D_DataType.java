package chapter01;

public class D_DataType {
	public static void main(String[] args) {
		/*
			데이터 타입(자료형, Data Type)
			: 자바는 '강'타입 언어
			>> 모든 변수 선언 시 반드시! 데이터타입을 명시
		
			1. 데이터 타입 종류
			1) 기본 타입
				- 변수 선언 시 해당되는 자료형의 크기 만큼 메모리가 할당
				- 실질적인 데이터가 저장
				
			2) 참조 타입
				- 객체의 참조(메모리 주소)를 저장하는 변수 타입
				- 객체, 배열과 같이 메모리의 Heap 영역에 저장된 데이터를 참조
		*/
		
		// 1) 기본 타입 (자료형 - 8개)
		// byte(1), short(2), long(8), float(4)
		//* int(4), double(8), char(2), boolean(1)
		
		// cf) 자료형 크기의 단위
		// 1byte 체계
		// == 8bit (1bit 메모리 한 칸)
		
		// 1-1) 정수형: byte(1) < short(2) < int(4) < long(8)
		// byte: -128 ~ 127(2의 8제곱)
		// short: -32,768 ~ 32,767
		//* int: 약 -2.1억 ~ 약 2.1억
		// long: 약 -2의 63제곱 ~ 약 2의 63제곱
		byte byteValue = 127;
		int intValue = 86412685;
		long longValue = 123123123123L; 
		// >> long 타입은 숫자 뒤에 알파벳 l,L을 써서 표기(대문자 권장)
		
		// 1-2) 문자형: char (Character)
		// : 2바이트 크기, 단일 문자 저장만 가능
		// >> 홑따옴표(작은따옴표)로 표기
		char grade = 'A';
		char lastName = '이';
		// char lastName2 = "이";
		char gender = '남';
		
		// 1-3) 실수형: float < double
		// - float (4바이트 실수)
		// - double (8바이트 실수)*
		// >> 부동 소수점이 있는 수
		float dollar1 = 32.123F; // 데이터값 뒤에 알파벳 f, F 사용
		double dollar2 = 32.123;
		
		// 1-4) 논리형: boolean
		// : 데이터 값으로 true, false 만을 가짐
		// > 1바이트, 값 지정 시 소문자 값 사용을 권장!
		// > 변수명 지정 시 의문문 사용
		
		boolean isMarried = false;
		boolean isActived = true;
		boolean hasSnack = false;
		
		boolean isLogin = false;
		boolean isLightOn = true;
		
		// 2) 참조 자료형
		// : 기본 자료형을 기초로 만들어진 자료형
		// > 실제 데이터 값 X, 데이터가 저장된 주소값을 가지는 자료형
		
		// 2-1) 문자열
		// String: 문자열(문자 여러 개)을 저장하는 데 사용
		// > 쌍따옴표(큰따옴표)를 사용하여 문자열 작성
		
		// cf) 문자(char): 홑(작은)따옴표
		
		String name = "이승아";
		// String welcomeMessage = '만나서 반갑습니다 :)';
		
		char last = '이';
		
		System.out.println(name); // 이승아
		System.out.println(last); // 이
		
		// == 데이터 타입 정리 ==
		// 정수: byte < short < int(Integer) < long
		// 실수: float < double
		// 문자: char(Character)
		// 논리: boolean
		
		// cf) 참조 자료형: 문자열(String) - 크기 가변적
		
		// << 예시 >>
		// 학생 이름, 학생 나이, 학생 키, 학생 성별('M', 'F'), 학생 여부
		// : 변수 선언과 본인의 데이터 초기화
		
		// 학생 이름 (String)
		String studentName = "이승아";
		// >> 하나의 스코프({}) 내에서는 동일한 변수명 사용이 불가!
		int studentAge = 29;
		double height = 169.4;
		char studentGender = 'F';
		boolean isStudent = true;
	}
}