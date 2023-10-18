package swag.qrorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetail {
    private Integer orderListId;
    private Integer itemId;
    private Integer orderId;
    private Integer amount;
    private Integer optionValueId;
}
