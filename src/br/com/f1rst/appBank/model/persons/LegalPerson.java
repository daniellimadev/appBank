package br.com.f1rst.appBank.model.persons;

import br.com.f1rst.appBank.model.Account.Account;

import java.math.BigDecimal;

public class LegalPerson extends Account {
    private  String name;
    private String cnpj;

    public LegalPerson(String name, String number, String agency) {
        super(name, number, agency);
    }



    @Override
    public boolean toWithdraw(BigDecimal value) {
        return false;
    }

    @Override
    public boolean transfer(BigDecimal value, boolean addressee) {
        return false;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + " CNPJ: " + this.getCnpj() + ".\n";
    }

}
