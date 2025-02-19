package chapter09;

// === API ===
// : Application Programming Interface(미리 정의한 약속)
// - 소프트웨어 또는 시스템 간 상호작용을 가능하게 하기위해 정의된 메서드의 집합
// - 소프트웨어나 하드웨어와 상호작용할 수 있는 인터페이스를 제공

// 자바 API 클래스
// : 자바 프로그래밍 내에서 미리 정의된 클래스와 메서드의 집합
// - 자바 표준 라이브러리로 제공
// - 라이브러리 내에서 다양한 패키지로 나뉘며, 각 패키지는 특정 기능을 담당

// 1. java.lang 패키지
// : 기본 클래스(String, Math, System)를 포함
// - 자동으로 포함(import): import 없이 사용 가능

// 2. java.io 패키지
// : 입출력과 관련된 클래스
// - File, InputStream 등과 같은 외부의 입출력과 관련

// 3. java.util 패키지
// : 유틸리비 클래스(List, Map, Date 등)를 포함

// cf) 자바 API 공식 문서
// https://docs.oracle.com/en/java/javase/17/docs/api/index.html

public class JavaApi {
	public static void main(String[] args) {
		// java.lang
		String message = "Hello, Java";
		System.out.println(message.length());
	}
}
