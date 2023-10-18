package swag.qrorder.service;

import swag.qrorder.vo.OrderVo;

import java.util.List;

public interface OwnerService {
    boolean closeSession(String sessionId);
    List<OrderVo> findOrders(String restaurantId);
}
