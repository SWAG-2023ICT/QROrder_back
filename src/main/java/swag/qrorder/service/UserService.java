package swag.qrorder.service;

import swag.qrorder.model.Item;
import swag.qrorder.model.Restaurant;
import swag.qrorder.model.Session;
import swag.qrorder.vo.ItemVo;
import swag.qrorder.vo.OrderVo;

import java.util.List;

public interface UserService {
    Restaurant findMenuByQr(String qrKey);
    Item getMenuDetail(int itemId);
    Session addOrder(String qrKey, OrderVo orderVo);
    List<OrderVo> findHistory(String sessionId);
    List<ItemVo> findHistoryDetail(int orderListId);
}
