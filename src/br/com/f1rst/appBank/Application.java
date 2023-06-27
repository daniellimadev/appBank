package br.com.f1rst.appBank;

import br.com.f1rst.appBank.ui.createConsultBalance.CreateConsultBalanceWindow;
import br.com.f1rst.appBank.ui.createConsultBalance.factory.CreateConsultBalanceWindowFactory;
import br.com.f1rst.appBank.ui.createDeposit.CreateDepositWindow;
import br.com.f1rst.appBank.ui.createDeposit.factory.CreateDepositWindowFactory;
import br.com.f1rst.appBank.ui.createInvest.CreateInvestWindow;
import br.com.f1rst.appBank.ui.createInvest.factory.CreateInvestWondowFactory;
import br.com.f1rst.appBank.ui.createOpenNewAccount.CreateOpenNewAccountWindow;
import br.com.f1rst.appBank.ui.createOpenNewAccount.factory.CreateOpenNewAccountWindowFactory;
import br.com.f1rst.appBank.ui.createToWithdraw.CreateToWithdrawWindow;
import br.com.f1rst.appBank.ui.createToWithdraw.factory.CreateToWithdrawWindowFactory;
import br.com.f1rst.appBank.ui.createTransfer.CreateTransferWindow;
import br.com.f1rst.appBank.ui.createTransfer.factory.CreateTransferWindowFactory;
import br.com.f1rst.appBank.ui.menu.factory.MenuType;
import br.com.f1rst.appBank.ui.reader.MenuAction;
import br.com.f1rst.appBank.ui.window.MenuWindow;

public class Application {

    public static void main(String[] args) {

        MenuWindow menuWindow = new MenuWindow(MenuType.CONSOLE);
        MenuAction option = menuWindow.getAction();
        while (option != MenuAction.EXIT) {
            switch (option) {
                case OPEN_NEW_ACCOOUNT:
                    CreateOpenNewAccountWindow openNewAccountWindow = new CreateOpenNewAccountWindowFactory().create(MenuType.CONSOLE);
                    openNewAccountWindow.createOpenNewAccount();
                    break;
                case TO_WITHDRAW:
                    CreateToWithdrawWindow toWithdrawWindow = new CreateToWithdrawWindowFactory().create(MenuType.CONSOLE);
                    toWithdrawWindow.createToWithdraw();
                    break;
                case DEPOSIT:
                    CreateDepositWindow createDepositWindow = new CreateDepositWindowFactory().createDepositMenu(MenuType.CONSOLE);
                    createDepositWindow.createDeposit();
                    break;
                case TRANSFER:
                    CreateTransferWindow createTransferWindow = new CreateTransferWindowFactory().createTransferMenu(MenuType.CONSOLE);
                    createTransferWindow.createTransfer();
                    break;
                case INVEST:
                    CreateInvestWindow createInvestWindow = new CreateInvestWondowFactory().createInvestMenu(MenuType.CONSOLE);
                    createInvestWindow.createInvest();
                    break;
                case CONSULT_BALANCE:
                    CreateConsultBalanceWindow createConsultBalanceWindow = (CreateConsultBalanceWindow) new CreateConsultBalanceWindowFactory().consoleCreateInvestMenu(MenuType.CONSOLE);
                    createConsultBalanceWindow.createConsultBalance();
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
            option = menuWindow.getAction();
        }

    }
}
