package phr_solution.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import phr_solution.entity.HealthRecord;

public class HealthRecordRepository {
	private List<HealthRecord> records = new ArrayList<HealthRecord>();
	private static final HealthRecordRepository instance = new HealthRecordRepository();
	
	private HealthRecordRepository() {}
	
	public static HealthRecordRepository getInstance() {
		return instance;
	}
	
	public void save(HealthRecord record) {
		records.add(record);
	}
	
	public Optional<HealthRecord> findById(Long id) {
		return records.stream()
				.filter(record -> record.getId().equals(id))
				.findFirst();
	}
	
	public List<HealthRecord> findAll() {
		return records;
	}
	
	public void delete(HealthRecord healthRecord) {
		records.remove(healthRecord);
	}
}
