package chapter07.animalApp;

import java.util.ArrayList;

// == 동물 관리 시스템 == //
public class MainApp {
	public static void main(String[] args) {
		// == 서비스 계층(실행) 생성 == //
		// : service 객체의 handleAnimal 메서드는 Animal 타입의 객체를 인자로 받음
		AnimalService service = new AnimalService();
		
		// 동물을 관리하는 List 생성
		ArrayList<Animal> animals = new ArrayList<>();
		
		// 동적 배열에 객체 추가
		// : Animal 타입에 Cat/Dog 객체가 추가
		// >> 업캐스팅(자동 타입 변환)
		animals.add(new Cat());
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Dog());
		
		// 배열의 모든 동물을 service에 전달하여 출력
		for (Animal animal : animals) {
			if (animal instanceof Cat) {
				System.out.println("고양이가 있다.");
				Cat cat = (Cat) animal; // 다운캐스팅
				cat.eat();
			}
			service.handleAnimal(animal);
		}
		
		// 객체 생성 및 처리
		Animal cat = new Cat();
		Animal dog = new Dog();
		
		service.handleAnimal(cat);
		service.handleAnimal(dog);
		
		// cat.eat();
		
		if (cat instanceof Cat) {
			Cat onlycat = (Cat) cat;
			// 다운 캐스팅 - 해당 클래스가 가진 고유 멤버(필드, 메서드)에 접근 가능
			onlycat.eat(); // 츄르
		}
		
		if (dog instanceof Cat) { // false - 조건문 안의 오류구문이 실행되지 X
			Cat dogCat = (Cat) dog; 
			dogCat.eat();			
		}
	}
}