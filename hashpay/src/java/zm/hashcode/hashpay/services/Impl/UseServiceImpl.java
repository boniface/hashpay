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
        Users users = userDAO.getByPropertyName("username", user.getUsername());
        users.getAddress().clear();
        users.getContacts().clear();
        users.getAddresses().clear();
        users.setAddresses(user.getAddress());
        users.setContacts(user.getContacts());
        users.setName(user.getName());
        
       userDAO.merge(users);
       return user;
    }
    
    

}
