/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import zm.hashcode.hashpay.model.vouchers.Voucher;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import zm.hashcode.hashpay.repository.jpa.VoucherDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import zm.hashcode.hashpay.infrastructure.factories.voucher.VoucherFactory;
import zm.hashcode.hashpay.model.vouchers.ClaimTypeEnum;
import zm.hashcode.hashpay.model.vouchers.CurrencyTypeEnum;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusTypeEnum;
import static org.junit.Assert.*;

/**
 *
 * @author Bongani
 */
public class VoucherTest {
    private static ApplicationContext ctx;
    private VoucherDAO voucherDAO;
    private static Long id;
    
    
    public VoucherTest() {
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
     public void createVoucher() {
     
         voucherDAO = (VoucherDAO) ctx.getBean("voucherDAO");
         Calendar date = Calendar.getInstance(); 
         Voucher voucher = new VoucherFactory.Builder("123000321", BigDecimal.valueOf(123.21)).claimer("Bongani Mthembu").
                 dateClaimed(date.getTime()).dateGenerated(date.getTime()).serviceType("RoadShow Tickets").claimStatus(ClaimTypeEnum.CUSTOMER_CLAIM)
                 .voucherStatusType(VoucherStatusTypeEnum.SOLD).curencyType(CurrencyTypeEnum.ZMK).Build();
        voucherDAO.persist(voucher);
        assertNotNull(voucher.getId());
     
     
     }
}
