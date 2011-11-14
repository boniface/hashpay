/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;


import zm.hashcode.hashpay.repository.jpa.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import zm.hashcode.hashpay.client.mobile.model.ProfileBean;
import zm.hashcode.hashpay.model.people.Users;


/**
 *
 * @author Bongani
 */

@Controller
@RequestMapping(value = "/profile/*")
public class ProfileController {
    //user has no service so i'll refactor this later by adding user service
    @Autowired
    private UsersDAO userDAO;
    
    @RequestMapping(value = "profileDetails.html", method = RequestMethod.GET)
    public ModelAndView profileDetails(Model model) {
        ModelAndView mv = new ModelAndView();
        
        Users user = userDAO.getByPropertyName("username", "test@john.com");
        mv.addObject("username", user.getUsername().toString());
        mv.addObject("title", user.getName().getTitle().toString());
        mv.addObject("firstname", user.getName().getFirstname().toString());
        mv.addObject("lastname", user.getName().getLastname());
        mv.addObject("nickname", user.getName().getOtherName());
       return mv;
    }
}
