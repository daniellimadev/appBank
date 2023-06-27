package br.com.f1rst.appBank.ui.createConsultBalance.impl;

import br.com.f1rst.appBank.model.Account.Account;
import br.com.f1rst.appBank.repository.BankRepository;
import br.com.f1rst.appBank.ui.createConsultBalance.CreateConsultBalanceWindow;

import java.util.Scanner;

public class ConsoleCreateConsultBalanceMenu extends BankRepository implements CreateConsultBalanceWindow {
    @Override
    public void createConsultBalance() {
        Account account;
        String numberAccount;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Insira o número da conta a ser consultada.");
            numberAccount = scanner.nextLine();
        }while (!numberAccount.matches("[0-9]+"));

        account = searchAccount(numberAccount);

        if (account == null){
            System.out.println("Conta inexistente no sistema.");
        }else {
            System.out.println(account.toString());
        }
    }
}
