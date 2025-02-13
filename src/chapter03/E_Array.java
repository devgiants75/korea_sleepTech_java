package chapter03;

import java.util.ArrayList;
import java.util.Arrays;

// == 자바 배열 (정적) == //
// : 한 번 생성되면 크기 변경 X
// : 크기 변경이 필요한 경우, 변경된 크기의 배열을 생성하여 요소값을 복사
public class E_Array {
	public static void main(String[] args) {
		int[] numbers = new int[5];
		System.out.println(Arrays.toString(numbers)); // [0, 0, 0, 0, 0]
		// System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
		
		// == 동적 배열(ArrayList) 사용법 == //
		
		// 1. ArrayList란?
		// : Java의 동적 배열 구현체
		// - 크기 제한 없이 동적으로 요소 추가/삭제 기능
		// - Java Collection Framework의 일부: 'java.util.ArrayList'에서 제공
		
		// 2. ArrayList 장점
		// : 동적 크기, 유연성, 다양한 메서드(기능) 제공
		
		// 3. ArrayList 주의점
		
		// cf) int[] 배열명 = new int[크기];
		//		: 정적 배열의 경우 기본값이 '기본 데이터'로 지정
		// boolean[] - false
		// char[] - ''
		// int[] - 0
		// double[] - 0.0
		
		// ArrayList의 경우 기본 데이터 타입 사용 X
		// : 참조 데이터 타입만 가능
		// String (문자열)
		// int >> Integer
		// char >> Character
		// 이외의 기본 데이터타입은 첫 글자를 대문자로 작성
		
		// +) 참조 데이터 타입은 기본값이 모두 null
		// cf) null
		//		: 아무 객체도 참조하지 않음을 나타내는 값 (기본 데이터 타입 사용 X)
		
		// +) Collection Framework의 모든 클래스 내부에서는 객체 구조만을 다룸
		//		: 기본 타입 사용 X
		
		Integer a = null;
		// int b = null;
		
		// == ArrayList 생성 == //
		// : ArrayList<데이터타입> 변수명 = new ArrayList<>(초기용량);
		
		// int[] numberArray = new int[]; 
		// - 정적 배열은 크기값 미지정 시 오류
		// - 크기를 명시적으로 전달하지 않을 경우 실제 요소값이라도 전달
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		// : 초기 용량 미지정 시 - 기본값 10
		// > 해당 용량은 배열 사용 시 담겨있는 요소의 크기만큼만 측정
		
		System.out.println(arrayList);
		
		
		
	} 
}
