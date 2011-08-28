/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.vouchers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateGenerated;
    @Column(unique = true)
    private String voucherNumber;
    @Enumerated(EnumType.STRING)
    private VoucherStatusType voucherStatus;
    private BigDecimal voucherValue;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datedClaimed;
    @Enumerated(EnumType.STRING)
    private ClaimType claimType;
    private String claimer;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencySymbol;
    @OneToOne(orphanRemoval = true, cascade = {javax.persistence.CascadeType.ALL})
    @JoinColumn(name = "voucher_id")
    private VoucherSerial serialNumber;

    /**
     * @return the dateGenerated
     */
    public Date getDateGenerated() {
        return dateGenerated;
    }

    /**
     * @return the voucherNumber
     */
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
     * @return the claimType
     */
    public ClaimType getClaimType() {
        return claimType;
    }

    /**
     * @param claimType the claimType to set
     */
    public void setClaimType(ClaimType claimType) {
        this.claimType = claimType;
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
     * @return the currencySymbol
     */
    public CurrencyType getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * @return the voucherStatus
     */
    public VoucherStatusType getVoucherStatus() {
        return voucherStatus;
    }

    /**
     * @param voucherStatus the voucherStatus to set
     */
    public void setVoucherStatus(VoucherStatusType voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    /**
     * @return the serialNumber
     */
    public VoucherSerial getSerialNumber() {
        return serialNumber;
    }

    public static class Builder {

        private Date dateGenerated;
        private String voucherNumber;
        private VoucherStatusType voucherStatus;
        private BigDecimal voucherValue;
        private Date datedClaimed;
        private ClaimType claimType;
        private String claimer;
        private CurrencyType currencySymbol;
        private VoucherSerial serial;

        public Builder(String voucherNumber, BigDecimal voucherValue) {
            this.voucherNumber = voucherNumber;
            this.voucherValue = voucherValue;

        }

        public Builder dateGenerated(Date dateGenerated) {
            this.dateGenerated = dateGenerated;
            return this;
        }

        public Builder datedClaimed(Date datedClaimed) {
            this.setDatedClaimed(datedClaimed);
            return this;
        }

        public Builder claimType(ClaimType claimType) {
            this.setClaimType(claimType);
            return this;
        }

        public Builder claimer(String claimer) {
            this.setClaimer(claimer);
            return this;
        }

        public Builder currencySymbol(CurrencyType currencySymbol) {
            this.currencySymbol = currencySymbol;
            return this;
        }

        public Voucher build() {
            return new Voucher(this);
        }

        /**
         * @return the dateGenerated
         */
        public Date getDateGenerated() {
            return dateGenerated;
        }

        /**
         * @return the voucherNumber
         */
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
         * @return the claimType
         */
        public ClaimType getClaimType() {
            return claimType;
        }

        /**
         * @param claimType the claimType to set
         */
        public void setClaimType(ClaimType claimType) {
            this.claimType = claimType;
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
         * @return the currencySymbol
         */
        public CurrencyType getCurrencySymbol() {
            return currencySymbol;
        }
    }

    public Voucher() {
    }

    public Voucher(Builder builder) {
        this.claimType = builder.getClaimType();
        this.voucherStatus = VoucherStatusType.INVENTORY;
        this.claimer = builder.getClaimer();
        this.currencySymbol = builder.getCurrencySymbol();
        this.dateGenerated = builder.getDateGenerated();
        this.voucherNumber = builder.getVoucherNumber();
        this.voucherValue = builder.getVoucherValue();
        this.serialNumber = new VoucherSerial();
    }

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
        return "com.hashpay.domain.Voucher[id=" + id + "]";
    }
}
