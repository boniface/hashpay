/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.vouchers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Bongani
 */
@Entity
public class Voucher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String voucherNumber;
    private BigDecimal voucherValue;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datedClaimed;
    private String claimer;
    @Enumerated(EnumType.STRING)
    private ClaimTypeEnum claimType;
    @Enumerated(EnumType.STRING)
    private VoucherStatusTypeEnum voucherStatus;
    @Enumerated(EnumType.STRING)
    private CurrencyTypeEnum currencyType;
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voucher)) {
            return false;
        }
        Voucher other = (Voucher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.hashcode.hashpay.model.vouchers.Voucher[ id=" + id + " ]";
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    /**
     * @return the voucherValue
     */
    public BigDecimal getVoucherValue() {
        return voucherValue;
    }

    /**
     * @param voucherValue the voucherValue to set
     */
    public void setVoucherValue(BigDecimal voucherValue) {
        this.voucherValue = voucherValue;
    }

    /**
     * @return the datedClaimed
     */
    public Date getDatedClaimed() {
        return datedClaimed;
    }

    /**
     * @param datedClaimed the datedClaimed to set
     */
    public void setDatedClaimed(Date datedClaimed) {
        this.datedClaimed = datedClaimed;
    }

    /**
     * @return the claimer
     */
    public String getClaimer() {
        return claimer;
    }

    /**
     * @param claimer the claimer to set
     */
    public void setClaimer(String claimer) {
        this.claimer = claimer;
    }

    /**
     * @return the claimType
     */
    public ClaimTypeEnum getClaimType() {
        return claimType;
    }

    /**
     * @param claimType the claimType to set
     */
    public void setClaimType(ClaimTypeEnum claimType) {
        this.claimType = claimType;
    }

    /**
     * @return the voucherStatus
     */
    public VoucherStatusTypeEnum getVoucherStatus() {
        return voucherStatus;
    }

    /**
     * @param voucherStatus the voucherStatus to set
     */
    public void setVoucherStatus(VoucherStatusTypeEnum voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    /**
     * @return the currencyType
     */
    public CurrencyTypeEnum getCurrencyType() {
        return currencyType;
    }
    
}
