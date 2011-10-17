/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
    @Test
    public void createNewProfile() {
        service = (RegistrationService) ctx.getBean("registrationService");
        service.registerUser("shanevdbroek@gmail.com", "password", "password");
    }

    @Ignore
    public void activateProfile() {
    }

    @Ignore
    public void testChangePassowrd() {
    }

    @Ignore
    public void testAddMoneyToAccount() {
    }

    @Ignore
    public void testTestUpdateProfile() {
    }

    @Ignore
    public void testPurchaseAservice() {
    }
}