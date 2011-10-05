/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;



import zm.hashcode.hashpay.model.accounts.Account;


/**
 *
 * @author shane.broek
 */
public interface AccountService{
    public void createAccount(String status, String currency, String user);
    public void setAccountStatus(String status, String user);
}
