package swag.qrorder.model;

import lombok.Data;

import java.util.List;

@Data
public class Restaurant {
    String restaurantId;
    String restaurantName;
    String restaurantPhoneNumber;
    String bossId;
    List<Seat> seats;
    List<Item> items;
}
