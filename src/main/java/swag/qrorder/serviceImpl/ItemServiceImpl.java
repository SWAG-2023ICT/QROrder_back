package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swag.qrorder.mapper.ItemMapper;
import swag.qrorder.model.Item;
import swag.qrorder.service.ItemService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;
    @Override
    public List<Item> findAllItems(int itemId) {
        return itemMapper.findAllItems(itemId);
    }
    @Override
    public boolean addItems(List<Item> items) {
        Integer result = itemMapper.addItems(items);
        return result == items.size();
    }
    @Override
    public boolean updateItem(Item item) {
        Integer result = itemMapper.updateItem(item);
        return result > 0;
    }
    @Override
    public boolean updateItemStatus(int itemId) {
        Item item = this.findAllItems(itemId).get(0);
        item.setItemStatus(!item.isItemStatus());
        Integer result = itemMapper.updateItemStatus(item);
        return result > 0;
    }
    @Override
    public boolean deleteItem(int itemId) {
        Integer result = itemMapper.deleteItem(itemId);
        return result > 0;
    }
}
