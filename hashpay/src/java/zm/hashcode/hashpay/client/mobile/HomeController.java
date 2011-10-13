/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author boniface
 */
@Controller
@RequestMapping(value = "/home/*")
public class HomeController {
       @RequestMapping(value = "/home.html")
	public String home() {
		System.out.println("Mobile Controller Firing ");
		return "home";
	}
        
        @RequestMapping(value = "mobile.html")
	public String gethome() {
		System.out.println("get Home Fired ");
		return "home";
	}
}