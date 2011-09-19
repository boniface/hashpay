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
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author shane.broek
 */
@Repository("accountService")
@Transactional
public class AccountServiceJPAImpl implements AccountService{
    @Autowired
    private AccountDAO accountDAO;

    @Override
    public Account find(Long id) {
        return getAccountDAO().find(id);
    }

    @Override
    public void persist(Account entity) {
        getAccountDAO().persist(entity);
    }

    @Override
    public void merge(Account entity) {
        getAccountDAO().merge(entity);
    }

    @Override
    public void remove(Account entity) {
         getAccountDAO().remove(entity);
    }

    @Override
    public List<Account> findAll() {
        return getAccountDAO().findAll();
    }

    @Override
    public List<Account> findInRange(int firstResult, int maxResults) {
        return getAccountDAO().findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        return getAccountDAO().count();
    }

    @Override
    public Account getByPropertyName(String name, String value) {
        return getAccountDAO().getByPropertyName(name, value);
    }

    @Override
    public List<Account> getEntitiesByProperName(String name, String value) {
        return getAccountDAO().getEntitiesByProperName(name, value);
    }

    /**
     * @return the accountDAO
     */
    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    /**
     * @param accountDAO the accountDAO to set
     */
    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    
}
