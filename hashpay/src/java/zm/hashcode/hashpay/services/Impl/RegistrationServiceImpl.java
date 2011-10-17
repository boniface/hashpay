/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import zm.hashcode.hashpay.infrastructure.util.authentication.PasswordEncrypt;
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
            Users user = new Users();
            user.setUsername(email);
            user.setEnabled(false);
            String encryptedPassword = PasswordEncrypt.encrypt(password);
            user.setPassword(encryptedPassword);
            usersDAO.persist(user);
            
            Users s = usersDAO.getByPropertyName("username", email);
            
            String body = "Hi User\n "
                    + "Account Details:\n"
                    + "\tUserName:" + s.getUsername() + "\n\n"
                    + "Please follow the link to activate your account:\n\n"
                    + "http://www.hashpay/register.com?id="+s.getId()+"&token="+s.getTemporaryToken()+"\n\n"
                    + "Kind Regards\n"
                    + "Hashpay Team";
            sendingEmail(s, "Registration to Hashpay", body);
            

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
            user.setTemporaryToken("");
            usersDAO.merge(user);
            
            String body = "Hi\n Please follow the link to reset your password:\n"
                    + "hashpay/register?id="+user.getId()+"&token="+user.getTemporaryToken()+"\n"
                    + "Kind Regards"
                    + "Hashpay Team";
            sendingEmail(user,"Forgot Password - Hashpay", body);
            
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
    
    private void sendingEmail(Users user, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.maxxor.com");
        props.put("mail.from", "no-reply@hashpay.com");
        
        Session sessions = Session.getInstance(props, null);
        
        try{
            MimeMessage msg = new MimeMessage(sessions);
            msg.setFrom();
            msg.setRecipients(Message.RecipientType.TO,
                             user.getUsername());
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(body);
            Transport.send(msg);
            
        }catch(MessagingException mex)
        {
            System.out.println("send failed, exception: " + mex);
        }
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
