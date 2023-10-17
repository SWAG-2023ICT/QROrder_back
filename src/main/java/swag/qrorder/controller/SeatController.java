package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Seat;
import swag.qrorder.service.SeatService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequestMapping(value = "/qrorder/seats",produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
@RestController
public class SeatController {
    private final SeatService seatService;
    @PostMapping("")
    public ResponseEntity<?> addSeat(HttpServletRequest request,@RequestBody int count){
        String restaurantId = (String) request.getAttribute("restaurantId");
        boolean flag = seatService.addSeat(restaurantId,count);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
    @PutMapping("")
    public ResponseEntity<?> updateSeat(@RequestBody Seat seat){
        boolean flag = seatService.updateSeat(seat);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteSeat(@RequestBody List<Integer> seatIds){
        boolean flag = seatService.deleteSeat(seatIds);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
}
