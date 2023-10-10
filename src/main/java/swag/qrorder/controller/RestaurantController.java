package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Restaurant;
import swag.qrorder.service.RestaurantService;

import java.util.List;
@RequestMapping("/qrorder/restaurants")
@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/{bossId}")
    public ResponseEntity<?> findRestaurants(@PathVariable String bossId){
        List<Restaurant> restaurants = restaurantService.findRestaurants(bossId);
        if(restaurants.isEmpty()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");

        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }
    @PostMapping("")
    public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant){
        boolean flag = restaurantService.addRestaurant(restaurant);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
    @PutMapping("")
    public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant){
        boolean flag = restaurantService.updateRestaurant(restaurant);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteRestaurant(@RequestBody String restaurantId){
        boolean flag = restaurantService.deleteRestaurant(restaurantId);
        if(flag) return ResponseEntity.status(HttpStatus.OK).body("success!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail!");
    }
}
