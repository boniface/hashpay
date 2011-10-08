/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import java.util.List;
import zm.hashcode.hashpay.infrastructure.factories.market.MarketFactory;
import zm.hashcode.hashpay.model.market.Merchant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.hashpay.repository.jpa.MerchantDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.Assert;

/**
 *
 * @author Thozamile Sikwata
 */
public class MerchantTest {
   
    private static Long Id;
    private MerchantDAO merchantDAO;
    private static ApplicationContext ctx;
    
    
    public MerchantTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:zm/hashcode/hashpay/infrastructure/conf/applicationContext-*.xml"); ctx = new ClassPathXmlApplicationContext("classpath:zm/hashcode/hashpay/infrastructure/conf/applicationContext-*.xml");
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
    // @Test
    @Test
    public void createAccount() {
        merchantDAO = (MerchantDAO) ctx.getBean("merchantDAO");
        Merchant merchant = new MarketFactory().createAccount("Thozamile", "thozamilesikwata@live.com", "pele123!");
        merchantDAO.persist(merchant);
        Id = merchant.getId();
        Assert.assertNotNull(merchant.getId());
    }
 
      @Test
    public void testUpdate() {
       merchantDAO = (MerchantDAO) ctx.getBean("merchantDAO");
       Merchant merchant = merchantDAO.find(Id);
       merchant.setPassword("thozi");
       merchantDAO.merge(merchant);
       Merchant merchant2 = merchantDAO.find(Id);
       Assert.assertEquals("thozi",merchant.getPassword());          
    }

    @Test
    public void testCount() {
     merchantDAO = (MerchantDAO) ctx.getBean("merchantDAO"); 
     Long count = merchantDAO.count();
     Assert.assertEquals(new Long(1), count);          
    }

    @Test
    public void testList() {
     merchantDAO = (MerchantDAO) ctx.getBean("merchantDAO"); 
     List<Merchant> merchant = merchantDAO.findAll();
     Assert.assertTrue(merchant.size() > 0);
    }

    @Test
    public void testtGetByParamater() {
     merchantDAO = (MerchantDAO) ctx.getBean("merchantDAO"); 
     Merchant merchant = merchantDAO.getByPropertyName("userName", "Thozamile");
     Assert.assertEquals("Thozamile",merchant.getUserName());
  }

    @Test
    public void testDelete() {
        merchantDAO = (MerchantDAO) ctx.getBean("merchantDAO"); 
        Merchant merchant = merchantDAO.find(Id);
        merchantDAO.remove(merchant);
        Merchant merchant2 = merchantDAO.find(Id);
        Assert.assertNull(merchant2);   
          
    }
    
    

}
