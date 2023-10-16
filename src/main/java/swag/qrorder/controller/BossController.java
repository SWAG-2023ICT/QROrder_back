package swag.qrorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swag.qrorder.model.Boss;
import swag.qrorder.service.BossService;
import swag.qrorder.service.JwtService;

import javax.servlet.http.HttpServletResponse;


@RequiredArgsConstructor
@RequestMapping("/qrorder/boss")
@RestController
public class BossController {
    private final BossService bossService;
    private final JwtService jwtService;
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(Boss boss){
        if(boss == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        Integer result = bossService.signUp(boss);
        if(result.equals(1)) return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("signIn")
    public ResponseEntity<?> signIn(HttpServletResponse response,Boss boss){
        if(boss == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        Integer result = bossService.signIn(boss);
        if(result.equals(1)){
            String accessToken = jwtService.addJwt(boss.getBossId());
            response.setHeader("Authorization", "Bearer " + accessToken);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
