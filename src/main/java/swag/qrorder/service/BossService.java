package swag.qrorder.service;


import io.swagger.v3.oas.models.security.SecurityScheme;
import swag.qrorder.model.Boss;

public interface BossService {

    boolean signIn(Boss boss);

    boolean signUp(Boss boss);
}
