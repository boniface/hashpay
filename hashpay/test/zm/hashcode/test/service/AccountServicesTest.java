/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import java.math.BigDecimal;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import zm.hashcode.hashpay.services.AccountEntriesService;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author boniface
 */
public class AccountServicesTest {

    private static ApplicationContext ctx;
    private static Account accou;
    @Autowired
    private AccountService service;
    @Autowired
    private AccountDAO accountDAO;
    public AccountServicesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:zm/hashcode/hashpay/infrastructure/conf/applicationContext-*.xml");
       accou = new Account();
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
        service = (AccountService) ctx.getBean("accountService");
        accou = service.createAccount("deActive", "ZMB", "Shane");
        Assert.assertNotNull(accou.getId());
    }
    @Test
    public void testCreditAccount() {
        AccountEntriesService services = (AccountEntriesService) ctx.getBean("accountEntriesService");
        service = (AccountService) ctx.getBean("accountService");
        Account ac = service.findAccount("81");
         services.creditAccount(ac, BigDecimal.valueOf(200.00), "321654", "RSA");
        Assert.assertNotNull(ac.getBalance());
    }
    
    @Test
    public void checkBalance() {
        service = (AccountService) ctx.getBean("accountService");
        BigDecimal d= service.checkBalance("1");
        Assert.assertEquals(d, new BigDecimal("1050.00"));
    }

    @Test
    public void activateAccount() {
        service = (AccountService) ctx.getBean("accountService");
        service.setAccountStatus("Active", "1");
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account account = accountDAO.getByPropertyName("accountStatus","Active");
        Assert.assertEquals("Active",account.getAccountStatus());
    }

    @Test
    public void disableAccount() {
        service = (AccountService) ctx.getBean("accountService");
        service.setAccountStatus("Deactive", "1");
        accountDAO = (AccountDAO) ctx.getBean("accountDAO");
        Account account = accountDAO.getByPropertyName("accountStatus", "Deactive");
        Assert.assertEquals("Deactive", account.getAccountStatus().toString());
    }

    @Test
    public void testDebitAccount() {
       AccountEntriesService services = (AccountEntriesService) ctx.getBean("accountEntriesService");
        service = (AccountService) ctx.getBean("accountService");
        Account acc = service.findAccount("1");
        services.CreateDebitAccountEntry(acc, BigDecimal.valueOf(50.00), "321654", "RSA");
        Assert.assertNotNull(acc.getBalance());
    }

    @Ignore
    public void testAccountBalances() {
    }
}
