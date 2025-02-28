package phr_solution.controller;

import java.util.List;

import phr_solution.dto.request.PatientRequestDto;
import phr_solution.dto.response.PatientResponseDto;
import phr_solution.service.PatientService;
import phr_solution.service.implement.PatientServiceImpl;

public class PatientController {
	private PatientService service;
	
	public PatientController() {
		this.service = new PatientServiceImpl();
	}
	
	public void registerPatient(PatientRequestDto dto) {
		service.registerPatient(dto);
	}
	
	public List<PatientResponseDto> getAllPatients() {
		List<PatientResponseDto> patients = service.listAllPatients();
		return patients;
	}
	
	public PatientResponseDto getPatientById(long id) {
		PatientResponseDto patient = service.getPatientById(id);
		return patient;
	}
	
	public void updatePatient(long id, PatientRequestDto dto) {
		service.updatePatient(id, dto);
	}
	
	public void deletePatient(long id) {
		service.deletePatient(id);
	}
}
