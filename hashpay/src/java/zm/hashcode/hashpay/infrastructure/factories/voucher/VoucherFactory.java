/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.voucher;

import java.math.BigDecimal;
import java.util.Date;
import zm.hashcode.hashpay.model.vouchers.ClaimTypeEnum;
import zm.hashcode.hashpay.model.vouchers.CurrencyTypeEnum;
import zm.hashcode.hashpay.model.vouchers.Voucher;
import zm.hashcode.hashpay.model.vouchers.VoucherStatusTypeEnum;

/**
 *
 * @author Bongani
 */
public class VoucherFactory {
    public static class Builder{
        private Date dateGenerated;
        private Date dateClaimed;
        private String claimer;
        private ClaimTypeEnum claimStatus;
        private CurrencyTypeEnum currencyType;
        private VoucherStatusTypeEnum voucherStatus;
        private String serviceType;
        
        private String voucherNumber;
        private BigDecimal voucherValue;
        
        
        public Builder(String voucherNumber, BigDecimal voucherValue){
            this.voucherNumber = voucherNumber;
            this.voucherValue = voucherValue;
        }
        
        public Builder dateGenerated(Date dateGenerated){
           this.dateGenerated = dateGenerated;
           return this;
        }
        public Builder dateClaimed(Date dateClaimed){
            this.dateClaimed = dateClaimed;
            return this;
        }
        public Builder claimer(String claimer){
            this.claimer = claimer;
            return this;
        }
        public Builder voucherStatusType(VoucherStatusTypeEnum voucherStatus){
            this.voucherStatus = voucherStatus;
            return this;
        }
        public Builder curencyType(CurrencyTypeEnum currencyType){
            this.currencyType = currencyType;
            return this;
        }
        public Builder claimStatus(ClaimTypeEnum claimStatus){
            this.claimStatus = claimStatus;
            return this;
        }
        
        public Builder serviceType(String serviceType)
        {
            this.serviceType = serviceType;
            return this;
        }
        
        public Voucher Build(){
            return getVoucher(this);
        }
        
        private Voucher getVoucher(Builder builder){
            
            Voucher voucher = new Voucher();
            
            voucher.setVoucherNumber(builder.voucherNumber);
            voucher.setVoucherValue(builder.voucherValue);
            voucher.setClaimer(builder.claimer);
            voucher.setDatedClaimed(builder.dateClaimed);
            voucher.setDateGenerated(builder.dateGenerated);
            voucher.setServiceType(builder.serviceType);
            voucher.setClaimType(builder.claimStatus);
            voucher.setVoucherStatus(builder.voucherStatus);
            voucher.setCurrencyType(builder.currencyType);
            
            
            return voucher; 
        }
        
        
    } 
    
}
