/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import java.util.List;
import org.junit.Assert;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.hashpay.model.market.Product;
import org.junit.Test;

/**
 *
 * @author 209042869
 */
public class ProductTest {
    
    private static Long productId;
    private ProductDAO productDAO;
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void testRead() {
         productDAO = (ProductDAO) ctx.getBean("productDAO");
         Product product = productDAO.find(productId);
         Assert.assertEquals("Air-time", product.getProductDescription());
    }
    
    @Test
    public void testUpdate() {
       productDAO = (ProductDAO) ctx.getBean("productDAO"); 
       Product product = productDAO.find(productId);
       product.setQauntity("600");
       Product product2 = productDAO.find(productId);
       Assert.assertEquals("600",product.getQauntity());          
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
    Assert.assertEquals("Active", product.getProductDescription());
  }

    @Test
    public void testDelete() {
        productDAO = (ProductDAO) ctx.getBean("productDAO");
        Product product = productDAO.find(productId);
        productDAO.remove(product);
        Product product2 = productDAO.find(productId);
        Assert.assertNull(product2);   
          
    }
   
}
