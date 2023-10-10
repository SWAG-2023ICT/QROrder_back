package swag.qrorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import swag.qrorder.model.Session;

@Mapper
public interface SessionMapper {
    void addSession(Session session);
    Session findSession(String restaurantId);
}
