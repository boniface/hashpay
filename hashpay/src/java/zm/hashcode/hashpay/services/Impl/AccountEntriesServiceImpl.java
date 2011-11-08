/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;


import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.factories.account.AccountFactory;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;
import zm.hashcode.hashpay.repository.jpa.AccountEntryDAO;
import zm.hashcode.hashpay.services.AccountEntriesService;

/**
 *
 * @author shane.broek
 */
@Repository("accountEntriesService")
@Transactional
public class AccountEntriesServiceImpl implements AccountEntriesService{
    @Autowired
    private AccountEntryDAO dao;
    

    @Override
    public BigDecimal getBalance(AccountEntry accountEntry, Account account) {
        AccountEntry v = dao.getByPropertyName("Balance", accountEntry.getBalance().toString());
        return v.getBalance();
    }

    /**
     * @return the dao
     */
    public AccountEntryDAO getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(AccountEntryDAO dao) {
        this.dao = dao;
    }

    @Override
    public void CreateDebitAccountEntry(Account account, BigDecimal debit, String description, String currency) {
        AccountFactory f = new AccountFactory();
        try {
            f.createDebitEntry(account, debit, description, currency);
        } catch (InsufficientBalanceException ex) {
            Logger.getLogger(AccountEntriesServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public AccountEntry creditAccount(Account account, BigDecimal val, String Decription, String currency) {
         AccountFactory f = new AccountFactory();
        
        AccountEntry newAccount = f.createCreditEntry(account, val, Decription, currency);
        
        return newAccount;
    }
}
