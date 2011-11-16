/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zm.hashcode.hashpay.client.mobile.model.RegisterBean;

/**
 
 * @author boniface
 */
@Controller
@RequestMapping(value = "/home/*")
public class HomeController {
       @RequestMapping(value = "/Newhome.html")
	public String home() {
		System.out.println("Mobile Controller Firing ");
		return "home";
	}
       
        @RequestMapping(value = "mobile.html")
	public String gethome() {
		System.out.println("get Home Fired ");
		return "home";
	}
        
         @RequestMapping(value = "welcome.html")
         public ModelAndView homePage() {
             ModelAndView mv = new ModelAndView();
             
             mv.setViewName("home");
            return mv;
    }
}