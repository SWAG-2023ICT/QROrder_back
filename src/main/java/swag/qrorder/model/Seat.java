package swag.qrorder.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Seat {
    String seatId;
    String seatName;
    String qrKey;
    String restaurantId;
}
