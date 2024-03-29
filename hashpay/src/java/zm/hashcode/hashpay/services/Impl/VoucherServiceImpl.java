/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.infrastructure.factories.voucher.VoucherFactory;
import zm.hashcode.hashpay.infrastructure.util.voucher.VoucherUtility;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.vouchers.ClaimType;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusType;
import zm.hashcode.hashpay.repository.jpa.VoucherDAO;
import zm.hashcode.hashpay.services.AccountEntriesService;
import zm.hashcode.hashpay.services.VoucherService;

/**
 *
 * @author Bongani
 */
@Repository("voucherService")
@Transactional
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherDAO voucherDAO;
    private VoucherUtility util;
    @Autowired
    private AccountEntriesService accountService;
    

    public VoucherDAO getVoucherDAO() {
        return voucherDAO;
    }

    /**
     * @param voucherDAO the voucherDAO to set
     */
    public void getVoucherDAO(VoucherDAO voucherDAO) {
        this.voucherDAO = voucherDAO;
    }
    
    @Override
    public Voucher createVoucher(BigDecimal amount, CurrencyType currency){
        VoucherFactory f = new VoucherFactory();
       Voucher voucher = f.createVoucher(amount, currency);  
       voucherDAO.persist(voucher);
       return voucher;
    }

    //THIS METHOD NEED TO BE SYNCHRONISED AND ATOMIC
    @Override
    public synchronized Voucher buyVoucher(Account accNumber, Voucher voucher)throws InsufficientBalanceException  {
        
        Voucher v = voucherDAO.find(voucher.getId());
         
            accountService.CreateDebitAccountEntry(accNumber, v.getVoucherValue(), v.getVoucherNumber(), v.getCurrencySymbol().toString());
            
            v.setVoucherStatus(VoucherStatusType.SOLD);
              voucherDAO.merge(v);
            
            return v;
        }
    

    /*@Override
    public Voucher processVoucher(String hash, String code, Account account) throws InvalidVoucherException {
     
        String codeGen = new VoucherUtility().getService().getConstructedCode(hash, code);
        Voucher voucher = voucherDAO.getByPropertyName("voucherNumber", codeGen);
        if (VoucherStatusType.SOLD == voucher.getVoucherStatus()) {
            accountService.creditAccount(account,new BigDecimal(voucher.getVoucherValue().toString()),voucher.getVoucherNumber().toString(), voucher.getCurrencySymbol().toString());
            voucher.setVoucherStatus(VoucherStatusType.CLAIMED);
            voucher.setClaimType(ClaimType.CUSTOMER_CLAIM);
            voucher.setClaimer(account.getCreatedBy().toString());
            voucher.setDatedClaimed(new Date());
            voucherDAO.merge(voucher);
            
        } else {
            throw new InvalidVoucherException();
        }
        return voucher;
    }*/
    
    @Override
    public Voucher processVoucher(String codeGen, Account account) throws InvalidVoucherException {
     
        Voucher voucher = voucherDAO.getByPropertyName("voucherNumber", codeGen);
        if (VoucherStatusType.SOLD != voucher.getVoucherStatus()) {
            accountService.creditAccount(account,new BigDecimal(voucher.getVoucherValue().toString()),voucher.getVoucherNumber().toString(), voucher.getCurrencySymbol().toString());
            voucher.setVoucherStatus(VoucherStatusType.CLAIMED);
            voucher.setClaimType(ClaimType.CUSTOMER_CLAIM);
            voucher.setClaimer(account.getCreatedBy().toString());
            voucher.setDatedClaimed(new Date());
            voucherDAO.merge(voucher);
            
        } else {
            throw new InvalidVoucherException();
        }
        return voucher;
    }

    @Override
    public List<Voucher> getExpiredVouchers() {
        return voucherDAO.getEntitiesByProperName("voucherStatus", VoucherStatusType.RETIRED.toString());
    }

    @Override
    public void createVouchers(BigDecimal amount, CurrencyType currency, int number) {
        VoucherFactory f = new VoucherFactory();
        f.createVouchers(amount, currency, number);
        
    }

    @Override
    public Voucher findVoucher(Long id) {
        Voucher v = voucherDAO.find(id);
        return v;
    }

    @Override
    public List<Voucher> voucherStatus(VoucherStatusType descr) {
        
        return voucherDAO.getEntitiesByProperName("voucherStatus",descr);
    }
}
