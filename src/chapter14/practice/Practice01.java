package chapter14.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// 1. 컬렉션 프레임워크
// 2. 스트림 API
// 3. 람다 표현식 & 메서드 참조

// == 학생 관리 시스템 == //
// 1. 학생 목록 필터링 & 정렬

@AllArgsConstructor
@Getter
@ToString
class StudentClass {
	private String name;
	private int age;
	private double grade; // 학점
}


public class Practice01 {
	public static void main(String[] args) {
		List<StudentClass> studentClasses = Arrays.asList(
					new StudentClass("이승아", 30, 4.3),
					new StudentClass("이도경", 32, 4.1),
					new StudentClass("이지희", 20, 3.8),
					new StudentClass("이지훈", 25, 4.0),
					new StudentClass("이민경", 31, 3.5)
				);
		
		
		// 1) 학점이 4.0 이상인 학생 필터링
		List<StudentClass> filteredStudents = studentClasses.stream()
				.filter(student -> student.getGrade() >= 4.0)
				.collect(Collectors.toList());
		
		// cf) Collectors.toList()
		//		: static 메서드
		//		: 스트림을 List 타입으로 변환
		
		System.out.println("학점이 4.0이상인 학생");
		filteredStudents.forEach(System.out::println);
		
		// 2) 학생 이름 목록만 추출
		List<String> studentNames = studentClasses.stream()
//				.map(student -> student.getName())
				// 순회되는 학생의 인스턴스 메서드를 참조
				// 클래스타입::인스턴스메서드
				.map(StudentClass::getName)
				.collect(Collectors.toList());
		
		System.out.println("학생 이름 목록");
		System.out.println(studentNames); // [이승아, 이도경, 이지희, 이지훈, 이민경]
		
		// 3) 학생들을 점수순으로 정렬
		// : 스트림 API 중간 연산의 'sorted'
		// >> Comparator 클래스의 .comparing타입 정적 메서드를 활용
		List<StudentClass> sortedStudents = studentClasses.stream()
				.sorted(Comparator.comparingDouble(StudentClass::getGrade))
//				.sorted(Comparator.comparingDouble(StudentClass::getGrade).reversed())
				.collect(Collectors.toList());
		
		System.out.println("점수 순으로 정렬된 학생들");
		sortedStudents.forEach(System.out::println);
		
		// 4) 학생들 중 이름에 '지'가 포함된 학생 필터링
		List<StudentClass> studentsWithJi = studentClasses.stream()
				.filter(studentClass -> studentClass.getName().contains("지"))
				.collect(Collectors.toList());
		
		System.out.println("이름에 '지'가 들어간 학생");
		studentsWithJi.forEach(System.out::println);
	}
}
