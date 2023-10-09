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
    public boolean addItems(List<Item> items) {
        Integer result = itemMapper.addItem(items);
        return result == items.size();
    }
}
