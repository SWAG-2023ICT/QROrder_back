package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swag.qrorder.common.util.RandomCodeUtil;
import swag.qrorder.mapper.ItemMapper;
import swag.qrorder.mapper.RestaurantMapper;
import swag.qrorder.mapper.SeatMapper;
import swag.qrorder.mapper.SessionMapper;
import swag.qrorder.model.*;
import swag.qrorder.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final RestaurantMapper restaurantMapper;
    private final SeatMapper seatMapper;
    private final SessionMapper sessionMapper;
    private final ItemMapper itemMapper;
    private final RandomCodeUtil randomCodeUtil;

    public void addOrder(String qrKey,List<Item> items){
        Seat seat = getSeat(qrKey);
        String sessionId = addSession(qrKey,seat.getRestaurantId());
        List<Order> orders = new ArrayList<>();
        for(Item item : items){
            orders.add(Order.builder()
                    .totalPrice(item.getItemPrice())
                    .seatId(seat.getSeatId())
                    .sessionId(sessionId)
                    .build());
        }
    }
    private String addSession(String qrKey,String restaurantId){
        Session session = sessionMapper.findSession(restaurantId);
        if(session == null){
            session = Session.builder()
                    .sessionId(randomCodeUtil.createRandomCode(64))
                    .restaurantId(restaurantId)
                    .build();
            sessionMapper.addSession(session);
        }
        return session.getSessionId();
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
