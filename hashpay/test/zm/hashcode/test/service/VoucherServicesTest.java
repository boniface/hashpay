/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.test.service;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.services.jpa.VoucherService;

/**
 *
 * @author boniface
 */
public class VoucherServicesTest {
        private static ApplicationContext ctx;
    @Autowired
    private VoucherService service;

    public VoucherServicesTest() {
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
    public void createVouchers() {
         service = (VoucherService) ctx.getBean("voucherService");
         service.createVouchers(new BigDecimal("2000.00"), CurrencyType.ZMK, 10);
    
    }

}