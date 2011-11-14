/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zm.hashcode.hashpay.client.mobile.model.LoginBean;
import zm.hashcode.hashpay.infrastructure.util.authentication.GetUserCredentials;

/**
 *
 * @author shane.broek
 */
@Controller
@RequestMapping(value = "/login/*")
public class LoginController {
    @RequestMapping(value = "login.html")
	public ModelAndView Login(Model model) {
        GetUserCredentials credentials = new GetUserCredentials();
        LoginBean login = new LoginBean();
        model.addAttribute(login);
        String test = credentials.username();
		ModelAndView mv = new ModelAndView();
                mv.setViewName("home");
                return mv;
	}
    
}
