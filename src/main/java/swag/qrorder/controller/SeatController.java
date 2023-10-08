package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Seat;
import swag.qrorder.serviceImpl.SeatServiceImpl;

@Slf4j
@RequestMapping("/qrorder/seats")
@RequiredArgsConstructor
@RestController
public class SeatController {
    private final SeatServiceImpl seatService;
    @PostMapping("")
    public ResponseEntity<?> addSeat(@RequestBody int count){
        String restaurantId = ""; // 헤더에서 id 가져오기
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
    public ResponseEntity<?> deleteSeat(@RequestBody String seatId){
        boolean flag = seatService.deleteSeat(seatId);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
}
