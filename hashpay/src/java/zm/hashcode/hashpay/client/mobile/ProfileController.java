/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;


import java.util.List;
import javax.imageio.spi.RegisterableService;
import javax.validation.Valid;
import zm.hashcode.hashpay.repository.jpa.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import zm.hashcode.hashpay.client.mobile.model.ProfileBean;
import zm.hashcode.hashpay.client.mobile.users.UserInformation;
import zm.hashcode.hashpay.model.people.Address;
import zm.hashcode.hashpay.model.people.Contacts;
import zm.hashcode.hashpay.model.people.Users;
import zm.hashcode.hashpay.services.RegistrationService;
import zm.hashcode.hashpay.services.UserService;


/**
 *
 * @author Bongani
 */

@Controller
@RequestMapping(value = "/profile/*")
public class ProfileController {
    //user has no service so i'll refactor this later by adding user service
    @Autowired
    private UserService usersService;
    String username;
    
    @RequestMapping(value = "profileDetails.html", method = RequestMethod.GET)
    public ModelAndView profileDetails(Model model) {
        ModelAndView mv = new ModelAndView();
        UserInformation name = new UserInformation();
        username = name.credentials();
        Users user = usersService.findUser(username);
        if(user.getName() != null)
        {
            mv.addObject("username", user.getUsername().toString());
            mv.addObject("title", user.getName().getTitle().toString());
            mv.addObject("firstname", user.getName().getFirstname().toString());
            mv.addObject("lastname", user.getName().getLastname());
            mv.addObject("nickname", user.getName().getOtherName());
            mv.addObject("contactList", user.getContacts());
            mv.addObject("addressList", user.getAddress());
        }
        
        mv.addObject("username", user.getUsername());
        mv.setViewName("profile");
       return mv;
    }
    
    @RequestMapping(value = "updateProfile.html",method= RequestMethod.POST)
    public String updateProfile(@Valid ProfileBean user, BindingResult bindingResultl,Model model)
    {
      
        
        model.addAttribute("message", " your profile details has been updated!");
           return "message";
    }
    
    @RequestMapping(value = "showProfile.html", method = RequestMethod.GET)
    public String showProf()
    {
        return "profile";
    }
}
