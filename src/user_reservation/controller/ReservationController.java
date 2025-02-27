package user_reservation.controller;

import java.util.List;
import java.util.Scanner;

import user_reservation.entity.Reservation;
import user_reservation.service.implement.ReservationServiceImpl;
import user_reservation.service.implement.UserServiceImpl;

public class ReservationController {
	private final UserServiceImpl userServiceImpl;
	private final ReservationServiceImpl reservationServiceImpl;
	
	public ReservationController() {
		this.userServiceImpl = new UserServiceImpl();
		this.reservationServiceImpl = new ReservationServiceImpl(userServiceImpl);
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			displayMenu();
			int choice = getChoice(sc);
			
			if (!processChoice(choice, sc)) {
				break;
			}
		}
	}
	
	private void displayMenu() {
		System.out.println("1. 사용자 등록 | 2. 로그인 | 3. 로그아웃");
		System.out.println("4. 예약 등록 | 5. 예약 확인 | 6. 예약 취소");
		System.out.println("7. 종료");
		System.out.print("선택 : ");
	}
	
	private int getChoice(Scanner sc) {
		while (!sc.hasNextInt()) {
			// hasNextInt()
			// : 입력된 값이 int면 true, 그렇지 않으면 false 반환
			
			// 입력값이 정수가 아닌 경우
			System.out.println("숫자를 입력해주세요.");
			sc.next();
		}
		return sc.nextInt();
	}
	
	private boolean processChoice(int choice, Scanner sc) {
		sc.nextLine(); // 정수값 입력받고 남은 버퍼 처리
		
		switch (choice) {
		case 1:
			userServiceImpl.registerUser(
					input(sc, "사용자 ID"), 
					input(sc, "사용자 비밀번호"), 
					input(sc, "사용자 이름"), 
					input(sc, "사용자 이메일"));
			break;
		case 2:
			userServiceImpl.login(input(sc, "사용자 ID"), input(sc, "사용자 비밀번호"));
			break;
		case 3:
			userServiceImpl.logout();
			break;
		case 4:
			reservationServiceImpl.createReservation(input(sc, "사용자 ID"));
			break;
		case 5:
			List<Reservation> results = reservationServiceImpl.getReservationsByUserId(input(sc, "사용자 ID"));
			results.forEach(System.out::println);
			break;
		case 6:
			String reservationId = input(sc, "예약 ID");
			reservationServiceImpl.cancelReservation(Long.parseLong(reservationId));
			break;
		case 7:
			System.out.println("프로그램을 종료합니다.");
			return false;
		default:
			System.out.println("잘못된 선택입니다. 유효한 기능을 선택하세요(1 ~ 7)");
		}
		
		return true;
	}
	
	private String input(Scanner sc, String prompt) {
		System.out.print(prompt + ": ");
		return sc.nextLine();
	}
}
