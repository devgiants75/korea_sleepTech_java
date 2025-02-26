package chapter15.signUp;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

// 실제 회원가입 프로세스의 사용자 데이터
@Getter
@Builder
public class User {
	private Long id; // 사용자 데이터의 구분값 - 데이터 저장소에서 일괄 작성
	private String userId;
	private String password;
	private String username;
	private String email;
	private String phone;
	private String nickname;
	private Date signUpDate; // 회원가입 날짜 저장
}
