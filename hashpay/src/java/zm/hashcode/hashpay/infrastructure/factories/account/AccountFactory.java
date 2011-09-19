/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.account;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;
import zm.hashcode.hashpay.services.AccountEntriesService;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author 209052414
 */
public class AccountFactory {
     
    @Autowired
    private AccountService accountService;
    ApplicationContext ctx = GetContext.getApplicationContext();
    
    public BigDecimal getBalance(Account account) {
        AccountEntriesService accountEntriesService = (AccountEntriesService) ctx.getBean("accountEntriesService");
        BigDecimal balance = accountEntriesService.getBalance(account);
        return balance;
    }
}
