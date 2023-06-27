package br.com.f1rst.appBank.model.Account;

import br.com.f1rst.appBank.model.persons.LegalPerson;
import br.com.f1rst.appBank.model.persons.Person;

import java.math.BigDecimal;

public class InvestmentAccount extends Account{
    private BigDecimal taxPerformance;

    public InvestmentAccount(String name, String number, String agency) {
        super(name, number, agency);
        if (account instanceof LegalPerson){
            this.taxPerformance = BigDecimal.valueOf(1.07);
        }else {
            this.taxPerformance = BigDecimal.valueOf(1.05);
        }
    }

    @Override
    public boolean toWithdraw(BigDecimal value) {
        if (this.getBalance().compareTo(value.multiply(this.getTax())) >= 0){
            this.setBalance(this.getBalance().subtract(value.multiply(this.getTax())));
            return true;
        }
        return false;
    }

    @Override
    public boolean transfer(BigDecimal value, boolean addressee) {
        if (addressee){
            this.setBalance(this.getBalance().add(value));
            return true;
        } else if (this.getBalance().compareTo(value.multiply(this.getTax())) >= 0){
            this.setBalance(this.getBalance().subtract(value.multiply(this.getTax())));
            return true;
        }
        return false;
    }

    public void invest(BigDecimal value) {
        this.setBalance(value.add(this.getBalance()));
    }

    public void investing() {
        super.setBalance(super.getBalance().multiply(getTaxPerformance()));
    }

    public BigDecimal getTaxPerformance() {return this.taxPerformance;}

    public void setTaxPerformance(BigDecimal taxPerformance) {
        this.taxPerformance = taxPerformance;
    }

    @Override
    public String toString() {
        return super.toString() + "Taxa de rendimento: " + (this.getTaxPerformance()
                .subtract(BigDecimal.valueOf(1))).multiply(BigDecimal.valueOf(100)) + "%.\n";
    }
}
