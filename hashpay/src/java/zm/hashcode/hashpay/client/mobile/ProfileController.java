/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;


import java.util.ArrayList;
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
import zm.hashcode.hashpay.model.people.Name;
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
        ProfileBean user = new ProfileBean();
        model.addAttribute(user);
        ModelAndView mv = new ModelAndView();
        UserInformation user1 = new UserInformation();
        username = user1.credentials();
        Users finduser = usersService.findUser(username);
        
        
        if(finduser.getName() == null)
        {
            
            mv.addObject("username", finduser.getUsername().toString());
          //  mv.addObject("title", finduser.getName().getTitle().toString());
           // mv.addObject("firstname", finduser.getName().getFirstname().toString());
            //mv.addObject("lastname", finduser.getName().getLastname());
            //mv.addObject("nickname", finduser.getName().getOtherName());
            //mv.addObject("contactList", finduser.getContacts().get(1));
            //mv.addObject("addressList", finduser.getAddress().get(1));
            
        } else
        {
            mv.addObject("username", "");
            mv.addObject("title", "Insert Name");
            mv.addObject("firstname", "Insert Name");
            mv.addObject("lastname", "Insert last name");
            mv.addObject("nickname", "Insert nickname");
         
        }
        mv.setViewName("profile");
        
        
       return mv;
    }
    
    @RequestMapping(value = "updateProfile.html",method= RequestMethod.POST)
    public String updateProfile(@Valid ProfileBean user, BindingResult bindingResultl,Model model)
    {
      model.addAttribute(user);
      Users users = new Users();
      
      List addressList = new ArrayList(); 
      Address a = new Address();
      a.setPhysicalAddress(user.getPhysicalAddress());
      a.setPostalAddress(user.getPostalAddress());
      a.setPostalcode(user.getPostalCode());
      addressList.add(a);
      
      List contactList = new ArrayList();
      Contacts contact = new Contacts();
      contact.setCellNumber(user.getCellNumber());
      contact.setEmailAddress("");
      contact.setFaxNumber(user.getFaxNumber());
      contact.setPhoneNumber(user.getHomeNumber());
      contactList.add(contact);
      
      Name name = new Name();
      name.setFirstname(user.getFirstname());
      name.setLastname(user.getLastName());
      name.setOtherName(user.getNickname());
      name.setTitle(user.getTitle());
      
      users.setAddresses(addressList);
      users.setContacts(contactList);
      users.setName(name);
      users.setUsername(user.getUsername());
        usersService.updateDetails(users);
        model.addAttribute("message", " your profile details has been updated!");
           return "message";
    }
    
    @RequestMapping(value = "showProfile.html", method = RequestMethod.GET)
    public String showProf()
    {
        return "profile";
    }
}
