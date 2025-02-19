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
	
	
}


public class C_ListPractice {
	public static void main(String[] args) {
		
		
		
		
		
	}
}
