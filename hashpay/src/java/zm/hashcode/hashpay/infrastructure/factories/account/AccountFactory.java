/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.account;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import zm.hashcode.hashpay.services.AccountEntriesService;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author 209052414
 */
public class AccountFactory {
     
    @Autowired
    private AccountService accountService;
    private AccountDAO accountDAO;
    private AccountEntriesService accountEntriesService;
    ApplicationContext ctx = GetContext.getApplicationContext();
    
    public BigDecimal getBalance(AccountEntry account) {
        AccountEntriesService accountEntriesService = (AccountEntriesService) ctx.getBean("accountEntriesService");
        BigDecimal balance = accountEntriesService.getBalance(account);
        return balance;
    }
    
    public Account createNewAccount(String currency,String status, String user) {
        Account acc = new Account.Builder(currency).accountStatus(status).createdBy(user).creationDate(new Date()).build();
        return acc;
    }
    public void setAccountStatus(String status, String user)
    {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account uss = accountDAO.getByPropertyName("createdBy", user);
        uss.setAccountStatus(status);
        accountDAO.merge(uss);
    }
    
    public AccountEntry createDebitEntry(BigDecimal debit,BigDecimal balance, String description, String voucherNumber, String currency) throws InsufficientBalanceException {

        AccountEntry debitEntry = null;
        if ((balance.subtract(debit)).compareTo(BigDecimal.ONE) ==1) {
            debitEntry = new AccountEntry.Builder(balance, new Date()).currencySymbol(currency).
                    entryDescription(description).
                    debitEntry(debit).build();
        } else {
            throw new InsufficientBalanceException();
        }
        return debitEntry;
    }
    public AccountEntry createCreditEntry(BigDecimal credit,BigDecimal balance, String description, String voucherNumber, String currency) {
        accountEntriesService = (AccountEntriesService) ctx.getBean("accountEntriesService");
        AccountEntry creditEntry = new AccountEntry.Builder(balance,new Date()).currencySymbol(currency).
                entryDescription(description).
                creditEntry(credit).build();
        return creditEntry ;
    }
}
