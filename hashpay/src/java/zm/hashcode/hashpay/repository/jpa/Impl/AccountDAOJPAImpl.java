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
import zm.hashcode.hashpay.repository.jpa.AccountDAO;

/**
 *
 * @author shane.broek
 */
@Repository("accountDAO")
@Transactional
public class AccountDAOJPAImpl implements AccountDAO{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Account find(Long id) {
        return em.find(Account.class, id);
    }

    @Override
    public void persist(Account entity) {
        em.persist(entity);
    }

    @Override
    public void merge(Account entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Account entity) {
        Account acc = em.find(Account.class, entity.getId());
        em.remove(acc);
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) em.createQuery("select a from Account a").getResultList();
    }

    @Override
    public List<Account> findInRange(int firstResult, int maxResults) {
        return (List<Account>) em.createQuery("select a from Account a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("select count(a) from Account a").getSingleResult();
    }

    @Override
    public Account getByPropertyName(String name, String value) {
        List<Account> list = em.createQuery("select e from Account e where e." + name + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Account> getEntitiesByProperName(String name, String value) {
        List<Account> list = em.createQuery("select e from Account e where e." + name + "=?1").setParameter(1, value).getResultList();
        return list;
    }
    
}
