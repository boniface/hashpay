/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.repository.jpa;

import java.util.List;
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusType;
import zm.hashcode.hashpay.repository.DAO;

/**
 *
 * @author Bongani
 */
public interface VoucherDAO extends DAO<Voucher,Long>{

    public List<Voucher> getEntitiesByProperName(String string, VoucherStatusType voucherStatusType);
    
}
