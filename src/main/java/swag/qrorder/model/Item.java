package swag.qrorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    Integer itemId;
    String itemName;
    int itemPrice;
    String itemDescription;
    byte[] itemImage;
    boolean itemStatus;
    String restaurantId;
    int amount;
    @Schema(hidden = true)
    List<Option> options;
    @Schema(hidden = true)
    List<Category> categories;
}
