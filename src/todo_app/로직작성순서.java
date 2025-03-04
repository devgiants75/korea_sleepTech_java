package todo_app;

public class 로직작성순서 {
/*
 ===== 로직 작성 순서 =====
	Entity (데이터 정의)
		- User(사용자 객체)
		- Task(할일 객체)
	
	DTO (데이터 전송 객체 정의)
		request
		- UserSignUpRequestDto(회원가입 요청 데이터)
		- UserSignInRequestDto(로그인 요청 데이터)
		- TaskRequestDto(할일 생성/수정 요청 데이터)
			>> 분리 가능
		response
		- UserResponseDto(회원가입, 로그인 시 반환)
		- TaskResponseDto(할일 응답 반환)
		
	Repository(메모리 기반 데이터 저장소 구현)
		- UserRepository
			cf) User 데이터에 대한 List 컬렉션 저장소 정의
				사용자 등록(save), 사용자 단건 조회(findById), 사용자 전체 조회(findAll), 사용자 삭제(deleteById)
		- TaskRepository
			cf) Task 데이터에 대한 List 컬렉션 저장소 정의
				할일 등록(save), 할일 단건 조회, 할일 전체 조회, 할일 수정, 할일 삭제

	Service(비즈니스 로직 구현)
		- UserService / UserServiceImpl
		- TaskService / TaskServiceImpl
		
	Controller(각 데이터 관련 요청을 처리)
		- UserController
		- TaskController
	
	App.java(콘솔 기반 메뉴를 활용한 사용자 및 할일 관련 기능을 실행)
*/
}
