package br.com.f1rst.appBank.ui.createToWithdraw.factory;

import br.com.f1rst.appBank.ui.createToWithdraw.CreateToWithdrawWindow;
import br.com.f1rst.appBank.ui.createToWithdraw.impl.ConsoleCreateToWithdrawMenu;
import br.com.f1rst.appBank.ui.menu.factory.MenuType;

import java.util.Map;

public class CreateToWithdrawWindowFactory {
    private Map<MenuType, CreateToWithdrawWindow> toWithdrawWindowMap = Map.of(
            MenuType.CONSOLE, new ConsoleCreateToWithdrawMenu()
    );

    public ConsoleCreateToWithdrawMenu create(MenuType menuType) {
        return (ConsoleCreateToWithdrawMenu) toWithdrawWindowMap.get(menuType);
    }
}
