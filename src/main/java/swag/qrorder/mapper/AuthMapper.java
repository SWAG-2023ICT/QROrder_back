package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Boss;

@Mapper
public interface AuthMapper {

    Boss getBossByBossId(Boss boss);

    Integer signUp(Boss boss);

}
