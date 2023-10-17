package swag.qrorder.common.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Setter
@Getter
public class Token implements Serializable {
    private String restaurantId;
    private String accessToken;
}
