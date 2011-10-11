/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.accounts;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author 209052414
 */
@Entity
public class AccountEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal debit;
    private BigDecimal credit;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date entryDate;
    private BigDecimal balance;
    private String description;
    private String currencySymbol;
    @Column(name="accountNumber")
    private Long accountID;
    
    /**
     * @return the accountID
     */
    public Long getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }
    
    public static class Builder {

        private BigDecimal Balance;
        private BigDecimal debit;
        private BigDecimal credit;
        private Date entryDate;
        private String Description;
        private String currencySymbol;
        private AccountNumber accountID;

        public Builder(BigDecimal balance, Date entryDate, AccountNumber accountID) {
            this.Balance=balance;
            this.entryDate = entryDate;
            this.accountID = accountID;
        }
        
        public Builder currencySymbol(String currencySymbol) {
            this.currencySymbol = currencySymbol;
            return this;
        }

        public Builder entryDate(Date entryDate) {
            this.entryDate = entryDate;
            return this;
        }

        public Builder entryDescription(String Description) {
            this.Description = Description;
            return this;
        }

        public Builder debitEntry(BigDecimal debit) {
            this.debit = debit;
            return this;
        }

        public Builder currentBalance(BigDecimal balance) {
            this.Balance = balance;
            return this;
        }

        public Builder creditEntry(BigDecimal credit) {
            this.credit = credit;
            return this;
        }

        public AccountEntry build() {
            return new AccountEntry(this);
        }
    }

    public AccountEntry() {
    }

    public AccountEntry(Builder builder) {

        if (builder.credit != null) {
            this.credit = builder.credit;
        } else {
            this.credit = new BigDecimal(BigInteger.ZERO);
        }
        
        if (builder.Balance != null) {
            this.balance = builder.Balance;
        } else {
            this.balance = new BigDecimal(BigInteger.ZERO);
        }
        this.currencySymbol = builder.currencySymbol;
        if (builder.debit != null) {
            this.debit = builder.debit;
        } else {
            this.debit = new BigDecimal(BigInteger.ZERO);
        }
        this.accountID = builder.accountID.getId();
        this.entryDate = builder.entryDate;
        this.description = builder.Description;
    }
    
     /**
     * @return the entryDate
     */
    public Date getEntryDate() {
        return entryDate;
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
        if (!(object instanceof AccountEntry)) {
            return false;
        }
        AccountEntry other = (AccountEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.hashcode.hashpay.model.accounts.AccountEntry[ id=" + id + " ]";
    }

    /**
     * @return the debit
     */
    public BigDecimal getDebit() {
        return debit;
    }

    /**
     * @param debit the debit to set
     */
    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    /**
     * @return the credit
     */
    public BigDecimal getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    /**
     * @return the balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
