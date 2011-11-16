/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;

import zm.hashcode.hashpay.model.people.Users;

/**
 *
 * @author Bongani
 */
public interface UserService {
    public Users findUser(String username);
    public Users updateDetails(Users user);
    
}
