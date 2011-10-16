/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.market.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import zm.hashcode.hashpay.model.market.product.EnumProductStatus;

/**
 *
 * @author Peter Phillip
 */
@Entity
public class Product implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

 private String ProductSerial;
 private String Description; 
 @Temporal(javax.persistence.TemporalType.DATE)
 private Date createDate;
 private BigDecimal unitPrice;
 @Enumerated(EnumType.STRING)  
 private EnumProductStatus productStatus;
  @OneToOne(orphanRemoval = true, cascade = {javax.persistence.CascadeType.ALL})
  @JoinColumn(name = "token_id")
  private Token token;
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
