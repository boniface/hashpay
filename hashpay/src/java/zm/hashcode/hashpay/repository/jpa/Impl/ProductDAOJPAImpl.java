/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.repository.jpa.Impl;

import java.util.List;
import zm.hashcode.hashpay.model.market.Product;
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
    public Product find(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public void persist(Product entity) {
         em.persist(entity);
    }

    @Override
    public void merge(Product entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Product entity) {
          Product prd = em.find(Product.class, entity.getId());
           em.remove(prd);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) em.createQuery("select p from Product p").getResultList();
    }

    @Override
    public List<Product> findInRange(int firstResult, int maxResults) {
        return (List<Product>) em.createQuery("select p from Product p").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
        return (Long) em.createQuery("select count(p) from Product p").getSingleResult();
    }

    @Override
    public Product getByPropertyName(String name, String value) {
         List<Product> list = em.createQuery("select p from Product p where p." + name + "=?1").setParameter(1, value).getResultList();
         return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Product> getEntitiesByProperName(String name, String value) {
       List<Product> list = em.createQuery("select p from Product p where p." + name + "=?1").setParameter(1, value).getResultList();
       return list;
    }
    
}
