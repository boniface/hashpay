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
    public void registerUser(String email, String password, String confirm);
    public void forgotPassowrd(String email);
    
    
}
