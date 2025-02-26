package chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * === 스트림 API ===
 * 
 * 1. 스트림 생성: .stream()
 * 2. 중간(가공) 절차
 * 		- map(Function - 입력값을 받아 특정 연산 후 반환)
 * 		- filter(Predicate - 입력값을 받아 조건을 검사)
 * 		- sorted(Comparator - 입력값에 대한 비교)
 * 3. 최종(결과) 절차
 * 		- collect
 *		- forEach
 * */

// 자바에서 배열과 리스트의 정렬 
// 1. 배열(Arrays 클래스) 정렬
// : Arrays 클래스의 정적 메서드(.sort()) 사용
// >> 오름차순 정렬만 지원
// cf) 내림차순 정렬 - Comparator 클래스를 사용 .reverseOrder() 정적 메서드 사용

// 2. 리스트 정렬
// : Collections.sort() 
// : List 인터페이스의 sort() 메서드를 사용
public class A_Sort {
	public static void main(String[] args) {
		// 1. 배열 정렬
		// 1) 오름차순 정렬
		int[] numbers = {5, 3, 2, 8, 1};
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers)); // [1, 2, 3, 5, 8]

		System.out.println(numbers[0]); // 1
		
		// 2) 내림차순 정렬
		// : Comparator 클래스의 reverseOrder()
		//		>> Comparator<T>을 반환하는 메서드
		//			: 객체 (타입) 간의 비교 (기본데이터타입 비교 X)
		Integer[] nums = {5, 3, 6, 2, 7};
		Arrays.sort(nums, Collections.reverseOrder());
		
		System.out.println(nums[0]); // 7
		System.out.println(nums[4]); // 2
		
		// 2. 리스트 정렬
		// 1) 기본 정렬: sort() - 오름차순
		//				, Collections.sort(데이터, Collections.reverseOrder()); - 내림차순
		
		// 2) Comparator 클래스 사용
		List<String> names = new ArrayList<String>(List.of("Tom", "Jerry", "Pororo", "Loopy"));
		
		// 문자열 길이 기준 정렬
		// : 전체 순회 >> 각 이름의 길이값을 반환 >> 오름차순 정렬
		names.sort(Comparator.comparingInt(name -> name.length()));
		names.sort(Comparator.comparingInt(String::length));
		
		// cf) sort() 메서드
		// : List 인터페이스의 메서드
		// - 리스트를 특정 기준에 따라 정렬
		// >> 정렬의 기준을 결정하는 Comparator를 인수로 받음
		
		// cf) Comparator
		// : 두 객체를 비교해서 정렬 순서를 결정
		
		// 3) 스트림 API 사용 정렬
		// : 정렬된 결과를 새로운 리스트로 반환
		List<Integer> listNumbers = new ArrayList<>(List.of(8, 2, 4, 5, 1));
		
		List<Integer> sortedNumbers = listNumbers.stream()
			.sorted() // 오름차순 - 중간 연산 메서드
			.collect(Collectors.toList());
		
		System.out.println(sortedNumbers); // [1, 2, 4, 5, 8]
		
		// 내림차순
		List<Integer> sortedReverseNumbers = listNumbers.stream()
				.sorted((a, b) -> b - a) // 내림차순
				.collect(Collectors.toList());
		
		// cf) 정렬식 (내림차순)
		// (a, b) -> b - a
		// : a와 b는 리스트 안의 두 개의 요소
		// - 두 요소를 비교한 결과를 반환
		//		1) 반환값이 양수: b가 a보다 앞에 옴
		//		2) 반환값이 0: 순서 변경 X (두 수가 같음)
		//		3) 반환값이 음수: a가 b보다 앞에 옴
		
		// +) 오름차순 (a, b) -> a - b
		
		List<String> characterNames = new ArrayList<String>(List.of("Tom", "Jerry", "Pororo", "Loopy"));
		// 캐릭터 이름의 길이를 오름차순 정렬
		
		List<String> sortedCharacter = characterNames.stream()
				.sorted((n1, n2) -> n2.length() - n1.length())
				.collect(Collectors.toList());
		
		System.out.println(sortedCharacter);
		
		
		
		
		
		
	}
}
