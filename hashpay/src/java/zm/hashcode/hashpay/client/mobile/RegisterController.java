/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zm.hashcode.hashpay.client.mobile.model.RegisterBean;
import zm.hashcode.hashpay.services.RegistrationService;

/**
 *
 * @author boniface
 */
@Controller
@RequestMapping(value = "/register/*")
public class RegisterController {
    @Autowired
    private RegistrationService service;

    @RequestMapping(value = "createaccount.html", method = RequestMethod.GET, params = "new")
    public String register( Model model) {
        RegisterBean user = new RegisterBean();
        model.addAttribute(user);
       service.registerUser(user.getEmailAddress(), user.getPassword(), user.getRetypePassword());
        return "register";
    }

    @RequestMapping(value = "newaccount.html", method = RequestMethod.POST)
    public String createNewAccount(@Valid RegisterBean user, BindingResult bindingResultl,Model model) {
                model.addAttribute(user);
       service.registerUser(user.getEmailAddress(), user.getPassword(), user.getRetypePassword());
        if (bindingResultl.hasErrors()) {
            
            return "register";
        }
        
        model.addAttribute("message", "Your Account Has been Created. Please Check Your e-mail to activate it.");
        
        return "message";
    }

    @RequestMapping(value = "activate.html", method = RequestMethod.GET, params="token={token}")
    public String activate(@RequestParam("token") String token, Model model) {
        // Call with params =domain/hashpay/register/actrivate.html?token=12345
        service.activateAccount(token, Long.valueOf("110"));
        System.out.println("The Token Sent was " + token);
//        String message = service.activateAccount(token);
        model.addAttribute("message"," You account has been Activated. Please Login to start using it");
        return "message";
    }

    @RequestMapping(value = "forgotpassword.html", method = RequestMethod.GET)
    public String forgotPassword(@RequestParam("token") String token, Model model) {
        
        // Call with params =domain/hashpay/register/actrivate.html?token=12345
        System.out.println("The Token Sent was " + token);
//        String message = service.activateAccount(token);
//        model.addAttribute(message);
        return "message";
    }

    @RequestMapping(value = "resetpassword.html", method = RequestMethod.GET)
    public String resetPassword(@RequestParam("token") String token, Model model) {
          // Call with params =domain/hashpay/register/actrivate.html?token=12345
        System.out.println("The Token Sent was " + token);
//        String message = getService().activateAccount(token);
//        model.addAttribute(message);
        return "message";
    }

    @RequestMapping(value = "requeststore.html", method = RequestMethod.GET)
    public String requeststore(@RequestParam("token") String token, Model model) {
        System.out.println("The Token Sent was " + token);
//        String message = getService().activateAccount(token);
//        model.addAttribute(message);
        return "message";
    }

    /**
     * @return the service
     */
    public RegistrationService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(RegistrationService service) {
        this.service = service;
    }
}