/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.jpa.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.model.vouchers.Voucher;
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
    
}
