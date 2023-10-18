package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swag.qrorder.service.ReservationService;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/qrorder/owner")
public class OwnerController {

    private final ReservationService reservationService;

    @PostMapping("/reservationList")
    public ResponseEntity<?> getAllReservation(HttpServletRequest request){
        if(request == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("request(토큰)이 null 값입니다.");
        String restaurantId = (String) request.getAttribute("restaurantId");
        log.info("{}", restaurantId);
        return reservationService.getAllReservation(restaurantId);
    }
}
