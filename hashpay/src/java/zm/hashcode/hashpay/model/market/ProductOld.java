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
 * @author Thozamile Sikwata
 */
@Entity
public class ProductOld implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productDescription;
    private BigDecimal productPrice ;
    private String productType;
    private String qauntity;
    private String code;

    
    

    
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
        if (!(object instanceof ProductOld)) {
            return false;
        }
        ProductOld other = (ProductOld) object;
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
    

    /**
     * @return the qauntity
     */
    public String getQauntity() {
        return qauntity;
    }

    /**
     * @return the token
     */
    

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * @param productValue the productValue to set
     */
    

    /**
     * @param qauntity the qauntity to set
     */
    public void setQauntity(String qauntity) {
        this.qauntity = qauntity;
    }

    /**
     * @return the productPrice
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice the productPrice to set
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @param productStatus the productStatus to set
     */
    
    
     public static class Builder {
                
        
       public Builder(){
             
       }
             
      //product details
      private String productDescription;
      private BigDecimal productPrice;
      private String productType;
      //BalanceOnHand
      private String qauntity;
      
      //token
      private String code;  
      
      
      public Builder (String productDescrptions,String productType,BigDecimal productPrice){
             this.productDescription=productDescrptions;
             this.productPrice=productPrice;
             this.productType=productType;
             
        }       
       
    public Builder BalanceOnHand(String qauntity){
           this.qauntity=qauntity;
           return this;
       }
      
     public Builder code(String code){
          this.code= code;
          return this;       
       }   
    
    public ProductOld build() {
       return  new ProductOld(this);
    }
   }
    
      public ProductOld() {
      }
      public ProductOld(Builder builder) {
        this.productDescription=builder.productDescription;
        this.productPrice=builder.productPrice;
        this.productType=builder.productType;
        this.code=builder.code;
        this.qauntity=builder.qauntity;
        
    }

   
   
  
}
