/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services;

import java.math.BigDecimal;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;

/**
 *
 * @author shane.broek
 */
public interface AccountEntriesService{
    public BigDecimal getBalance(AccountEntry accountEntry, Account account);
    public void CreateDebitAccountEntry(String account, BigDecimal debit, String description, String currency );
    public AccountEntry creditAccount(String accountNumber, BigDecimal val, String Decription, String currency);
}
