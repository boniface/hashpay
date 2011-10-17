/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.market;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.model.market.Merchant;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.repository.jpa.MerchantDAO;
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
       private MerchantDAO merchantDAO;
       ApplicationContext ctx = GetContext.getApplicationContext();

    /*public Product createProduct(String Description,String productType, BigDecimal productPrice,String qty,String code) {
          productDAO = (ProductDAO) ctx.getBean("productDAO");  
          Product product = new Product//.Builder(Description,productType,new BigDecimal("0.00")).
                    BalanceOnHand(qty).
                    code(code).build();   
              productDAO.persist(product);
               return product;
                  
      }   */   
   
    public Merchant createAccount(String Username,String emailAddres,AccountNumber ac, String password){
          merchantDAO = (MerchantDAO) ctx.getBean("merchantDAO");  
          Merchant merchant = new Merchant.Builder(Username,emailAddres).
                   passWord(password).
                  AccountNumber(ac).build();
                 merchantDAO.persist(merchant);
           return merchant;
        } 
      
    /*public Product removeProduct(String productDescription){
             product = (ProductDAO) ctx.getBean("productDAO");
             Product product = productDAO.getByPropertyName("productDescription", productDescription);
             productDAO.remove(product);
             return product;
         }*/

  }

    
  

