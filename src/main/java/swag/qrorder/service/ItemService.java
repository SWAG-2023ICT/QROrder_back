package swag.qrorder.service;

import swag.qrorder.model.Item;

import java.util.List;

public interface ItemService {
    boolean addItems(List<Item> items);
}
