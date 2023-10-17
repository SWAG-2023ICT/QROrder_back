package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Restaurant;
import swag.qrorder.service.JwtService;
import swag.qrorder.service.RestaurantService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;


@RequestMapping(value = "/qrorder/restaurants",produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final JwtService jwtService;

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

    @Transactional
    @PostMapping("/switch")
    public ResponseEntity<?> switchRestaurant(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody String restaurantId) throws SQLException {
        boolean flag = jwtService.deleteJwt(
                (String) request.getAttribute("restaurantId"));
        String accessToken = "";
        if(flag) accessToken = jwtService.switchJwt(restaurantId);

        if(accessToken.isBlank()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        response.setHeader("Authorization", "Bearer " + accessToken);

        return ResponseEntity.ok().build();
    }
}
