package user_reservation.service.implement;

import java.util.Date;
import java.util.List;

import user_reservation.entity.Reservation;
import user_reservation.repository.ReservationRespository;
import user_reservation.service.ReservationService;

public class ReservationServiceImpl implements ReservationService {
	private final ReservationRespository reservationRespository;
	private final UserServiceImpl userServiceImpl;
	private long reservationIdSequence;
	
	public ReservationServiceImpl(UserServiceImpl userServiceImpl) {
		this.reservationRespository = new ReservationRespository();
		this.userServiceImpl = userServiceImpl;
	}

	@Override
	public void createReservation(String userId) {
		if (userServiceImpl.isLoggedIn()) {
			Date reservationTime = new Date();
			Reservation newReservation = new Reservation(reservationIdSequence++, userId, reservationTime);
			reservationRespository.save(newReservation);
			System.out.println("예약 완료");
		} else {
			System.out.println("로그인이 필요한 기능입니다.");
		}
	}

	@Override
	public List<Reservation> getReservationsByUserId(String userId) {
		List<Reservation> reservations = reservationRespository.findByUserId(userId);
		if (reservations.isEmpty()) {
			System.out.println(userId + "님의 예약이 없습니다.");
		}
		return reservations;
	}

	@Override
	public void cancelReservation(Long reservationId) {
		reservationRespository.findById(reservationId)
			.ifPresentOrElse(Reservation::cancel
					, () -> System.out.println("해당 예약 ID의 정보를 찾을 수 없습니다."));		
	}
}
