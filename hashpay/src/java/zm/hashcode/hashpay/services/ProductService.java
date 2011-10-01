/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;
import java.math.BigDecimal;

/**
 *
 * @author 209042869
 */
public interface ProductService {
    
     public void createProduct(String Descrtn, BigDecimal pValue,String qyt,String token);
     public String getProduct(String Description);
     
    
}
