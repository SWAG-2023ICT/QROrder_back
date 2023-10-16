package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.qrorder.mapper.ItemMapper;
import swag.qrorder.mapper.OptionMapper;
import swag.qrorder.model.Category;
import swag.qrorder.model.Item;
import swag.qrorder.model.Option;
import swag.qrorder.model.OptionValue;
import swag.qrorder.service.ItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;
    private final OptionMapper optionMapper;
    @Override
    public List<Item> findAllItems(int itemId) {
        return itemMapper.findAllItems(itemId);
    }
    @Override
    public boolean addItems(Item item) {
        Integer result = itemMapper.addItem(item);
        return result > 0;
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
    @Override
    public boolean addItemDetails(int itemId, List<Integer> categoryIds) {
        Map<String,Object> details = new HashMap<>();
        details.put("itemId",itemId);
        details.put("categoryIds",categoryIds);
        Integer result = itemMapper.addItemDetails(details);
        return result > 0;
    }
    @Override
    public boolean addOptions(List<Option> options) {
        Integer result = optionMapper.addOptions(options);
        if(result == options.size()){
            for(Option option : options){
                List<OptionValue> optionValues = option.getOptionValues();
                for(OptionValue optionValue : optionValues){
                    optionValue.setOptionId(option.getOptionId());
                }
                if(!addOptionValues(optionValues)) return false;
            }
        }
        return true;
    }
    @Override
    public boolean addOptionValues(List<OptionValue> values) {
        Integer result = optionMapper.addOptionValues(values);
        return result == values.size();
    }
    @Override
    public List<Category> getCategories() {
        return itemMapper.getCategories();
    }
}
