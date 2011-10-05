/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;

import java.math.BigDecimal;
import java.util.List;
import zm.hashcode.hashpay.model.market.Merchant;

/**
 *
 * @author Thozamile Sikwata
 */
public interface MerchantService {
    

    public void requestToRegister(String userName,String emailAddres);  
    public void addProduct(String productDescrption,BigDecimal productPrice,String qty,String token);
    public List<Merchant> listallProductsPublished();
    public Merchant validateProductInventory(String productDescription);
       
}
