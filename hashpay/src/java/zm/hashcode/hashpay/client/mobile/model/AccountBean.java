/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Temporal;
import zm.hashcode.hashpay.model.accounts.AccountNumber;

/**
 *
 * @author Thozamile Sikwata
 */
public class AccountBean {
    
    private Long id;
    private AccountNumber accountNumber;
    private String accountStatus;
    private String createdBy;
    private String currencyType;
    private BigDecimal balance;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;

    /**
     * @return the accountNumber
     */
    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the accountStatus
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * @param accountStatus the accountStatus to set
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the currencyType
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * @param currencyType the currencyType to set
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
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
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
