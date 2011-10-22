/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;
import java.math.BigDecimal;
import java.util.Date;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.market.Product;

/**
 *
 * @author Peter Phillip
 */
public interface ProductService {
    
     public void createProduct(String pserial, String desc, Date cdate, BigDecimal uPrice,EnumProductStatus proStatus, EnumTokenType tokType);
    
     public boolean claimProduct(String serialNumber, Date date);
     public Product sellProduct(String desc);
     public void removeProduct(String desc);   
     public Product findProduct(String serialNumber);
}
