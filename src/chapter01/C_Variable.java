package chapter01;

public class C_Variable {
	// main 메서드
	// : main + 자동 완성(ctrl + space)
	public static void main(String[] args) {
		// === 변수 (Variable) ===
		// : 데이터를 저장하는 공간
		// >> 데이터를 메모리에 저장하고 사용할 때의 공간
		
		// 1. 변수 선언: 메모리 공간 생성
		// - 데이터타입 변수명; 
		int price; // 가격을 저장할 수 있는 변수(그릇)
		String name;
		
		int num; // 정수를 담는 그릇
		char chr; // 문자를 담는 그릇
		boolean bool; // 논리를 담는 그릇
		
		// 2. 변수 초기화(할당): 그릇에 데이터 넣기
		// - 변수명 = 데이터값;
		
		// cf) 처음 데이터를 넣는 과정: 초기화
		//		데이터를 바꾸는 과정: (재)할당
		num = 10;
		chr = '가';
		bool = true;
		
		// cf) A = B 
		// : 우항B에서 좌항A으로 값을 '대입'한다.
		// : 같다(==)
		
		// 3. 변수 선언과 동시에 초기화
		// - 데이터타입 변수명 = 데이터값;
		
		int number = 10;
		char character = '가';
		boolean boolValue = false;
		
		// = 변수 명명 규칙 = 
		// : 문자, 숫자, 기호를 사용
		// - 대소문자를 구분, 길이 제한 X
		int age;
		int Age; // 서로 다른 변수(그릇)
		
		// - 숫자로 시작할 수 X
		// int 0211Age;
		int age0211;
		
		// - 기호는 _(언더스코어)와 $(달러)만 사용 가능
		int _0211;
		int age$;
		// int age%;
		
		// - 자바의 예약어, 키워드는 변수명으로 사용할 수 X
		// int if;
		
		// cf) 변수명 선택적 명명 규칙 
		// : lowerCamelCase 사용 권장
		// >> 소문자로 작성하되 연결하는 단어의 시작은 대문자로 작성
		
		// 딸기 초코 케이크
		int strawberrychococake;
		int strawberryChocoCake;
		
		// +) UpperCamelCase
		// int StrawberryChocoCake;
		
		// +) lower_snake_case
		// int strawberry_choco_cake;
		
		// = 변수의 재할당 =
		int height = 167; // 변수의 선언 및 초기화
		
		// 변수의 재할당 방법
		// - 변수명 = 변경할값;
		height = 169;
		
		// === 상수 (Constant) ===
		// : 프로그램 실행 동안 그 값이 변경되지 않는 변수
		// > 선언과 동시에 반드시! 초기화가 이루어져야 함!
		
		// 1. 상수 선언 방법
		// - final 키워드를 사용하여 선언
		// : final 데이터타입 변수명 = 데이터값;
		
		// 2. 상수 명명 규칙
		// - UPPER_SNAKE_CASE 사용
		// - 모든 문자 대문자 + 연결은 _(언더스코어) 사용
		
		final int RESIDENT_NUMBER = 1234567;
		// RESIDENT_NUMBER = 7654321;
		
		// = 변수(상수)명을 활용한 데이터값 읽기 =
		int numberValue = 10;
		
		// 변수명 호출 시 변수(그릇) 안의 데이터값이 출력
		System.out.println(numberValue); // 10		
		
		// cf) 세미콜론(;)
		// 코드 명령어 단위를 한 줄에 한 문장 작성을 원칙!
		// - 세미콜론은 문장의 끝마침을 의미
		// - 문장 종료 시 반드시 세미콜론 첨부!
		// 
		int semi; int colon; // 사용 금지!
		
		// cf) 콤마(,)
		// : 같은 데이터타입의 변수 선언 시 콤마로 구분하여 동시 생성 가능
		int a, b, c;
		a = 10;
		b = 20;
		c = 30; // 초기화는 개별적
		
		int d;
		int e;
		int f;
	}
}
