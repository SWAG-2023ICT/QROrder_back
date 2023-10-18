package swag.qrorder.service;

import org.springframework.http.ResponseEntity;
import swag.qrorder.model.Reservation;


public interface ReservationService {

    ResponseEntity<?> getAllReservation(String restaurantId);

    boolean addReservation(Reservation reservation);

    boolean updateReservationStatus(int reservationId);

}
