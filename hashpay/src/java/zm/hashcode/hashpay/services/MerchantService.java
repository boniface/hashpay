/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;

import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.model.market.Product;
//import zm.hashcode.hashpay.model.market.Merchant;

/**
 *
 * @author Thozamile Sikwata
 */
public interface MerchantService {
    

    public void requestToRegister(String emailAddres,String password,String confirmPassword);  
   // public void addProduct(String productDescrption,String productType,BigDecimal productPrice,String qty,String code);
   // public List<ProductOld> listallProductsPublished();
    public Product removeProduct(String ProductDescritpion);
      
}
