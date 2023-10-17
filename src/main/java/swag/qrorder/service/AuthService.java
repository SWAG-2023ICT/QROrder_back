package swag.qrorder.service;


import swag.qrorder.model.Boss;

public interface AuthService {

    boolean signIn(Boss boss);

    boolean signUp(Boss boss);
}
