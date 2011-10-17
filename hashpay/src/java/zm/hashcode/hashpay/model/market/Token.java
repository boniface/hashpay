/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.market;
import javax.persistence.OneToOne;
import zm.hashcode.hashpay.model.market.EnumTokenType;
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
   
    public Token(){
        
    }
    public Token(Builder builder){
        this.eTokenType = builder.getClaimType();
        this.dynamicToken = new DynamicToken();
    }
    private static final long serialVersionUID = 1L;
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


    public EnumTokenType geteTokenType() {
        return eTokenType;
    }

    public void seteTokenType(EnumTokenType eTokenType) {
        this.eTokenType = eTokenType;
    }

    public DynamicToken getDynamicToken() {
        return dynamicToken;
    }

    public StaticToken getStaticToken() {
        return staticToken;
    }

    public static class Builder {
   
    private EnumTokenType eTokenType;
    private DynamicToken dynamicToken;
    private StaticToken staticToken;
    
    public Builder(EnumTokenType eType)
    {
            this.eTokenType = eType;
    }
    
    public Builder eTokenType(EnumTokenType etype) {
            this.setClaimType(etype);
            return this;
        }
    
      public void setClaimType(EnumTokenType eType) {
            this.eTokenType = eType;
        }   
    
      public EnumTokenType getClaimType() {
            return eTokenType;
        }
      
      public Token build(){
            return new Token(this);
        }
    }
    
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
