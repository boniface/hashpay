/*Developer: Peter Phillip - Cubetec 
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.country;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Peter Phillip
 */
@Entity
public class District implements Serializable {
    @Id
    private Long id;
        private String name;
    private String code;
    @ManyToOne
    private Suburb suburb;
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the code
     */
  
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the suburb
     */
    public Suburb getSuburb() {
        return suburb;
    }

    /**
     * @param suburb the suburb to set
     */
    public void setSuburb(Suburb suburb) {
        this.suburb = suburb;
    }
}
