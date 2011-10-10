/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;


import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.factories.account.AccountFactory;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import zm.hashcode.hashpay.repository.jpa.AccountEntryDAO;
import zm.hashcode.hashpay.services.AccountEntriesService;

/**
 *
 * @author shane.broek
 */
@Repository("accountEntriesService")
@Transactional
public class AccountEntriesServiceJPAImpl implements AccountEntriesService{
    @Autowired
    private AccountEntryDAO dao;
    private AccountDAO accountDAO;
    private AccountEntryDAO accountEntryDAO;
    private static ApplicationContext ctx;
    

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
    public void CreateDebitAccountEntry(String accountId, BigDecimal debit, String description, String currency) {
        AccountFactory f = new AccountFactory();
        ctx = new ClassPathXmlApplicationContext("classpath:zm/hashcode/hashpay/infrastructure/conf/applicationContext-*.xml");
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");

        Account acc = accountDAO.getByPropertyName("createdBy", "Lance");
        try {
            f.createDebitEntry(acc, debit, description, currency);
        } catch (InsufficientBalanceException ex) {
            Logger.getLogger(AccountEntriesServiceJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public AccountEntry creditAccount(String accountNumber, BigDecimal val, String Decription, String currency) {
         AccountFactory f = new AccountFactory();
        ctx = new ClassPathXmlApplicationContext("classpath:zm/hashcode/hashpay/infrastructure/conf/applicationContext-*.xml");
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        
        Account acc = accountDAO.getByPropertyName("createdBy", "Lance");
        
        AccountEntry newAccount = f.createCreditEntry(acc, val, Decription, currency);
        
        return newAccount;
    }
}
