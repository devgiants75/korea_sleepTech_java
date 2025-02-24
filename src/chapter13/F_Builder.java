package chapter13;

// == 빌더로 게임 캐릭터 생성 == //
// 필수: 이름, 분류
// 선택: 스킬, 아이템

class GameCharacter {
	// 필수
	private final String name;
	private final String sort;
	
	// 선택 
	private final String skill;
	private final String item;
	
	// 1) 빌더 클래스
	public static class Builder {
		private final String name;
		private final String sort;

		private String skill = "Basic Attack";
		private String item = "None";
		
		// 생성자
		public Builder(String name, String sort) {
			this.name = name;
			this.sort = sort;
		}
		
		// 선택 필드에 대한 할당 메서드
		// : 필드명 그 자체의 메서드명을 가짐
		public Builder skiil(String skill) {
			this.skill = skill;
			return this;
		}
		
		public Builder item(String item) {
			this.item = item;
			return this;
		}
		
		public GameCharacter build() {
			return new GameCharacter(this);
		}
	}
	
	public GameCharacter(Builder builder) {
		this.name = builder.name;
		this.sort = builder.sort;
		this.skill = builder.skill;
		this.item = builder.item;
	}
}

public class F_Builder {
	
}
