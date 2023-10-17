package swag.qrorder.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swag.qrorder.common.model.Token;
import swag.qrorder.common.util.TokenUtil;
import swag.qrorder.mapper.JwtMapper;
import swag.qrorder.mapper.RestaurantMapper;
import swag.qrorder.service.JwtService;

import java.sql.SQLException;

@RequiredArgsConstructor
@Service
public class JwtServiceImpl implements JwtService {
    private final RestaurantMapper restaurantMapper;
    private final JwtMapper jwtMapper;
    private final TokenUtil tokenUtil;

    @Override
    public String signIn(String bossId) throws SQLException {
        String restaurantId = restaurantMapper.findRestaurantId(bossId);
        if(restaurantId == null) throw new SQLException();
        Token token = tokenUtil.createToken(restaurantId);
        Integer result = jwtMapper.addJwt(token);
        if(result > 0) return token.getAccessToken();

        throw new SQLException();
    }

    @Override
    public boolean deleteJwt(String restaurantId) {
        Integer result = jwtMapper.deleteJwt(restaurantId);
        return result > 0;
    }

    @Override
    public String switchJwt(String restaurantId) throws SQLException {
        Token token = tokenUtil.createToken(restaurantId);
        Integer result = jwtMapper.addJwt(token);
        if(result > 0) return token.getAccessToken();

        throw new SQLException();
    }
}
