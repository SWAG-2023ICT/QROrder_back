package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import swag.qrorder.common.util.RandomCodeUtil;
import swag.qrorder.mapper.*;
import swag.qrorder.model.*;
import swag.qrorder.service.UserService;
import swag.qrorder.vo.ItemVo;
import swag.qrorder.vo.OrderVo;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final RestaurantMapper restaurantMapper;
    private final SeatMapper seatMapper;
    private final SessionMapper sessionMapper;
    private final ItemMapper itemMapper;
    private final OrderMapper orderMapper;
    private final RandomCodeUtil randomCodeUtil;

    public Session addOrder(String qrKey, OrderVo orderVo){
        Seat seat = getSeat(qrKey);
        Session session = addSession(seat.getRestaurantId());
        Order order = Order.builder()
                .totalPrice(orderVo.getTotalPrice())
                .seatId(seat.getSeatId())
                .sessionId(session.getSessionId())
                .build();
        Integer result = orderMapper.addOrder(order);
        if(result > 0){
            List<ItemVo> items = orderVo.getItems();
            List<OrderDetail> orderDetails = new ArrayList<>();
            for(ItemVo item : items){
                orderDetails.add(OrderDetail
                        .builder()
                        .itemId(item.getItemId())
                        .orderId(order.getOrderId())
                        .amount(item.getAmount())
                        .optionValueId(item.getOptionValueId())
                        .build());
            }
            result = orderMapper.addOrderList(orderDetails);
            if(result == orderDetails.size()){
                if(orderMapper.addSelectedOption(orderDetails) == orderDetails.size())
                    return session;
            }

        }
        return null;
    }

    @Override
    public List<OrderVo> findHistory(String sessionId) {
        return orderMapper.findHistory(sessionId);
    }

    private Session addSession(String restaurantId){
        Session session = sessionMapper.findSession(restaurantId);
        if(session == null){
            session = Session.builder()
                    .sessionId(randomCodeUtil.createRandomCode(64))
                    .restaurantId(restaurantId)
                    .build();
            sessionMapper.addSession(session);
        } // else 이전 세션이 만료되었는지 확인.
        return session;
    }
    private Seat getSeat(String qrKey){
        return seatMapper.findSeatByQr(qrKey);
    }

    @Override
    public Restaurant findMenuByQr(String qrKey) {
        return restaurantMapper.findMenuByQr(qrKey);
    }

    @Override
    public Item getMenuDetail(int itemId) {
        Item item = itemMapper.getMenuDetail(itemId);
//        if(item == null) throw new NullPointerException()
        return item;
    }
}
