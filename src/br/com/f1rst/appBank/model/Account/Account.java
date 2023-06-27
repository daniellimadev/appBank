package br.com.f1rst.appBank.model.Account;

import br.com.f1rst.appBank.model.persons.LegalPerson;
import br.com.f1rst.appBank.model.persons.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Account{
    protected Account account;
    protected String name,number,agency;
    protected BigDecimal balance, tax;

    public Account(String name, String number, String agency) {
        this.name = name;
        this.number = number;
        this.agency = agency;
        this.balance = BigDecimal.valueOf(0);
        if (account instanceof LegalPerson)
            this.tax = BigDecimal.valueOf(1.005);
        else
            this.tax = BigDecimal.valueOf(1);
    }

    public abstract boolean toWithdraw(BigDecimal value);

    public abstract boolean transfer(BigDecimal value, boolean addressee);

    // Getteres & Setters


    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getAgency() {
        return agency;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Conta: " + this.getNumber() + ". Agência: " + this.getAgency() + ".\nTitular: " +
                this.getName() + "Taxa: " + (this.getTax().subtract(BigDecimal.valueOf(1)).multiply(BigDecimal.valueOf(100)) +
                "%.\nSaldo: R$" + this.getBalance().setScale(2, RoundingMode.HALF_UP) + ".\n");
    }
}
