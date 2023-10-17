package swag.qrorder.service;

import swag.qrorder.model.Item;
import swag.qrorder.model.Restaurant;
import swag.qrorder.vo.OrderVo;

import java.util.List;


public interface UserService {
    Restaurant findMenuByQr(String qrKey);
    Item getMenuDetail(int itemId);
    OrderVo addOrder(String qrKey, OrderVo orderVo);
}
