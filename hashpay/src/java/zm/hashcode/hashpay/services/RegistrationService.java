/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;

/**
 *
 * @author boniface
 */
public interface RegistrationService {

    public String registerUser(String email, String password, String confirm);

    public String forgotPassowrd(String email);

    public String activateAccount(String token, Long id);

    public  String resetPassword(String token,Long id);
}
