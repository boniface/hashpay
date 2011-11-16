/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import junit.framework.Assert;
import java.math.BigDecimal;
import java.util.Date;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.services.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Ignore;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidProductException;
import zm.hashcode.hashpay.infrastructure.factories.market.MarketFactory;
import java.util.List;

/**
 *
 * @author T
 */
public class ProductServicesTest {
   
    @Autowired
    private ProductService service;
    private static ApplicationContext ctx;
    @Autowired
    private AccountDAO accountDAO;
     @Autowired
    private ProductDAO productDAO;
    
    
    
    public ProductServicesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:zm/hashcode/hashpay/infrastructure/conf/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void CreateProduct() {
         service = (ProductService) ctx.getBean("productService");
         Product product = service.createProduct("12111221", "Electricity", BigDecimal.valueOf(50.00), EnumProductStatus.AVAILABLE, EnumTokenType.STATIC, CurrencyType.ZMK);
         Assert.assertNotNull(product.getId());
  }
    
     @Ignore
    public void sellProduct(){
        MarketFactory sales = new MarketFactory();
        service = (ProductService) ctx.getBean("productService");
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        accountDAO = (AccountDAO)ctx.getBean("accountDAO");

        Product product = productDAO.find(new Long("38"));
        Account account = accountDAO.find(new Long("40"));
        
        try {
            product = service.buyProduct(account,product);
            sales.addProductSales(product.getDescription(), product.getUnitPrice(),new Date(),account.getCreatedBy());
            
        } catch (InsufficientBalanceException ex) {
            Logger.getLogger(ProductServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assert.assertNotNull(product.getId());
    }
    
     @Ignore
    public void claimProduct() throws InvalidProductException, InvalidVoucherException{
       service = (ProductService) ctx.getBean("productService");
       accountDAO = (AccountDAO)ctx.getBean("accountDAO");
       Account account = accountDAO.find(new Long("40"));
       String status = null;   
       try{
       Product product = service.validatedProduct("1287bef0659d401fa", "e3b3a6720492cdc", account);
       status = product.getProductStatus().CLAIMED.toString();
        } catch(InvalidVoucherException ex){
            Logger.getLogger(ProductServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
   
       Assert.assertEquals("CLAIMED", status);
    }
    
   @Ignore
    public void createBulkProducts(){
        service = (ProductService) ctx.getBean("productService");
       
        service.createProducts("MTN201", "Air-time", BigDecimal.valueOf(200.00), EnumProductStatus.AVAILABLE, EnumTokenType.STATIC, CurrencyType.ZMK, 2);
       
        productDAO = (ProductDAO)ctx.getBean("productDAO");
        List <Product> product = productDAO.findAll();
        Assert.assertTrue(product.size()>6);
    } 
      
    
}
