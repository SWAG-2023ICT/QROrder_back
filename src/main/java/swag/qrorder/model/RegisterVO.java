package swag.qrorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterVO {
    String bossId;
    String password;
    String name;
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$",message = "전화번호 형식이 맞지않습니다.")
    String phoneNumber;
    @Pattern(regexp = "^(\\d{3})-(\\d{2})-(\\d{5})$", message = "사업자 번호 형식이 맞지않습니다.")
    String restaurantId;
    String restaurantName;
    String restaurantPhoneNumber;
}
