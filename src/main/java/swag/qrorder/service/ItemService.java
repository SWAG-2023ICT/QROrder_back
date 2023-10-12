package swag.qrorder.service;

import swag.qrorder.model.Item;
import swag.qrorder.model.Option;
import swag.qrorder.model.OptionValue;

import java.util.List;

public interface ItemService {
    List<Item> findAllItems(int itemId);
    boolean addItems(List<Item> items);
    boolean updateItem(Item item);
    boolean updateItemStatus(int itemId);
    boolean deleteItem(int itemId);
    boolean addItemDetails(int itemId, List<Integer> categoryIds);
    boolean addOptions(List<Option> options);
    boolean addOptionValues(List<OptionValue> values);
}
