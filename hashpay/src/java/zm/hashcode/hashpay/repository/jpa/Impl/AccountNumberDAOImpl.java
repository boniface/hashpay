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
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.repository.jpa.AccountNumberDAO;

/**
 *
 * @author shane.broek
 */
@Repository("accountNumberDAO")
@Transactional
public class AccountNumberDAOImpl implements AccountNumberDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public AccountNumber find(Long id) {
        return em.find(AccountNumber.class, id);
    }

    @Override
    public void persist(AccountNumber entity) {
        em.persist(entity);
    }

    @Override
    public void merge(AccountNumber entity) {
        em.merge(entity);
    }

    @Override
    public void remove(AccountNumber entity) {
        AccountNumber accNum = em.find(AccountNumber.class, entity.getId());
        em.remove(accNum);
    }

    @Override
    public List<AccountNumber> findAll() {
        return (List<AccountNumber>) em.createQuery("select a from AccountNumber a").getResultList();
    }

    @Override
    public List<AccountNumber> findInRange(int firstResult, int maxResults) {
        return (List<AccountNumber>) em.createQuery("select a from AccountNumber a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("select count(a) from AccountNumber a").getSingleResult();
    }

    @Override
    public AccountNumber getByPropertyName(String name, String value) {
        List<AccountNumber> list = em.createQuery("select e from AccountNumber e where e." + name + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<AccountNumber> getEntitiesByProperName(String name, String value) {
        List<AccountNumber> list = em.createQuery("select e from AccountNumber e where e." + name + "=?1").setParameter(1, value).getResultList();
        return list;
    }
   
}
