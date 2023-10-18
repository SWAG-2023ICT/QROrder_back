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
    private Integer itemId;
    private String itemName;
    private Integer itemPrice;
    private List<Option> options;
    private Integer amount;
}
