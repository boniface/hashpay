/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import org.junit.Ignore;
import java.util.List;
import junit.framework.Assert;
import java.math.BigDecimal;
import zm.hashcode.hashpay.model.accounts.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import zm.hashcode.hashpay.infrastructure.factories.account.AccountFactory;
import zm.hashcode.hashpay.model.accounts.Account.Builder;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import static org.junit.Assert.*;

/**
 *
 * @author 209052414
 */
public class AccountTest {

    private static Long Id;
    private AccountDAO accountDAO;
    private static ApplicationContext ctx;

    public AccountTest() {
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
    public void createAccount() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        //Account account = new AccountFactory.Builder("123456789", "Savings Account", "Deactivated").credit(BigDecimal.valueOf(100.00)).debit(BigDecimal.valueOf(30.00)).balance(BigDecimal.valueOf(70.00)).description("Airtime-Value 30.00").build();
        //accountDAO.persist(account);
        //Assert.assertNotNull(account.getId());
        Account account = new AccountFactory().createNewAccount("RSA", "Active", "Shane");
        accountDAO.persist(account);
        Id = account.getId();
        Assert.assertNotNull(account.getId());
    }

    @Ignore
    public void testRead() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        
        Account account = accountDAO.find(Id);
        Assert.assertEquals("Active", account.getAccountStatus());
    }

    @Ignore
    public void testUpdate() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        
        Account account = accountDAO.find(Id);
        account.setAccountStatus("Deactive");
        accountDAO.merge(account);
        Account account2 = accountDAO.find(Id);
        Assert.assertEquals("Deactive", account.getAccountStatus());
    }

    @Ignore
    public void testCount() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        
        Long count = accountDAO.count();
        Assert.assertEquals(new Long(1), count);        
    }

    @Ignore
    public void testList() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        
        List<Account> account = accountDAO.findAll();
        Assert.assertTrue(account.size() > 0);
    }

    @Ignore
    public void testtGetByParamater() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account account = accountDAO.getByPropertyName("createdBy", "Shane");
        Assert.assertEquals("Shane", account.getCreatedBy());
    }

    @Ignore
    public void testDelete() {
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account account = accountDAO.find(Id);
        accountDAO.remove(account);
        Account account2 = accountDAO.find(Id);
        Assert.assertNull(account2);
    }

    @Ignore
    public void testDisable() {
    }
}
