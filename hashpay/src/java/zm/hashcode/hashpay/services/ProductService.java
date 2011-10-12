/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;
import java.math.BigDecimal;
import zm.hashcode.hashpay.model.market.Product;

/**
 *
 * @author Thozamile Sikwata
 */
public interface ProductService {
    
     public void createProduct(String Descrtn, BigDecimal pValue,String qyt,String token);
     public Product validated_product(String Description,String productType);
      
}
