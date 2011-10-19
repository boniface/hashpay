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
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
/**
 *
 * @author Peter Phillip
 */
@Entity
public class Product implements Serializable {
    
    public Product(){
        
    }
    
    public Product(Builder build){
        
    }
    private static long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ProductSerialNumber;
    
    private String Description; 
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createDate;
    
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
    
    
    }
}
