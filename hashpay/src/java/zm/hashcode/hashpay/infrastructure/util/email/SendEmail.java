/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.util.email;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.*;
import zm.hashcode.hashpay.model.people.Users;

/**
 *
 * @author boniface
 */
public class SendEmail {
    //private String message;
    //private String host;
    //private String port;
    
    public void sendEmail(Users user, String subject, String body)
    {
        try {
            Email email = new SimpleEmail();
        
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("username", "password"));
            email.setTLS(true);
            email.setFrom("no-reply@hashpay.com");
            email.setSubject(subject);
            email.setMsg(body);
            email.addTo(user.getUsername());
            email.send();
        } catch (EmailException mex) {
            Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, mex);
            System.out.println("send failed, exception: " + mex);
        }
    }
}
