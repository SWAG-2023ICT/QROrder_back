package swag.qrorder.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class Item {
    int itemId;
    String itemName;
    int itemPrice;
    String itemDescription;
    MultipartFile itemImage;
    boolean itemStatus;
    String restaurantId;
    int amount;
    List<Option> options;
    List<Category> categories;
}
