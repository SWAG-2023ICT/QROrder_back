package swag.qrorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Pattern(regexp = "^(\\d{3})-(\\d{2})-(\\d{5})$", message = "사업자 번호 형식이 맞지않습니다.")
    String restaurantId;
    String restaurantName;
    String restaurantPhoneNumber;
    String bossId;
    List<Seat> seats;
    List<Item> items;
}
