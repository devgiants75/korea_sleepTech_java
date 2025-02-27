package user_reservation.service;

import java.util.List;

import user_reservation.entity.Reservation;

public interface ReservationService {
	// 예약 등록, 조회, 취소
	void createReservation(String userId);
	List<Reservation> getReservationsByUserId(String userId);
	void cancelReservation(String reservationId);
}
