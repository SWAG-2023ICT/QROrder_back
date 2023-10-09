package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Item;

import java.util.List;

@Mapper
public interface ItemMapper {
    Integer addItem(List<Item> items);
}
