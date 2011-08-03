/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.hashpay.infrastructure.factories.people.UsersFactory;
import zm.hashcode.hashpay.model.people.Users;
import zm.hashcode.hashpay.repository.jpa.UsersDAO;

/**
 *
 * @author boniface
 */

public class UsersTest {

    private static Long usersId;
    private UsersDAO usersDAO;
    private static ApplicationContext ctx;

    public UsersTest() {
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
    public void createUser() {
         usersDAO = (UsersDAO) ctx.getBean("usersDAO");
         Users user=new UsersFactory.Builder("John","Banda").
                 addressStatus("CURRENT"). cellNumber("0867337373").
                 contactStatus("CURRENT").emailAddress("name@email.com").
                 faxNumber("0218938393").otherName("Lukas").
                 phoneNumber("921921912").physicalAddress("20 Chanda Mali Close")
                 .postalAddress("P.O.Box 23487").postalcode("7654").
                 rolename("ADMIN").title("MR").username("test@john.com").enabled(true).build();
                 usersDAO.persist(user);
                 Assert.assertNotNull(user.getId());
        
    }

   
}