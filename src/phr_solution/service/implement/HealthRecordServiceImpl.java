package phr_solution.service.implement;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import phr_solution.dto.request.RecordRequestDto;
import phr_solution.dto.response.RecordResponseDto;
import phr_solution.entity.HealthRecord;
import phr_solution.entity.Patient;
import phr_solution.repository.HealthRecordRepository;
import phr_solution.repository.PatientRepository;
import phr_solution.service.HealthRecordService;

public class HealthRecordServiceImpl implements HealthRecordService {
	private final HealthRecordRepository recordRepository;
	private final PatientRepository patientRepository;
	
	private static long currentId = 1;
	
	public HealthRecordServiceImpl() {
		this.recordRepository = HealthRecordRepository.getInstance();
		this.patientRepository = PatientRepository.getInstance();
	}
	
	private Long generatedRecordId() {
		return currentId++;
	}
	
	// 환자 고유 ID 유효성 입증
	private void validatePatientId(Long patientId) {
		// 환자 존재 여부 확인
		Optional<Patient> foundPatient = patientRepository.findById(patientId);
		
		if (!foundPatient.isPresent()) {
			throw new IllegalArgumentException("해당 ID의 환자를 찾을 수 없습니다." + patientId);
		}
	}

	@Override
	public void createRecord(RecordRequestDto dto) {
		try {
			validatePatientId(dto.getPatientId());
			
			HealthRecord record = new HealthRecord(
					generatedRecordId(), dto.getPatientId(), dto.getDateOfVisit()
					, dto.getDiagnosis(), dto.getTreatment()
			);
			
			recordRepository.save(record);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<RecordResponseDto> getAllRecords() {
		List<RecordResponseDto> responseDtos = null;
		
		try {
			List<HealthRecord> records = recordRepository.findAll();
			
			responseDtos = records.stream()
					.map(record -> new RecordResponseDto(
							record.getId(), record.getPatientId()
							, record.getDateOfVisit(), record.getDiagnosis()
							, record.getTreatment(), new Date()
					))
					.collect(Collectors.toList());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return responseDtos;
	}

	@Override
	public List<RecordResponseDto> filterRecordsByDiagnosis(String diagnosis) {
		List<RecordResponseDto> responseDtos = null;
		
		try {
			List<HealthRecord> records = recordRepository.findAll();
			
			responseDtos = records.stream()
					// 스트림 중간요소는 스트림 값을 반환
					// filter: 조건에 일치하는(true) 값을 스트림으로 반환
					.filter(r -> r.getDiagnosis().contains(diagnosis))
					.map(filteredRecord -> new RecordResponseDto(
							filteredRecord.getId(), filteredRecord.getPatientId()
							, filteredRecord.getDateOfVisit(), filteredRecord.getDiagnosis()
							, filteredRecord.getTreatment(), new Date()
							
					))
					.collect(Collectors.toList());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return responseDtos;
	}

	@Override
	public void deleteRecord(Long id) {
		try {
			HealthRecord healthRecord = recordRepository.findById(id)
					.orElseThrow(() 
							-> new IllegalArgumentException("해당 ID의 건강 기록은 존재하지 않습니다. ID: " + id));
			
			recordRepository.delete(healthRecord);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
