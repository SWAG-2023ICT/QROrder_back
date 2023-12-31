package swag.qrorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    int orderId;
    Date orderDtm;
    boolean orderStatus;
    int totalPrice;
    String seatId;
    String sessionId;
    List<Item> items;
}
