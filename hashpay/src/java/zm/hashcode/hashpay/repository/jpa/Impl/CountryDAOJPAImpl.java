/*Developer: Peter Phillip - Cubetec 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.repository.jpa.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.model.country.Country;
import zm.hashcode.hashpay.repository.jpa.CountryDAO;

/**
 *
 * @author Peter Phillip
 */
@Repository("CountryDAOImpl")
@Transactional
public class CountryDAOJPAImpl implements CountryDAO{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Country find(Long id) {
        return em.find(Country.class, id);
    }

    @Override
    public void persist(Country entity) {
        em.persist(entity);
    }

    @Override
    public void merge(Country entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Country entity) {
        Country country = em.find(Country.class, entity.getId());
        em.remove(country);
    }

    @Override
    public List<Country> findAll() {
         return (List<Country>) em.createQuery("select a from Country a").getResultList();
    }

    @Override
    public List<Country> findInRange(int firstResult, int maxResults) {
        return (List<Country>) em.createQuery("select a from Country a").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Override
    public long count() {
       return (Long) em.createQuery("select count(a) from Country a").getSingleResult();
    }

    @Override
    public Country getByPropertyName(String name, String value) {
        List<Country> list = em.createQuery("select e from Country e where e." + name + "=?1").setParameter(1, value).getResultList();
        return (list.isEmpty()) ? null : list.get(0);
    }

    @Override
    public List<Country> getEntitiesByProperName(String name, String value) {
       List<Country> list = em.createQuery("select e from Country e where e." + name + "=?1").setParameter(1, value).getResultList();
        return list;
    }
    
   
    
}
