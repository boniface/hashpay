/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.repository.jpa;

import java.util.List;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;
import zm.hashcode.hashpay.repository.DAO;

/**
 *
 * @author shane.broek
 */
public interface AccountEntryDAO extends DAO<AccountEntry, Long>{

    public List<AccountEntry> getEntitiesByProperName(String string, Long aLong);
    
}
