/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.market;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue; import javax.persistence.GenerationType; import javax.persistence.Id; import javax.persistence.JoinColumn; import javax.persistence.OneToOne; import javax.persistence.Temporal; import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;

/**
 *
 * @author Peter Phillip
 */
@Entity
public class Product implements Serializable {
    
    public Product(){
        
    }
    
    public Product(Builder builder){
    this.ProductSerialNumber = builder.getProductSerialNumber();
    this.Description = builder.getDescription(); 
    this.createDate = builder.getCreateDate();
    this.unitPrice = builder.getUnitPrice();
    this.productStatus = builder.getProductStatus();
    this.eTokenType = builder.geteTokenType();
    this.token = new Token();
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ProductSerialNumber;
    private String Description; 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateClaimed;
    private BigDecimal unitPrice;
    @Enumerated(EnumType.STRING)  
    private EnumProductStatus productStatus;
    @Enumerated(EnumType.STRING) 
    private EnumTokenType eTokenType;
    @OneToOne(orphanRemoval = true, cascade = {javax.persistence.CascadeType.ALL})
    @JoinColumn(name = "token_id")
    private Token token;
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductSerialNumber() {
        return ProductSerialNumber;
    }

    public String getDescription() {
        return Description;
    }
    
    public Date getDatedClaimed() {
        return dateClaimed;
    }
    
    public void setDatedClaimed(Date datedClaimed) {
        this.dateClaimed = datedClaimed;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
        
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public EnumProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(EnumProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public EnumTokenType geteTokenType() {
        return eTokenType;
    }

    public void seteTokenType(EnumTokenType eTokenType) {
        this.eTokenType = eTokenType;
    }

    public Token getToken() {
        return token;
    }
    
   
    
    public static class Builder{
        
    private String ProductSerialNumber;
    private String Description; 
    private Date createDate;
    private BigDecimal unitPrice;
    private EnumProductStatus productStatus;
    private EnumTokenType eTokenType;
    private Date dateClaimed;
    
     public Builder(String pserial, String desc, Date cdate, BigDecimal uPrice,EnumProductStatus proStatus, EnumTokenType tokType)
     {
         this.ProductSerialNumber = pserial;
         this.Description = desc;
         this.createDate = cdate;
         this.unitPrice = uPrice; 
         this.productStatus = proStatus; 
         this.eTokenType = tokType;
         
     }

        public String getProductSerialNumber() {
            return ProductSerialNumber;
        }

        public void setProductSerialNumber(String ProductSerialNumber) {
            this.ProductSerialNumber = ProductSerialNumber;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public BigDecimal getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
        }

        public EnumProductStatus getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(EnumProductStatus productStatus) {
            this.productStatus = productStatus;
        }

        public EnumTokenType geteTokenType() {
            return eTokenType;
        }

        public void seteTokenType(EnumTokenType eTokenType) {
            this.eTokenType = eTokenType;
        }
        
        public Date getDatedClaimed() {
            return dateClaimed;
        }

        public void setDatedClaimed(Date datedClaimed) {
            this.dateClaimed = datedClaimed;
        }
      
        public Builder productSerialNumber(String pSerial){
            this.ProductSerialNumber = pSerial; 
            return this;
        }
        
   
        public Builder description(String desc){
            this.Description = desc;
         return this;
        }
        
  
        public Builder createDate(Date cDate){
            this.createDate = cDate;
            return this; 
        }
 
        public  Builder unitPrice(BigDecimal uPrice){
            this.unitPrice = uPrice;
            return this;
        }
 
        public Builder productStatus(EnumProductStatus proStatus){
            this.setProductStatus(proStatus);
            return this;
        } 
  
        public Builder eTokenType(EnumTokenType eType){
            this.eTokenType = eType;
            return this;
        }
        
          public Builder datedClaimed(Date datedClaimed) {
            this.setDatedClaimed(datedClaimed);
            return this;
        }
          
           public Product build() {
            return new Product(this);
        }
    }
}

