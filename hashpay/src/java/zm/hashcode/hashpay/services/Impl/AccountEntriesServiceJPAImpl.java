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
import zm.hashcode.hashpay.services.AccountEntriesService;

/**
 *
 * @author shane.broek
 */
public class AccountEntriesServiceJPAImpl implements AccountEntriesService{
    @Autowired

    @Override
    public BigDecimal getBalance(Account account) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AccountEntry find(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void persist(AccountEntry entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void merge(AccountEntry entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(AccountEntry entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AccountEntry> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AccountEntry> findInRange(int firstResult, int maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AccountEntry getByPropertyName(String name, String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AccountEntry> getEntitiesByProperName(String name, String value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
