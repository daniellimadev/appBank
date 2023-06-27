package br.com.f1rst.appBank.ui.createTransfer.impl;

import br.com.f1rst.appBank.repository.BankRepository;
import br.com.f1rst.appBank.ui.createTransfer.CreateTransferWindow;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleCreateTransferMenu extends BankRepository implements CreateTransferWindow {
    @Override
    public void createTransfer() {
        String numbleAccountAddressee,numbleAccountSender;
        boolean exception = false;
        BigDecimal value = BigDecimal.valueOf(0);

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Insira o número da conta que será descontada a transferência.");
            numbleAccountSender = scanner.nextLine();
        }while (!numbleAccountSender.matches("[0-9]+"));

        do {
            System.out.println("Insira o número da conta que receberá a transferência.");
            numbleAccountAddressee = scanner.nextLine();
        }while (!numbleAccountAddressee.matches("[0-9]+"));

        do {
            try {
                exception = false;
                System.out.println("Insira a quantia a ser transferida.");
                value = scanner.nextBigDecimal();
            }catch (InputMismatchException e){
                System.out.println("Insira um número positivo para continuar.");
                scanner.nextLine();
                exception = true;
            }
        }while (exception || value.compareTo(BigDecimal.valueOf(0)) <=0);

        if (transfer(numbleAccountAddressee,numbleAccountSender,value)){
            System.out.println("Transferência de R$" + value.setScale(2, RoundingMode.HALF_UP)
            + " da conta " + numbleAccountSender + " para conta " + numbleAccountAddressee + " realizado com sucesso.");
        }else {
            System.out.println("Não foi possível realizar a transferência por um dos seguintes motivos:" +
                    "\n\tSaldo do remetente insuficiente.\n\tConta do remetente inexistente no sistema." +
                    "\n\tConta do destinatário inexistente no sistema.");

        }
    }
}
