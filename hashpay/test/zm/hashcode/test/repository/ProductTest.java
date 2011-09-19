/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testAddProduct() {
    
    }
    
    @Test
    public void testRead() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testCount() {
    }

    @Test
    public void testList() {
    }

    @Test
    public void testtGetByParamater() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testDisable() {
    }     
    
}
