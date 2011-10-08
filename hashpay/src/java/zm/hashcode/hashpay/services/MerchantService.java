/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;

import java.math.BigDecimal;
import java.util.List;
import zm.hashcode.hashpay.model.market.Merchant;
import zm.hashcode.hashpay.model.market.Product;

/**
 *
 * @author Thozamile Sikwata
 */
public interface MerchantService {
    

    public void requestToRegister(String userName,String emailAddres,String password);  
    public void addProduct(String productDescrption,BigDecimal productPrice,String qty,String token);
    public List<Product> listallProductsPublished();
   //method will be used to check balance on  hand of each product so that merchant will know when to add more products
     public Product validateProductInventory(String productDescription);
     public Product removeProduct(String ProductDescritpion);
       
}
