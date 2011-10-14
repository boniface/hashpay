/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.repository.jpa.Impl;

import java.util.List;
import zm.hashcode.hashpay.model.market.ProductOld;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 209042869
 */
@Repository("productDAO")
@Transactional
public class ProductDAOJPAImpl  implements ProductDAO{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public ProductOld find(Long id) {
        return em.find(ProductOld.class, id);
    }

    @Override
    public void persist(ProductOld entity) {
         em.persist(entity);
    }

    @Override
    public void merge(ProductOld entity) {
        em.merge(entity);
    }

    @Override
    public void remove(ProductOld entity) {
          ProductOld prd = em.find(ProductOld.class, entity.getId());
           em.remove(prd);
    }

    @Override
    public List<ProductOld> findAll() {
        return (List<ProductOld>) em.createQuery("select p from Product p").getResultList();
    }

    @Override
    public List<ProductOld> findInRange(int firstResult, int maxResults) {
        return (List<ProductOld>) em.createQuery("select p from Product p").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("select count(p) from Product p").getSingleResult();
    }

    @Override
    public ProductOld getByPropertyName(String name, String value) {
         List<ProductOld> list = em.createQuery("select p from Product p where p." + name + "=?1").setParameter(1, value).getResultList();
         return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<ProductOld> getEntitiesByProperName(String name, String value) {
       List<ProductOld> list = em.createQuery("select p from Product p where p." + name + "=?1").setParameter(1, value).getResultList();
       return list;
    }
    
}
