package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Reservation;
import swag.qrorder.service.ReservationService;

@RequestMapping("/qrorder/reservation")
@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("")
    public ResponseEntity<?> addReservation(@RequestBody Reservation reservation){
        if(reservation == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("예약 내용이 null 값입니다.");
        boolean result = reservationService.addReservation(reservation);
        if(result) return ResponseEntity.status(HttpStatus.CREATED).body("예약 완료되었습니다");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("예약에 실패했습니다.");
    }

}
