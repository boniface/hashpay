/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.factories.market.MarketFactory;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import zm.hashcode.hashpay.services.ProductService;

/**
 *
 * @author Peter Phillip
 */
@Repository("productService")
@Transactional
public class ProductServiceJPAImpl implements ProductService {
  
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

    @Override
    public void createProduct(String pserial, String desc, Date cdate, BigDecimal uPrice, EnumProductStatus proStatus, EnumTokenType tokType) {
         
        MarketFactory pro = new MarketFactory();
        pro.createProduct( pserial,  desc,  cdate,  uPrice, proStatus,  tokType);
        
    }
    
    @Override
    public boolean claimProduct(String serialNumber, Date date) {
        MarketFactory pro = new MarketFactory();
        pro.claimProduct(serialNumber, date);
        return true;
    }

    @Override
    public Product sellProduct(String serialNumber) {
        MarketFactory pro = new MarketFactory();
       Product prodcut = new Product();
       prodcut = pro.sellProduct(serialNumber);
       return prodcut;
    }

    @Override
    public void removeProduct(String desc) {
       MarketFactory pro = new MarketFactory();
       pro.removeProduct(desc);
    }
    @Override
    public Product findProduct(String serialNumber){
        MarketFactory pro = new MarketFactory();
       Product product = new Product();
       product = pro.findProduct(serialNumber);
       return product;
    }
    
    
}
