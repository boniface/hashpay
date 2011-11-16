/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;

import java.math.BigDecimal;
import java.util.List;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusType;

/**
 *
 * @author Bongani
 */
public interface VoucherService {

    public Voucher buyVoucher(Account accNumber, Voucher voucher)throws InsufficientBalanceException ;

    //public Voucher processVoucher(String hash, String code, Account account) throws InvalidVoucherException;
    public Voucher processVoucher(String codeGen, Account account)throws InvalidVoucherException;
    
    public List<Voucher> getExpiredVouchers();

    public void createVouchers(BigDecimal amount, CurrencyType currency, int number);
    
    public Voucher createVoucher(BigDecimal amount, CurrencyType currency);
    public Voucher findVoucher(Long id);
    public List<Voucher> voucherStatus(VoucherStatusType descr);
    
}
