package br.com.f1rst.appBank.model.persons;

import br.com.f1rst.appBank.model.Account.Account;

import java.math.BigDecimal;

public class PhysicalPerson extends Account {
    private String cpf;

    public PhysicalPerson(String name, String number, String agency) {
        super(name, number, agency);
    }


    public String getCpf() {
        return cpf;
    }

    @Override
    public boolean toWithdraw(BigDecimal value) {
        return false;
    }

    @Override
    public boolean transfer(BigDecimal value, boolean addressee) {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " CPF: " + this.getCpf() + ".\n";
    }
}
