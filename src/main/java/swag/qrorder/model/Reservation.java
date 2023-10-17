package swag.qrorder.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {
    int reservationId;
    Date reservationDtm;
    boolean reservationStatus;
    String customerPhoneNumber;
    int customerCount;
    String restaurantId;
}
