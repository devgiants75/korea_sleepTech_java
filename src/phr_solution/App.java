package phr_solution;

import java.util.List;
import java.util.Scanner;

import phr_solution.controller.HealthRecordController;
import phr_solution.controller.PatientController;
import phr_solution.dto.request.PatientRequestDto;
import phr_solution.dto.request.RecordRequestDto;
import phr_solution.dto.response.PatientResponseDto;
import phr_solution.dto.response.RecordResponseDto;

/*
 * === PHR (개인 건강 기록, Personal Health Record) 솔루션 === 
 * 
 * 1. 프로젝트 개요
 * : 개인 건강 기록(PHR) 솔루션을 위한 간단한 콘솔 기반 응용 프로그램
 * 		- 환자의 기본 정보를 관리, 환자의 건강 기록 등록, 수정, 조회 기능
 * 		- 특정 조건에 맞는 건강 기록을 필터링하고 집계 기능
 * 
 * 2. 주요 기능 & 비즈니스 로직
 * : 환자 정보 관리
 * 		- CR(단건/전체)UD
 * : 건강 기록 관리
 * 		- CRUD + 필터링(조회)
 * 
 * 3. 비즈니스 로직 구조
 * - Controller: 사용자의 입력을 처리하고 적절한 서비스 메소드를 호출
 * - Service: 핵심 비즈니스 로직을 수행
 * - Repository: 데이터 저장소와의 상호 작용을 담당
 * - DTO: 계층 간 데이터 전송을 위한 객체
 * - Entity: 데이터베이스 테이블과 매핑되는 도메인 객체
 *
 * 4. 실행 및 관리
 * - Main Class (App.java): 프로그램의 실행 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어
 * */

public class App {
	private static final Scanner sc = new Scanner(System.in);
	private static final PatientController patientController = new PatientController();
	private static final HealthRecordController healthRecordController = new HealthRecordController();

	private static void displayMenu() {
		System.out.println("\n[메뉴 선택]");
		// cf) 이스케이프 문자
		// : 문자 제어 코드, 문자열 내에서 특수한 기능을 수행하는 문자
		// - 백슬래시(\)를 사용하여 표현
		// \n(줄바꿈), \\(\ 기호 그 자체) \"(" 기호 그 자체) 등
		System.out.println("1. 환자 등록");
		System.out.println("2. 환자 정보 전체 조회");
		System.out.println("3. 환자 정보 단건 조회");
		System.out.println("4. 환자 정보 수정");
		System.out.println("5. 환자 정보 삭제");

		System.out.println("6. 건강 기록 추가");
		System.out.println("7. 건강 기록 조회");
		System.out.println("8. 건강 기록 필터링");
		System.out.println("9. 건강 기록 삭제");

		System.out.println("10. 프로그램 종료");
		System.out.print("메뉴를 선택하세요: ");
	}

	private static int getChoice() {
		// sc.hasNextInt()
		// : 입력 받은 값이 숫자면 true, 아니면 false 반환
		while (!sc.hasNextInt()) {
			System.out.println("숫자를 입력해주세요.");
			sc.next();
		}

		int choice = sc.nextInt();
		sc.next(); // 버퍼 처리
		return choice;
	}

	private static String getInput(String prompt) {
		System.out.print(prompt + ": ");
		return sc.nextLine().trim();
	}

	private static long getIdInput() {
		String input = getInput("ID를 입력하세요");
		return Long.parseLong(input);
	}

	private static PatientRequestDto createPatientRequest() {
		PatientRequestDto dto = null;

		try {
			String name = getInput("환자 이름을 입력하세요");
			int age = Integer.parseInt(getInput("환자 나이를 입력하세요"));
			String gender = getInput("환자 성별을 입력하세요(남/여)");

			dto = new PatientRequestDto(name, age, gender);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dto;
	}

	private static RecordRequestDto createRecordRequest() {
		RecordRequestDto dto = null;

		try {

			long patientId = getIdInput();
			String dateOfVisit = getInput("방문 날짜를 입력하세요(예: 2025-02-28)");
			String diagnosis = getInput("진단명을 입력하세요");
			String treatment = getInput("처방 내용을 입력하세요");

			dto = new RecordRequestDto(patientId, dateOfVisit, diagnosis, treatment);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dto;
	}

	private static boolean processChoice(int choice) {
		switch (choice) {
		// 환자 관련 기능
		case 1: {
			PatientRequestDto requestDto = createPatientRequest();
			patientController.registerPatient(requestDto);
			break;
		}
		case 2: {
			List<PatientResponseDto> patients = patientController.getAllPatients();
			if (patients.isEmpty()) {
				System.out.println("환자 정보가 없습니다.");
			} else {
				patients.forEach(System.out::println);
			}
			break;
		}
		case 3: {
			long id = getIdInput();
			PatientResponseDto patient = patientController.getPatientById(id);
			if (patient == null) {
				System.out.println("해당하는 ID의 환자가 없습니다.");
			} else {
				System.out.println(patient);
			}
			break;
		}
		case 4: {
			long id = getIdInput();
			PatientRequestDto requestDto = createPatientRequest();
			patientController.updatePatient(id, requestDto);
			break;
		}
		case 5: {
			long id = getIdInput();
			patientController.deletePatient(id);
			break;
		}

		// 건강 기록 관련 기능
		case 6: {
			RecordRequestDto requestDto = createRecordRequest();
			healthRecordController.createRecord(requestDto);
			break;
		}
		case 7: {
			List<RecordResponseDto> records = healthRecordController.getAllRecords();
			if (records.isEmpty()) {
				System.out.println("건강 기록이 없습니다.");
			} else {
				records.forEach(System.out::println);
			}
			break;
		}
		case 8: {
			String diagnosisFilter = getInput("필터 조건 (진단명):");
			List<RecordResponseDto> filteredRecords = healthRecordController.filterRecordsByDiagnosis(diagnosisFilter);
			if (filteredRecords.isEmpty()) {
				System.out.println("검색 결과를 찾을 수 없습니다.");
			} else {
				filteredRecords.forEach(System.out::println);
			}
			break;
		}
		case 9: {
			long id = getIdInput();
			healthRecordController.deleteRecord(id);
			break;
		}
		case 10: {
			System.out.println("프로그램을 종료합니다. 이용해주셔서 갑사합니다 :)");
			return false;
		}
		default: {
			System.out.println("잘못된 선택입니다. 유효한 메뉴를 선택해주세요.");
			break;
		}
		}
		return true;
	}

	public static void main(String[] args) {
		try {
			while (true) {
				displayMenu(); // 프로그램 메뉴 출력
				int choice = getChoice(); // 사용자 메뉴 선택 저장

				// 사용자의 선택을 처리
				// : 처리의 반환 값이 false면 while문 종료
				if (!processChoice(choice))
					break;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// 예외 발생과 상관없이 반드시 실행 보장
			sc.close();
		}
	}
}
