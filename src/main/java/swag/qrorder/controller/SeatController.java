package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Seat;
import swag.qrorder.service.SeatService;

import java.util.List;

@Slf4j
@RequestMapping("/qrorder/seats")
@RequiredArgsConstructor
@RestController
public class SeatController {
    private final SeatService seatService;
    @PostMapping("")
    public ResponseEntity<?> addSeat(@RequestBody int count){
        String restaurantId = "111-22-33333"; // 헤더에서 id 가져오기
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
