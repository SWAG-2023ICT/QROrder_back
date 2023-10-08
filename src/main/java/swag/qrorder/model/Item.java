package swag.qrorder.model;

import lombok.Data;
import java.util.List;

@Data
public class Item {
    int itemId;
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
