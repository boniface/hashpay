/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;

import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.people.Users;

/**
 *
 * @author boniface
 */
public interface RegistrationService {

    public String registerUser(String email, String password, String confirm);

    public String forgotPassowrd(String email);

    public String activateAccount(String token, Long id);

    public  String resetPassword(String token,Long id);
    
    public String changePassword(String email,String oldpassword, String newpassword, String confirmnewpassword);
    
    public String setNames(String firstName, String lastName, String otherName, String title, String username);
    public Users setDetails(Users user);
}
