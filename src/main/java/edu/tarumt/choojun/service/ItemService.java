package edu.tarumt.choojun.service;

import edu.tarumt.choojun.model.Item;
import java.util.List;

public interface ItemService {
    void addItem(Item item);
    Item getItemById(Long id);
    List<Item> getAllItems();
    void updateItem(Item item);
    void deleteItem(Long id);
}