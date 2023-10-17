package swag.qrorder.vo;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class ItemVo {
    private int itemId;
    private String itemName;
    private int itemPrice;
    private String optionName;
    private int optionValueId;
    private int optionValueName;
    private int optionValuePrice;
    private int amount;
}
