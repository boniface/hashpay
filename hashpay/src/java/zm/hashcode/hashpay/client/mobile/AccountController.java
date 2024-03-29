/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import zm.hashcode.hashpay.client.mobile.users.UserInformation;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author shane.broek
 */
@Controller
@RequestMapping(value = "/account/*")
public class AccountController {
    @Autowired
    private AccountService service;
    private String username;
    
    @RequestMapping(value = "accountDetails.html", method = RequestMethod.GET)
    public ModelAndView accountDetails(Model model) {
        UserInformation name = new UserInformation();
        username = name.credentials();
        ModelAndView mv = new ModelAndView();
        Account account = service.userAccount(username);
        //Account account = service.findAccount("52");
        AccountNumber accno = account.getAccountNumber();
        mv.addObject("accountNumber", accno.getId().toString());
        mv.addObject("status", account.getAccountStatus());
        mv.addObject("currentBalance", account.getBalance().toString());
        mv.addObject("currency", account.getCurrencyType());    
        mv.setViewName("account");
       return mv;
    }
    
    @RequestMapping(value = "accountTransactions.html", method = RequestMethod.GET)
    public ModelAndView accountTransactions(Model model) {
        UserInformation name = new UserInformation();
        username = name.credentials();
        Account Checkaccount = service.userAccount(username);
        ModelAndView mv = new ModelAndView();
        List<AccountEntry> account = service.findAllAccountEntries(Checkaccount.getAccountNumber().getId().toString());
        mv.addObject("list", account);
        mv.setViewName("accountEntries");
       return mv;
    }
    
}
