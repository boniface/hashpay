/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.factories.market.MarketFactory;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;

/**
 *
 * @author 209042869
 */
@Repository("productService")
@Transactional
public class ProductServiceJPAImpl{
  
      @Autowired
    private ProductDAO productDAO;
   
    /**
     * @return the productDAO
     */
    public ProductDAO getProductDAO() {
        return productDAO;
    }

    /**
     * @param productDAO the productDAO to set
     */
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void createProduct(String Descrtn, String productType,BigDecimal price, String qyt, String token) {
        MarketFactory p = new MarketFactory();
        p.createProduct(Descrtn, productType,price,qyt,token);
    }

    
    
}
