/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.people;

import java.util.List;

/**
 *
 * @author boniface
 */
public interface Person {
    public Name getName();
    public List<Address> getAddress();
    public List<Contacts> getContacts();
    public List<Roles> getRoles();
    
    
}
