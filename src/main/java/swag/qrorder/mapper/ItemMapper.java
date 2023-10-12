package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Item;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemMapper {
    List<Item> findAllItems(int itemId);
    Integer addItems(List<Item> items);
    Integer updateItem(Item item);
    Integer updateItemStatus(Item item);
    Integer deleteItem(int itemId);
    Integer addItemDetails(Map<String,Object> details);
}
