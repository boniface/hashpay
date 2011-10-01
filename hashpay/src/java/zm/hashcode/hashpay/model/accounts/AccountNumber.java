/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.accounts;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author boniface
 */

@Entity
public class AccountNumber implements Serializable {
   
    private static final long serialVersionUID = 1L;
    //This is not working well
    @Id
    @GeneratedValue(generator = "SeqName")
    @org.hibernate.annotations.GenericGenerator(name = "SeqName", strategy = "sequence", parameters = {
        @Parameter(name = "sequence", value = "productprice_productpriceid_seq")})
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountNumber)) {
            return false;
        }
        AccountNumber other = (AccountNumber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hashpay.domain.AccountNumber[id=" + id + "]";
    }


}
