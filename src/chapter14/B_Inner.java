package chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

// == 학교 시스템 == //

@AllArgsConstructor
@Getter
class School {
	private String schoolName;
	
	// 내부 클래스 - 학생
	@AllArgsConstructor
	class Student {
		private int studentId;
		private String studentName;
		
		public void displayInfo() {
			System.out.println("학교명: " + schoolName + ", 학생 이름: " + studentName);
		}
	}
	
	// 정적 내부 클래스 - 교장 선생님 (싱글톤 패턴)
	static class Principal {
		private static Principal instance; 
		
		private Principal() {}
		
		public static Principal getInstance() {
			if (instance == null) {
				instance = new Principal();
			}
			return instance;
		}
		
		public void displayInfo() {
			System.out.println("훈화말씀: 공부 열심히! 밥 잘 먹고! 일찍 자고! 일찍 일어나기!");
		}
	}
}

public class B_Inner {
	public static void main(String[] args) {
		School school = new School("유성 초등학교");
		
		// @롬복어노테이션생성자
		// : 필드값 순서대로 매개변수 값을 설정 - 타입 유의!!
		School.Student student1 = school.new Student(43, "이승아");
		student1.displayInfo(); // 학교명: 유성 초등학교, 학생 이름: 이승아
		
		// Principal 클래스: 정적 내부 클래스
		// - 외부 클래스 인스턴스 없이 사용 가능: static 메서드 호출 가능
		// >> getInstance() 내부의 new 연산자 사용으로 new 키워드 생략 가능
		School.Principal principal = School.Principal.getInstance();
		principal.displayInfo(); // 훈화말씀: 공부 열심히! 밥 잘 먹고! 일찍 자고! 일찍 일어나기!
	}
}
