package swag.qrorder.service;

import swag.qrorder.model.Category;
import swag.qrorder.model.Item;
import swag.qrorder.model.Option;
import swag.qrorder.model.OptionValue;

import java.util.List;

public interface ItemService {
    List<Item> findAllItems(int itemId);
    boolean addItems(Item items);
    boolean updateItem(Item item);
    boolean updateItemStatus(int itemId);
    boolean deleteItem(int itemId);
    boolean addItemDetails(int itemId, List<Category> categories);
    boolean addOptions(List<Option> options);
    boolean addOptionValues(List<OptionValue> values);
    List<Category> getCategories();
}
