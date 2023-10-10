package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Restaurant;
import swag.qrorder.service.UserService;

@Slf4j
@RequestMapping("/qrorder/menus")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    @GetMapping("/{qrKey}")
    public ResponseEntity<?> findRestaurantByQr(@PathVariable String qrKey){
        Restaurant restaurant = userService.findRestaurantByQr(qrKey);
        if(restaurant.getItems().isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");

        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

}
