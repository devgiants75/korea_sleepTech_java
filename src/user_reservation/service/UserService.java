package user_reservation.service;

public interface UserService {
	// 매개변수의 데이터들을 dto로 묶어서 관리 가능
	void registerUser(String userId, String password, String name, String email);
	void login(String userId, String password);
	void logout();
	boolean isLoggedIn(); // 사용자의 로그인 유무를 확인
}
