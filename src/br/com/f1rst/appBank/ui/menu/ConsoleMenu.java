package br.com.f1rst.appBank.ui.menu;

public class ConsoleMenu implements DrawableMenu {


    @Override
    public void drawMenu() {
        System.out.println("****APP Bank****");
        System.out.println("O que você quer fazer? ");
        System.out.println("1 - Abrir nova conta.");
        System.out.println("2 - Sacar.");
        System.out.println("3 - Depositar.");
        System.out.println("4 - Transferência.");
        System.out.println("5 - Investir.");
        System.out.println("6 - Consultar saldo.");
        System.out.println("7 - Sair.");
    }
}
