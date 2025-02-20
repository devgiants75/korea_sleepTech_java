package chapter10.practice02.service;

import java.util.List;
import chapter10.practice02.entity.Item;

public interface InventoryService {
	void addItem(Item item);
	void updateItemPrice(String itemId, int newPrice);
	void deleteItem(String itemId);
	List<Item> getItemsByCategory(String category);
}
