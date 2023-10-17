package swag.qrorder.service;


import java.sql.SQLException;

public interface JwtService {
    String signIn(String bossId) throws SQLException;
    boolean deleteJwt(String restaurantId);
    String switchJwt(String restaurantId) throws SQLException;
}
