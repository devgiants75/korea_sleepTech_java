package chapter01;

public class A_Hello {

	public static void main(String[] args) {
		// 1. 자바 소스 파일(.java)
		// : 고급 언어(사람이 이해할 수 있는 언어)를 작성할 확장자 파일
		
		// cf) 2. javac 컴파일러
		//		: 고급 언어를 저급 언어로 변환하는 기계 (번역기)
		
		// 3. 바이트 코드 파일(.class)
		// : 바이트 코드가 저장되는 위치
		// >> javac 컴파일러가 자동 변환하여 저장
		
		// cf) 4. java 실행
		//		: JVM이 기계어(0, 1)로 변역 후 실행
		
		System.out.println("Hello, Java");
		// 윈도우: ctrl + f11
		// 맥: command + fn + f11
	}
}
