/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.test.repository;

import zm.hashcode.hashpay.model.vouchers.Voucher;
import java.math.BigDecimal;
import java.util.Date;
import zm.hashcode.hashpay.repository.jpa.VoucherDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import zm.hashcode.hashpay.infrastructure.factories.voucher.VoucherFactory;
import zm.hashcode.hashpay.model.vouchers.ClaimType;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusType;

/**
 *
 * @author Bongani
 */
public class VoucherTest {

    private static ApplicationContext ctx;
    private VoucherDAO voucherDAO;
    private static Long voucherId;

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
        Voucher voucher = new VoucherFactory().createVoucher(new BigDecimal("2000.00"), CurrencyType.ZMK);
        voucherDAO.persist(voucher);
        voucherId = voucher.getId();
        Assert.assertNotNull(voucher.getId());
    }

    @Test
    public void sellVoucher() {
        voucherDAO = (VoucherDAO) ctx.getBean("voucherDAO");
        Voucher v = voucherDAO.find(voucherId);
        v.setVoucherStatus(VoucherStatusType.SOLD);
        voucherDAO.merge(v);
        Voucher newv = voucherDAO.find(voucherId);
        Assert.assertEquals(VoucherStatusType.SOLD, newv.getVoucherStatus());
    }

    @Test
    public void claimVoucher() {
        voucherDAO = (VoucherDAO) ctx.getBean("voucherDAO");
        Voucher v = voucherDAO.find(voucherId);
        v.setClaimType(ClaimType.CUSTOMER_CLAIM);
        v.setClaimer("boniface");
        v.setDatedClaimed(new Date());
        v.setVoucherStatus(VoucherStatusType.CLAIMED);
        voucherDAO.merge(v);
        Voucher newVoucher = voucherDAO.find(voucherId);
        Assert.assertEquals("boniface", newVoucher.getClaimer());
    }
}
