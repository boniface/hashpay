/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.accounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
    private String accountNumber;
    private String accountType;
    private String status;
    @OneToMany(orphanRemoval = true, cascade = {javax.persistence.CascadeType.ALL})
    @JoinColumn(name = "account_id")
    private List<AccountEntry> entries = new ArrayList<AccountEntry>();

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

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

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
     public static class Builder {

        private String accountNumber;
        private String status;
        private String accountType;

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }

    public Account() {
    }

    public Account(Builder builder) {
        Account account = new Account();
        account.status = builder.status;
        account.accountType = builder.accountType;
        account.accountNumber = builder.accountNumber;
    }
    
}
