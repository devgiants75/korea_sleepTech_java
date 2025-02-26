package chapter15;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// === 스트림 API의 최종 연산 === //
// 1. collect 메서드
// : 스트림의 요소를 변환하거나, 집계에서 최종 결과를 생성하는 데 사용
// - 스트림의 종결 작업 중 하나
// - 특정 컨테이너(List, Set, Map)로 변환 ||  값을 합산, 집계에 사용

// 2. Collectors 클래스
// : 다양한 Collector를 제공하여 collect 메서드와 결합해 하나의 결과를 반환
// - 다양한 정적 메서드를 제공

// 1) toList, toSet, toMap: 해당 컬렉션으로 값을 반환
// 2) joining(): 문자열 요소를 연결
// 3) counting(): 스트림의 요소 수를 계산
// 4) groupingBy(): 요소를 그룹화
// 5) partitioningBy(): 스트림의 요소를 조건에 따라 두 그룹으로 나눔

// cf) Collector: 스트림 요소를 어떻게 수집할지 정의하는 객체
public class B_Collect {
	public static void main(String[] args) {
		// Collectors.toList()
		List<String> languages = Arrays.asList("java", "python", "javascript");
		
		List<String> upperLanguages = languages.stream()
//				.map(language -> language.toUpperCase())
				.map(String::toUpperCase)
				.collect(Collectors.toList());
				
		// Collectors.joining()
		// : 문자열 요소를 결합하여 하나의 문자열로 반환
		// >> 3개의 인자를 받음 (delimiter - 구분자, prefix - 접두사, suffix - 접미사)
		String result = upperLanguages.stream()
				.collect(Collectors.joining(", ", "[", "]"));
		
		System.out.println(result);
		
		// Collectors.groupingBy()
		// : 특정 기준에 따라 요소를 그룹화
		Map<Character, List<String>> groupedByFirstChar = upperLanguages.stream()
				.collect(Collectors.groupingBy(language -> language.charAt(0)));
		
		System.out.println(groupedByFirstChar);
		// {P=[PYTHON], J=[JAVA, JAVASCRIPT]}
		
		// Collectors.partitioningBy()
		// : 조건에 따라 두 그룹으로 나눔 >> 해당 조건이 참/거짓인 경우로 나뉨
		Map<Boolean, List<Integer>> partitioned = Stream.of(1, 2, 3, 4, 5)
				.collect(Collectors.partitioningBy(num -> num % 2 == 0));
		
		System.out.println(partitioned); // {false=[1, 3, 5], true=[2, 4]}
	}
}
