package swag.qrorder.service;

import swag.qrorder.model.Item;
import swag.qrorder.model.Order;
import swag.qrorder.model.Restaurant;


public interface UserService {
    Restaurant findRestaurantByQr(String qrKey);
}
