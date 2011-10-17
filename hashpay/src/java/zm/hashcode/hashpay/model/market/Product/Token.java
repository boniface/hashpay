/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.market.Product;
import javax.persistence.OneToOne;
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
   
    
    private static long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Enumerated(EnumType.STRING)  
    private EnumTokenType eTokenType;
    @OneToOne
    private DynamicToken dynamicToken;
    @OneToOne
    private StaticToken staticToken;
   
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
//    public String getToken(Long id,EnumTokenType tokenType){
//        
//       if(tokenType != null && tokenType == eTokenType.DYNAMIC){
//       
//            this.dynamicToken = new DynamicToken();
//            this.dynamicToken.setId(id);
//           
//            return this.dynamicToken;
//            
//        }
//        else if (tokenType != null && tokenType == eTokenType.STATIC)
//        {
//            returnStaticToken();
//        }
//      
//       return "Token requested is invalid";
//    }
//    
//   public DynamicToken returnDynamicToken(){
//      return this.dynamicToken;
//   }
//  
//   public StaticToken returnStaticToken(){
//       return this.staticToken;
//   }

    public EnumTokenType geteTokenType() {
        return eTokenType;
    }

    public void seteTokenType(EnumTokenType eTokenType) {
        this.eTokenType = eTokenType;
    }

    public DynamicToken getDynamicToken() {
        return dynamicToken;
    }

    public void setDynamicToken(DynamicToken dynamicToken) {
        this.dynamicToken = dynamicToken;
    }

    public StaticToken getStaticToken() {
        return staticToken;
    }

    public void setStaticToken(StaticToken staticToken) {
        this.staticToken = staticToken;
    }
    
}
