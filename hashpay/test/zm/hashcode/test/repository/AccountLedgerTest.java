/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import zm.hashcode.hashpay.infrastructure.factories.market.MarketFactory;
import zm.hashcode.hashpay.model.market.AccountingLedger;
import zm.hashcode.hashpay.repository.jpa.AccountingLedgerDAO;


/**
 *
 * @author 209042869
 */
public class AccountLedgerTest {
    
    
    private static Long Id;
    private AccountingLedgerDAO accountingLedgerDAO;
    private static ApplicationContext ctx;
    public AccountLedgerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
    public void addProducttoSales() {
      accountingLedgerDAO = (AccountingLedgerDAO) ctx.getBean("accountingLedgerDAO");   
      AccountingLedger acc = new MarketFactory().addProductSales("Air-time", BigDecimal.valueOf(20.00), new Date(), "Lance");
      Id = acc.getId();
      Assert.assertNotNull(acc.getId());
    }
    
     @Test
    public void testRead() {
         accountingLedgerDAO = (AccountingLedgerDAO) ctx.getBean("accountingLedgerDAO");  
         AccountingLedger acc = accountingLedgerDAO.find(Id);
         Assert.assertEquals("Air-time",acc.getDescription());
     }
  

      @Test
    public void testUpdate() {
       accountingLedgerDAO = (AccountingLedgerDAO) ctx.getBean("accountingLedgerDAO");  
       AccountingLedger acc = accountingLedgerDAO.find(Id);
       acc.setAmountSold(BigDecimal.valueOf(40.00));
       accountingLedgerDAO.merge(acc);
       AccountingLedger acc2 = accountingLedgerDAO.find(Id);
       Assert.assertEquals(BigDecimal.valueOf(40.00),acc2.getAmountSold());          
    }

    @Test
    public void testCount() {
     accountingLedgerDAO = (AccountingLedgerDAO) ctx.getBean("accountingLedgerDAO");  
     Long count = accountingLedgerDAO.count();
     Assert.assertEquals(new Long(1), count);          
    }

    @Test
    public void testList() {
     accountingLedgerDAO = (AccountingLedgerDAO) ctx.getBean("accountingLedgerDAO"); 
     List<AccountingLedger> acc = accountingLedgerDAO.findAll();
     Assert.assertTrue(acc.size() > 0);
    }

    @Test
    public void testtGetByParamater() {
     accountingLedgerDAO = (AccountingLedgerDAO) ctx.getBean("accountingLedgerDAO"); 
     AccountingLedger acc = accountingLedgerDAO.getByPropertyName("user", "Lance");
     Assert.assertEquals("Lance",acc.getUser());
  }

    @Ignore
    public void testDelete() {
        accountingLedgerDAO = (AccountingLedgerDAO) ctx.getBean("accountingLedgerDAO");  
         AccountingLedger acc = accountingLedgerDAO.find(Id);
        accountingLedgerDAO.remove(acc);
        AccountingLedger acc2 = accountingLedgerDAO.find(Id);
        Assert.assertNull(acc2);   
          
    }
}
