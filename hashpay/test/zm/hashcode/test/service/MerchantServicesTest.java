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
import zm.hashcode.hashpay.services.MerchantService;
import junit.framework.Assert;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;

/**
 *
 * @author Thozamile Sikwata
 */
public class MerchantServicesTest {

   
    @Autowired
    private MerchantService  merchantService;
    private static Long productId;
    private ProductDAO productDAO;
    private static ApplicationContext ctx;
  
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
        merchantService = (MerchantService) ctx.getBean("merchantService");
        merchantService.requestToRegister("Thozamile Sikwata","thozamilesikwata@live.com", "2424fsgs");
        Assert.assertNotNull(merchantService);
    }

    @Test
    public void testAddProduct(){
         merchantService = (MerchantService) ctx.getBean("merchantService");
         merchantService.addProduct("Bus Ticket-Single",BigDecimal.valueOf(400), "2", "2423141622");
         Assert.assertNotNull(merchantService);
     }
    
    @Test
       public void testRemoveProduct() {
        merchantService = (MerchantService) ctx.getBean("merchantService");
       merchantService.removeProduct("Bus Ticket-Single");
       Product product = productDAO.find(productId);
       Assert.assertNull(product);
        
    }
    
   @Test
   public void testlistProductPublished(){
    merchantService = (MerchantService) ctx.getBean("merchantService");
    merchantService.listallProductsPublished();
    List<Product> product = productDAO.findAll();
    Assert.assertTrue(product.size() > 0);
  }       
    

    
}