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
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import zm.hashcode.hashpay.repository.jpa.AccountEntryDAO;
import zm.hashcode.hashpay.repository.jpa.AccountNumberDAO;
import zm.hashcode.hashpay.services.AccountEntriesService;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author Shane van der Broeck
 */
public class AccountFactory {
     
    @Autowired
    private AccountDAO accountDAO;
    private AccountEntryDAO accountEntryDAO;
    ApplicationContext ctx = GetContext.getApplicationContext();
    
    public BigDecimal getBalance(AccountEntry account) {
        AccountEntriesService accountEntriesService = (AccountEntriesService) ctx.getBean("accountEntriesService");
        //BigDecimal balance = accountEntriesService.getBalance(account);
        return null;
    }
    
    public Account createNewAccount(String currency,String status, String user) {
        Account acc = new Account.Builder(currency, new BigDecimal("0.00")).
                accountStatus(status).
                createdBy(user).
                creationDate(new Date()).build();
        return acc;
    }
    
    public AccountEntry createDebitEntry(Account acc, BigDecimal debit, String description, String currency) throws InsufficientBalanceException {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        accountEntryDAO = (AccountEntryDAO) ctx.getBean("accountEntryDAO");
        AccountEntry debitEntry = null;
        BigDecimal balances = acc.getBalance();
        if ((balances.subtract(debit)).compareTo(BigDecimal.ONE) ==1) {
            BigDecimal newbalance = balances.subtract(debit);
            debitEntry = new AccountEntry.Builder(newbalance, new Date(), acc.getAccountNumber()).currencySymbol(currency).
                    entryDescription(description).
                    debitEntry(debit).build();
            acc.setBalance(newbalance);
            accountDAO.merge(acc);
            accountEntryDAO.persist(debitEntry);
        } else {
            throw new InsufficientBalanceException();
        }
        return debitEntry;
    }
    public AccountEntry createCreditEntry(Account acc, BigDecimal credit, String description, String currency) {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        accountEntryDAO = (AccountEntryDAO) ctx.getBean("accountEntryDAO");
        
        BigDecimal balances = acc.getBalance();
        BigDecimal newbalance = balances.add(credit);
        AccountEntry creditEntry = new AccountEntry.Builder(newbalance,new Date(),acc.getAccountNumber()).currencySymbol(currency).
                entryDescription(description).
                creditEntry(credit).build();
        acc.setBalance(newbalance);
        accountDAO.merge(acc);
            accountEntryDAO.persist(creditEntry);
        return creditEntry ;
    }
}
