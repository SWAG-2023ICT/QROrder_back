package swag.qrorder.vo;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class OrderVo {
    private int orderId;
    private Date orderDtm;
    private boolean orderStatus;
    private int totalPrice;
    List<ItemVo> items;
}
