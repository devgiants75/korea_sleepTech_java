package chapter16;


/*
 * == ENUM 메서드 오버라이딩 ==
 * : Enum은 상수별 다른 동작 정의
 * - abstract 메서드를 선언하고 상수별로 구현 가능
 * */

enum Operation {
	ADD {
		public int apply(int x, int y) {
			return x + y;
		}
	},
	SUBTRACT {
		public int apply(int x, int y) {
			return x - y;
		}
	},
	MULTIPLY {
		@Override
		public int apply(int x, int y) {
			return x * y;
		}
	};	
	public abstract int apply(int x, int y);
}

enum Season {
	SPRING("봄"),
	SUMMER("여름"),
	AUTUMN("가을"),
	WINTER("겨울");
	
	private final String seasonName;
	
	Season(String seasonName) {
		this.seasonName = seasonName;
	}
	
	public String getSeasonName() { return seasonName; }
}

public class C_Enum {
	public static void main(String[] args) {
		System.out.println(Operation.ADD.apply(5, 3));
		System.out.println(Operation.SUBTRACT.apply(5, 3));
		
		Season seaon = Season.WINTER;
		switch(seaon) {
		case SPRING:
			System.out.println("봄봄봄 봄이 왔어요~~");
			break;
		case SUMMER:
			System.out.println("한 여름밤의 꿀~~");
			break;
		case AUTUMN:
			System.out.println("나 가을 타나봐~~");
			break;
		case WINTER:
			System.out.println("메리 크리스마스~~");
			break;
		}
	}
}