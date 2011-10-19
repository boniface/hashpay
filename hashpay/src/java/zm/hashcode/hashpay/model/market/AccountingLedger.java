/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.market;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import zm.hashcode.hashpay.model.people.Users;

/**
 *
 * @author Thozamile Sikwata
 */
@Entity
public class AccountingLedger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date soldDate;
    private String Description;
    private BigDecimal amountSold; 
    private String Username;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
   

    public AccountingLedger() {
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
        if (!(object instanceof AccountingLedger)) {
            return false;
        }
        AccountingLedger other = (AccountingLedger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.hashcode.hashpay.model.market.Product.Ledger[ id=" + id + " ]";
    }

    /**
     * @return the soldDate
     */
    public Date getSoldDate() {
        return soldDate;
    }

    /**
     * @param soldDate the soldDate to set
     */
    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the amountSold
     */
    public BigDecimal getAmountSold() {
        return amountSold;
    }

    /**
     * @param amountSold the amountSold to set
     */
    public void setAmountSold(BigDecimal amountSold) {
        this.amountSold = amountSold;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the user
     */
   // public Users getUser() {
     //   return user;
    //}

    /**
     * @param user the user to set
     */
    //public void setUser(Users user) {
      //  this.user = user;
    //}
    
     public static class Builder {
        private Date soldDate;
        private String Description;
        private BigDecimal amountSold; 
        private String Username;
        
        public Builder(String description,BigDecimal amountSold){
            this.Description=description;
            this.amountSold=amountSold; 
        }
        
        public Builder cretationDate(Date soldDate){
            this.soldDate=soldDate;
                    return this;
        }
        
       public Builder userSellingProduct(String user){
           this.Username=user;
           return this;
       }
        
     
       public AccountingLedger build() {
     
       return  new AccountingLedger(this);
      }
        
     }
     
    public AccountingLedger(Builder builder) {
        this.Description=builder.Description;
        this.amountSold=builder.amountSold;
        this.soldDate= builder.soldDate;
        this.Username= builder.Username;
        
   }
}
