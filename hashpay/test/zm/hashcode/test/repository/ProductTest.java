/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import zm.hashcode.hashpay.infrastructure.factories.market.MarketFactory;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import junit.framework.Assert;
import org.junit.Ignore;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;


/**
 *
 * @author Thozamile
 */
public class ProductTest {
    
    private static Long productId;
    private ProductDAO productDAO;
    private EnumTokenType tType;
    private EnumProductStatus proStatus;
    private static ApplicationContext ctx;
    
    public ProductTest() {
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
    
     @Test
    public void createAccount() {
         Date date = null;
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        Product product = new MarketFactory().createProduct("2342","testing product",date,new BigDecimal("27000.00"),proStatus.AVAILABLE,tType.DYNAMIC);
        productDAO.persist(product);
        productId = product.getId();
        Assert.assertNotNull(product.getId());
    }


  @Test
    public void testRead() {
         productDAO = (ProductDAO) ctx.getBean("productDAO");
         Product product = productDAO.find(productId);
      //   Assert.assertEquals("Air-time", product.getProductDescription());
  }
  
 
    @Test
    public void testUpdate() {
       productDAO = (ProductDAO) ctx.getBean("productDAO"); 
       Product product = productDAO.find(productId);
     //  product.setProductPrice(BigDecimal.valueOf(10.00));
       productDAO.merge(product);
       Product product2 = productDAO.find(productId);
      // Assert.assertEquals(BigDecimal.valueOf(10.00),product.getProductPrice());          
    }

    @Test
    public void testCount() {
     productDAO = (ProductDAO) ctx.getBean("productDAO"); 
     Long count = productDAO.count();
     Assert.assertEquals(new Long(1), count);          
    }

    @Test
    public void testList() {
     productDAO = (ProductDAO) ctx.getBean("productDAO"); 
     List<Product> product = productDAO.findAll();
     Assert.assertTrue(product.size() > 0);
    }

    @Test
    public void testtGetByParamater() {
    productDAO = (ProductDAO) ctx.getBean("productDAO"); 
    Product product = productDAO.getByPropertyName("productDescription", "Air-time");
  //  Assert.assertEquals("Air-time",product.getProductDescription());
  }

     @Ignore
    public void testDelete() {
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        Product product = productDAO.find(productId);
        productDAO.remove(product);
        Product product2 = productDAO.find(productId);
        Assert.assertNull(product2);   
          
    }
   
  
}
