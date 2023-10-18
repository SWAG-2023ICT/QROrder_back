package swag.qrorder.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import swag.qrorder.model.Option;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class ItemVo {
    private int itemId;
    private String itemName;
    private int itemPrice;
    private List<Option> options;
    private int amount;
}
