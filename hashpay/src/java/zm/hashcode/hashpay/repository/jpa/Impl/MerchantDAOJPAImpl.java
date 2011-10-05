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
import zm.hashcode.hashpay.model.market.Merchant;
import zm.hashcode.hashpay.repository.jpa.MerchantDAO;

/**
 *
 * @author Thozmile Sikwata
 */
@Repository("merchantDAO")
@Transactional
public class MerchantDAOJPAImpl implements MerchantDAO {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Merchant find(Long id) {
         return em.find(Merchant.class, id);
    }

    @Override
    public void persist(Merchant entity) {
        em.persist(entity);
    }

    @Override
    public void merge(Merchant entity) {
         em.merge(entity);
    }

    @Override
    public void remove(Merchant entity) {
         Merchant merchn = em.find(Merchant.class, entity.getId());
        em.remove(merchn);
    }

    @Override
    public List<Merchant> findAll() {
        return em.createQuery("SELECT m FROM Merchant m").getResultList();
    }

    @Override
    public List<Merchant> findInRange(int firstResult, int maxResults) {
        return em.createQuery("SELECT m FROM Merchant m").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return ((Long) em.createQuery("SELECT COUNT(m) from Merchant m ").getSingleResult());
    }

    @Override
    public Merchant getByPropertyName(String name, String value) {
        List<Merchant> list = em.createQuery("SELECT m FROM Merchant m WHERE m." + name + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Merchant> getEntitiesByProperName(String name, String value) {
         List<Merchant> list = em.createQuery("SELECT m FROM Merchant m WHERE m." + name + "=?1").setParameter(1, value).getResultList();
         return list;
    }
    
    
   
    
}
