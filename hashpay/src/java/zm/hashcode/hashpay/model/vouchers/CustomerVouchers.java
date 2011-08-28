/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.vouchers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author boniface
 */
@Entity
public class CustomerVouchers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String voucherNumber;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateLoaded;
    private BigInteger units;
    private String currency;
    private BigDecimal voucherValue;
    private String currencySymbol;

    public static class Builder {

        private String voucherNumber;
        private BigInteger units;
        private Date dateLoaded;
        private String currency;
        private BigDecimal voucherValue;
        private String currencySymbol;

        public Builder(String voucherNumber) {
            this.voucherNumber = voucherNumber;
        }

        public Builder units(BigInteger units) {
            this.units = units;
            return this;
        }

        public Builder dateLoaded(Date dateLoaded) {
            this.dateLoaded = dateLoaded;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder voucherValue(BigDecimal voucherValue) {
            this.voucherValue = voucherValue;
            return this;
        }

        public Builder currencySymbol(String currencySymbol) {
            this.currencySymbol = currencySymbol;
            return this;
        }

        public CustomerVouchers build(){
            return new CustomerVouchers(this);
        }

    }

    public CustomerVouchers() {
    }

    public CustomerVouchers(Builder builder) {
        this.currency = builder.currency;
        this.currencySymbol = builder.currencySymbol;
        this.dateLoaded = builder.dateLoaded;
        this.units = builder.units;
        this.voucherNumber = builder.voucherNumber;
        this.voucherValue = builder.voucherValue;
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
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerVouchers)) {
            return false;
        }
        CustomerVouchers other = (CustomerVouchers) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashpay.domain.CustomerVouchers[id=" + getId() + "]";
    }

    /**
     * @return the voucherNumber
     */
    public String getVoucherNumber() {
        return voucherNumber;
    }

    /**
     * @param voucherNumber the voucherNumber to set
     */
    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    /**
     * @return the dateLoaded
     */
    public Date getDateLoaded() {
        return dateLoaded;
    }

    /**
     * @param dateLoaded the dateLoaded to set
     */
    public void setDateLoaded(Date dateLoaded) {
        this.dateLoaded = dateLoaded;
    }

    /**
     * @return the units
     */
    public BigInteger getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(BigInteger units) {
        this.units = units;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
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
     * @return the currencySymbol
     */
    public String getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * @param currencySymbol the currencySymbol to set
     */
    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }
}
