package swag.qrorder.model;

import lombok.Data;

@Data
public class OptionValue {
    int optionValueId;
    String name;
    int price;
    int optionId;
}
