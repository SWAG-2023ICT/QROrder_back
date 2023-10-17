package swag.qrorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Option {
    int optionId;
    boolean optionType;
    String optionName;
    String optionDescription;
    Integer itemId;
    List<OptionValue> optionValues;
}
