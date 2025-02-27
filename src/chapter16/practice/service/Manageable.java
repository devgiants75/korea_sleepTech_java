package chapter16.practice.service;

import java.util.List;

import chapter16.practice.entity.Category;
import chapter16.practice.entity.Item;

public interface Manageable {
	List<Item> searchByCategory(Category category);
}
