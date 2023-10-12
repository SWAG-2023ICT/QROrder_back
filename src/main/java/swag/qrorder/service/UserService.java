package swag.qrorder.service;

import swag.qrorder.model.Item;
import swag.qrorder.model.Restaurant;


public interface UserService {
    Restaurant findMenuByQr(String qrKey);
    Item getMenuDetail(int itemId);
}
