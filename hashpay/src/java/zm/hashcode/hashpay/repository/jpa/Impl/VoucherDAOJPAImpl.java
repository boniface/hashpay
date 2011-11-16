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
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusType;
import zm.hashcode.hashpay.repository.jpa.VoucherDAO;

/**
 *
 * @author Bongani
 */
@Repository("voucherDAO")
@Transactional
public class VoucherDAOJPAImpl implements VoucherDAO{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Voucher find(Long id) {
        return em.find(Voucher.class, id) ;
    }

    @Override
    public void persist(Voucher entity) {
        em.persist(entity);
    }

    @Override
    public void merge(Voucher entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Voucher entity) {
        Voucher voucherId = em.find(Voucher.class, entity.getId());
        em.remove(voucherId);
                
    }

    @Override
    public List<Voucher> findAll() {
        return (List<Voucher>) em.createQuery("SELECT v FROM Voucher v").getResultList();
    }

    @Override
    public List<Voucher> findInRange(int firstResult, int maxResults) {
        return (List<Voucher>) em.createQuery("SELECT v FROM Voucher v").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("SELECT count(v) FROM Voucher v").getSingleResult();
    }

    @Override
    public Voucher getByPropertyName(String name, String value) {
        List<Voucher> list = em.createQuery("SELECT v FROM Voucher v where v." + name + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Voucher> getEntitiesByProperName(String name, String value) {
        List<Voucher> list = em.createQuery("SELECT v FROM Voucher v where v." + name + "=?1").setParameter(1, value).getResultList();
        return list;
    }

    @Override
    public List<Voucher> getEntitiesByProperName(String string, VoucherStatusType voucherStatusType) {
        List<Voucher> list = em.createQuery("SELECT v FROM Voucher v where v." + string + "=?1").setParameter(1, voucherStatusType).getResultList();
        return list;
    }
    
}
