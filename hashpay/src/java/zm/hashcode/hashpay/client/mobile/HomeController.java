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
public class HomeController {

	@RequestMapping(value = "/mobile/")
	public String home() {
		System.out.println("Mobile Controller Firing ");
		return "home";
	}
}