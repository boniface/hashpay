/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zm.hashcode.test.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusType;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import zm.hashcode.hashpay.repository.jpa.VoucherDAO;
import zm.hashcode.hashpay.services.VoucherService;

/**
 *
 * @author boniface
 */
public class VoucherServicesTest {
    private static ApplicationContext ctx;
    @Autowired
    private VoucherService service;
    private AccountDAO accountDAO;
    private static Long voucherId;
    private VoucherDAO voucherDAO;

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
    public void createVoucher() {
         service = (VoucherService) ctx.getBean("voucherService");
         Voucher voucher = service.createVoucher(new BigDecimal("2000.00"), CurrencyType.ZMK);
         Assert.assertNotNull(voucher.getId());
    }
    @Test
    public void sellVoucher(){
        
        service = (VoucherService) ctx.getBean("voucherService");
        voucherDAO = (VoucherDAO)ctx.getBean("voucherDAO");
        accountDAO = (AccountDAO)ctx.getBean("accountDAO");

        Voucher voucher = voucherDAO.find(Long.valueOf("302"));
        Account account = accountDAO.find(new Long("123"));
        
        try {
            voucher = service.buyVoucher(account,voucher);
        } catch (InsufficientBalanceException ex) {
            Logger.getLogger(VoucherServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assert.assertNotNull(voucher.getId());
    }
    @Ignore
    public void claimVoucher() throws InvalidVoucherException{
        service = (VoucherService) ctx.getBean("voucherService");
        accountDAO = (AccountDAO)ctx.getBean("accountDAO");
        Account account = accountDAO.find(new Long("123"));
        String status = null;
        try{
       Voucher voucher = service.processVoucher("e8ad1f7dc8f34bc4", "a4cd3622b619fb59", account);
         status = voucher.getVoucherStatus().CLAIMED.toString();
        } catch(InvalidVoucherException ex){
            Logger.getLogger(VoucherServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       Assert.assertEquals("CLAIMED", status);
    }
    @Test
    public void createBulkVouchers(){
        service = (VoucherService) ctx.getBean("voucherService");
        service.createVouchers(new BigDecimal("150.95"), CurrencyType.ZMK, 9);
        voucherDAO = (VoucherDAO)ctx.getBean("voucherDAO");
        List <Voucher> voucher = voucherDAO.findAll();
        Assert.assertTrue(voucher.size()>9);
    }
}
