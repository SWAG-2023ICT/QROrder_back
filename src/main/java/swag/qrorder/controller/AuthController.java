package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swag.qrorder.model.Boss;
import swag.qrorder.model.Restaurant;
import swag.qrorder.service.ReservationService;
import swag.qrorder.service.RestaurantService;
import swag.qrorder.vo.RegisterVO;
import swag.qrorder.service.AuthService;
import swag.qrorder.service.JwtService;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/qrorder/auth")
@RestController
public class AuthController {
    private final AuthService authService;
    private final RestaurantService restaurantService;
    private final JwtService jwtService;
  
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody RegisterVO registerVO){
        if(registerVO == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입 정보가 null 값입니다.");
        log.info("{}", registerVO.getBoss());
        log.info("{}", registerVO.getRestaurant());
        boolean bossAddResult = authService.signUp(registerVO.getBoss());
        if(bossAddResult) {
            Restaurant restaurant = registerVO.getRestaurant();
            restaurant.setBossId(registerVO.getBoss().getBossId());
            boolean restaurantAddResult = restaurantService.addRestaurant(restaurant);
            if(restaurantAddResult) return ResponseEntity.status(HttpStatus.CREATED).body("회원가입이 성공적으로 완료되었습니다.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("레스토랑 추가에 실패했습니다.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원 가입에 실패했습니다.");
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(HttpServletResponse response,Boss boss) throws SQLException {
        if(boss == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인 하려는 정보가 null 값입니다.");

        boolean result = authService.signIn(boss);

        if(result){
            String accessToken = jwtService.signIn(boss.getBossId());
            response.setHeader("Authorization", "Bearer " + accessToken);
            return ResponseEntity.status(HttpStatus.OK).body("로그인 성공했습니다.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인에 실패했습니다.");
    }

    @DeleteMapping("/logout")
    public ResponseEntity<?> logout(Restaurant restaurant){
        if(restaurant == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("레스토랑이 null 입니다.");
        boolean result = authService.logout(restaurant.getRestaurantId());
        if(result) return ResponseEntity.status(HttpStatus.OK).body("로그아웃되었습니다.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그아웃에 실패했습니다.");
    }

}
