package swag.qrorder.service;

import org.springframework.http.ResponseEntity;
import swag.qrorder.model.Reservation;

import java.util.List;

public interface ReservationService {

    ResponseEntity<?> getAllReservation(String restaurantId);

    boolean addReservation(Reservation reservation);

}
