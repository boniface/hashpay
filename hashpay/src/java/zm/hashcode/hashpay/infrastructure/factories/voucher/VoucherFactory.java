/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.voucher;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;
import zm.hashcode.hashpay.infrastructure.util.voucher.VoucherUtility;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.services.VoucherService;

/**
 *
 * @author Bongani
 */
public class VoucherFactory {

    @Autowired
    private VoucherService voucherService;
    ApplicationContext ctx = GetContext.getApplicationContext();
    private VoucherUtility util = new VoucherUtility();

    public Voucher createVoucher(BigDecimal amount, CurrencyType currency) {
        Voucher voucher = new Voucher.Builder(util.getService().getCode(), amount).currencySymbol(currency).dateGenerated(new Date()).build();
        return voucher;
    }

    public Voucher getVoucher(String hash, String code) {
        String voucherNumber = new VoucherUtility().getService().getConstructedCode(hash, code);
        voucherService = (VoucherService) ctx.getBean("voucherService");
       // Voucher voucher = voucherService.getByPropertyName("voucherNumber", voucherNumber);
        return null; //voucher;
    }

    public void createVouchers(BigDecimal amount, CurrencyType currency, int number) {
        voucherService = (VoucherService) ctx.getBean("voucherService");
        for (int i = 0; i < number; i++) {
            //voucherService.persist(createVoucher(amount, currency));
        }

    }
}