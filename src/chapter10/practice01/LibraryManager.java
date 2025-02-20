package chapter10.practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LibraryManager implements Manageable {
	private List<Item> items = new ArrayList<>();

	@Override
	public void add(Item item) {
		items.add(item);
		System.out.println("Item added: " + item.getName());
	}

	@Override
	public void remove(String id) {
		boolean removed = false; // 삭제 여부 확인용 데이터
		
		int size = items.size();
		for (int i = 0; i < size; i++) {
			// 전체 items를 순회
			// 각 순번의 item의 id와 매개변수의 id가 일치한다면 해당 인덱스의 요소를 제거
			if (items.get(i).getId().equals(id)) {
				items.remove(i);
				removed = true;
				System.out.println("Item with ID: " + id + " removed");
				break; // 반복문 종료
			}
		}
		
		if (!removed) {
			// 제거되지 않은 경우
			System.out.println("No item found with ID: " + id);
		}
	}

	@Override
	public List<Item> search(String keyword) {
		// 전체 리스트의 요소에서 키워드 검색
		// : name, author, publisher 통합 검색
		List<Item> foundItems = new ArrayList<>();
		
		for (Item item: items) {
			if (item.getName().contains(keyword)
					|| (item instanceof Book && ((Book)item).getAuthor().contains(keyword) 
							|| ((Book)item).getPublisher().contains(keyword))
			) {
				foundItems.add(item);
			}
		}
		
		if (foundItems.isEmpty()) {
			// 예외를 던질 경우 해당 메서드가 종료
			throw new NoSuchElementException("No item found for keyword: " + keyword);
		}
		
		return foundItems;
	}

	@Override
	public List<Item> searchByCategory(String category) {
		List<Item> result = new ArrayList<>();
		
		for (Item item: items) {
			if (item instanceof Book && ((Book)item).getCategory().equalsIgnoreCase(category)) {
				// equalsIgnoreCase
				// : 대소문자를 구분하지 않고 데이터의 값을 비교
				// : 영어만 사용 가능
				result.add(item);
			}
		}
		
		return result;
	}

	@Override
	public List<Item> searchByPriceRange(int minPrice, int maxPrice) {
		List<Item> result = new ArrayList<>();
		
		for (Item item: items) {
			if (item instanceof Book) {
				int price = ((Book)item).getPrice();
				
				if (price >= minPrice && price <= maxPrice) {
					result.add(item);
				}
			}
		}
		return result;
	}

	@Override
	public void updateStock(String id, int quantity) {
		for (Item item: items) {
			if (item.getId().equals(id) && item instanceof Book) {
				((Book)item).updateStock(quantity);
				System.out.println("Stock updated for ID: " + id + ", Stock: " + ((Book)item).getStock());
				return; // 메서드를 종료하는 키워드
			}
		}
		System.out.println("No item found with ID: " + id);
	}

	@Override
	public void listAll() {
		if (items.isEmpty()) {
			System.out.println("No items in the library");
		} else {
			System.out.println("=== Library Items ===");
			for (Item item: items) {
				item.display();
			}
		}
	}
}