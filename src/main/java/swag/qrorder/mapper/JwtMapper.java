package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.common.model.Token;

@Mapper
public interface JwtMapper {
    Integer addJwt(Token token);
}
