package user_reservation.entity;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// final 또는 @NonNull인 필드만 생성자의 매개변수로 작성
@RequiredArgsConstructor
@Getter
public class Reservation {
	private final String reservationId; // 각 예약의 고유값
	private final String userId; // 예약자 정보
	private final Date reservationTime; // 예약 시간
	
	// 활성화 유무를 저장
	// : 해당 예약의 활성화 상태를 저장
	// - true: 예약 완료
	// - false: 예약 취소
	private boolean isActive = true; 
	
	// 예약 취소 메서드
	public void cancel() {
		this.isActive = false;
	}
	
	@Override
	public String toString() {
		String isActiveMessage = isActive ? "예약 중" : "예약 취소";
		
		return "[예약 ID: " + reservationId + ", 사용자 ID: " + userId 
				+ ", 예약일자: " + reservationTime + ", 예약 상태: " + isActiveMessage + "]";		
	}
}
