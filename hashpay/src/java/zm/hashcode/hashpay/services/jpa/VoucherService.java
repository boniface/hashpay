/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.jpa;

import java.math.BigDecimal;
import java.util.List;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.services.Service;

/**
 *
 * @author Bongani
 */
public interface VoucherService extends Service<Voucher, Long> {

    public Voucher buyVoucher();

    public Voucher processVoucher(String hash, String code) throws InvalidVoucherException;

    public List<Voucher> getExpiredVouchers();

    public void createVouchers(BigDecimal amount, CurrencyType currency, int number);
}
