/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;

import java.math.BigDecimal;
import java.util.List;
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.model.market.Merchant;
import zm.hashcode.hashpay.model.market.Product;

/**
 *
 * @author Thozamile Sikwata
 */
public interface MerchantService {
    

    public void requestToRegister(String userName,String emailAddres,AccountNumber accountNumber,String password);  
    public void addProduct(String productDescrption,String productType,BigDecimal productPrice,String qty,String code);
    public List<Product> listallProductsPublished();
    public Product removeProduct(String ProductDescritpion);
       
}
