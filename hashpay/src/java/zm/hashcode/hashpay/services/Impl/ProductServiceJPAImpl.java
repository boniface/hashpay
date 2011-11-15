/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidProductException;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.infrastructure.factories.market.MarketFactory;
import zm.hashcode.hashpay.infrastructure.util.voucher.VoucherUtility;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import java.util.List;
import zm.hashcode.hashpay.services.AccountEntriesService;
import zm.hashcode.hashpay.services.ProductService;


/**
 *
 * @author Thozamile Sikwata
 */
@Repository("productService")
@Transactional
public class ProductServiceJPAImpl implements ProductService {
  
    @Autowired
    private ProductDAO productDAO;
    private VoucherUtility util;
    @Autowired
    private AccountEntriesService accountService;
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:zm/hashcode/hashpay/infrastructure/conf/applicationContext-*.xml");

   
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
    public Product createProduct(String ProductSerialNumber, String Description, BigDecimal unitPrice, EnumProductStatus productStatus, EnumTokenType eTokenType,CurrencyType currencySymbol) {
         MarketFactory p = new MarketFactory();
         Product product= p.createProduct(ProductSerialNumber, Description, unitPrice, productStatus, eTokenType,currencySymbol);
         return product;
    }

    @Override
    public Product buyProduct(Account accNumber, Product product) throws InsufficientBalanceException {
            Product prod= productDAO.find(product.getId());
            accountService = (AccountEntriesService) ctx.getBean("accountEntriesService");
            accountService.CreateDebitAccountEntry(accNumber, prod.getUnitPrice(),prod.getTokenNumber(), prod.getCurrencySymbol().toString());
            prod.setProductStatus(EnumProductStatus.SOLD);
            productDAO.merge(prod);
           return prod;
    }

    @Override
    public Product validatedProduct(String hash, String code, Account account) throws InvalidVoucherException {
         accountService = (AccountEntriesService) ctx.getBean("accountEntriesService");
        String codeGen = new VoucherUtility().getService().getConstructedCode(hash, code);
        Product product = productDAO.getByPropertyName("tokenNumber", codeGen);
        if (EnumProductStatus.SOLD == product.getProductStatus()) {
            accountService.creditAccount(account,new BigDecimal(product.getUnitPrice().toString()),product.getTokenNumber().toString(), product.getCurrencySymbol().toString());
            product.setProductStatus(EnumProductStatus.CLAIMED);
            product.setDatedClaimed(new Date());
            product.setClaimer(account.getCreatedBy().toString());
            productDAO.merge(product);
            
        } else {
            try {
                throw new InvalidProductException();
            } catch (InvalidProductException ex) {
                Logger.getLogger(ProductServiceJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            }
             return product;
    }
    
   

    @Override
    public void createProducts(String ProductSerialNumber, String Description, BigDecimal unitPrice, EnumProductStatus productStatus, EnumTokenType eTokenType, CurrencyType currencySymbol, int number) {
         MarketFactory f = new MarketFactory();
         f.createProducts(ProductSerialNumber, Description, unitPrice, productStatus, eTokenType, currencySymbol, number);
    }
     @Override
    public Product findProduct(String productNumber){
        return  productDAO.getByPropertyName("id", productNumber);
   }

   

    @Override
    public List<Product> allproductbyDescr(String descr) {
      return productDAO.getEntitiesByProperName("Description",descr);
    }

    @Override
    public Product list(String prd) {
        return  productDAO.getByPropertyName("Description", prd);
    }
   
    
}
