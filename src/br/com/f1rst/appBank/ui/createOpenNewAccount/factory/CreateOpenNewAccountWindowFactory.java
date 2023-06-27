package br.com.f1rst.appBank.ui.createOpenNewAccount.factory;

import br.com.f1rst.appBank.ui.createOpenNewAccount.CreateOpenNewAccountWindow;
import br.com.f1rst.appBank.ui.createOpenNewAccount.impl.ConsoleCreateOpenNewAccountMenu;
import br.com.f1rst.appBank.ui.menu.factory.MenuType;

import java.util.Map;

public class CreateOpenNewAccountWindowFactory {
    private Map<MenuType, CreateOpenNewAccountWindow> accountTypeCreateOpenNewAccountWindowMap = Map.of(
        MenuType.CONSOLE, new ConsoleCreateOpenNewAccountMenu()
    );

    public ConsoleCreateOpenNewAccountMenu create (MenuType accountType) {
        return (ConsoleCreateOpenNewAccountMenu) accountTypeCreateOpenNewAccountWindowMap.get(accountType);
    }
}
