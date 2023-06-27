package br.com.f1rst.appBank.ui.createToWithdraw.impl;

import br.com.f1rst.appBank.repository.BankRepository;
import br.com.f1rst.appBank.ui.createToWithdraw.CreateToWithdrawWindow;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleCreateToWithdrawMenu extends BankRepository implements CreateToWithdrawWindow {

    @Override
    public void createToWithdraw() {

        String numberAccount;
        boolean exception = false;
        BigDecimal value = BigDecimal.valueOf(0);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Insira o número da conta a ser sacada.");
            numberAccount = scanner.nextLine();
        }while (!numberAccount.matches("[0-9]+"));

        do {
            try {
                exception = false;
                System.out.println("Insira a valor a ser sacada.");
                 value= scanner.nextBigDecimal();
            }catch (InputMismatchException e) {
                System.out.println("Insira um valor positivo para continuar.");
                scanner.nextLine();
                exception = true;
            }
        }while (exception || value.compareTo(BigDecimal.valueOf(0)) <=0 );

        if (toWithdraw(numberAccount,value)){
            System.out.println("R$" + value.setScale(2, RoundingMode.HALF_UP) + " sacado com sucesso.");
        }else {
            System.out.println("Erro ao sacar: valor insuficiente na conta ou conta inexistente.");
        }

    }
}
