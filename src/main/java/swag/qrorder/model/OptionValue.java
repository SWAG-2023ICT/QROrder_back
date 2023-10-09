package swag.qrorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class OptionValue {
    int optionValueId;
    String name;
    int price;
    Integer optionId;
}
