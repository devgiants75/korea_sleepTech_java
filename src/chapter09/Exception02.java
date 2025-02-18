package chapter09;

// == 자바 예외 처리 == //
// 1. try-catch 블록
// 2. throw, throws 키워드
// 3. 사용자 정의 예외

/*
	try-catch 블록
	
	== 기본 형태 ==
	try {
		예외가 발생할 수 있는 코드
	} catch ('발생할 예외의 타입' '예외를 저장할 변수') {
		해당 예외 발생 시 실행할 코드
	} catch ('발생할 예외의 타입' '예외를 저장할 변수') {
		해당 예외 발생 시 실행할 코드
	}
	
	- catch 블록: 특정 예외 타입이 발생했을 때 실행될 코드를 정의
			>> 다중 catch 블록으로 사용 가능 (여러 예외 처리 가능)
*/
public class Exception02 {
	public static void main(String[] args) {
		
		// char c1 = 'abc'; - 컴파일 예외
		// System.out.println(a1); - 컴파일 예외
		String s1 = "string";
		
		// int division = 10 / 0; - 런타임 예외
//		Exception in thread "main" java.lang.ArithmeticException: / by zero
//		at chapter09.Exception02.main(Exception02.java:30)
		
		try {
			// 예외 발생 가능성 코드 작성
			int division = 10 / 0;
		} catch (ArithmeticException e) { // 예외 변수명: e, exception 등이 주로 사용
			// try 블록 내에서 발생하는 예외를 매개변수로 자동 전달 받음
			// : Throwable 내의 다양한 기능 활용
			System.out.println(e.getMessage()); // / by zero
			System.out.println("0으로 정수를 나눌 수 없습니다.");
		}
		
		System.out.println("정상적인 실행");
		
		System.out.println("== 다중 catch 블록 실행 ==");
	}
}
