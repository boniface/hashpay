/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.util.voucher.cor;

import zm.hashcode.hashpay.model.vouchers.VoucherStatusType;

/**
 *
 * @author boniface
 */
public abstract class VoucherHandler {

    VoucherHandler successor;
    private VoucherStatusType status;

    public void setSuccessor(VoucherHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(VoucherStatusType request);

    /**
     * @param status the status to set
     */
    public void setStatus(VoucherStatusType status) {
        this.status = status;
    }

    /**
     * @return the status
     */
    public VoucherStatusType getStatus() {
        return status;
    }
}
