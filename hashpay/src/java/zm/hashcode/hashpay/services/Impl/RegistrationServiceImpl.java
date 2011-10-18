/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.hashcode.hashpay.infrastructure.util.authentication.PasswordEncrypt;
import zm.hashcode.hashpay.infrastructure.util.authentication.PasswordGenerator;
import zm.hashcode.hashpay.infrastructure.util.email.SendEmail;
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
        Users s = usersDAO.getByPropertyName("username", email);
        if (s == null)
        {
            return "Username already exists";
        }else{
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

                PasswordGenerator token = new PasswordGenerator();
                token.generatePassword();

                user.setTemporaryToken(token.getPassword());
                user.setEnabled(false);
                String encryptedPassword = PasswordEncrypt.encrypt(password);
                user.setPassword(encryptedPassword);
                usersDAO.persist(user);


                String body = "Hi User\n "
                        + "Account Details:\n"
                        + "\tUserName:" + user.getUsername() + "\n\n"
                        + "Please follow the link to activate your account:\n\n"
                        + "http://www.hashpay/register.com?id="+user.getId()+"&token="+token.getPassword()+"\n\n"
                        + "Kind Regards\n"
                        + "Hashpay Team";
                //sendingEmail(s, "Registration to Hashpay", body);
                
                SendEmail send = new SendEmail();
                send.sendEmail(s, "Registration to Hashpay", body);

                return "Your Has been Created ";

            }
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
            PasswordGenerator token = new PasswordGenerator();
            token.generatePassword();
            
            user.setTemporaryToken(token.getPassword());
            usersDAO.merge(user);
            
            String body = "Hi\n Please follow the link to reset your password:\n"
                    + "hashpay/register?id="+user.getId()+"&token="+token.getPassword()+"\n"
                    + "Kind Regards"
                    + "Hashpay Team";
            //sendingEmail(user,"Forgot Password - Hashpay", body);
            
            SendEmail send = new SendEmail();
            send.sendEmail(user, "Registration to Hashpay", body);
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
            usersDAO.merge(user);
            return "Account Activated , Login";
        }
        return "Error message";
    }

    @Override
    public String resetPassword(String token, Long id) {
       //get User;
        //check token
        //generate new password
        //update passwrd on user object
        // delete Token
        //email user the password
        //
        Users user = usersDAO.find(id);
        if (user.getTemporaryToken().equals(token)) {
            PasswordGenerator newPassword = new PasswordGenerator();
            newPassword.generatePassword();

            user.setPassword(newPassword.getPassword());
            user.setTemporaryToken(null);
            usersDAO.merge(user);
            
            String body = "Hi "+user.getName()+"\n Your new password is as follows:\n"
                    + "\t"+user.getPassword()+"\n"
                    + "Please login in with these new credentials\n\n"
                    + "Kind Regards"
                    + "Hashpay Team";
            //sendingEmail(user,"Reset Password - Hashpay", body);
            SendEmail send = new SendEmail();
            send.sendEmail(user, "Registration to Hashpay", body);
        }
        
        return "";
    }
    
    @Override
    public String changePassword(String email,String oldpassword, String newpassword, String confirmnewpassword) {
        Users user = usersDAO.getByPropertyName("username", email);
        if(oldpasswordmatching(user,oldpassword)){
            return "Old password was incorrect";
        }else{
            if (passwordNotmatching(newpassword, confirmnewpassword) ) {
                    return "Password Does Not Match";
                } else {
                String encryptedPassword = PasswordEncrypt.encrypt(newpassword);
                user.setPassword(encryptedPassword);
                usersDAO.merge(user);

                return "Password has been changed";
            }
        }
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

    private boolean oldpasswordmatching(Users user, String oldpassword) {
        String dencryptedPassword = PasswordEncrypt.encrypt(oldpassword);
        if (dencryptedPassword.equals(user.getPassword()))
            return false;
        return true;
    }

   
}
