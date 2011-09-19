/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.accounts;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private BigDecimal balance;
    private String description;
    

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

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    public static class Builder {

        private BigDecimal currentBalance;
        private BigDecimal debitEntry;
        private BigDecimal creditEntry;
        private String Description;

        public Builder(BigDecimal balance) {
            this.currentBalance=balance;
        }


        public Builder entryDescription(String Description) {
            this.Description = Description;
            return this;
        }

        public Builder debitEntry(BigDecimal debit) {
            this.debitEntry = debit;
            return this;
        }

        public Builder currentBalance(BigDecimal balance) {
            this.currentBalance = balance;
            return this;
        }

        public Builder creditEntry(BigDecimal credit) {
            this.creditEntry = credit;
            return this;
        }

        public AccountEntry build() {
            return new AccountEntry(this);
        }
    }

    public AccountEntry() {
    }

    public AccountEntry (Builder builder) {

        if (builder.creditEntry != null) {
            this.credit = builder.creditEntry;
        } else {
            this.credit = new BigDecimal(BigInteger.ZERO);
        }
        if (builder.currentBalance != null) {
            this.balance = builder.currentBalance;
        } else {
            this.balance = new BigDecimal(BigInteger.ZERO);
        }
        if (builder.debitEntry != null) {
            this.debit = builder.debitEntry;
        } else {
            this.debit = new BigDecimal(BigInteger.ZERO);
        }
        this.description = builder.Description;

}
}
