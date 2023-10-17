package swag.qrorder.vo;

import lombok.*;
import swag.qrorder.model.Boss;
import swag.qrorder.model.Restaurant;

import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
public class RegisterVO {
    Boss boss;
    Restaurant restaurant;
}
