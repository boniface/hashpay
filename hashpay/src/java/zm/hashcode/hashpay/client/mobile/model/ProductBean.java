/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile.model;

import java.math.BigDecimal;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;

/**
 *
 * @author Franky
 */
public class ProductBean {
    private String id;
    private String ProductSerialNumber;
    private String Description;
    private BigDecimal unitPrice;
    private EnumProductStatus productStatus;
    private EnumTokenType eTokenType;
    private CurrencyType currencySymbol;
    private String tokenNumber;
    private int number;

    /**
     * @return the ProductSerialNumber
     */
    public String getProductSerialNumber() {
        return ProductSerialNumber;
    }

    /**
     * @param ProductSerialNumber the ProductSerialNumber to set
     */
    public void setProductSerialNumber(String ProductSerialNumber) {
        this.ProductSerialNumber = ProductSerialNumber;
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
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the productStatus
     */
    public EnumProductStatus getProductStatus() {
        return productStatus;
    }

    /**
     * @param productStatus the productStatus to set
     */
    public void setProductStatus(EnumProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * @return the eTokenType
     */
    public EnumTokenType geteTokenType() {
        return eTokenType;
    }

    /**
     * @param eTokenType the eTokenType to set
     */
    public void seteTokenType(EnumTokenType eTokenType) {
        this.eTokenType = eTokenType;
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

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }
    
}
