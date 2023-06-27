package br.com.f1rst.appBank.ui.createInvest.impl;

import br.com.f1rst.appBank.repository.BankRepository;
import br.com.f1rst.appBank.ui.createInvest.CreateInvestWindow;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleCreateInvestMenu extends BankRepository implements CreateInvestWindow {
    @Override
    public void createInvest() {
        String numberAccount;
        boolean exception = false;
        BigDecimal value = BigDecimal.valueOf(0);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Insira o número da conta que receberá o investimento.");
            numberAccount = scanner.nextLine();
        }while (!numberAccount.matches("[0-9]+"));

        do {
            try {
                exception = false;
                System.out.println("Insira a quantia a ser investida.");
                value= scanner.nextBigDecimal();
            }catch (InputMismatchException e) {
                System.out.println("Insira um valor positivo para continuar.");
                scanner.nextLine();
                exception = true;
            }
        }while (exception || value.compareTo(BigDecimal.valueOf(0)) <=0 );

        if (invest(numberAccount,value)){
            System.out.println("R$" + value.setScale(2, RoundingMode.HALF_UP) + " investido com sucesso.");
        }else {
            System.out.println("Erro ao Invertir: valor insuficiente na conta ou conta inexistente.");
        }
    }
}
