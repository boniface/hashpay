/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.hashpay.model.people.Users;
import zm.hashcode.hashpay.repository.jpa.UsersDAO;
import zm.hashcode.hashpay.services.RegistrationService;

/**
 *
 * @author boniface
 */
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public String registerUser(String email, String password, String confirm) {
        if (passwordNotmatching(password, confirm)) {
            return "Password Does Not Match";
        } else {

            // Assign Role
            //Assign username
            //Assign Password
            //Persists
            // hashpay/register?id="12344"&token="qwerty"
            // Send Email Link with Token

            return "Your Has been Created ";

        }
    }

    @Override
    public String forgotPassowrd(String email) {
        Users user = usersDAO.getByPropertyName("username", email);
        if (user != null) {
            //generate Token
            //add token user
            //merge
            //e-mail the User Link with userId & Token
            return "check for instructions";


        }
        return "Wrong E-mail";
    }

    @Override
    public String activateAccount(String token, Long id) {
        Users user = usersDAO.find(id);
        if (user.getTemporaryToken().equals(token)) {
            user.setEnabled(true);
            user.setTemporaryToken(null);
            return "Account Activated , Login";
        }
        return "Error message";
    }

    @Override
    public String resetPassword(String token, Long Id) {
       //get User;
        //check token
        //generate new password
        //update passwrd on user object
        // delete Token
        //email user the password
        //
        
        return "";
    }

    public UsersDAO getUsersDAO() {
        return usersDAO;
    }

    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    private boolean passwordNotmatching(String password, String confirm) {

        if (password!=null && confirm!=null) {
            if (password.equals(confirm)) {
                return false;
            }
        }
        return true;
    }
}
