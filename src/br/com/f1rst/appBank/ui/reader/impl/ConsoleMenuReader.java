package br.com.f1rst.appBank.ui.reader.impl;

import br.com.f1rst.appBank.ui.reader.MenuAction;
import br.com.f1rst.appBank.ui.reader.MenuReader;

import java.util.Scanner;

public class ConsoleMenuReader implements MenuReader {
    @Override
    public MenuAction readOption() {
        Scanner scanner = new Scanner(System.in);
        int selecteOption = scanner.nextInt();
        return MenuAction.fromInt(selecteOption);
    }
}
