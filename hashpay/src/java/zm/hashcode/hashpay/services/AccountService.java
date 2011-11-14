/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;



import java.math.BigDecimal;
import java.util.List;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;


/**
 *
 * @author shane.broek
 */
public interface AccountService{
    public Account createAccount(String status, String currency, String user);
    public void setAccountStatus(String status, String accountNumber);
    public Account checkAccountStatus(String accountNumber);
    public BigDecimal checkBalance(String accountNumber);
    public Account checkStatus(String accountNumber);
    public Account findAccount(String accountNumber);
    public List<AccountEntry> findAllAccountEntries(String accountNumber);
}
