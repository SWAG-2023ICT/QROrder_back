package swag.qrorder.model;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class Boss {
    String bossId;
    String password;
    String name;
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$",message = "전화번호 형식이 맞지않습니다.")
    String phoneNumber;
    List<Restaurant> restaurants;
}
