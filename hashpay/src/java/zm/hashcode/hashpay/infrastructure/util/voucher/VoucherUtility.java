/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.util.voucher;

import com.kabaso.codegenerator.service.CodeService;
import com.kabaso.codegenerator.service.Impl.CodeServiceImpl;
import zm.hashcode.hashpay.infrastructure.util.voucher.cor.ClaimedVoucherHandler;
import zm.hashcode.hashpay.infrastructure.util.voucher.cor.InventoryVoucherHandler;
import zm.hashcode.hashpay.infrastructure.util.voucher.cor.RetiredVoucherHandler;
import zm.hashcode.hashpay.infrastructure.util.voucher.cor.SoldVoucherHandler;
import zm.hashcode.hashpay.infrastructure.util.voucher.cor.VoucherHandler;
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusType;

/**
 *
 * @author boniface
 */
public class VoucherUtility {

    public CodeService getService() {
        return new CodeServiceImpl();
    }

    public VoucherStatusType getVoucherStatus(Voucher voucher) {

        if (voucher!= null) {
            VoucherHandler chain = setUpChain();
            chain.handleRequest(voucher.getVoucherStatus());
            return chain.getStatus();
        } else {
            return VoucherStatusType.INVALID;
        }
    }

    public static VoucherHandler setUpChain() {
        VoucherHandler sold = new SoldVoucherHandler();
        VoucherHandler claimed = new ClaimedVoucherHandler();
        VoucherHandler retired = new RetiredVoucherHandler();
        VoucherHandler inventory = new InventoryVoucherHandler();

        sold.setSuccessor(claimed);
        claimed.setSuccessor(retired);
        retired.setSuccessor(inventory);
        return sold;
    }
}
