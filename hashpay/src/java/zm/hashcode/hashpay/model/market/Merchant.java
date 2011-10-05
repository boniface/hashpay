/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.market;

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
 * @author Thozamile Sikwata 
 */
@Entity
public class Merchant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String emailAddress;
    private String password;
    @OneToMany(orphanRemoval = true, cascade = {javax.persistence.CascadeType.ALL})
    @JoinColumn(name = "product_id")
    private List<Product>  product = new ArrayList<Product>();
   
    
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
        if (!(object instanceof Merchant)) {
            return false;
        }
        Merchant other = (Merchant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.hashcode.hashpay.model.market.Merchant[ id=" + id + " ]";
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the product
     */
    public List<Product> getProduct() {
        return product;
    }
   
    
public static class Builder {
           
    
       public Builder(){

           
       }
    
       private String userName;
       private String emailAddress;
       private String password;
       
       public Builder UserName(String userNme){
           this.userName=userNme;
           return this;
       }
       
       public Builder emailAddress(String email){
           this.emailAddress=email;
           return this;
       }
       
       public Builder passWord(String passwrd){
             this.password= passwrd;
             return this;
       }
    
     public Merchant build() {
     
       return  new Merchant();
     }

 }
}
