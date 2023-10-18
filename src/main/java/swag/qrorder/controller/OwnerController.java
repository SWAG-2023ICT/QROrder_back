package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Reservation;
import swag.qrorder.service.OwnerService;
import swag.qrorder.service.ReservationService;
import swag.qrorder.vo.OrderVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/qrorder/owner")
public class OwnerController {
    private final ReservationService reservationService;
    private final OwnerService ownerService;

    @PostMapping("/reservationList")
    public ResponseEntity<?> getAllReservation(HttpServletRequest request){
        if(request == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("request(토큰)이 null 값입니다.");
        String restaurantId = (String) request.getAttribute("restaurantId");
        log.info("{}", restaurantId);
        return reservationService.getAllReservation(restaurantId);
    }


    @PutMapping("/reservationStatus")
    public ResponseEntity<?> updateReservationStatus(HttpServletRequest request, Reservation reservation) {
        if (request == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("request(토큰)이 null 값입니다.");
        String restaurantId = (String) request.getAttribute("restaurantId");
        log.info("{}", restaurantId);
        boolean result = reservationService.updateReservationStatus(reservation.getReservationId());
        if (result) return ResponseEntity.status(HttpStatus.OK).body("입장 완료처리했습니다.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("정상 처리 되지 않았습니다.");
    }

    @PostMapping("/{sessionId}")
    public ResponseEntity<?> closeSession(@PathVariable String sessionId){
        boolean flag = ownerService.closeSession(sessionId);
        if(flag) return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("")
    public ResponseEntity<?> findOrders(HttpServletRequest request){
        String restaurantId = (String) request.getAttribute("restaurantId");
        List<OrderVo> orders = ownerService.findOrders(restaurantId);
        if(orders != null) return ResponseEntity.ok(orders);

        return ResponseEntity.badRequest().build();
    }
}
