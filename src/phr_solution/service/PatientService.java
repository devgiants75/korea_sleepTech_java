package phr_solution.service;

import java.util.List;

import phr_solution.dto.request.PatientRequestDto;
import phr_solution.dto.response.PatientResponseDto;

public interface PatientService {
	void registerPatient(PatientRequestDto dto);
	List<PatientResponseDto> listAllPatients();
	PatientResponseDto getPatientById();
	void updatePatient(Long id, PatientRequestDto dto);
	void deletePatient(Long id);
}
