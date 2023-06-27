package br.com.f1rst.appBank.model.Account;

import br.com.f1rst.appBank.model.persons.LegalPerson;
import br.com.f1rst.appBank.model.persons.Person;

import java.math.BigDecimal;
import java.util.MissingFormatArgumentException;

public class SavingsAccount extends Account{
    private BigDecimal taxPerformance;

    public SavingsAccount(String name, String number, String agency) throws MissingFormatArgumentException {
        super(name, number, agency);
        if (account instanceof LegalPerson){
            throw new MissingFormatArgumentException("Erro! PJ não pode possuir conta poupança!!");
        }
        this.taxPerformance = BigDecimal.valueOf(1.03);
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
        if (addressee){
            this.setBalance(this.getBalance().add(value));
            return true;
        }else if (this.getBalance().compareTo(value.multiply(this.getTax())) >= 0) {
            this.setBalance(this.getBalance().subtract(value.multiply(this.getTax())));
            return true;
        }
        return false;
    }

    public void deposit (BigDecimal value) {
        this.setBalance(value.add(this.getBalance()));
    }

    public void sparing (){
        this.setBalance(this.getBalance().multiply(this.getTaxPerformance()));
    }

    public BigDecimal getTaxPerformance() {
        return taxPerformance;
    }

    public void setTaxPerformance(BigDecimal taxPerformance) {
        this.taxPerformance = taxPerformance;
    }

    @Override
    public String toString() {
        return super.toString() + "Taxa de rendimento: "
                + (this.getTaxPerformance().subtract(BigDecimal.valueOf(1))).multiply(BigDecimal.valueOf(100)) + "%.\n";
    }
}
