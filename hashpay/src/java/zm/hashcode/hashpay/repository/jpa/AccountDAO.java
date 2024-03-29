/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.repository.jpa;

import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountNumber;
import zm.hashcode.hashpay.repository.DAO;

/**
 *
 * @author shane.broek
 */
public interface AccountDAO extends DAO<Account, Long>{

    public Account getByPropertyName(String string, AccountNumber a);
    
}
