package chapter13;

import java.util.ArrayList;
import java.util.List;

// 제네릭 와일드 카드 정리 //
// 1. 일반 와일드 카드: 모든 타입 허용 <?>
// 2. 상한 제한 와일드 카드: 특정 타입 & 그 하위 클래스만 허용 <? extends Number>
// 3. 하한 제한 와일드 카드: 특정 타입 & 그 상위 클래스만 허용 <? super Integer>

// == 주문 관리 시스템 == //
// 상품(Product)과 할인(Discount) 정보를 관리
// : 할인 정책 사용 시, Product 또는 Product를 상속받는 하위 클래스에서만 적용

// 1. 상위 클래스
class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() { return price; }
	public String getName() { return name; }
}

// 2. 하위 클래스: Electronics
class Electronics extends Product {
	public Electronics(String name, int price) {
		super(name, price);
	}
}

// 2. 하위 클래스: Furniture
class Furniture extends Product {
	public Furniture(String name, int price) {
		super(name, price);
	}
}

// 3. 할인 정책 클래스
class DiscountPolicy {
	public static double applyDiscount(List<? extends Product> products, double discountRate) {
		// 리스트 컬렉션 프레임워크 형식에 Product 타입을 가지거나 해당 타입의 하위 클래스(전자, 가구)만을 허용
		// : 상한 제한 와일드 카드
		double totalDiscount = 0.0;
		
		for (Product product: products) {
			double discount = product.getPrice() * discountRate;
			totalDiscount += discount;
			System.out.println(product.getName() +  " 할인 적용: " + discount + "원");
		}
		
		return totalDiscount;
	}
}

public class C_Generic_Prac {
	public static void main(String[] args) {
		List<Electronics> electronics = new ArrayList<>();
		electronics.add(new Electronics("냉장고", 108));
		electronics.add(new Electronics("세탁기", 130));
		electronics.add(new Electronics("인덕션", 80));
		
		double totalElectronics = DiscountPolicy.applyDiscount(electronics, 0.1);
		
		System.out.println("총 가전 할인액: " + totalElectronics + "원"); //  총 가전 할인액: 31.8원
		
		List<Furniture> furnitures = new ArrayList<>();
		furnitures.add(new Furniture("침대", 230));
		furnitures.add(new Furniture("쇼파", 170));
		furnitures.add(new Furniture("화장대", 50));
		
		double totalFurnitures = DiscountPolicy.applyDiscount(furnitures, 0.2);
		
		System.out.println("총 가구 할인액: " + totalFurnitures + "원"); // 총 가구 할인액: 90.0원
	}
}
