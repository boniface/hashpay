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
import zm.hashcode.hashpay.model.market.AccountingLedger;
import zm.hashcode.hashpay.repository.jpa.AccountingLedgerDAO;

/**
 *
 * @author Thozamile Sikwata
 */
@Repository("accountingLedgerDAO")
@Transactional
public class AccountingLedgerDAOImpl implements AccountingLedgerDAO {

    
    @PersistenceContext
    private EntityManager em;
    @Override
    public AccountingLedger find(Long id) {
        return em.find(AccountingLedger.class, id);
    }

    @Override
    public void persist(AccountingLedger entity) {
        em.persist(entity);
    }

    @Override
    public void merge(AccountingLedger entity) {
        em.merge(entity);
    }

    @Override
    public void remove(AccountingLedger entity) {
       AccountingLedger acc = em.find(AccountingLedger.class, entity.getId());
           em.remove(acc);
    }

    @Override
    public List<AccountingLedger> findAll() {
        return (List<AccountingLedger>) em.createQuery("select a from AccountingLedger a").getResultList();
    }

    @Override
    public List<AccountingLedger> findInRange(int firstResult, int maxResults) {
        return (List<AccountingLedger>) em.createQuery("select a from AccountingLedger a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
      return (Long) em.createQuery("select count(a) from AccountingLedger a").getSingleResult();
    }

    @Override
    public AccountingLedger getByPropertyName(String name, String value) {
        List<AccountingLedger> list = em.createQuery("select a from AccountingLedger a where a." + name + "=?1").setParameter(1, value).getResultList();
         return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<AccountingLedger> getEntitiesByProperName(String name, String value) {
          List<AccountingLedger> list = em.createQuery("select a from AccountingLedger a where a." + name + "=?1").setParameter(1, value).getResultList();
          return list;
    }
    
}
