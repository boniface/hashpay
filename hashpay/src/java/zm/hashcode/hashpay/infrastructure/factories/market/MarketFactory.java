/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.market;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.services.ProductService;

/**
 *
 * @author 209042869
 */
public class MarketFactory {
    
      @Autowired
       private ProductService productService;
       ApplicationContext ctx = GetContext.getApplicationContext();

      public Product createProduct(String Description, BigDecimal productValue,String qty,String token) {
            Product product = new Product.Builder().ProductDescription(Description).ProductValue(productValue).BalanceOnHand(qty).token(token).build();    
            return product;
        
    }      

  
  }

    
  

