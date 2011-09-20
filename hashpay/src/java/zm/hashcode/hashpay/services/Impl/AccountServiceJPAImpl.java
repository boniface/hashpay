/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.hashpay.infrastructure.factories.account.AccountFactory;
import zm.hashcode.hashpay.services.AccountService;

/**
 *
 * @author shane.broek
 */
@Repository("accountService")
@Transactional
public class AccountServiceJPAImpl implements AccountService{

    @Override
    public void createAccount(String status, String accType) {
        AccountFactory f = new AccountFactory();
        f.createAccount(status, accType);
    }
   
}
