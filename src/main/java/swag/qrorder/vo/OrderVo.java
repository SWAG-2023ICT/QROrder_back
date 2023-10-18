package swag.qrorder.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import swag.qrorder.model.OrderDetail;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class OrderVo {
    private Integer orderId;
    private Date orderDtm;
    private boolean orderStatus;
    private Integer totalPrice;
    private OrderDetail orderDetail;
    List<ItemVo> items;
}
