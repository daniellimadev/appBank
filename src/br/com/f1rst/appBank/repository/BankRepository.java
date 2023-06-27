package br.com.f1rst.appBank.repository;

import br.com.f1rst.appBank.model.Account.Account;
import br.com.f1rst.appBank.model.Account.CurrentAccount;
import br.com.f1rst.appBank.model.Account.InvestmentAccount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankRepository implements InsertableRepostory<Account>{
    private List<Account> ACCOUNTS;

    @Override
    public void insert(Account model) {
        ACCOUNTS.add(model);
    }

    public BankRepository() {
        this.ACCOUNTS = new ArrayList<Account>() ;
    }

    public boolean openAccount(Account newAccount){
        Account account = searchAccount(newAccount.getNumber());
        if (account != null){
            return false;
        }
        this.ACCOUNTS.add(newAccount);
        return true;
    }

    protected Account searchAccount(String numberAccount) {
        if (this.ACCOUNTS == null)
            return null;
        for (Account account: this.ACCOUNTS) {
            if (numberAccount.compareTo(account.getNumber()) == 0)
                return account;
        }
        return null;
    }

    public boolean toWithdraw(String numberAccount, BigDecimal value){
        Account account = searchAccount(numberAccount);
        if (account != null && account.toWithdraw(value)) {
            this.toUpdateAccount(account);
            return true;
        }
        return false;
    }

    protected void toUpdateAccount(Account account) {
        for (Account index: this.ACCOUNTS) {
            if (account.getNumber().equals(index.getNumber())){
                index = account;
                break;
            }
        }
    }

    public boolean deposit(String numbleAccount, BigDecimal value){
        Account account = searchAccount(numbleAccount);
        if (account != null && account instanceof InvestmentAccount == false) {
            if (account instanceof CurrentAccount)
                ((CurrentAccount) account).deposit(value);
            else
                ((CurrentAccount) account).deposit(value);
                this.toUpdateAccount(account);
                return true;
        }
        return false;
    }

    public boolean invest(String numbleAccount, BigDecimal value) {
        Account account = searchAccount(numbleAccount);
        if (account != null && account instanceof InvestmentAccount){
            ((InvestmentAccount) account).invest(value);
            return true;
        }
        return false;
    }

    public boolean transfer(String numbleAccountAddressee, String numbleAccountSender,BigDecimal value){
        Account addressee = searchAccount(numbleAccountAddressee), sender = searchAccount(numbleAccountSender);
        if (addressee != null && sender != null && sender.transfer(value, false)){
            return addressee.transfer(value, true);
        }
        return false;
    }
}
