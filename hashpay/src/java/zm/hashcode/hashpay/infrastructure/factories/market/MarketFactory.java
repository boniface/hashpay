/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.market;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;
import zm.hashcode.hashpay.model.market.Merchant;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import zm.hashcode.hashpay.services.ProductService;

/**
 *
 * @author thozamile Sikwata
 */
public class MarketFactory {
    
      @Autowired
       private ProductService productService;
       private ProductDAO productDAO;
       ApplicationContext ctx = GetContext.getApplicationContext();

      public Product createProduct(String Description, BigDecimal productValue,String qty,String token) {
            Product product = new Product.Builder().
                    ProductDescription(Description).
                    ProductValue(productValue).
                    BalanceOnHand(qty).
                    token(token).build();    
            return product;
        }      
   
      public Merchant createAccount(String Username,String emailAddres, String password){
           Merchant merchant = new Merchant.Builder().
                   UserName(Username).
                   emailAddress(emailAddres).
                   passWord(password).build();
           return merchant;
        } 
      
      public Product removeProduct(String productDescription){
             productDAO = (ProductDAO) ctx.getBean("productDAO");
             Product product = productDAO.getByPropertyName("productDescription", productDescription);
            return product;
         }
      
      
      
      
   
  
  
  }

    
  

