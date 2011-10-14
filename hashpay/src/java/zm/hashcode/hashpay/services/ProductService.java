/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;
import java.math.BigDecimal;
import zm.hashcode.hashpay.model.market.ProductOld;

/**
 *
 * @author Thozamile Sikwata
 */
public interface ProductService {
    
     public void createProduct(String Descrtn, BigDecimal pValue,String qyt,String token);
     public ProductOld validated_product(String Description,String productType);
      
}
