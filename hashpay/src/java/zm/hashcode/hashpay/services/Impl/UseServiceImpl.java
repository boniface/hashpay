/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.hashpay.model.people.Users;
import zm.hashcode.hashpay.repository.jpa.UsersDAO;
import zm.hashcode.hashpay.services.UserService;

/**
 *
 * @author Bongani
 */
@Service("userService")
public class UseServiceImpl implements UserService{
    @Autowired
    UsersDAO userDAO;
    
    @Override
    public Users findUser(String username) {
        return userDAO.getByPropertyName("username", username);  
    }

    @Override
    public Users updateDetails(Users user) {
       userDAO.merge(user);
       return user;
    }
    
    

}
