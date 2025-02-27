package chapter16.practice.entity;

public enum Category {
	FICTION, NONFICTION, SCIENCE, HISTORY, FANTASY;
	
	public static Category fromString(String value) {
		try {
			return Category.valueOf(value);
			// >> valueOf(인자)에 Category와 일치하지 않는 인자값 전달의 경우 IllegalArgumentException 발생
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid category: " + value);
		}
	}
}
