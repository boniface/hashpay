/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.account;

import java.math.BigDecimal;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.accounts.AccountEntry;

/**
 *
 * @author 209052414
 */
public class AccountFactory {
     public static class Builder
    {
        private String accountNumber;
        private String accountType;
        private String status;
        
        //Account Entry
        private BigDecimal debit;
        private BigDecimal credit;
        private BigDecimal balance;
        private String description;
        
        public Builder(String accountNumber, String accountType, String status)
        {
            this.accountNumber = accountNumber;
            this.accountType = accountType;
            this.status = status;
        }
        
         public Builder debit(BigDecimal debit)
         {
             this.debit = debit;
             return this;
         }
         
          public Builder credit(BigDecimal credit)
          {
              this.credit = credit;
              return this;
          }
           public Builder balance(BigDecimal balance)
           {
               this.balance = balance;
               return this;
           }
            public Builder description(String description)
            {
                this.description = description;
                return this;
            }
            
            public Account build()
            {
                return getAccount(this);
            }

        private Account getAccount(Builder builder) {
            Account account = new Account();
            account.setAccountNumber(builder.accountNumber);
            account.setAccountType(builder.accountType);
            account.setStatus(builder.status);
            
            
            AccountEntry accountEntry = new AccountEntry();
            accountEntry.setCredit(builder.credit);
            accountEntry.setDebit(builder.debit);
            accountEntry.setDescription(builder.description);
            accountEntry.setBalance(builder.balance);
            account.getEntries().add(accountEntry);
            
            return account;
        }
    }
}
