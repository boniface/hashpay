/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.market;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 209042869
 */
@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productDescription;
    private BigDecimal productValue;
    private String qauntity;
    private String token;

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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.hashcode.hashpay.model.market.Product[ id=" + id + " ]";
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

   
    /**
     * @return the productValue
     */
    public BigDecimal getProductValue() {
        return productValue;
    }

    /**
     * @return the qauntity
     */
    public String getQauntity() {
        return qauntity;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * @param productValue the productValue to set
     */
    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }

    /**
     * @param qauntity the qauntity to set
     */
    public void setQauntity(String qauntity) {
        this.qauntity = qauntity;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the value
     */
  
}
