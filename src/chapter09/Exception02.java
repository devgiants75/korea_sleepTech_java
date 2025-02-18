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
		try {
			System.out.println("정상 실행");
			
			// int division = 10 / 0;
			
			System.out.println("50번째 줄 주석 시 실행");
			
			int[] numbers = new int[5]; // new int[배열의크기];
			// numbers[10] = 50; // 변수명[인덱스번호]
			
			String text = null;
			System.out.println(text.length()); // 문자열.length(): 문자열 길이 반환
			
		} catch(ArithmeticException e) {
			System.out.println("수학 공식 에러: " + e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스 초과 에러: " + e.getMessage());
		} catch(NullPointerException e) {
			System.out.println("null값 계산 에러: " + e.getMessage());
		} catch(Exception e) {
			System.out.println("초과 오류  발생: " + e.getMessage());
			
			// cf) Exception 클래스
			//		: 자바 전체 예외의 최상위 클래스
			//		- 예기치 못한 예외 발생 방지를 위해 세부적인 예외 작성의 마지막에 첨부
		} finally {
			// cf) 예외 발생 여부와 상관없이 항상 실행되는 코드 블럭
			System.out.println("finally 블록 - 항상 실행");
		}
	}
}
