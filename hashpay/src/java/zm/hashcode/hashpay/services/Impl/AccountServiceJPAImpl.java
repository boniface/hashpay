/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.factories.account.AccountFactory;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author shane.broek
 */
@Repository("accountService")
@Transactional
public class AccountServiceJPAImpl implements AccountService{

    @Override
    public void createAccount(String status, String currency, String user) {
        AccountFactory f = new AccountFactory();
        f.createNewAccount(currency,status, user);
    }

    @Override
    public void setAccountStatus(String status, String user) {
        AccountFactory f = new AccountFactory();
        f.setAccountStatus(status, user);
    }

    @Override
    public Account checkAccountStatus(String accountNumber) {
        AccountFactory f = new AccountFactory();
        Account account = f.checkAccountStatus(accountNumber);
        return account;
    }

    @Override
    public Account checkBalance(Account accountNumber) {
        AccountFactory f = new AccountFactory();
        Account balance = f.checkBalance(accountNumber);
        return balance;
    }
   
}
