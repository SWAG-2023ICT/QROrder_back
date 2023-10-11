package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Item;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<Item> findAllItems(int itemId);
    Integer addItems(List<Item> items);
    Integer updateItem(Item item);
    Integer updateItemStatus(Item item);
    Integer deleteItem(int itemId);
}
