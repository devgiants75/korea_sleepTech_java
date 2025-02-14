package chapter05;

// 음식점 클래스
// : 다양한 방법으로 음식을 주문 받는 메서드
class Restaurant {
	// 메서드 정의: placeOrder()
	
	// 메뉴 이름 (String dish)
	// 메뉴 이름 * 수량 제공 (int quantity)
	// 메뉴 이름 * 특별 요청 사항 (String specialRequests)
	// 메뉴 이름 * 수량 제공 * 특별 요청 사항
	
	void placeOrder(String dish) { 
		System.out.println(dish); 
	}
	void placeOrder(String dish, int quantity) {
		System.out.println(dish +  " * " + quantity);
	}
	void placeOrder(String dish, String specialRequests) {
		System.out.println(dish + " - " + specialRequests);
	}
	void placeOrder(String dish, int quantity, String specialRequests) {
		System.out.println(dish +  " * " + quantity + " - " + specialRequests);
	}
}

public class G_Overloading {
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		
		restaurant.placeOrder("햄버거");
		restaurant.placeOrder("피자", 2);
		restaurant.placeOrder("파스타", "소스 많이");
		restaurant.placeOrder("샐러드", 3, "땅콩 빼고");
	}
}