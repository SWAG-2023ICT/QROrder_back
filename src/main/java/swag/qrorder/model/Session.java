package swag.qrorder.model;

import lombok.Data;

import java.util.Date;

@Data
public class Session {
    String sessionId;
    Date creationDtm;
    String restaurantId;
}
