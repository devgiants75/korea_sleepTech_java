package chapter10.practice01;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Inventory: 재고 관리
public class InventorySystem {
	public static void main(String[] args) {
		LibraryManager manager = new LibraryManager(); // 도서 관리 시스템을 인스턴스화
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("=== Inventory System ===");
			// CRUD(크루드)
			// : 저장된 데이터에 대해 작업할 수는 있는 기본 데이터 처리 기능
			System.out.println("1. Add Book"); // 생성(추가) Create
			System.out.println("2. List All Book"); // 조회 Read
			System.out.println("3. Search Book");
			System.out.println("4. Search by Category");
			System.out.println("5. Search by Price Range");
			System.out.println("6. Update Stock"); // 수정 Update
			System.out.println("7. Remove Book"); // 삭제 Delete
			System.out.println("8. Exit");
			
			try {
				// sc.nextLine();
				// : 입력값이 문자열로 인식 
				
				// Integer.parseInt(A)
				// : A 값을 분석하여 Integer 형태로 변경
				// >> 숫자 형태로 변경할 수 없는 값이 입력되는 경우 NumberFormatException 예외 발생 
				int choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) {
				case 1:
					System.out.println("Enter Book ID: ");
					String id = sc.nextLine();
					System.out.println("Enter Book Title: ");
					String title = sc.nextLine();
					System.out.println("Enter Book ISBN: ");
					String isbn = sc.nextLine();
					System.out.println("Enter Book Author: ");
					String author = sc.nextLine();
					System.out.println("Enter Book Publisher: ");
					String publisher = sc.nextLine();
						
					System.out.println("Enter Book Publish Year: ");
					int year = Integer.parseInt(sc.nextLine());
					System.out.println("Enter Book Price: ");
					int price = Integer.parseInt(sc.nextLine());
					System.out.println("Enter Book Stock Quantity: ");
					int stock = Integer.parseInt(sc.nextLine());
					
					System.out.println("Enter Book Category");
					String category = sc.nextLine();
					
					manager.add(new Book(id, title, isbn, author, publisher, year, price, stock , category));
					break;
				case 2:
					manager.listAll();
					break;
				case 3:
					System.out.println("Enter Search Keyword");
					String keyword = sc.nextLine();
					List<Item> searchResults = manager.search(keyword);
					if (searchResults.isEmpty()) {
						System.out.println("No items found in keyword: " + keyword);
					} else {
						for (Item item: searchResults) {
							item.display();
						}
					}
					break;
				case 4:
					System.out.println("Enter Category: ");
					String searchCategory = sc.nextLine();
					List<Item> categoryResults = manager.searchByCategory(searchCategory);
					if (categoryResults.isEmpty()) {
						System.out.println("No items found in category: " + searchCategory);
					} else {
						for (Item item: categoryResults) {
							item.display();
						}
					}
					break;
				case 5:
					System.out.println("Enter minimum price: ");
					int minPrice = Integer.parseInt(sc.nextLine());
					System.out.println("Enter maximum price: ");
					int maxPrice = Integer.parseInt(sc.nextLine());
					
					List<Item> priceResults = manager.searchByPriceRange(minPrice, maxPrice);
					if (priceResults.isEmpty()) {
						System.out.println("No items in price range");
					} else {
						for (Item item: priceResults) {
							item.display();
						}
					}
					break;
				case 6:
					System.out.println("Enter Book ID to update stock: ");
					String updateId = sc.nextLine();
					System.out.println("Enter Quantity to add/subtract");
					int quantity = Integer.parseInt(sc.nextLine());
					
					manager.updateStock(updateId, quantity);
					break;
				case 7:
					System.out.println("Enter Book ID to remove: ");
					String removeId = sc.nextLine();
					manager.remove(removeId);
					break;
				case 8:
					System.out.println("If you want to exit, please enter 'Y'");
					if (sc.nextLine().equalsIgnoreCase("y")) {
						System.out.println("=== Exiting ===");
						return;
					}
					System.out.println("Please try again");
				default:
					System.out.println("Invalid option. Try again!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please Enter a valid number");
			} catch (NoSuchElementException e) {
				// 검색된 내용이 없을 경우 실행될 블럭
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
