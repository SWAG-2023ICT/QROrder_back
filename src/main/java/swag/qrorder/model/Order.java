package swag.qrorder.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class Order {
    int orderId;
    Date orderDtm;
    int totalPrice;
    String seatId;
    String sessionId;
    List<Item> items;
}
