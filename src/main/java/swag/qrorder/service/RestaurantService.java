package swag.qrorder.service;

import swag.qrorder.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findRestaurants(String bossId);
    boolean addRestaurant(Restaurant restaurant);
    boolean updateRestaurant(Restaurant restaurant);
    boolean deleteRestaurant(String restaurantId);
}
