package chapter10;

import java.util.HashMap;
import java.util.Map;

// == Map 인터페이스 == //
// : 키(Key)와 값(Value)의 쌍으로 요소를 저장하는 데이터 구조
// - 키는 고유한 데이터를 가짐 (중복 키 허용 X)
// - 동일한 키에 서로 다른 값을 전달하는 경우 기존 값이 새로운 값으로 덮어씌워짐
// EX) name: '이승아', name: '이도경' (불가! - name: '이도경'만 존재)

// - 서로 다른 키에 동일한 값은 가능
// EX) name: '개구리', nickname: '개구리'

// +) 키의 유일성, 값의 중복성 보장
//	>> 순서 보장 X (LinkedHashMap은 예외적으로 순서 보장 O)
//  >> 키를 기반으로 빠른 검색 가능

// == Map 인터페이스 종류 (구현체) == //
// 1. HashMap
// : 가장 많이 사용, 키와 값에 null 허용
// - 빠른 검색, 삽입 성능 제공
// - 순서 유지 X

// 2. LinkedHashMap
// : HashMap + 삽입 순서 유지
// - 삽입 순서가 중요하고 빠른 검색이 필요할 때 주로 사용

// 3. TreeMap
// : 키에 따라 자동 정렬 기능 보장
// - 키에 null 허용 X

public class E_Map {
	public static void main(String[] args) {
		// == Map 인터페이스 메서드 == //
		// Map<키타입, 값타입> 인스턴스명 = new Map종류<>();
		
		Map<String, Integer> students = new HashMap<>();
		// 이름(키), 나이(값)
		
		// 1. put(키, 값): 키와 값을 Map 추가
		students.put("이승아", 29);
		students.put("이도경", 31);
		students.put("김명진", 34);
		
		System.out.println(students); 
		// {이승아=29, 김명진=34, 이도경=31}
		// : {키=값, 키=값} - 키와 값의 구분을 =로 표시
		
		
		
		
		
		
		
	}
}
