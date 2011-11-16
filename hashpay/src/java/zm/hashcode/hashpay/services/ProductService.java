/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;
import java.math.BigDecimal;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import java.util.List;


/**
 *
 * @author Thozamile
 */
public interface ProductService {
    

     public Product createProduct(String ProductSerialNumber, String Description, BigDecimal unitPrice, EnumProductStatus productStatus, EnumTokenType eTokenType,CurrencyType currencySymbol);
     public Product buyProduct(Account accNumber, Product voucher)throws InsufficientBalanceException ;
     public Product validatedProduct(String hash, String code, Account account) throws InvalidVoucherException;
     public void createProducts(String ProductSerialNumber, String Description, BigDecimal unitPrice, EnumProductStatus productStatus, EnumTokenType eTokenType,CurrencyType currencySymbol,int number); 
     public Product findProduct(String productNumber); 
     public List<Product> allproductbyDescr(String descr);
 
     
}
