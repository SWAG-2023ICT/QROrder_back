package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Restaurant;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    List<Restaurant> findRestaurants(String bossId);
    Integer addRestaurant(Restaurant restaurant);
    Integer updateRestaurant(Restaurant restaurant);
    Integer deleteRestaurant(String restaurantId);
    Restaurant findMenuByQr(String qrKey);
}
