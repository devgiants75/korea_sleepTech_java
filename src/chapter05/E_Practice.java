package chapter05;

class BaseballPlayer {
	// === 인스턴스 변수 ===
    // 선수 이름(name -  문자열)
    // 타율(battingAverage - 실수)
    // 홈런 수(homeRuns - 정수)
	String name;
	double battingAverage;
	int homeRuns;
	
	// === 정적(클래스) 변수 ===
    // : 생성된 선수의 총 인원(playerCount - 정수)
    // >> 모든 인스턴스에서 공유
	static int playerCount;
	
	// == 생성자 ==
	// +) 필드값 초기화 & 정적 변수 후위 증가
	BaseballPlayer(String name, double battingAverage, int homeRuns) {
		this.name = name;
		this.battingAverage = battingAverage;
		this.homeRuns = homeRuns;
		
		playerCount++;
	}
	
	// 1) 인스턴스 메서드
	void updateStatus(double newBattingAverage, int newHomeRuns) {
		battingAverage = newBattingAverage;
		homeRuns = newHomeRuns;
	}
	
	// 2) 정적 메서드
	// : 특정 홈런 수 이상인 선수를 평가
	static String evaluateHomeRun(int homeRunCount) {
		if (homeRunCount > 20) {
			return "홈런상 후보에 등록됩니다.";
		} else {
			return "홈런상 후보에 등록될 수 없습니다.";
		}
	}
}

public class E_Practice {
	public static void main(String[] args) {
		
		// 인스턴스 생성
		BaseballPlayer player1 = new BaseballPlayer("윤영서", 0.325, 16);
		BaseballPlayer player2 = new BaseballPlayer("문창배", 0.293, 20);
		BaseballPlayer player3 = new BaseballPlayer("전창현", 0.301, 11);
		BaseballPlayer player4 = new BaseballPlayer("고혁재", 0.292, 21);
		
		System.out.println("총 생성된 선수의 수: " + BaseballPlayer.playerCount);
		// 총 생성된 선수의 수: 4
		
		player2.updateStatus(0.312, 22);
		System.out.println(player2.battingAverage); // 0.312
		System.out.println(player2.homeRuns); // 22
		
		System.out.println(BaseballPlayer.evaluateHomeRun(player3.homeRuns));
		System.out.println(BaseballPlayer.evaluateHomeRun(player4.homeRuns));
	}
}