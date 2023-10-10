package swag.qrorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Option {
    int optionId;
    boolean optionType;
    String optionName;
    String optionDescription;
    Integer itemId;
    List<OptionValue> optionValues;
}
