package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swag.qrorder.mapper.OrderMapper;
import swag.qrorder.service.OwnerService;
import swag.qrorder.vo.OrderVo;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OwnerServiceImpl implements OwnerService {
    private final OrderMapper orderMapper;
    @Override
    public boolean closeSession(String sessionId) {
        Integer result = orderMapper.closeSession(sessionId);
        return result > 0;
    }
    @Override
    public List<OrderVo> findOrders(String restaurantId) {
        return orderMapper.findOrders(restaurantId);
    }
}
