/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.market;

import java.math.BigDecimal;
import zm.hashcode.hashpay.model.market.Product;

/**
 *
 * @author 209042869
 */
public class MarketFactory {
    
    
     public static class Builder {
                
      //product details
      private String productDescription;
      private BigDecimal productValue;
      
      //BalanceOnHand
      private String qauntity;
      
      //token
      private String token;  
      
      public Builder(String productDescrption,BigDecimal productValue){
             this.productDescription=productDescrption;
             this.productValue=productValue;
      }   
        
      public Builder BalanceOnHand(String qauntity){
           this.qauntity=qauntity;
           return this;
       }
      
     public Builder token(String token){
          this.token= token;
          return this;       
     }    
       
       public Product build() {
         return getProduct(this);
      }
       
      private Product getProduct(Builder builder){
     
      Product product = new Product();
      product.setProductDescription(builder.productDescription);
      product.setProductValue(builder.productValue);
      product.setQauntity(builder.qauntity);
      product.setToken(builder.token);
      return product;
      } 
        
   }
              
      
  }
    
    
  

