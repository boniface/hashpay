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
    private String productStatus;
    private String token;

    public Product() {
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
     * @return the productStatus
     */
    public String getProductStatus() {
        return productStatus;
    }

    /**
     * @param productStatus the productStatus to set
     */
    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
    
     public static class Builder {
                
        
       public Builder(){
             
       }
             
      //product details
      private String productDescription;
      private BigDecimal productValue;
      private String  productStatus;
      //BalanceOnHand
      private String qauntity;
      
      //token
      private String token;  
      
      
      public Builder ProductDescription(String productDescrptions){
             this.productDescription=productDescrptions;
             return this;    
      }     
      
      public Builder ProductValue(BigDecimal productValue){
           this.productValue=productValue;
           return this; 
       }
      
       public Builder productStatus(String productStatuss){
           this.productStatus= productStatuss;
           return this;
       }
        
      public Builder BalanceOnHand(String qauntity){
           this.qauntity=qauntity;
           return this;
       }
      
     public Builder token(String token){
          this.token= token;
          return this;       
     }   
     
     
     
  
   public Product build() {
       return  new Product();
    }
   }
     
      public Product getProduct(Builder builder){
      Product product = new Product();
      product.setProductDescription(builder.productDescription);
      product.setProductValue(builder.productValue);
      product.setQauntity(builder.qauntity);
      product.setProductStatus(builder.productStatus);
      product.setToken(builder.token);
      return product;
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
   
  
}
