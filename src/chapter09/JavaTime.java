package chapter09;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// == java.time 패키지 ==
// : ISO-8601 표준을 기반으로 설계
// : YYYY-MM-DDThh:mm:ss.sssZ
// - import 문을 사용하여 클래스를 명시!

public class JavaTime {
	public static void main(String[] args) {
		// 1) LocalDate - 날짜
		// : 날짜(연도, 월, 일)
		// .now(): 현재 날짜 반환
		// .of(연도, 월, 일): 특정 날짜를 국제 표기법 상 반환
		LocalDate today = LocalDate.now();
		System.out.println(today); // 2025-02-19

		LocalDate yesterday = LocalDate.of(2025, 2, 18);
		System.out.println(yesterday); // 2025-02-18

		// .plus(Years, Months, Days): N년 후, N달 후, N일 후
		LocalDate tomorrow = today.plusDays(1);
		System.out.println(tomorrow); // 2025-02-20

		// .minus(Years, Months, Days): N년 전, N달 전, N일 전
		LocalDate oneMonthsAgo = today.minusMonths(1);
		System.out.println(oneMonthsAgo); // 2025-01-19

		// 2) LocalTime - 시간
		// : 시간(시, 분, 초, 나노초)만 다룸
		// - 날짜와 시간대 정보는 포함하지 X
		// .now() - 현재 시간 반환
		// .of(시, 분, 초) - 특정 시간을 표준 형태로 반환

		LocalTime now = LocalTime.now();
		System.out.println(now); // 11:12:28.215875800

		LocalTime lunchTime = LocalTime.of(12, 50);
		System.out.println(lunchTime); // 12:50

		// .plus(Hours, Minutes, Seconds)
		// .minus(Hours, Minutes, Seconds)

		LocalTime restTime = now.plusMinutes(35);
		System.out.println(restTime); // 11:50:07.926675400

		// cf) LocalDateTime 클래스
		// : 날짜와 시간을 함께 다루는 클래스
		// > .now(), .of(), .plus~(), .minus~() 사용 가능
		LocalDateTime nowDateTime = LocalDateTime.now();
		System.out.println(nowDateTime); // 2025-02-19T11:16:38.093757300

		// cf) get 메서드
		// : getYear(), getMonth(), getDayOfMonth(): 날짜 정보를 반환
		// : getHour(), getMinute(), getSecond(): 시간 정보를 반환
		System.out.println(today.getYear()); // 2025
		System.out.println(today.getMonth()); // FEBRUARY - 키워드 반환
		System.out.println(today.getDayOfMonth()); // 19

		// cf) 날짜/시간 포맷팅
		// : formatting - 원하는 형식으로 출력
		LocalDateTime example = LocalDateTime.now();
		System.out.println(example); // 2025-02-19T11:22:10.591169200

		// DateTimeFormatter: LocalDateTime의 날짜/시간 데이터를 원하는 패턴으로 변경
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");

		// 변경할 날짜/시간 데이터.format(원하는 포맷 형식)
		System.out.println(example.format(formatter)); // 25-02-19 11:24:33
	}
}