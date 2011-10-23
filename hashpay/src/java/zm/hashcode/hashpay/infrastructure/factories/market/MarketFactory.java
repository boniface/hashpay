/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.market;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;
import zm.hashcode.hashpay.infrastructure.util.voucher.VoucherUtility;
import zm.hashcode.hashpay.model.market.AccountingLedger;
import zm.hashcode.hashpay.repository.jpa.AccountingLedgerDAO;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import zm.hashcode.hashpay.services.ProductService;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;




/**
 *
 * @author Peter Phillip
 */
public class MarketFactory {
    
      @Autowired
       private ProductService productService;
       private ProductDAO productDAO;
       private AccountingLedgerDAO accountingLedgerDAO;
       ApplicationContext ctx = GetContext.getApplicationContext();

      private VoucherUtility util = new VoucherUtility();
      String tokenType= "DYNAMIC";

    
   
   
   

     public Product createProduct(String ProductSerialNumber,String Description,BigDecimal unitPrice,EnumProductStatus productStatus,EnumTokenType eTokenType,CurrencyType currencySymbol) {
          productDAO = (ProductDAO) ctx.getBean("productDAO"); 
          Product product = null;
          String tokenNumber=null;
          
        if (tokenType.equals(EnumTokenType.DYNAMIC.toString()))
          {
           product = new Product.Builder(Description, unitPrice,util.getService().getCode()).
                  productSerialNumber(ProductSerialNumber).createDate(new Date()).
                  productStatus(productStatus).
                  eTokenType(eTokenType).
                  datedClaimed(new Date()).
                  currencySymbol(currencySymbol).
                  build();
           productDAO.persist(product);
           }
          else
          {
                 product = new Product.Builder(Description, unitPrice,tokenNumber).
                  productSerialNumber(ProductSerialNumber).createDate(new Date()).
                  productStatus(productStatus).
                  eTokenType(eTokenType).
                  datedClaimed(new Date()).currencySymbol(currencySymbol).
                  build();
                 productDAO.persist(product);
                
             }
         return product;
      }  
    
    public AccountingLedger addProductSales(String Description,BigDecimal amount,Date dateSold,String user){
         accountingLedgerDAO = (AccountingLedgerDAO) ctx.getBean("accountingLedgerDAO"); 
         AccountingLedger ledger = new AccountingLedger.
                 Builder(Description, amount).cretationDate(dateSold).
                 userSellingProduct(user).build();
         accountingLedgerDAO.persist(ledger);
         return ledger;
     }
    

    public Product removeProduct(String Description){
             productDAO = (ProductDAO) ctx.getBean("productDAO");
             Product product = productDAO.getByPropertyName("Description", Description);
             productDAO.remove(product);
          return product;
         }


  
  }

    
  

