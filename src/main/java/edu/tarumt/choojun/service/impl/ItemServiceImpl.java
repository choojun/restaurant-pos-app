package edu.tarumt.choojun.service.impl;

import edu.tarumt.choojun.dao.ItemDao;
import edu.tarumt.choojun.model.Item;
import edu.tarumt.choojun.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemDao itemDao;

    @Autowired
    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public void addItem(Item item) {
        itemDao.create(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemDao.getById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemDao.getAll();
    }

    @Override
    public void updateItem(Item item) {
        itemDao.update(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemDao.delete(id);
    }
}