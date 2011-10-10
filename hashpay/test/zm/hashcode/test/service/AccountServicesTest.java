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
import zm.hashcode.hashpay.services.AccountEntriesService;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author boniface
 */
public class AccountServicesTest {

    private static ApplicationContext ctx;
    @Autowired
    private AccountService service;
    @Autowired
    public AccountServicesTest() {
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
    @Ignore
    public void createAccount() {
        service = (AccountService) ctx.getBean("accountService");
        service.createAccount("DeActive", "ZMB", "Lance");
        Assert.assertNotNull(service);
    }
    @Ignore
    public void checkBalance() {
        service = (AccountService) ctx.getBean("accountService");
        BigDecimal d= service.checkBalance("1");
        Assert.assertEquals(d, new BigDecimal("0.00"));
    }

    @Ignore
    public void activateAccount() {
        service = (AccountService) ctx.getBean("accountService");
        service.setAccountStatus("Active", "Lance");
    }

    @Ignore
    public void disableAccount() {
        service = (AccountService) ctx.getBean("accountService");
        service.setAccountStatus("Deactive", "Lance");
    }

    @Test
    public void testCreditAccount() {
        AccountEntriesService services = (AccountEntriesService) ctx.getBean("accountEntriesService");
        service = (AccountService) ctx.getBean("accountService");
        services.creditAccount("34", BigDecimal.valueOf(200.00), "321654", "RSA");
    }

    @Ignore
    public void testDebitAccount() {
       AccountEntriesService services = (AccountEntriesService) ctx.getBean("accountEntriesService");
        service = (AccountService) ctx.getBean("accountService");
        services.CreateDebitAccountEntry("34", BigDecimal.valueOf(200.00), "321654", "RSA");
    }

    @Ignore
    public void testAccountBalances() {
    }
}