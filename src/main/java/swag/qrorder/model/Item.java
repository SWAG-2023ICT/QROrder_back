package swag.qrorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Item {
    Integer itemId;
    String itemName;
    int itemPrice;
    String itemDescription;
    byte[] itemImage;
    boolean itemStatus;
    String restaurantId;
    int amount;
    List<Option> options;
    List<Category> categories;
}
