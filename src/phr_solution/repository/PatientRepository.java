package phr_solution.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import phr_solution.entity.Patient;

public class PatientRepository {
	List<Patient> patients = new ArrayList<Patient>();
	private static final PatientRepository instance = new PatientRepository();
	
	private PatientRepository() {}
	
	public static PatientRepository getInstance() {
		return instance;
	}
	
	// 환자 정보 저장
	public void save(Patient newPatient) {
		patients.add(newPatient);
	}
	
	// 환자 조회 (단건)
	// : 요청하는 id의 환자 정보가 없을 경우 null 값이 반환되는 것을 방지하기 위한 Optional 클래스
	public Optional<Patient> findById(Long id) {
		return patients.stream()
				.filter(patient -> patient.getId().equals(id))
				.findFirst(); 
				// 최종 연산의 .findFirst(): 조건에 해당하는 요소 중 첫 번째 요소를 Optional로 반환
	}
	
	// 환자 조회 (전체)
	public List<Patient> findAll() {
		return patients;
	}
	
	// 환자 삭제
	public void delete(Patient patient) {
		patients.remove(patient);
	}
}
