/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.model.market.product.EnumTokenType;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Peter Phillip
 */
@Entity
public class Token implements Serializable {
   
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
   // @Enumerated(EnumType.STRING)  
   // private EnumTokenType eTokenType;
   
    private StaticToken staticToken;
    private String Token;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getToken(Long id,EnumTokenType tokenType){
        
     /*  if(tokenType != null){
        if(tokenType == eTokenType.DYNAMIC.toString())
        {
    //        this.dynamicToken = new DynamicToken();
     //       this.dynamicToken.setId(id);
     //       this.Token = this.dynamicToken.toString();
            return Token;
            
        }
        else if (tokenType == eTokenType.STATIC.toString())
        {
            this.Token = new StaticToken().getExternalToken();
            return Token;
        }
       }*/
       return "Token requested is invalid";
    }
  
    
}
