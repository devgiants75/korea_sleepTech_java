package chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;

// == 성적 계산 프로그램 == //

@AllArgsConstructor
@Getter
class Student {
	private String name;
	private int score;
}

// 인터페이스 - 성적 계산기
interface Grading {
	String calculateGrade(Student student);
}

// Anonymous: 익명의
public class C_Anonymous {
	public static void main(String[] args) {
		Student student1 = new Student("조승범", 85);
		Student student2 = new Student("진상영", 90);
		Student student3 = new Student("윤대휘", 100);
		Student student4 = new Student("정규민", 80);
		Student student5 = new Student("박성욱", 95);
		
		Grading grading = new Grading() {
			@Override
			public String calculateGrade(Student student) {
				int score = student.getScore();
				
				if (score > 100 || score < 0) {
					System.out.println("잘못된 점수입니다.");
					return null;
				} else if (score >= 90) {
					return "A";
				} else if (score >= 80) {
					return "B";
				} else if (score >= 70) {
					return "C";
				} else if (score >= 60) {
					return "D";
				} else {
					// 0 ~ 59점까지
					return "F";
				}
			}
		};
		
		System.out.println(student1.getName() + "의 성적: " + grading.calculateGrade(student1));
		System.out.println(student2.getName() + "의 성적: " + grading.calculateGrade(student2));
		System.out.println(student3.getName() + "의 성적: " + grading.calculateGrade(student3));
		System.out.println(student4.getName() + "의 성적: " + grading.calculateGrade(student4));
		System.out.println(student5.getName() + "의 성적: " + grading.calculateGrade(student5));

	}
}
