/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
    @Test
    public void createAccount() {
        service = (AccountService) ctx.getBean("voucherService");
        service.createAccount("DeActive", "RSA", "Shane");
        Assert.assertNotNull(service);
    }

    @Test
    public void activateAccount() {
        service = (AccountService) ctx.getBean("voucherService");
        service.setAccountStatus("Active", "Shane");
    }

    @Test
    public void disableAccount() {
        service = (AccountService) ctx.getBean("voucherService");
        service.setAccountStatus("Deactive", "Shane");
    }

    @Test
    public void testCreditAccount() {
    }

    @Test
    public void testDebitAccount() {
    }

    @Test
    public void testAccountBalances() {
    }
}