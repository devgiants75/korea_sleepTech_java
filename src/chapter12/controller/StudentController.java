package chapter12.controller;

import java.util.ArrayList;
import java.util.List;
import chapter12.model.Student;

public class StudentController {
	private List<Student> students;
	
	public StudentController() {
		this.students = new ArrayList<Student>();
	}
	
	// 1. 학생 추가(Create)
	public void addStudent(String name, int age, String studentId) {
		// 학생 추가 시 입력한 id의 학생이 존재하는 경우 
		// : 기능 X + 메시지 출력
		Student student = findStudentByStudentId(studentId);
		// >> 해당 id의 학생이 존재하지 않는 경우 null 반환
		
		if (student != null) {
			// 입력받은 id의 학생이 존재하기 때문에 학생 추가 불가
			System.out.println("해당 id의 학생이 이미 존재합니다.");
			return;
		}
		
		students.add(new Student(name, age, studentId));
	}
	
	// 2. 전체 조회
	public List<Student> getAllStudents() {
		return students;
	}
	
	// 3. 단건 조회
	public Student findStudentByStudentId(String StudentId) {
		for (Student student: students) {
			if (student.getStudentId().equals(StudentId)) {
				return student; // 해당 학번의 학생을 반환
			}
		}
		return null; // 학번에 해당하는 학생이 없을 경우 null 반환
	}
	
	// 4. 학생 데이터 수정
	public boolean updateStudent(String id, String newName, int newAge) {
		Student student = findStudentByStudentId(id);
		
		if (student != null) {
			student.setName(newName);
			student.setAge(newAge);
			return true;
		}
		return false;
	}
	
	// 5. 학생 데이터 삭제
	public boolean removeStudent(String id) {
		Student student = findStudentByStudentId(id);
		if (student != null) {
			students.remove(student);
			return true;
		}
		return false;
	}
}
