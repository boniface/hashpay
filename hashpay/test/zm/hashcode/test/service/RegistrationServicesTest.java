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
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.hashpay.services.AccountService;
import zm.hashcode.hashpay.services.RegistrationService;

/**
 *
 * @author boniface
 */
public class RegistrationServicesTest {

    private static ApplicationContext ctx;
    @Autowired
    private RegistrationService service;
    @Autowired
    private AccountService accountservice;
    private String message;

    @Autowired
    public RegistrationServicesTest() {
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
    public void createNewProfile() {
        service = (RegistrationService) ctx.getBean("registrationService");
        message = service.registerUser("ReidJason@gmail.com", "password", "password");
        Assert.assertEquals("User Has been Created", message);
    }

    @Test
    public void activateProfile() {
        service = (RegistrationService) ctx.getBean("registrationService");
        message = service.activateAccount("FuSOqdJz", Long.valueOf("384"));
        Assert.assertEquals("Account Activated , Login", message);
    }

    @Ignore
    public void testChangePassowrd() {
        service = (RegistrationService) ctx.getBean("registrationService");
        service.changePassword("shanevdbroek@gmail.com","password", "1234", "1234");
        Assert.assertEquals("Password has been changed", message);
    }
    @Ignore
    public void testAddMoneyToAccount() {      
    }

    @Ignore
    public void testTestUpdateProfile() {
        service = (RegistrationService)ctx.getBean("registrationService");
        message = service.setNames("Shane", "Van Der Broeck", "Kyle", "Mr", "shanevdbroek@gmail.com");
        Assert.assertEquals("Your account has been Updated", message);
    }

    @Ignore
    public void testPurchaseAservice() {
    }
}