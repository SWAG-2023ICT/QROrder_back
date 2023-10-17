package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.qrorder.mapper.RestaurantMapper;
import swag.qrorder.model.Restaurant;
import swag.qrorder.service.RestaurantService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantMapper restaurantMapper;
    @Override
    public List<Restaurant> findRestaurants(String bossId) {
        return restaurantMapper.findRestaurants(bossId);
    }
    @Transactional
    @Override
    public boolean addRestaurant(Restaurant restaurant) {
        Integer result = restaurantMapper.addRestaurant(restaurant);
        return result > 0;
    }
    @Transactional
    @Override
    public boolean updateRestaurant(Restaurant restaurant) {
        Integer result = restaurantMapper.updateRestaurant(restaurant);
        return result > 0;
    }
    @Transactional
    @Override
    public boolean deleteRestaurant(String restaurantId) {
        Integer result = restaurantMapper.deleteRestaurant(restaurantId);
        return result > 0;
    }

}
