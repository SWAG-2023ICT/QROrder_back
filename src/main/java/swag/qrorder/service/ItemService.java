package swag.qrorder.service;

import swag.qrorder.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllItems(int itemId);
    boolean addItems(List<Item> items);
    boolean updateItem(Item item);
    boolean updateItemStatus(int itemId);
    boolean deleteItem(int itemId);
}
