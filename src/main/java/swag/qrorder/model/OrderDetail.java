package swag.qrorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetail {
    private int itemId;
    private int orderId;
    private int amount;
    private int optionValueId;
}
