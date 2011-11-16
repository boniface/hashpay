/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile.users;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Bongani
 */
public class UserInformation {
    private String username;
    public String credentials()
    {
         Object principal =
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails ) {
        username = ((UserDetails)principal).getUsername();
            } else {
        username = principal.toString();
     }
        
        return username;
    }
}
