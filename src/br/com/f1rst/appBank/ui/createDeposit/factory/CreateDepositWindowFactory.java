package br.com.f1rst.appBank.ui.createDeposit.factory;

import br.com.f1rst.appBank.ui.createDeposit.CreateDepositWindow;
import br.com.f1rst.appBank.ui.createDeposit.impl.ConsoleCreateDepositMenu;
import br.com.f1rst.appBank.ui.menu.factory.MenuType;

import java.util.Map;

public class CreateDepositWindowFactory {
    private Map<MenuType, CreateDepositWindow> menuTypeCreateDepositWindowMap = Map.of(
            MenuType.CONSOLE, new ConsoleCreateDepositMenu()
    );

    public ConsoleCreateDepositMenu createDepositMenu(MenuType menuType){
        return (ConsoleCreateDepositMenu) menuTypeCreateDepositWindowMap.get(menuType);
    }
}
