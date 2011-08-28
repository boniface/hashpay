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
public class ClaimedVoucherHandler extends VoucherHandler {
    @Override
    public void  handleRequest(VoucherStatusType request) {
        if (request == VoucherStatusType.CLAIMED) {
            setStatus(VoucherStatusType.CLAIMED);
        } else {
            if (successor != null) {
                 setStatus(request);
                successor.handleRequest(request);
            }
          
        }
    }
}


