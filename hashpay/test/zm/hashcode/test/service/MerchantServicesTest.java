/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import junit.framework.Assert;
import zm.hashcode.hashpay.infrastructure.factories.market.MarketFactory;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import zm.hashcode.hashpay.services.AccountEntriesService;
import zm.hashcode.hashpay.services.AccountService;
import zm.hashcode.hashpay.services.ProductService;
import zm.hashcode.hashpay.services.RegistrationService;

/**
 *
 * @author Thozamile Sikwata
 */
public class MerchantServicesTest {

   
    @Autowired
    private RegistrationService registrationService;
    private static Long productId;
    private ProductDAO productDAO;
    private static Account accou;
    private static ApplicationContext ctx;
    private ProductService productService;
    private AccountService service;
    
  
    public MerchantServicesTest() {
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
    public void createRequestAccount() {
        registrationService=(RegistrationService) ctx.getBean("registrationService");
        registrationService.registerUser("thozamilesikwata@live.com", "pele", "pele");
        Assert.assertNotNull(registrationService);
    }

    @Test
    public void testAddProduct(){
         productService = (ProductService) ctx.getBean("productService");
         Product product = productService.createProduct("12332", "Bus-Ticket", BigDecimal.valueOf(500.11), EnumProductStatus.AVAILABLE, EnumTokenType.DYNAMIC, CurrencyType.ZMK);
         Assert.assertNotNull(product.getId());
     }
    
    @Test
       public void testRemoveProduct() {
        MarketFactory prd= new MarketFactory();
        prd.removeProduct("Bus-Ticket");
        Assert.assertNotNull(prd);
        
    }
    
   @Test
   public void testlistProductPublished(){
    productDAO = (ProductDAO) ctx.getBean("productDAO");
    List<Product> product = productDAO.findAll();
    Assert.assertTrue(product.size() > 0);
  }  
   
   @Test
    public void testCreditAccount() {
        AccountEntriesService services = (AccountEntriesService) ctx.getBean("accountEntriesService");
        service = (AccountService) ctx.getBean("accountService");
        services.creditAccount(accou, BigDecimal.valueOf(200.00), "321654", "RSA");
    }
   
   @Test
    public void testcheckAccountBalance() {
        service = (AccountService) ctx.getBean("accountService");
        BigDecimal d= service.checkBalance("1");
        Assert.assertEquals(d, new BigDecimal("0.00"));
    }
   
    
    

    
}