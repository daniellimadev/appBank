package br.com.f1rst.appBank.ui.createOpenNewAccount.impl;


import br.com.f1rst.appBank.model.Account.Account;
import br.com.f1rst.appBank.model.Account.CurrentAccount;
import br.com.f1rst.appBank.model.Account.InvestmentAccount;
import br.com.f1rst.appBank.model.Account.SavingsAccount;
import br.com.f1rst.appBank.repository.BankRepository;
import br.com.f1rst.appBank.ui.createOpenNewAccount.CreateOpenNewAccountWindow;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class ConsoleCreateOpenNewAccountMenu extends BankRepository implements CreateOpenNewAccountWindow {

    @Override
    public void createOpenNewAccount() {
        String name,cpfOrCnpj,agency,numberAccount;
        int accountType;
        boolean exception;


        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Digite o nome do titular da nova conta: ");
            name = scanner.nextLine();
        }while (!name.matches("[A-Za-z]+"));

        do {
            System.out.print("Insira o CPF/CNPJ do titular: ");
            cpfOrCnpj = scanner.nextLine();
        }while (!cpfOrCnpj.matches("[0-9]+") || cpfOrCnpj.length() != 11 && cpfOrCnpj.length() != 14);

        do {
            try {
                exception = false;
                System.out.println("Insira o tipo de conta a ser criada.\n\t1 - Conta corrente.\n\t2 - Conta investimento.\n\t3 - Conta poupança.");
                accountType = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("\nInsira um número inteiro dentro do intervalo para prosseguir.");
                accountType = scanner.nextInt();
                exception = true;
            }
        }while (exception || accountType < 1 || accountType > 3);
        scanner.nextLine();

        do {
            System.out.print("Insira o número da nova conta. ");
            numberAccount = scanner.nextLine();
        }while (!numberAccount.matches("[0-9]+"));

        do {
            System.out.print("Insira a agência da nova conta. ");
            agency = scanner.nextLine();
        }while (!agency.matches("[0-9]+"));

        try {
            if(openAccount(accountType == 1 ? new CurrentAccount(name,numberAccount,agency) : accountType == 2 ? new InvestmentAccount(name,numberAccount,agency) : new SavingsAccount(name,numberAccount,agency) ))
                System.out.println("Conta criada com sucesso.");
            else
                System.out.println("Falha ao criar nova conta: número de conta já existente no sistema.");

        }catch (MissingFormatArgumentException e){
            System.out.println(e .getFormatSpecifier());
        }


    }

}
