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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.JoinColumn; 
import javax.persistence.OneToOne; 
import javax.persistence.Temporal;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;


/**
 *
 * @author Thozamile
 */
@Entity
public class Product implements Serializable {
   
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
    private String tokenNumber;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencySymbol;
    private String claimer;
  
    
    public Product(){
        
    }
    
  
  
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

    /**
     * @return the tokenNumber
     */
    public String getTokenNumber() {
        return tokenNumber;
    }

    /**
     * @param tokenNumber the tokenNumber to set
     */
    public void setTokenNumber(String tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    /**
     * @return the currencySymbol
     */
    public CurrencyType getCurrencySymbol() {
        return currencySymbol;
    }

    /**
     * @param currencySymbol the currencySymbol to set
     */
    public void setCurrencySymbol(CurrencyType currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public void setClaimer(String claimer) {
        this.claimer=claimer;
    }

    /**
     * @return the claimer
     */
    public String getClaimer() {
        return claimer;
    }
    
    public static class Builder{
        
            private String ProductSerialNumber;
            private String Description; 
            private Date createDate;
            private BigDecimal unitPrice;
            private EnumProductStatus productStatus;
            private EnumTokenType eTokenType;
            private Date dateClaimed;
            private String tokenNumber;
            private CurrencyType currencySymbol;
          
        public Builder(String Description,BigDecimal unitPrice,String tokenNumber){
            this.Description=Description;
            this.unitPrice=unitPrice;
            this.tokenNumber=tokenNumber;
         } 
        
        public Builder productSerialNumber(String pSerial){
            this.ProductSerialNumber = pSerial; 
            return this;
        }
           
  
        public Builder createDate(Date cDate){
            this.createDate = cDate;
            return this; 
        }

 
        public Builder productStatus(EnumProductStatus proStatus){
            this.productStatus=proStatus;
            return this;
        } 
  
        public Builder eTokenType(EnumTokenType eType){
            this.eTokenType = eType;
            return this;
        }
        
          public Builder datedClaimed(Date datedClaimed) {
            this.dateClaimed=datedClaimed;
            return this;
        }
          
       public Builder tokenNumber(String tokenNumber){
           this.tokenNumber=tokenNumber;
           return this;
       }   
       
      public Builder currencySymbol(CurrencyType currencySymbol) {
            this.currencySymbol = currencySymbol;
            return this;
        }
          
          public Product build() {
     
          return  new Product(this);
     }
          
          
    }
    public Product(Builder builder){
            this.ProductSerialNumber = builder.ProductSerialNumber;
            this.Description = builder.Description; 
            this.createDate = builder.createDate;
            this.unitPrice = builder.unitPrice;
            this.productStatus = builder.productStatus;
            this.eTokenType = builder.eTokenType;
            this.tokenNumber=builder.tokenNumber;
            this.currencySymbol=builder.currencySymbol;
            this.token = new Token();
    }
}

