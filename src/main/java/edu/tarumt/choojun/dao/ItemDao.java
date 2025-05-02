package edu.tarumt.choojun.dao;

import edu.tarumt.choojun.model.Item;
import java.util.List;

public interface ItemDao {
    void create(Item item);
    Item getById(Long id);
    List<Item> getAll();
    void update(Item item);
    void delete(Long id);
}