package br.com.f1rst.appBank.model.Account;

import br.com.f1rst.appBank.model.persons.Person;

import java.math.BigDecimal;

public class CurrentAccount extends Account {


    public CurrentAccount(String name, String number, String agency) {
        super(name, number, agency);
    }

    @Override
    public boolean toWithdraw(BigDecimal value) {
        if (this.getBalance().compareTo(value.multiply(this.getTax())) >= 0) {
            this.setBalance(this.getBalance().subtract(value.multiply(this.getTax())));
            return true;
        }
        return false;
    }

    @Override
    public boolean transfer(BigDecimal value, boolean addressee) {
        if (addressee) {
            this.setBalance(this.getBalance().add(value));
            return true;
        } else if (this.getBalance().compareTo(value.multiply(this.getTax())) >= 0) {
            this.setBalance(this.getBalance().subtract(value.multiply(this.getTax())));
            return true;
        }
        return false;
    }
    public void deposit(BigDecimal value) {
        this.setBalance(value.add(getBalance()));
    }

}
