package user_reservation.service.implement;

import java.util.Optional;

import user_reservation.entity.User;
import user_reservation.repository.UserRepository;
import user_reservation.service.UserService;

public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private User loggedUser; // 로그인 된 사용자 정보를 저장하고 있는 필드
	
	public UserServiceImpl() {
		this.userRepository = new UserRepository();
	}

	@Override
	public void registerUser(String userId, String password, String name, String email) {
		
		Optional<User> optionalUser = userRepository.findByUserId(userId);
		
		if (optionalUser.get() != null) {
			System.out.println("해당 ID의 유저가 존재합니다. 다시 시도해주세요.");
			return;
		}
		
		User newUser = new User(userId, password, name, email);
		userRepository.save(newUser);
		System.out.println("사용자 회원가입 완료: " + name);
	}

	@Override
	public void login(String userId, String password) {
		// ifPresentOrElse(a, b)
		// : 정보가 존재하는 경우 a 로직, 존재하지 않을 경우 b 로직
		userRepository.findByUserId(userId).ifPresentOrElse(user -> {
			// userId에 일치하는 정보는 확인
			// +) 일치하는 user의 비밀번호가 일치하는지 확인
			if (user.getPassword().equals(password)) {
				loggedUser = user;
				System.out.println("로그인 성공: " + user.getName());
			} else {
				System.out.println("로그인 실패: 비밀번호가 일치하지 않습니다.");
			}
		}, () -> System.out.println("로그인 실패: 사용자 ID를 찾을 수 없습니다."));
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLoggedIn() {
		// TODO Auto-generated method stub
		return false;
	}

}
