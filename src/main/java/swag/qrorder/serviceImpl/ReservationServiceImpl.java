package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import swag.qrorder.mapper.ReservationMapper;
import swag.qrorder.model.Reservation;
import swag.qrorder.service.ReservationService;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationMapper reservationMapper;


    @Override
    public ResponseEntity<?> getAllReservation(String restaurantId) {
        List<Reservation> reservationList = reservationMapper.getAllReservation(restaurantId);
        if(reservationList == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("예약 목록이 없습니다.");
        return ResponseEntity.status(HttpStatus.OK).body(reservationList);
    }

    @Override
    public boolean addReservation(Reservation reservation) {
        boolean result = reservationMapper.addReservation(reservation);
        return result;
    }


}
