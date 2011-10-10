/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.accounts;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author 209052414
 */
@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private AccountNumber accountNumber;
    private String accountStatus;
    private String createdBy;
    private String currencyType;
    private BigDecimal balance;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    @OneToMany(orphanRemoval = true, cascade = {javax.persistence.CascadeType.ALL})
    @JoinColumn(name = "accountNumber")
    private List<AccountEntry> entries = new ArrayList<AccountEntry>();
    
    /**
     * @return the entries
     */
    public List<AccountEntry> getEntries() {
        return entries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(List<AccountEntry> entries) {
        this.entries = entries;
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
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }
    
     public static class Builder {

        private Date creationDate;
        private BigDecimal balance;
        private AccountNumber accountNumber;
        private String accountStatus;
        private String createdBy;
        private String currencyType;

        public Builder(String currency, BigDecimal balance) {
            this.currencyType = currency;
            this.balance = balance;
        }
        
        public Builder accountNumber(AccountNumber accountNumber)
        {
            this.accountNumber = accountNumber;
            return this;
        }
        public Builder creationDate(Date date) {
            this.creationDate = date;
            return this;
        }

        public Builder createdBy(String user) {
            this.createdBy = user;
            return this;
        }

        public Builder accountStatus(String status) {
            this.accountStatus = status;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }

    public Account() {
    }

    public Account(Builder builder) {
        this.accountNumber = new AccountNumber();
        this.accountStatus = builder.accountStatus;
        this.createdBy = builder.createdBy;
        this.creationDate = builder.creationDate;
        this.currencyType = builder.currencyType;
        this.balance = builder.balance;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.hashcode.hashpay.model.accounts.Account[ id=" + id + " ]";
    }

}
