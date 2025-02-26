package chapter14.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// === 직원 관리 시스템 === //

// 직원 데이터 정의
@AllArgsConstructor // Setter 역할
@Getter
@ToString
class Employee {
	private String department; // 부서
	private String name; // 직원명
	private int salary; // 급여
}

public class Practice02 {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("IT", "이승아", 300),
				new Employee("HR", "조승범", 500),
				new Employee("IT", "김준일", 400),
				new Employee("OP", "전예찬", 350),
				new Employee("HR", "윤대휘", 380)
		);
		
		// 1. 급여가 400 이상인 직원 '필터링'
		// : filter() - 조건을 검사해서 true인 요소만을 다시 반환
		List<Employee> highSalaryEmployees = employees.stream()
				.filter(e -> e.getSalary() >= 400)
				.collect(Collectors.toList());
		
		highSalaryEmployees.forEach(e -> System.out.println(e));
//		highSalaryEmployees.forEach(System.out::println);
		
		// 2. IT 부서 직원의 이름만 추출
		// 1) 부서(department)가 'IT'인 직원을 필터링 - filter
		// 2) 부서가 'IT'인 직원 목록을 전체 순회하여 이름만 추출 - map
		List<String> itEmployeeNames = employees.stream()
			.filter(employee -> "IT".equals(employee.getDepartment()))
//			.map(employee -> employee.getName())
			.map(Employee::getName) // 임의 객체 인스턴스 메서드 참조(객체클래스타입::인스턴스메서드)
			.collect(Collectors.toList());
		
		itEmployeeNames.forEach(System.out::println);
		
		// 3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
		// 1) 부서가 'HR'인 직원을 필터링 >> equals
		// 2) 위의 목록 중 이름에 '조'가 포함된 직원을 필터링 >> contains
		
		List<Employee> employeeWithJo = employees.stream()
				.filter(employee -> employee.getDepartment().equals("HR"))
				.filter(employee -> employee.getName().contains("조"))
				.collect(Collectors.toList());
		
		employeeWithJo.forEach(System.out::println);
	}
}
