/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.jpa.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.infrastructure.factories.voucher.VoucherFactory;
import zm.hashcode.hashpay.infrastructure.util.voucher.VoucherUtility;
import zm.hashcode.hashpay.model.vouchers.ClaimType;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusType;
import zm.hashcode.hashpay.repository.jpa.VoucherDAO;
import zm.hashcode.hashpay.services.jpa.VoucherService;

/**
 *
 * @author Bongani
 */
@Repository("voucherService")
@Transactional
public class VoucherServiceJPAImpl implements VoucherService{
    
        @Autowired
    private VoucherDAO voucherDAO;
    private VoucherUtility util;

    @Override
    public Voucher find(Long id) {
        return voucherDAO.find(id);
    }

    @Override
    public void persist(Voucher entity) {
        getVoucherDAO().persist(entity);
    }

    @Override
    public void merge(Voucher entity) {
        getVoucherDAO().merge(entity);
    }

    @Override
    public void remove(Voucher entity) {
        getVoucherDAO().remove(entity);
    }

    @Override
    public List<Voucher> findAll() {
        return getVoucherDAO().findAll();
    }

    @Override
    public List<Voucher> findInRange(int firstResult, int maxResults) {
        return getVoucherDAO().findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        return getVoucherDAO().count();
    }

    @Override
    public Voucher getByPropertyName(String name, String value) {
        return getVoucherDAO().getByPropertyName(name, value);
    }

    @Override
    public List<Voucher> getEntitiesByProperName(String name, String value) {
        return getVoucherDAO().getEntitiesByProperName(name, value);
    }
    
    
       public VoucherDAO getVoucherDAO() {
        return voucherDAO;
    }

    /**
     * @param voucherDAO the voucherDAO to set
     */
    public void getVoucherDAO(VoucherDAO voucherDAO) {
        this.voucherDAO = voucherDAO;
    }



    //THIS METHOD NEED TO BE SYNCHRONISED AND ATOMIC
    @Override
    public synchronized Voucher buyVoucher() {
        Voucher v = voucherDAO.getByPropertyName("voucherStatus", VoucherStatusType.INVENTORY.toString());
        v.setVoucherStatus(VoucherStatusType.SOLD);
        voucherDAO.persist(v);
        return v;
    }

    @Override
    public Voucher processVoucher(String hash, String code) throws InvalidVoucherException {
        String codeGen = new VoucherUtility().getService().getConstructedCode(hash, code);
        Voucher voucher = voucherDAO.getByPropertyName("voucherNumber", codeGen);
        VoucherStatusType voucherType = util.getVoucherStatus(voucher);
        if (VoucherStatusType.SOLD == voucherType) {
            voucher.setVoucherStatus(VoucherStatusType.CLAIMED);
            voucher.setClaimType(ClaimType.CUSTOMER_CLAIM);
            voucher.setClaimer("Username");
            voucher.setDatedClaimed(new Date());
            voucherDAO.persist(voucher);
            return voucher;
        } else {
            throw new InvalidVoucherException();
        }
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
    
}
