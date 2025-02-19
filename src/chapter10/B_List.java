package chapter10;

import java.util.ArrayList;
import java.util.LinkedList;

// == List 인터페이스 == //
// : 순서유지, 중복 저장 가능
// - 저장된 순서에 따라 데이터를 관리하는 다양한 메서드를 정의

// 1. List 특징
// - 인덱스를 통해 정확한 위치 지정
// - 중복 가능
// - 다양한 구현체를 통해 사용 가능

// 2. List 종류

// 1) ArrayList
// : 내부에서 배열을 사용한 요소 저장
// - 빠른 읽기 성능 / 느린 삽입,삭제 성능
// - 빠른 조회 기능에 적합, 삽입과 삭제 시 데이터 이동이 필요하여 상대적으로 성능 저하

// EX) '사과바구니' - 사과를 일렬로 정렬 정리
//		: 사과 추가/제거 - 공간에 대한 정리 (속도 느림)
//		: 사과 꺼내기 - 순차적인 수를 사용한 꺼내기 (속도 빠름)

// 2) LinkedList
// : 내부에서 이중 연결 리스트를 사용한 요소 저장
// - 빠른 삽입,삭제 성능 / 느린 읽기 성능
// - 연결 기반 데이터 관리: 비순차적 데이터 작업에 적합, 특정 요소 접근 시 순차 탐색이 필요하여 성능 저하

// EX) '기차' - 칸마다 서로 연결 정리
// 		: 새로운 칸(객차) 추가/삭제 - 앞뒤 칸에 연결만 하면 가능 (속도 빠름)
//		: 특정 칸을 찾기 - 앞에서부터 하나씩 이동

public class B_List {
	public static void main(String[] args) {
		
		// == List 인터페이스의 주요 메서드 == //
		// 1. ArrayList 예제
		System.out.println("== ArrayList ==");
		
		// List 인터페이스 > AbstractList 추상 클래스 > ArrayList 클래스
		ArrayList<String> arrayList = new ArrayList<>();
		
		// 데이터 추가
		arrayList.add("Java"); // 리스트 끝에 요소 추가
		arrayList.add(0, "Python"); // 원하는 인덱스에 요소 추가
		arrayList.add("JavaScript");
		
		System.out.println(arrayList); // [Python, Java, JavaScript]
		
		// 데이터 읽기(반환)
		String firstElement = arrayList.get(0); // 해당 인덱스의 요소를 반환
		System.out.println(firstElement); // Python
		
		// 데이터 수정 
		arrayList.set(2, "TypeScript"); // 해당 인덱스의 요소를 변경
		System.out.println(arrayList); // [Python, Java, TypeScript]
		
		// 데이터 삭제
		// : 해당 인덱스의 요소를 삭제 후 '반환'
		String removedElement = arrayList.remove(1);
		System.out.println(removedElement); // Java
		System.out.println(arrayList); // [Python, TypeScript]
		
		// 리스트 크기
		System.out.println(arrayList.size()); // 2
		
		// 리스트 비우기
		arrayList.clear();
		System.out.println(arrayList); // []
		
		// 1. LinkedList 예제
		System.out.println("== LinkedList ==");
		
		LinkedList<String> linkedList = new LinkedList<>();
		
		// 데이터 추가
		linkedList.add("Apple");
		linkedList.add("Orange");
		linkedList.add("Mango");
		linkedList.add(1, "Banana");
		System.out.println(linkedList); // [Apple, Banana, Orange, Mango]
		
		// 데이터 읽기
		String secondFruit = linkedList.get(1);
		System.out.println(secondFruit); // Banana

		// 데이터 포함 여부 확인
		// 리스트.contains(요소값); 
		// : 포함 여부를 boolean 값으로 반환
		System.out.println(linkedList.contains("Orange")); // true
		System.out.println(linkedList.contains("Strawberry")); // false
		
		// === ArrayList VS LinkedList 성능 비교 === //
		System.out.println("=== ArrayList VS LinkedList 성능 비교 ===");
		
		ArrayList<Integer> arrayListTest = new ArrayList<>();
		
		// cf) 클래스 구조의 객체 타입 데이터
		// : 클래스 구조는 객체 타입의 데이터만 삽입 가능
		// > Integer, Character, Boolean, Double 등
		
		long startTime = System.nanoTime();
		// 1초 = 1,000,000,000 나노초
		System.out.println(startTime); // 20353925431000
		
		for (int i = 0; i < 222222; i++) {
			arrayListTest.add(0, i); // 항상 맨 앞에 요소 삽입
		}
		long endTime = System.nanoTime();
		
		System.out.println("ArrayList 삽입 시간: " + (endTime - startTime) + "ns");
		
		// ======= //
		LinkedList<Integer> linkedListTest = new LinkedList<>();
		startTime = System.nanoTime();
		
		for (int i = 0; i < 222222; i++) {
			linkedListTest.add(0, i); // 항상 맨 앞에 요소 삽입
		}
		endTime = System.nanoTime();
		
		System.out.println("LinkedList 삽입 시간: " + (endTime - startTime) + "ns");
	}
}