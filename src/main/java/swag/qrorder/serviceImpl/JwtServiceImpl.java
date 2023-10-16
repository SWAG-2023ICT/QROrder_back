package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swag.qrorder.common.model.Token;
import swag.qrorder.common.util.TokenUtil;
import swag.qrorder.mapper.JwtMapper;
import swag.qrorder.mapper.RestaurantMapper;
import swag.qrorder.service.JwtService;

@RequiredArgsConstructor
@Service
public class JwtServiceImpl implements JwtService {
//    private final RestaurantMapper restaurantMapper;
    private final JwtMapper jwtMapper;
    private final TokenUtil tokenUtil;

    @Override
    public String addJwt(String bossId) {
//        String restaurantId = restaurantMapper.findRestaurantId(bossId);
        Token token = tokenUtil.createToken(bossId);
        Integer result = jwtMapper.addJwt(token);
        return token.getAccessToken();
    }
}
