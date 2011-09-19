/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.repository.jpa.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;
import zm.hashcode.hashpay.repository.jpa.AccountEntryDAO;

/**
 *
 * @author shane.broek
 */
@Repository("accountEntryDAO")
@Transactional
public class AccountEntryDAOJPAImpl implements AccountEntryDAO{
    @PersistenceContext
    private EntityManager em;


    @Override
    public AccountEntry find(Long id) {
        return em.find(AccountEntry.class, id);
    }

    @Override
    public void persist(AccountEntry entity) {
        em.persist(entity);
    }

    @Override
    public void merge(AccountEntry entity) {
        em.merge(entity);
    }

    @Override
    public void remove(AccountEntry entity) {
        AccountEntry acc = em.find(AccountEntry.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<AccountEntry> findAll() {
        return em.createQuery("SELECT a FROM AccountEntries a").getResultList();
    }

    @Override
    public List<AccountEntry> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT a FROM AccountEntries a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return ((Long) em.createQuery("SELECT COUNT(a) from AccountEntries a ").getSingleResult());
    }

    @Override
    public AccountEntry getByPropertyName(String name, String value) {
        List<AccountEntry> list = em.createQuery("SELECT a FROM AccountEntries a WHERE a." + name + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<AccountEntry> getEntitiesByProperName(String name, String value) {
        List<AccountEntry> list = em.createQuery("SELECT a FROM AccountEntries a WHERE a." + name + "=?1").setParameter(1, value).getResultList();
         return list;
    }
    

    
}
