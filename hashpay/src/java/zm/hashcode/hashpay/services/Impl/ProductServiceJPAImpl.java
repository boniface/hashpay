/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import java.util.List;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;

/**
 *
 * @author 209042869
 */
@Repository("productService")
@Transactional
public class ProductServiceJPAImpl implements ProductService{
  
    @Autowired
    private ProductDAO productDAO;
    
    
    @Override
    public Product find(Long id) {
         return productDAO.find(id);
    }

    @Override
    public void persist(Product entity) {
          productDAO.persist(entity);
    }

    @Override
    public void merge(Product entity) {
       productDAO.merge(entity);
    }

    @Override
    public void remove(Product entity) {
        productDAO.remove(entity);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<Product> findInRange(int firstResult, int maxResults) {
       return productDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return productDAO.count();
    }

    @Override
    public Product getByPropertyName(String name, String value) {
        return productDAO.getByPropertyName(name, value);
    }

    @Override
    public List<Product> getEntitiesByProperName(String name, String value) {
        return productDAO.getEntitiesByProperName(name, value);
    }
    
}
