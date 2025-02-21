package chapter12;

/*
 * == 학생 관리 시스템 ==
 * : MVC 패턴 사용
 * : 학생 데이터에 대한 CRUD 기능 
 * 
 * 1. 기능 정의
 * - 학생 추가 기능
 * - 전체 학생 조회 기능 (전체 조회)
 * - 특정 학생 조회 기능 (단건 조회)
 * - 학생 수정 기능
 * - 학생 삭제 기능
 * - 프로그램 종료
 * 
 * 2. MVC 패턴 구성 요소
 * 
 * === Model (Student) ===
 * @Field
 * 		이름(name), 나이(age), 학번(studentId)
 * @Method
 * 		getter/setter, toString 
 * 
 * === View (StudentView) ===
 * : 사용자와 상호작용할 수 있는 메뉴를 표시
 * 		- 각각의 요청에 따라 controller에게 요청값과 행위를 전달
 * 
 * === Controller (StudentController) ===
 * @Field
 * 		학생 데이터 저장(List<Student>)
 * 		- 6가지 기능을 수행

 * */
public class StudentManagement {
	public static void main(String[] args) {
		
	}
}
