package swag.qrorder.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private int orderListId;
    List<ItemVo> items;
}
