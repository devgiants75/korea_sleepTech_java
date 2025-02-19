package chapter10;

import java.util.ArrayList;
import java.util.LinkedList;

// === 이벤트 관리 시스템 === //
// - 이벤트 참가자 명단과 대기열 관리를 위한 시스템
// : 참가자는 사전 등록된 명단을 통해 이벤트에 참가
// : 명단이 가득 찰 경우 대기열로 추가, 참가자가 떠나면 대기열의 다음 사람이 추가

// 1) 이벤트 참가자 명단 관리: 사전 등록, 이벤트 당일 추가 참가자 등록 X
// : ArrayList (목록 추가, 삭제 X / 참가자 조회 O)

// 2) 대기열 관리
// : 이벤트의 한정된 좌석, 좌석이 모두 차면 추가 참가자는 대기열에 등록
// : LinkedList (목록 추가, 삭제 O / 참가자 조회 X)

class EventManagement {
	// == 필드 == //
	ArrayList<String> participantList = new ArrayList<>(); // 이벤트 참가자 명단
	LinkedList<String> waitingQueue = new LinkedList<>(); // 대기열 명단
	
	// == 메서드 == //
	void addParticipant(String name) {
		participantList.add(name);
	}
	
	void addToWaitingQueue(String name) {
		waitingQueue.add(name);
	}
	
	void leaveParticipant(String name) {
		// 대기열의 인원이 존재해야만 대기열 인원을 참가자 명단에 추가 가능
		// : 대기열 크기(.size())가 0 이상
		if (waitingQueue.size() > 0) {
			String nextParticipant = waitingQueue.remove(0); // 대기열에서 제거
			addParticipant(nextParticipant); // 참가자 명단에 추가
		}
	}
	
	boolean checkParticipant(String name) {
		return participantList.contains(name);
	}
}

public class C_ListPractice {
	public static void main(String[] args) {
		EventManagement eventManagement = new EventManagement();
		
		eventManagement.addParticipant("이승아");
		eventManagement.addParticipant("이도경");
		eventManagement.addParticipant("조승범");
		eventManagement.addParticipant("진상영");
		eventManagement.addParticipant("윤대휘");
		
		eventManagement.addToWaitingQueue("정규민");
		eventManagement.addToWaitingQueue("박성욱");
		eventManagement.addToWaitingQueue("김소빈");
		eventManagement.addToWaitingQueue("윤안나");
		
		System.out.println(eventManagement.participantList); // [이승아, 이도경, 조승범, 진상영, 윤대휘]
		System.out.println(eventManagement.waitingQueue); // [정규민, 박성욱, 김소빈, 윤안나]
		
		eventManagement.addToWaitingQueue("이은우");
		eventManagement.addToWaitingQueue("이혜지");
		
		eventManagement.leaveParticipant("이승아");
		eventManagement.leaveParticipant("조승범");
		eventManagement.leaveParticipant("윤대휘");
		
		System.out.println(eventManagement.participantList);
		// [이승아, 이도경, 조승범, 진상영, 윤대휘, 정규민, 박성욱, 김소빈]
		
		System.out.println(eventManagement.waitingQueue); // [윤안나, 이은우, 이혜지]
		
		System.out.println(eventManagement.checkParticipant("조승범")); // true
		System.out.println(eventManagement.checkParticipant("이은우")); // false
	}
}
