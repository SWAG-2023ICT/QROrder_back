package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
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
    @Override
    public Restaurant findRestaurantByQr(String qrKey) {
        return restaurantMapper.findRestaurantByQr(qrKey);
    }
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
                    .sessionId(createRandomString())
                    .restaurantId(restaurantId)
                    .build();
            sessionMapper.addSession(session);
        }
        return session.getSessionId();
    }
    private Seat getSeat(String qrKey){
        return seatMapper.findSeatByQr(qrKey);
    }
    private String createRandomString(){
        return RandomStringUtils.random(32,true,true);
    }
}
