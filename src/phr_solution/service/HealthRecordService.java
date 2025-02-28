package phr_solution.service;

import java.util.List;

import phr_solution.dto.request.RecordRequestDto;
import phr_solution.dto.response.RecordResponseDto;

public interface HealthRecordService {
	void createRecord(RecordRequestDto dto);
	List<RecordResponseDto> getAllRecords();
	List<RecordResponseDto> filterRecordsByDiagnosis(String diagnosis);
	void deleteRecord(Long id);
}
