package swag.qrorder.common.model;

import lombok.Builder;

import javax.persistence.Id;
import java.io.Serializable;

@Builder
public class Token implements Serializable {
    @Id
    private String tokenId;
    private String accessToken;
}
