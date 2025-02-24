package chapter13;

// import lombok.AllArgsConstructor;
// import lombok.Getter;
// - import lombok.NoArgsConstructor;
// import lombok.RequiredArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;
import lombok.*; // 롬복 라이브러리 전체 클래스를 import

// == Lombok(롬복) 라이브러리 == //
// : 보일러플레이트 코드를 줄여주는 라이브러리
// - 어노테이션을 사용하여 코드를 간결하게 만들어 주는 역할

// cf) 프레임워크 VS 라이브러리
// 1) 프레임워크
// : 개발자가 따라야하는 가이드를 제공
// - Frame(틀) + Work(일하다)

// 2) 라이브러리
// : 개발자가 만들어낸 클래스들의 나열
// - 원하고자 하는 기능을 라이브러리 내에서 추출하여 사용

// >> 프레임워크가 개발자를 제어
//		개발자가 라이브러리를 제어

// cf) 보일러플레이트 코드
// : 프로그래밍에서 반복되는 작업이나 패턴에 대한 일종의 표준화 된 코드 (반복적인 코드)

// == 롬복 라이브러리의 어노테이션 종류 == //
// 1. @Getter / @Setter
// : 필드에 대한 getter와 setter 메서드를 자동으로 생성

// 2. @ToString 
// : 클래스의 toString() 메서드를 자동으로 구현
// - 객체를 출력하는 경우 지정된 형식으로 출력
// - 클래스명(필드명1=필드값1, 필드명2=필드값2, ...)

// 3. 생성자 어노테이션
// cf) 매개변수 - parameter(params), 인자(인수) - argument(args)

// 1) @NoArgsConstuctor
// 2) @AllArgsConstuctor
// 3) @RequiredArgsConstuctor

// 4. @Data 어노테이션
// : @Setter, @Getter, @RequiredConstructor, @EqualsAndHashCode 어노테이션을 
//		한 번에 적용하는 어노테이션

// cf) @EqualsAndHashCode
// : 두 객체의 내용이 같은지(동등성) 비교, 두 객체가 같은 객체인지(동일성) 비교 연산자
// >> boolean 값 반환

@Data
// @Setter
// @Getter
// @ToString
// @NoArgsConstructor
// : 필드에 final값이 있는 경우 빈 생성자 호출이 불가!
@AllArgsConstructor // - title, author 모두를 매개변수로 가짐
// @RequiredArgsConstructor // - title(필수값)을 매개변수로 가짐
class LombokClass {
	
	// cf) @RequiredConstructor
	//		: 필수값을 매개변수로 받는 생성자
	//		- final 필드값 또는 @NonNull 어노테이션을 매개변수로 받음
	
	@NonNull // null 값이 들어갈 수 없음! (필드에 필수값 지정)
	private final String title;
	private String author;
	
	// 1. getter/setter
	// : public 접근제한자 사용
	// - getter는 필드 타입의 반환타입을 가지는 메서드
	// - setter는 필드의 타입과 필드명의 매개변수를 가지는 메서드
	// public String getTitle() { return title; }
	// public void setAuthor(String author) { this.author = author; }
	

}







public class H_Lombok {
	public static void main(String[] args) {
//		LombokClass lombokClass = new LombokClass();
//		lombokClass.setTitle("백설공주");
//		lombokClass.setAuthor("이도경");
//		System.out.println(lombokClass);
		// LombokClass(title=백설공주, author=이도경)
		
		LombokClass lombokClass1 = new LombokClass("백설공주");
		// lombokClass1.setTitle("신데렐라");
		// : @Setter는 final 필드에 대해서 메서드 생성 X
		
		LombokClass lombokClass2 = new LombokClass("신데렐라", "이승아");
		
		System.out.println(lombokClass1); // LombokClass(title=백설공주, author=null)
		System.out.println(lombokClass2); // LombokClass(title=신데렐라, author=이승아)
		
		
		
		
		
		
		
		
		
		
	}
}
