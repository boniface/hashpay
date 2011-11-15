/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;


import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.factories.account.AccountFactory;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.model.people.Users;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import zm.hashcode.hashpay.repository.jpa.AccountEntryDAO;
import zm.hashcode.hashpay.repository.jpa.AccountNumberDAO;
import zm.hashcode.hashpay.repository.jpa.UsersDAO;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author shane.broek
 */
@Repository("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountNumberDAO accountNumberDAO;
    @Autowired
    private AccountEntryDAO accountEntryDAO;
    @Autowired
    private UsersDAO userDAO;
    
    @Override
    public Account createAccount(String status, String currency, String user) {
        AccountFactory f = new AccountFactory();
        Account acc = f.createNewAccount(currency,status, user);
        accountDAO.persist(acc);
        return acc;
    }

    @Override
    public void setAccountStatus(String status, String accountNumber) {
        AccountNumber a = accountNumberDAO.find(Long.valueOf(accountNumber));
        Account uss = accountDAO.getByPropertyName("accountNumber", a);
        uss.setAccountStatus(status);
        accountDAO.merge(uss);
    }

    @Override
    public Account checkAccountStatus(String accountNumber) {
        AccountNumber a = accountNumberDAO.find(Long.valueOf(accountNumber));
        Account uss = accountDAO.getByPropertyName("accountNumber", a);
        return uss;
    }

    @Override
    public BigDecimal checkBalance(String accountNumber) {
        AccountNumber a = accountNumberDAO.find(Long.valueOf(accountNumber));

        Account balance = accountDAO.getByPropertyName("accountNumber", a);
        return (balance.getBalance());
    }
    @Override
    public Account checkStatus(String accountNumber) {
        Account account = checkAccountStatus(accountNumber);
        return account;
    }

    @Override
    public Account findAccount(String accountNumber) {
        AccountNumber a = accountNumberDAO.find(Long.valueOf(accountNumber));
        
        Account acc = accountDAO.getByPropertyName("accountNumber", a);
        return acc;
    }

    @Override
    public List<AccountEntry> findAllAccountEntries(String accountNumber) {
        List<AccountEntry> accountEntry = accountEntryDAO.getEntitiesByProperName("accountID", new Long(accountNumber));
        return accountEntry;
    }

    @Override
    public Account userAccount(String username) {
        Users user = userDAO.getByPropertyName("username", username);
        
        Account acc = accountDAO.find(Long.valueOf(user.getAccount().getId().toString()));
        
        return acc;
    }
   
}
