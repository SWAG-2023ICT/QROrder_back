package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swag.qrorder.mapper.RestaurantMapper;
import swag.qrorder.mapper.SeatMapper;
import swag.qrorder.model.Item;
import swag.qrorder.model.Order;
import swag.qrorder.model.Restaurant;
import swag.qrorder.model.Session;
import swag.qrorder.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final RestaurantMapper restaurantMapper;
    private final SeatMapper seatMapper;
    @Override
    public Restaurant findRestaurantByQr(String qrKey) {
        return restaurantMapper.findRestaurantByQr(qrKey);
    }
}
