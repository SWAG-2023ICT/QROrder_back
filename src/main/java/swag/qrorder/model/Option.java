package swag.qrorder.model;

import lombok.Data;

import java.util.List;

@Data
public class Option {
    int optionId;
    boolean optionType;
    String optionName;
    String optionDescription;
    int itemId;
    List<OptionValue> optionValues;
}
