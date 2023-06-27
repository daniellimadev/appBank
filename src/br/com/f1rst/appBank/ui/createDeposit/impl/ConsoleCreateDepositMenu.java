package br.com.f1rst.appBank.ui.createDeposit.impl;

import br.com.f1rst.appBank.repository.BankRepository;
import br.com.f1rst.appBank.ui.createDeposit.CreateDepositWindow;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleCreateDepositMenu extends BankRepository implements CreateDepositWindow {
    @Override
    public void createDeposit() {
        String numberAccount;
        boolean exception = false;
        BigDecimal value = BigDecimal.valueOf(0);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Insira o número da conta que receberá o depósito.");
            numberAccount = scanner.nextLine();
        }while (!numberAccount.matches("[0-9]+"));

        do {
            try {
                exception = false;
                System.out.println("Insira a quantia a ser depositada.");
                value= scanner.nextBigDecimal();
            }catch (InputMismatchException e) {
                System.out.println("Insira um valor positivo para continuar.");
                scanner.nextLine();
                exception = true;
            }
        }while (exception || value.compareTo(BigDecimal.valueOf(0)) <=0 );

        if (deposit(numberAccount,value)){
            System.out.println("R$" + value.setScale(2, RoundingMode.HALF_UP) + " depositado com sucesso.");
        }else {
            System.out.println("Erro ao depositar: conta inexistente ou do tipo investimento.");
        }

    }
}
