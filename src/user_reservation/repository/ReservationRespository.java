package user_reservation.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import user_reservation.entity.Reservation;

public class ReservationRespository {
	private final List<Reservation> reservations = new ArrayList<Reservation>();
	
	public void save(Reservation reservation) {
		reservations.add(reservation);
	}
	
	// 예약 확인 - 사용자 Id로 예약 조회
	// >> 예약자 정보와 활성화 유무를 확인
	public List<Reservation> findByUserId(String userId) {
		return reservations.stream()
				.filter(res -> res.getUserId().equals(userId) && res.isActive())
				.collect(Collectors.toList());
	}
	
	// 예약 정보 확인 - 단건 조회
	public Optional<Reservation> findById(Long reservationId) {
		return reservations.stream()
				.filter(res -> res.getReservationId().equals(reservationId)).findFirst();
	}
}
