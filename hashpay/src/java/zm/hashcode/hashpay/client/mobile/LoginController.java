/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zm.hashcode.hashpay.client.mobile.model.LoginBean;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;
import zm.hashcode.hashpay.infrastructure.util.authentication.GetUserCredentials;

/**
 *
 * @author shane.broek
 */
@Controller
@RequestMapping(value = "/login/*")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    private Authentication auth;
    
    @RequestMapping(value = "login.html")
	public ModelAndView Login(Model model) {
        
        LoginBean login = new LoginBean();
        model.addAttribute(login);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("shanevdbroek@gmail.com", "password");
        ApplicationContext ctx = GetContext.getApplicationContext();
        authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");

        setAuth(authenticationManager.authenticate(token));
        if (getAuth() != null) {
            SecurityContextHolder.getContext().setAuthentication(getAuth());
            ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
            return mv;
        }		
                return null;
	}
    @RequestMapping(value = "Test.html")
	public ModelAndView Test(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }
    
    /**
     * @return the auth
     */
    public Authentication getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(Authentication auth) {
        this.auth = auth;
    }
    
}
