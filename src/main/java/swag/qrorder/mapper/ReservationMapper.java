package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Reservation;

import java.util.List;

@Mapper
public interface ReservationMapper {

    List<Reservation> getAllReservation(String restaurantId );

    boolean addReservation(Reservation reservation);

    boolean updateReservationStatus(int reservationId);

}
