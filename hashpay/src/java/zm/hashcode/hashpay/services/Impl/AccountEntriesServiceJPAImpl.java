/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;
import zm.hashcode.hashpay.repository.jpa.AccountEntryDAO;
import zm.hashcode.hashpay.services.AccountEntriesService;

/**
 *
 * @author shane.broek
 */
public class AccountEntriesServiceJPAImpl implements AccountEntriesService{
    @Autowired
    private AccountEntryDAO dao;

    @Override
    public BigDecimal getBalance(AccountEntry accountEntry) {
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
}
