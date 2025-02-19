package chapter09;

// == throw & throws 키워드 == //

// 1. throw
// : 프로그램 실행 중에 특정 조건에서 예외를 직접 발생시킬 때 사용
// > 주로 조건문과 함께 사용(프로그램의 흐름을 제어하는 역할)

// 사용법
// : throw new ExceptionType("예외 메시지");
// >> 인자로 전달되는 문자열 "예외 메시지"는 getMessage() 메서드를 통해 catch 블록에서 출력 가능

// 2. throws
// : 메서드 선언부에 위치, 호출자에게 예외 처리를 위임
// - 체크(컴파일) 예외: 필수 / 언체크(런타임) 예외: 선택

// 사용법
// : [접근제어자] 반환타입 메서드명() throws ExceptionType {}

// cf) throw: 메서드 내부에 위치, 예외를 발생시킴, throw new ExceptionType("예외메시지");

// == 사용자 정의 예외 == //
// : 자바의 Exception 클래스를 '상속'받는 자식 클래스를 직접 정의
class InvalidUserException extends Exception {
	InvalidUserException(String message) {
		super(message); // Exception 클래스의 getMessage()에서 사용
	}
}

class CustomException extends Exception {
	CustomException(String message) {
		super(message);
	}
}

public class Exception03 {
	
	// 1) 단일 예외 던지기 - throws
	// : 메서드 선언부에서 해당 메서드가 발생시킬 수 있는 예외를 명시하는 키워드
	// - 메서드 호출자에게 예외 처리를 위임
	static void login(String username, String password) throws InvalidUserException {
		// 문자열.equals(문자열);
		// : 동일한 문자열일 경우 true, 그렇지 않으면 false 반환
		if (!"admin".equals(username)) {
			// 잘못된 사용자 인 경우
			throw new InvalidUserException("사용자 이름이 잘못되었습니다");
		}
	}
	
	// 2) 여러 예외 던지기 - throws
	// : throws 키워드에 ,(콤마)로 구분하여 나열
	static void exceptions(int num) throws CustomException, ArithmeticException, ArrayIndexOutOfBoundsException {
		if (num == 1) {
			throw new CustomException("1번 선택 - 커스텀 예외");
		} else if (num == 2) {
			throw new ArithmeticException("2번 선택 - 수학 공식 예외");
		} else {
			throw new ArrayIndexOutOfBoundsException("그 외에는 - 배열 인덱스 초과 예외");
		}
	}
	
	public static void main(String[] args) {
		int age = -10;
		
		try {
			if (age < 0) {
				throw new Exception("나이는 음수가 될 수 없습니다!!!");
			}
			System.out.println("출력 X");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// === 사용자 정의 예외 === //
		// InvalidUserException
	
		// login("admin", "password");
		// : throws로 메서드의 예외 발생 가능성을 명시하는 경우 
		// 		메서드 호출 시 반드시! try-catch 블록의 예외 처리가 필수!
		try {
			login("admin", "password");
		} catch(InvalidUserException e) {
			System.out.println(e.getMessage());
		}
		
		// === 여러 예외 던지기 === //
		// exceptions(1);
		
		try {
			System.out.println("여러 예외 던지기 테스트");
			exceptions(1);
		} catch(CustomException e) {
			System.out.println("1번: " + e.getMessage());
		} catch(ArithmeticException e) {
			System.out.println("2번: " + e.getMessage());
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("기타: " + e.getMessage());
		}
	}
}
