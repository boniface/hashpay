/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.market;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.model.market.AccountingLedger;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.market.Merchant;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.model.people.Users;
import zm.hashcode.hashpay.repository.jpa.AccountingLedgerDAO;
import zm.hashcode.hashpay.repository.jpa.MerchantDAO;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import zm.hashcode.hashpay.services.ProductService;

/**
 *
 * @author Peter Phillip
 */
public class MarketFactory {
    
      @Autowired
       private ProductService productService;
       private ProductDAO productDAO;
       private MerchantDAO merchantDAO;
       private AccountingLedgerDAO accountingLedgerDAO;
       ApplicationContext ctx = GetContext.getApplicationContext();

    public Product createProduct(String pserial, String desc, Date cdate, BigDecimal uPrice,EnumProductStatus proStatus, EnumTokenType tokType) {
          productDAO = (ProductDAO) ctx.getBean("productDAO");  
          Product product = new Product.Builder(pserial,desc,cdate,uPrice,proStatus,tokType).build();
              productDAO.persist(product);
               return product;        
      }   
   
    public Merchant createAccount(String Username,String emailAddres,AccountNumber ac, String password){
          merchantDAO = (MerchantDAO) ctx.getBean("merchantDAO");  
          Merchant merchant = new Merchant.Builder(Username,emailAddres).
                   passWord(password).
                  AccountNumber(ac).build();
                 merchantDAO.persist(merchant);
           return merchant;
        } 
      
    public AccountingLedger addProductSales(String Description,BigDecimal amount,Date dateSold,String user){
         accountingLedgerDAO = (AccountingLedgerDAO) ctx.getBean("accountingLedgerDAO"); 
         AccountingLedger ledger = new AccountingLedger.
                 Builder(Description, amount).cretationDate(dateSold).
                 userSellingProduct(user).build();
         accountingLedgerDAO.persist(ledger);
         return ledger;
     }
    
    public Product removeProduct(String serialNumber){
             productDAO = (ProductDAO) ctx.getBean("productDAO");
             Product product = productDAO.getByPropertyName("ProductSerialNumber", serialNumber);
             productDAO.remove(product);
             return product;
         }
    
      public Product sellProduct(String serialNumber){
             productDAO = (ProductDAO) ctx.getBean("productDAO");
             Product product = productDAO.getByPropertyName("ProductSerialNumber", serialNumber);
             return product;
         }
    
        public void claimProduct(String serialNumber, Date date){
             productDAO = (ProductDAO) ctx.getBean("productDAO");
             Product product = productDAO.getByPropertyName("ProductSerialNumber", serialNumber);
             product.setDatedClaimed(date);
             
             productDAO.merge(product);
         }
        
            
       public Product findProduct(String serialNumber) {
        ctx = new ClassPathXmlApplicationContext("classpath:zm/hashcode/hashpay/infrastructure/conf/applicationContext-*.xml");
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        Product pp = productDAO.find(Long.valueOf(serialNumber));
        
        return pp;
    }
  }

    
  

