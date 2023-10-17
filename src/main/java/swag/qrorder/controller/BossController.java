package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swag.qrorder.model.Boss;
import swag.qrorder.service.RestaurantService;
import swag.qrorder.vo.RegisterVO;
import swag.qrorder.service.BossService;
import swag.qrorder.service.JwtService;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/qrorder/boss")
@RestController
public class BossController {
    private final BossService bossService;
    private final RestaurantService restaurantService;
    private final JwtService jwtService;
  
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody RegisterVO registerVO){
        if(registerVO == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        log.info("{}", registerVO.getBoss());
        log.info("{}", registerVO.getRestaurant());
        boolean bossAddResult = bossService.signUp(registerVO.getBoss());
        if(bossAddResult) {
            Boolean restaurantAddResult = restaurantService.addRestaurant(registerVO.getRestaurant());
            if(restaurantAddResult) return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("signIn")
    public ResponseEntity<?> signIn(HttpServletResponse response,Boss boss) throws SQLException {
        if(boss == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        boolean result = bossService.signIn(boss);
        if(result) return ResponseEntity.status(HttpStatus.OK).build();
      
        Integer result = bossService.signIn(boss);
        if(result.equals(1)){
            String accessToken = jwtService.signIn(boss.getBossId());
            response.setHeader("Authorization", "Bearer " + accessToken);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
