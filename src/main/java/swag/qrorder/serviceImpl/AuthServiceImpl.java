package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import swag.qrorder.mapper.AuthMapper;
import swag.qrorder.model.Boss;
import swag.qrorder.service.AuthService;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean signIn(Boss signInBoss) {
        Boss boss = authMapper.getBossByBossId(signInBoss);
        if(boss == null) return false;
        boolean result = passwordEncoder.matches(signInBoss.getPassword(), boss.getPassword());
        return result;
    }

    @Override
    public boolean signUp(Boss signUpBoss) {
        Boss boss = authMapper.getBossByBossId(signUpBoss);
        if(boss != null) return false;
        signUpBoss.setPassword(passwordEncoder.encode(signUpBoss.getPassword()));
        boolean result = authMapper.signUp(signUpBoss) > 0;
        return result;
    }


}

