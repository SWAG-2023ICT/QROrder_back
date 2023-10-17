package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import swag.qrorder.mapper.BossMapper;
import swag.qrorder.model.Boss;
import swag.qrorder.service.BossService;

@Slf4j
@Service
@RequiredArgsConstructor
public class BossServiceImpl implements BossService {
    private final BossMapper bossMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean signIn(Boss signInBoss) {
        Boss boss = bossMapper.getBossByBossId(signInBoss);
        if(boss == null) return false;
        boolean result = passwordEncoder.matches(signInBoss.getPassword(), boss.getPassword());
        return result;
    }

    @Override
    public boolean signUp(Boss signUpBoss) {
        Boss boss = bossMapper.getBossByBossId(signUpBoss);
        if(boss != null) return false;
        signUpBoss.setPassword(passwordEncoder.encode(signUpBoss.getPassword()));
        boolean result = bossMapper.signUp(signUpBoss) > 0;
        return result;
    }


}

